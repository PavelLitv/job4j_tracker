package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса:
 * добавление/удаление/поиск клиентов {@link User}
 * добавление/поиск банковского счета {@link Account}
 * перевод между счетами
 * @author Pavel Litvinenko
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в банковский сервис
     * @param user пользователь, который будет добавлен
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет клиента из банковского сервиса
     * @param passport параметр для поиска клиента
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    /**
     * Метод добавляем счет существующему клиенту
     * @param passport параметр для поиска клиента
     * @param account счет, который будет добавлен
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    /**
     * Метод осуществляет поиск клиента по паспортным данным
     * @param passport параметр для поиска клиента
     * @return возвращает найденного клиента или null, если клиент не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск счет поиск счета
     * @param passport параметр для поиска клиента, у которого будет осуществлен поиск счета
     * @param requisite параметр для поиска счета у найденного клиента
     * @return возвращает найденный счет или null, если клиент или счет не найдены
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод между счетами
     * @param sourcePassport параметр для поиска клиента-плательщика
     * @param sourceRequisite параметр для поиска счета клиента-плательщика
     * @param destinationPassport параметр для поиска клиента-получателя
     * @param destinationRequisite параметр для поиска счета клиента-получателя
     * @param amount сумма перевода
     * @return возвращает true в случае совершения перевода, false, если перевод
     * осуществить не удалось (не найден один из клиентов/счетов или не достаточно средств для перевода)
     */
    public boolean transferMoney(
            String sourcePassport, String sourceRequisite,
            String destinationPassport, String destinationRequisite,
            double amount
    ) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
