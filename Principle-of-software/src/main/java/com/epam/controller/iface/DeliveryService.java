package com.epam.controller.iface;

import com.epam.beans.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksei_Kankou on 2/12/2017.
 */
public abstract class DeliveryService
{
    protected Map<Integer, Order> orders = new HashMap<Integer, Order>();
    private int countOfOrders = 0;
    private int incCountOfOrders()
    {
        return countOfOrders++;
    }
    public void addDelivery(Order order)
    {
        orders.put(incCountOfOrders(), order);
    }
    public abstract void showAllDelivery();
    public abstract Map<Integer, Order> getAllOrders();
}
