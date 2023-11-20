package com.tshahakurov.sklad.model.check;

import com.tshahakurov.sklad.model.order.Order;
import com.tshahakurov.sklad.model.product.Product;

import java.util.ArrayList;

/**
 *  Чек, он же счет
 *  У каждого заказа есть, как не странно, он есть
 *  в счете просчитывается итоговая цена, по количеству заказов
 */
public class Check {

    // Сам заказ
    private Order order;

    // Конструктор
    public Check(Order order) {
        this.order = order;
    }

    // Информация о счете и возвращается своего рода Чек типа String
    public String getCheckInfo(){
        String check = "";

        StringBuffer buffer = new StringBuffer(check);
        buffer.append("---------Products---------\n");
        for (Product product: order.provideOrder()) {
            buffer.append(product.toString() + '\n');
        }
        buffer.append("---------Total---------\n");
        buffer.append("Total price : ");
        buffer.append(order.getTotalPrice());
        buffer.append('\n');
        return buffer.toString();
    }
}
