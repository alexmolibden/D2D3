package com.epam.controller.impl;

import com.epam.beans.Product;
import com.epam.beans.User;
import com.epam.controller.iface.SellerService;

import java.util.Map;
import java.util.Set;

/**
 * Created by Aliaksei_Kankou on 2/12/2017.
 */
public class SellerServiceImpl implements SellerService
{
    public void addProduct(int id, Product product)
    {
        products.put(id, product);
    }

    public Map<Integer, Product> getAllProducts()
    {
        return products;
    }

    public Product deleteProduct(int id)
    {
        return products.remove(id);
    }

    public Product getProduct(int idProduct)
    {
        return products.get(idProduct);
    }

    public void showAllProducts()
    {
        for (Map.Entry<Integer, Product> entry : products.entrySet())
        {
            System.out.println("id = " + entry.getKey() + " " + entry.getValue());
        }
    }
}
