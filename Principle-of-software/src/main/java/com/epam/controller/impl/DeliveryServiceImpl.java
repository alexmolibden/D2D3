package com.epam.controller.impl;

import com.epam.beans.Order;
import com.epam.controller.iface.DeliveryService;

import java.util.Map;

/**
 * Created by Aliaksei_Kankou on 2/12/2017.
 */
public class DeliveryServiceImpl extends DeliveryService
{
    public void showAllDelivery()
    {
        for (Map.Entry<Integer, Order> entry : getAllOrders().entrySet())
        {
            System.out.println("Delivery: id = " + entry.getKey() + "Order: " + entry.getValue());
        }
    }

    @Override
    public Map<Integer, Order> getAllOrders()
    {
        return orders;
    }


}
