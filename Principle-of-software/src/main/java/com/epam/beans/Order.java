package com.epam.beans;

/**
 * Created by Aliaksei_Kankou on 2/12/2017.
 */
public class Order
{
    private User customer;
    private Delivery delivery;
    private Product product;
    private boolean isDelivered = false;

    public Order() {}

    public User getCustomer()
    {
        return customer;
    }

    public void setCustomer(User customer)
    {
        this.customer = customer;
    }

    public Delivery getDelivery()
    {
        return delivery;
    }

    public void setDelivery(Delivery delivery)
    {
        this.delivery = delivery;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public boolean isDelivered()
    {
        return isDelivered;
    }

    public void setDelivered(boolean delivered)
    {
        isDelivered = delivered;
    }
}
