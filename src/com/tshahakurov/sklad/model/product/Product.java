package com.tshahakurov.sklad.model.product;


/**
 *  Наш товар/продукт
 *  Ничего особенного чисто дефолтная инфа
 */
public class Product {

    // Дефолтная цена на товар
    private static final double DEFAULT_PRODUCT_PRICE = 31.4;
    // Счетчик (на данный момент нужен исключительно для нейминга)
    private static int counter = 0;
    // Наименование товара
    String name;
    // Цена товара
    Double price;

    // Конструктор : Указываем имя (используя счетчик) и цену
    public Product() {
        this.name = getDefaultProductName();
        price = DEFAULT_PRODUCT_PRICE;
    }

    // Конструктор : Добавил по приколу, а почему бы и нет?!
    public Product(String name) {
        this.name = name;
        price = DEFAULT_PRODUCT_PRICE;
    }

    // Getter для имени
    public String getName(){
        return name;
    }

    // Getter для цены
    public double getPrice(){
        return price;
    }

    // toString() так же, почему бы и нет (ладно, он используется для чека)
    @Override
    public String toString() {
        return "Name : " + name + "\nPrice : " + price;
    }

    // Собственно сама функция по предоставлению нейминга
    private static String getDefaultProductName() {
        counter++;
        return "Product " + counter;
    }
}
