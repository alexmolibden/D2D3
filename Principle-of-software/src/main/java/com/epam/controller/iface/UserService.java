package com.epam.controller.iface;

import com.epam.beans.User;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksei_Kankou on 2/11/2017.
 */
public interface UserService
{
    Map<String, User> users = new HashMap<String, User>();

    User getUser(String name, String password);

    void addUser(User user);

    User deleteUser(String name);
}
