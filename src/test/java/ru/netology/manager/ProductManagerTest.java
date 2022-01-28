package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, 150, "Sharlotte Bronte");
    private Book second = new Book(2, 200, "Joanne Rowling");
    private Book third = new Book(3, 100, "L.F.Baum");
    private Smartphone fourth = new Smartphone(4, 12000, "Sumsung");
    private Smartphone fifth = new Smartphone(5, 80000, "Apple");
    private Smartphone sixth = new Smartphone(6, 39000, "Huawei");
    private Product product = new Product();


    @BeforeEach
    public void shouldStartManager() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(product);

    }

    @Test
    public void shouldSearchByText() {
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Sharlotte");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText2() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Joanne");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText3() {
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Sumsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText4() {
        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextFalse() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Pushkin");
        assertArrayEquals(expected, actual);
    }

}