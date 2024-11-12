package ru.job4j.pojo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        first.setOwner("Li");
        License second = new License();
        second.setCode("audio");
        second.setOwner("Li");
        assertThat(first).isEqualTo(second);
    }
}