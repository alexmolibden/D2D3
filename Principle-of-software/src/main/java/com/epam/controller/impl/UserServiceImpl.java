package com.epam.controller.impl;

import com.epam.beans.User;
import com.epam.controller.iface.UserService;

/**
 * Created by Aliaksei_Kankou on 2/11/2017.
 */
public class UserServiceImpl implements UserService
{

    public User getUser(String name, String password)
    {
        User user = users.get(name);
        if (user != null && password.equals(user.getPassword()))
        {
            return user;
        }
        return null;
    }

    public void addUser(User user)
    {
        users.put(user.getName(), user);
    }

    public User deleteUser(String name)
    {
        return users.remove(name);
    }


}
