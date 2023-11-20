package com.tshahakurov.sklad.model.warehouse;

import com.tshahakurov.sklad.model.product.Product;

import java.util.ArrayList;

/**
 * Склад с товарами Singleton
 * Хранит товары (уже с лимитом)
 **/

public class Warehouse {
    private static Warehouse instance;
    // Лимит нашего склада
    private static final int WAREHOUSE_CAPACITY_LIMIT = 100;
    // Список продуктов на складе
    private ArrayList<Product> products;

    private Warehouse() {
        products = new ArrayList<>(WAREHOUSE_CAPACITY_LIMIT);
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            return new Warehouse();
        } else {
            return instance;
        }
    }

    // Ф-ия возвращает список товаров
    public ArrayList<Product> getProducts() {
        return products;
    }

    // Ф-ия возвращает кол-во товаров
    public int getProductCount() {
        return products.size();
    }

    // Добавление 1 товара
    public boolean addProduct(Product product) {
        if (getProductCount() < WAREHOUSE_CAPACITY_LIMIT) {
            products.add(product);
            return true;
        } else {
            return false;
        }
    }

    // Добавление нескольких товаров
    public boolean addProducts(ArrayList<Product> products) {
        if (products.size() <= availableSpace()) {
            products.addAll(products);
            return true;
        } else {
            return false;
        }
    }

    // Сколько еще свободного места
    public int availableSpace(){
        return WAREHOUSE_CAPACITY_LIMIT - getProductCount();
    }

    // Предоставление товаров (по схеме стэк - FIFO)
    public Product takeProduct() {
        if (!products.isEmpty())
            return products.remove(products.size() - 1);
        else
            return new Product("Empty Product");
    }
}
