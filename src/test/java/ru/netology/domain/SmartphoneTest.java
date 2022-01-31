package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone phone = new Smartphone (5, "iPhone 12",80000, "Apple");

    @Test
    void shouldMatchByBrand() {
        String match = "Apple";

        assertTrue(phone.matches(match));
    }

    @Test
    void shouldMatchByName() {
        String match = "iPhone 12";

        assertTrue(phone.matches(match));
    }

    @Test
    void shouldMatchByAuthor2() {
        String match = "LG";

        assertFalse(phone.matches(match));
    }

    @Test
    void shouldMatchByName2() {
        String match = "GooglePixel";

        assertFalse(phone.matches(match));
    }


}