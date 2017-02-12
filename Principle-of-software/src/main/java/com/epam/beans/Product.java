package com.epam.beans;

/**
 * Created by Aliaksei_Kankou on 2/11/2017.
 */
public class Product
{
    public String name;

    public Product()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Product{" +
               "name='" + name + '\'' +
               '}';
    }
}
