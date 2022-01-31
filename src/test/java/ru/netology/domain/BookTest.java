package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book (1, "Jane Air",150, "Sharlotte Bronte");

    @Test
    void shouldMatchByAuthor() {
        String match = "Sharlotte Bronte";

        assertTrue(book.matches(match));
    }

    @Test
    void shouldMatchByName() {
        String match = "Jane Air";

        assertTrue(book.matches(match));
    }

    @Test
    void shouldMatchByAuthor2() {
        String match = "Joanne Rowling";

        assertFalse(book.matches(match));
    }

    @Test
    void shouldMatchByName2() {
        String match = "Harry Potter";

        assertFalse(book.matches(match));
    }

}