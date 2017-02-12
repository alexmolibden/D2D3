package com.epam.beans;

/**
 * Created by Aliaksei_Kankou on 2/11/2017.
 */
public abstract class User
{
    public String name;
    public String password;
    public User() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
