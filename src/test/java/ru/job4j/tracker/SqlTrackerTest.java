package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemThenMustBeReplaced() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item_1");
        tracker.add(item1);
        Item item2 = new Item(item1.getId(), "item_2", item1.getCreated());
        tracker.replace(item1.getId(), item2);
        assertThat(tracker.findById(item1.getId())).isEqualTo(item2);
    }

    @Test
    public void whenDeleteItemThenMustBeDeleted() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void findAllItemThenReturnAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> items = List.of(
                new Item("item1"),
                new Item("item2"),
                new Item("item3")
        );
        items.forEach(tracker::add);
        assertThat(tracker.findAll()).containsExactlyInAnyOrderElementsOf(items);
    }

    @Test
    public void findByNameThenReturnItemsWithThisName() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> items = List.of(
                new Item("item1"),
                new Item("item2"),
                new Item("item3"),
                new Item("item1")
        );
        items.forEach(tracker::add);
        assertThat(tracker.findByName(items.get(0).getName())).containsExactlyInAnyOrder(items.get(0), items.get(3));
    }
}
