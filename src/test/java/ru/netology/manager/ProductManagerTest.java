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
    ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Jane Air", 150, "Sharlotte Bronte");
    Product second = new Book(2, "Garry Potter", 200, "Joanne Rowling");
    Product third = new Book(3, "The wizard of Oz", 100, "L.F.Baum");
    Product fourth = new Smartphone(4, "A12", 12000, "Sumsung");
    Product fifth = new Smartphone(5, "iPhone13", 80000, "Apple");
    Product sixth = new Smartphone(6, "Nova8", 39000, "Huawei");


    @BeforeEach
    public void shouldStartManager() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
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
        Product[] actual = manager.searchBy("A12");
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
        Product[] actual = manager.searchBy("Dream");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetProducts() {
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetProductsAfterRemove() {
        manager.removeById(1);
        manager.removeById(3);
        manager.removeById(4);
        manager.removeById(6);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{second, fifth};
        assertArrayEquals(expected, actual);
    }
}