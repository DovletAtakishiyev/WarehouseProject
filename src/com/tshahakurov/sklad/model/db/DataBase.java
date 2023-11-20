package com.tshahakurov.sklad.model.db;

import com.tshahakurov.sklad.model.check.Check;
import com.tshahakurov.sklad.model.product.Product;
import com.tshahakurov.sklad.subject.client.Client;
import com.tshahakurov.sklad.subject.other.Supplier;

import java.util.ArrayList;

/**
 *  Модел базы данных Singleton
 *  Содержит Таблицы (в данной модели Списки)
 *      того что должны добавлять в БД
 */
public class DataBase {
    private static DataBase instance;

    // Таблица продуктов на складе
    private ArrayList<Product> productsTable;
    // Таблица клиентов
    private ArrayList<Client> clientsTable;
    // Таблица выданных счетов
    private ArrayList<Check> checksTable;
    // Таблица поставщиков (хз зачем надо если честно если товары мы никак не делим на категории)
    private ArrayList<Supplier> suppliersTable;

    // Конструктор
    private DataBase() {
        productsTable = new ArrayList<>();
        clientsTable = new ArrayList<>();
        checksTable = new ArrayList<>();
        suppliersTable = new ArrayList<>();
    }

    public static DataBase getInstance() {
        if (instance == null) {
            return new DataBase();
        } else {
            return instance;
        }
    }

    // Добавляем продукт в таблицу продуктов
    public boolean addToProductsTable(Product product){
        productsTable.add(product);
        return true;
    }

    // Добавляем клиетов в таблицу клиентов
    public boolean addToClientsTable(Client client){
        clientsTable.add(client);
        return true;
    }

    // Добавляем счета в таблицу счетов
    public boolean addToChecksTable(Check check){
        checksTable.add(check);
        return true;
    }

    // Добавляем поставщиков в таблицу поставщиков (тож хз зачем надо)
    public boolean addToSuppliersTable(Supplier supplier){
        suppliersTable.add(supplier);
        return true;
    }
}
