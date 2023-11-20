package com.tshahakurov.sklad.model.order;

import com.tshahakurov.sklad.model.product.Product;

import java.util.ArrayList;

/**
 *  Заказ
 *  Клиент делает заказ
 *  Сам заказ хранит данные о выбранных продуктах
 */
public class Order {

    // Список продуктов в заказе
    private ArrayList<Product> order;

    // Итоговая стоимость
    private double totalPrice;

    // Конструктор
    public Order() {
        order = new ArrayList<>();
    }

    // Добавляем товар в заказ
    public boolean addToOrder(Product product) {
        order.add(product);
        totalPrice = countPrice();
        return true;
    }

    // Добавляем несколько товаров в заказ
    public boolean addToOrder(ArrayList<Product> products) {
        order.addAll(products);
        return true;
    }

    // Обнуляем заказ
    public boolean terminateOrder(){
        order = new ArrayList<>();
        return true;
    }

    // Предоставляем список товаров в заказе
    public ArrayList<Product> provideOrder(){
        return order;
    }

    // Getter для заказа
    public double getTotalPrice(){
        return totalPrice;
    }

    // Просчитывает цену заказа
    private double countPrice(){
        double price = 0;
        for (Product product: provideOrder()) {
            price += product.getPrice();
        }
        return price;
    }
}
