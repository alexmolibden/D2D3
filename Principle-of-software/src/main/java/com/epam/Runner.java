package com.epam;

import com.epam.beans.Customer;
import com.epam.beans.Order;
import com.epam.beans.Product;
import com.epam.beans.Seller;
import com.epam.beans.User;
import com.epam.controller.iface.DeliveryService;
import com.epam.controller.iface.SellerService;
import com.epam.controller.iface.UserService;
import com.epam.creational.CustomerMaker;
import com.epam.creational.SellerMaker;
import com.epam.creational.UserMaker;
import com.epam.type.TypeOfUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by Aliaksei_Kankou on 2/11/2017.
 */
public class Runner
{
    public static ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    public static Scanner inScanner = new Scanner(System.in);
    public static User authorizedUser = null;
    public static UserService userService = (UserService) context.getBean("userService");
    public static SellerService sellerService = (SellerService) context.getBean("sellerService");
    public static DeliveryService deliveryService = (DeliveryService) context.getBean("deliveryService");

    public static void main(String[] args) {

        authorization();

        boolean isCreatingNewUser = true;
        while (isCreatingNewUser)
        {
            System.out.println("Login or password is wrong");
            System.out.println("Creating new user...");
            System.out.println("Enter type of user (Admin, Seller, Customer, Delivery):");
            String typeOfUser = inScanner.next();
            UserMaker userMaker = getMakerByType(typeOfUser);
            User user = userMaker.createUser();
            System.out.println("Enter new user...");
            user.setName(inScanner.next());
            System.out.println("Enter new password...");
            user.setPassword(inScanner.next());
            userService.addUser(user);
            System.out.println("Do you want to create new user? (y/n)");
            String creatingNewUser = inScanner.next();
            if ("n".equals(creatingNewUser)){
                isCreatingNewUser = false;
            }
        }

        System.out.println("Authorization after registration...");
        authorization();

        if (authorizedUser == null)
        {
            System.out.println("Login or password is wrong");
        }
        else
        {
            System.out.println("Hello, " + authorizedUser.getName());
        }

        boolean isContinueWork = true;
        while (isContinueWork)
        {
            System.out.println("Do you seller (1) or customer (2)? (1/2)");
            int typeOfUser = inScanner.nextInt();
            if (1 == typeOfUser)
            {
                if (authorizedUser instanceof Seller)
                {
                    boolean isWorkWithProducts = true;
                    while (isWorkWithProducts)
                    {
                        System.out.println("What do you want to do with product? (add, edit, delete, show)");
                        String choiceOfSeller = inScanner.next();
                        if ("add".equals(choiceOfSeller))
                        {
                            System.out.println("Enter id of product");
                            int idOfProduct = inScanner.nextInt();
                            sellerService.addProduct(idOfProduct, createNewProduct());

                        }
                        else if ("edit".equals(choiceOfSeller))
                        {
                            System.out.println("Enter id of product");
                            int idOfProduct = inScanner.nextInt();
                            Product product = sellerService.getProduct(idOfProduct);
                            if (product != null)
                            {
                                sellerService.addProduct(idOfProduct, createNewProduct());
                            }
                            else
                            {
                                System.out.println("Product isn't exist");
                            }
                        }
                        else if ("delete".equals(choiceOfSeller))
                        {
                            System.out.println("Enter product id:");
                            sellerService.deleteProduct(inScanner.nextInt());
                            System.out.println("Product was deleted");
                        }
                        else if ("show".equals(choiceOfSeller))
                        {
                            sellerService.showAllProducts();
                        }
                        else
                        {
                            System.out.println("Your choice is wrong!");
                        }
                        System.out.println("Do you want to continue to work with products? (y/another key)");
                        if (!"y".equals(inScanner.next()))
                        {
                            isWorkWithProducts = false;
                        }
                    }
                }
            }
            else if (2 == typeOfUser)
            {
                if (authorizedUser instanceof Customer)
                {
                    boolean isChooseProducts = true;
                    while (isChooseProducts)
                    {
                        System.out.println("Do you want to buy (1) or show (2) these products? (1/2)");
                        int typeOfWorkWithProduct = inScanner.nextInt();
                        if (1 == typeOfWorkWithProduct)
                        {
                            System.out.println("Enter id of Product");
                            int idOfProduct = inScanner.nextInt();
                            Order order = (Order) context.getBean("order");

                            order.setProduct(sellerService.getProduct(idOfProduct));
                            order.setCustomer(authorizedUser);

                            deliveryService.addDelivery(order);
                        }
                        else if (2 == typeOfWorkWithProduct)
                        {
                            sellerService.showAllProducts();
                        }
                        System.out.println("Do you want to continue to choose products? (y/another key)");
                        if (!"y".equals(inScanner.next()))
                        {
                            isChooseProducts = false;
                        }
                    }
                }
                else
                {
                    System.out.println("User isn't Customer");
                }
            }
            else
            {
                System.out.println("The choice is wrong");
            }
            System.out.println("Do you want to continue? (y/another key)");
            if (!"y".equals(inScanner.next()))
            {
                isContinueWork = false;
            }
            System.out.println("Do you want to re-enter? (y/another key)");
            if ("y".equals(inScanner.next()))
            {
                authorization();
            }
        }

        deliveryService.showAllDelivery();


    }

    private static Product createNewProduct()
    {
        System.out.println("Enter name of product");
        String nameOfProduct = inScanner.next();
        Product product = (Product) context.getBean("product");
        product.setName(nameOfProduct);
        return product;
    }

    public static UserMaker getMakerByType(String type)
    {
        UserMaker userMaker = null;
        switch (TypeOfUser.valueOf(type.toUpperCase()))
        {
            case CUSTOMER:
                userMaker = new CustomerMaker();
                break;
            case SELLER:
                userMaker = new SellerMaker();
                break;
            default:
                throw new RuntimeException("The type of user does not exist");
        }
        return userMaker;
    }

    public static void authorization() {

        System.out.println("Enter login");
        String login = inScanner.next();
        System.out.println("Enter password");
        String password = inScanner.next();
        User user = userService.getUser(login, password);
        if (user != null)
        {
            authorizedUser = user;
        }
    }
}
