package com.epam.controller.iface;

import com.epam.beans.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksei_Kankou on 2/11/2017.
 */
public interface SellerService
{
    Map<Integer, Product> products = new HashMap<Integer, Product>();

    void addProduct(int id, Product product);

    Map<Integer, Product> getAllProducts();

    Product deleteProduct(int id);

    Product getProduct(int idProduct);

    void showAllProducts();
}
