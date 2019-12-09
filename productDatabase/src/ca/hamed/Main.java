package ca.hamed;

import ca.hamed.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Datasource ds = new Datasource();

        if (ds.open()) {
            System.out.println("connected to db");
        } else {
            System.out.println("not connected to db");
        }



        boolean exit = false;

        Scanner sn = new Scanner(System.in);

        do {
            System.out.println("___________________________________________");
            System.out.println("What do you want to do ? please select one");
            System.out.println("___________________________________________");
            System.out.println("1 - Create");
            System.out.println("2 - Read");
            System.out.println("3 - Update");
            System.out.println("4 - Delete");

            int userChoice = sn.nextInt();

            switch (userChoice) {
                case 1: {

                        System.out.println("1 - Create a product");
                        System.out.println("2 - Create a customer");

                        int userChoice1 = sn.nextInt();
                        sn.nextLine();

                        switch (userChoice1) {
                            case 1: {
                                System.out.println("productName : ");
                                String productName = sn.nextLine();
                                System.out.println("productDescription : ");
                                String productDescription = sn.nextLine();
                                System.out.println("productPrice : ");
                                double productPrice = sn.nextDouble();
                                sn.nextLine();
                                System.out.println("currency_id : ");
                                int currency_id = sn.nextInt();
                                sn.nextLine();
                                System.out.println("categoryName : ");
                                String categoryName = sn.nextLine();
                                System.out.println("subCategory : ");
                                int subCategory = sn.nextInt();
                                sn.nextLine();

                                try {

                                    ds.insertProductCategory(productName, productDescription, productPrice, currency_id, categoryName, subCategory);

                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }

                                break;
                            }

                            case 2: {

                                System.out.println("customerName : ");
                                String customerName = sn.nextLine();
                                System.out.println("customerEmail : ");
                                String customerEmail = sn.nextLine();
                                System.out.println("customerAddress : ");
                                String customerAddress = sn.nextLine();
                                System.out.println("customerPhone");
                                String customerPhone = sn.nextLine();

                                try {

                                     ds.insertCustomer(customerName, customerEmail, customerAddress, customerPhone );

                                 } catch (SQLException e){
                                     System.out.println(e.getMessage());
                                 }

                                break;
                            }

                            default:
                                exit = true;
                                break;
                        };

                    break;
                }



                case 2: {

                    System.out.println("1 - Read products");
                    System.out.println("2 - Read customers");

                    int userChoice1 = sn.nextInt();
                    sn.nextLine();

                    switch (userChoice1) {
                        case 1: {

                            List<Product> productList = new ArrayList<>();
                            productList = ds.queryProducts();

                            for(Product product : productList){
                                System.out.println(product.toString());
                            }

                            break;
                        }

                        case 2: {

                            List<Customer> customerList = new ArrayList<>();
                            customerList = ds.queryCustomers();

                            for(Customer customer : customerList){
                                System.out.println(customer.toString());
                            }

                            break;
                        }

                        default:
                            exit = true;
                            break;
                    };

                    break;
                }


                case 3: {

                    System.out.println("1 - Update products");
                    System.out.println("2 - Update customers");

                    int userChoice1 = sn.nextInt();
                    sn.nextLine();

                    switch (userChoice1) {
                        case 1: {

                            System.out.println("productName : ");
                            String productName = sn.nextLine();
                            System.out.println("productPrice : ");
                            double productPrice = sn.nextDouble();
                            sn.nextLine();
                            try {
                                ds.updateProducts(productName , productPrice);
                            } catch(SQLException e){
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        case 2: {

                            System.out.println("customerEmail : ");
                            String customerEmail = sn.nextLine();
                            System.out.println("customerNewName : ");
                            String customerNewName = sn.nextLine();
                            try {
                                ds.updateCustomers(customerEmail , customerNewName);
                            } catch(SQLException e){
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        default:
                            exit = true;
                            break;
                    };

                    break;
                }


                case 4: {

                    System.out.println("1 - Delete a product");
                    System.out.println("2 - Delete a customer");

                    int userChoice1 = sn.nextInt();
                    sn.nextLine();

                    switch (userChoice1) {
                        case 1: {

                            try {
                                System.out.println("productName : ");
                                String productName = sn.nextLine();
                                ds.deleteProductCategory(productName);
                            } catch(SQLException e){
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        case 2: {

                            try {
                                System.out.println("customerEmail : ");
                                String customerEmail = sn.nextLine();
                                ds.deleteCustomers(customerEmail);
                            } catch(SQLException e){
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        default:
                            exit = true;
                            break;
                    };

                    break;
                }

                default:
                    exit = true;
                    System.out.println("bye");
                    break;
            }

        } while (!exit);

        sn.close();
//    }


//        //???
//        Invoice invoice1 = new Invoice(1,1,"Saygin" , "2019.12.22", new Invoice_details(1,1,2,1),1,"card");
//
//
//        Datasource ds = new Datasource();
//
//        if (ds.open()) {
//            System.out.println("connected to db");
//        } else {
//            System.out.println("not connected to db");
//        }
//
//        List<Product> productList = new ArrayList<>();
//        productList = ds.queryProducts();
//
//        for(Product product : productList){
//            System.out.println(product.toString());
//        }
//
//        List<Category> categoryList = new ArrayList<>();
//        categoryList = ds.queryCategory();
//
//        for(Category category : categoryList){
//            System.out.println(category.toString());
//        }
//
//        ds.queryProductCategoryCurrencies();
//
//        ds.queryProductCategory();
//
//        try {
//
//            ds.insertProductCategory("Cookie",
//                    "cooked with chocolate and mapple srup",
//                    2.25,
//                    1,
//                    "Snack",
//                    5);
//
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//
//        ds.queryProductCategory();
//
//        //add a customer
//        try {
//
//            ds.insertCustomer("Alen",
//                    "Alen@gmail.com",
//                    "435 granville",
//                    "6049580348");
//
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//
//
//
//        try {
//
//            ds.insertProductCategory("Bread",
//                    "fresh baked bread",
//                    1.55,
//                    1,
//                    "Food",
//                    5);
//
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//
//
//        List<Customer> customerList;
//        customerList = ds.queryCustomers();
//
//        for(Customer i : customerList){
//            System.out.println(i.toString());
//        }
//
//        ds.close();
//    }


    ds.close();
    }

}