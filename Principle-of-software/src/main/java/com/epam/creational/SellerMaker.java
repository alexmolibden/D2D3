package com.epam.creational;

import com.epam.beans.Seller;
import com.epam.beans.User;

/**
 * Created by Aliaksei_Kankou on 2/11/2017.
 */
public class SellerMaker implements UserMaker
{
    public User createUser()
    {
        return new Seller();
    }
}
