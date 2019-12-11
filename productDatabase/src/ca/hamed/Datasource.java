package ca.hamed;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;

public class Datasource {
    private final String DATABASE_BUSINESS = "business1.db";
    private final String CONNECTION_STRING = "jdbc:sqlite:src/";
    private Connection conn;
    private PreparedStatement queryProductsInfo;
    private PreparedStatement queryCategoryInfo;
    private PreparedStatement queryCustomersInfo;
    private PreparedStatement queryProductCategoryCurrenciesInfo;
    private PreparedStatement queryProductCategoryInfo;
    private PreparedStatement queryProduct;
    private PreparedStatement queryCategory;
    private PreparedStatement queryCustomer;
    private PreparedStatement queryCard;
    private PreparedStatement insertIntoProducts;
    private PreparedStatement insertIntoCategories;
    private PreparedStatement insertIntoCustomers;
    private PreparedStatement queryProductCategory;
    private PreparedStatement insertIntoProductCategories;

    private PreparedStatement deleteProductCategories;
    private PreparedStatement deleteProducts;
    private PreparedStatement updateProducts;
    private PreparedStatement updateCustomers;
    private PreparedStatement deleteCustomers;
    private PreparedStatement deleteCards;


    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING + DATABASE_BUSINESS);


            StringBuilder productcategoryquery = new StringBuilder();
            productcategoryquery.append("SELECT p.name AS Product,  p.price AS Price, c.name AS Category ");
            productcategoryquery.append("FROM products p ");
            productcategoryquery.append("JOIN products_categories pc ");
            productcategoryquery.append("ON p.id = pc.products_id ");
            productcategoryquery.append("JOIN categories c ");
            productcategoryquery.append("ON c.id = pc.categories_id ");
            productcategoryquery.append("JOIN currencies cur ");
            productcategoryquery.append("ON p.currency_id = cur.id ");
            productcategoryquery.append("where p.active = 1 ");
            productcategoryquery.append("ORDER BY p.name");
            queryProductCategoryInfo = conn.prepareStatement(productcategoryquery.toString());


            StringBuilder sb = new StringBuilder();
            sb.append("SELECT p.name AS Product,  p.price AS Price, c.name AS Category, ");
            sb.append("(SELECT curp.value FROM currencies_price curp WHERE id = 2) * p.price AS PriceUSD, ");
            sb.append("(SELECT curp.value FROM currencies_price curp WHERE id = 4) * p.price AS PriceJPY ");
            sb.append("FROM products p ");
            sb.append("JOIN products_categories pc ");
            sb.append("ON p.id = pc.products_id ");
            sb.append("JOIN categories c ");
            sb.append("ON c.id = pc.categories_id ");
            sb.append("JOIN currencies cur ");
            sb.append("ON p.currency_id = cur.id ");
            sb.append("JOIN currencies_price curp ");
            sb.append("ON curp.currency_id  = cur.id ");
            sb.append("where p.active = 1 ");
            sb.append("ORDER BY p.name");
            queryProductCategoryCurrenciesInfo = conn.prepareStatement(sb.toString());

            queryProduct = conn.prepareStatement("SELECT * FROM products WHERE name = ? AND active = 1");
            queryProductsInfo = conn.prepareStatement("SELECT * FROM products WHERE active = 1");
            queryCard = conn.prepareStatement("SELECT * FROM cards WHERE active = 1");
            queryCategory = conn.prepareStatement("SELECT * FROM categories WHERE name = ? AND active = 1");
            queryCategoryInfo = conn.prepareStatement("SELECT * FROM categories WHERE active = 1");
            queryCustomersInfo = conn.prepareStatement("SELECT * FROM customers WHERE active = 1");
            insertIntoProducts = conn.prepareStatement("INSERT INTO products (name, description, price, currency_id, created_at) VALUES(?, ? , ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertIntoCategories = conn.prepareStatement("INSERT INTO categories (name, sub_category_id, created_at) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            queryProductCategory = conn.prepareStatement("SELECT * FROM products_categories WHERE products_id = ? AND categories_id = ? AND active = 1");
            queryCustomer = conn.prepareStatement("SELECT * FROM customers WHERE email = ? AND active = 1", Statement.RETURN_GENERATED_KEYS);
            insertIntoProductCategories = conn.prepareStatement("INSERT INTO products_categories (products_id, categories_id, created_at) VALUES (?, ?, ?)");
            insertIntoCustomers = conn.prepareStatement("INSERT INTO customers (name, email, address, phone, created_at) VALUES (? , ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            deleteProductCategories = conn.prepareStatement("UPDATE products_categories SET active = 0 WHERE products_id = ? ");
            deleteProducts = conn.prepareStatement("UPDATE products SET active = 0 WHERE id = ? ");
            updateProducts = conn.prepareStatement("UPDATE products SET price = ? WHERE id = ? ");
            updateCustomers = conn.prepareStatement("UPDATE customers SET name = ? WHERE id = ? ");
            deleteCustomers = conn.prepareStatement("UPDATE customers SET active = 0 WHERE id = ? ");
            deleteCards = conn.prepareStatement("UPDATE cards SET active = 0 WHERE customer_id = ? ");


            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {


            if (queryProductsInfo != null) {
                queryProductsInfo.close();
            }

            if (queryCategoryInfo != null) {
                queryCategoryInfo.close();
            }


            if (queryProductCategoryCurrenciesInfo != null) {
                queryProductCategoryCurrenciesInfo.close();
            }

            if (queryProductCategoryInfo != null) {
                queryProductCategoryInfo.close();
            }

            if (queryCategory != null) {
                queryCategory.close();
            }
            if (queryProduct != null) {
                queryProduct.close();
            }

            if (queryCard != null) {
                queryCard.close();
            }

            if (insertIntoCategories != null) {
                insertIntoCategories.close();
            }
            if (insertIntoProducts != null) {
                insertIntoProducts.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public void queryProducts() {

        try {
            ResultSet rs = queryProductsInfo.executeQuery();

            System.out.println("\u001B[36m" + "_________________________________________________PRODUCTS TABLE_________________________________________________");
            System.out.println("________________________________________________________________________________________________________________");
            System.out.format("%-8s %-18s %-52s %-8s %-8s\n", "id", "name", "description", "price", "currency_id");
            System.out.println("________________________________________________________________________________________________________________");
            while (rs.next()) {
                System.out.format("%-8s %-18s %-52s %-8s %-8s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("currency_id")
                );
            }
            System.out.println("\u001B[37m");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }


//
//
//    public List<Product> queryProducts() {
//
//        List<Product> pl = new ArrayList<>();
//        try {
//
//            ResultSet rs = queryProductsInfo.executeQuery();
//
//            while (rs.next()) {
//                pl.add(new Product(
//                                rs.getInt("id"),
//                                rs.getString("name"),
//                                rs.getString("description"),
//                                rs.getDouble("price"),
//                                rs.getInt("currency_id")
//                        )
//                );
//            }
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//        return pl;
//
//    }



    public void queryCategory() {

        try {
            ResultSet rs = queryCategoryInfo.executeQuery();

            System.out.println("\u001B[36m" + "______________CATEGORIES TABLE________________");
            System.out.println("______________________________________________");
            System.out.format("%-8s %-15s %-8s\n", "id", "name", "sub_category_id");
            System.out.println("______________________________________________");
            while (rs.next()) {
                System.out.format("%-8s %-15s %-8s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("sub_category_id")
                );
            }
            System.out.println("\u001B[37m");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }





//    public List<Category> queryCategory() {
//
//        List<Category> cl = new ArrayList<>();
//        try {
//            ResultSet rs = queryCategoryInfo.executeQuery();
//
//            while (rs.next()) {
//                cl.add(new Category(
//                                rs.getInt("id"),
//                                rs.getString("name"),
//                                rs.getInt("sub_category_id")
//                        )
//                );
//            }
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//        return cl;
//
//    }


    public void queryCustomers() {

        try {
            ResultSet rs = queryCustomersInfo.executeQuery();

            System.out.println("\u001B[36m" + "_________________________________________________CUSTOMERS TABLE_________________________________________________");
            System.out.println("________________________________________________________________________________________________________________");
            System.out.format("%-8s %-22s %-35s %-20s %-25s\n", "id", "name", "email", "address", "phone");
            System.out.println("________________________________________________________________________________________________________________");
            while (rs.next()) {
                System.out.format("%-8s %-22s %-35s %-20s %-20s\n",
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("address"),
                                rs.getString("phone")
                );
            }
            System.out.println("\u001B[37m");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }



//    public List<Customer> queryCustomers() {
//
//        List<Customer> cl = new ArrayList<>();
//
//        try {
//            ResultSet rs = queryCustomersInfo.executeQuery();
//
//            while (rs.next()) {
//                cl.add(new Customer(
//                                rs.getInt("id"),
//                                rs.getString("name"),
//                                rs.getString("email"),
//                                rs.getString("address"),
//                                rs.getString("phone")
//                        )
//                );
//            }
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//        return cl;
//
//    }

    public void queryProductCategory() {

        try {

            ResultSet rs = queryProductCategoryInfo.executeQuery();
            System.out.println("\033[0;34m" + "___________________________________________________________" + "\033[0;37m");
            System.out.format("%-25s %-16s %-20s\n", "Product", "Price", "Category");
            System.out.format("%-25s %-16s %-20s\n", "", "CAD", "");

            System.out.println("\033[0;34m" + "___________________________________________________________" + "\033[0;37m");
            while (rs.next()) {
                System.out.format("%-25s %-16.2f %-20s\n",
                        rs.getString("Product"),
                        rs.getDouble("Price"),
                        rs.getString("Category")
                );
            }
            System.out.println("\033[0;34m" + "___________________________________________________________" + "\033[0;37m");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void queryProductCategoryCurrencies() {

        try {


            ResultSet rs = queryProductCategoryCurrenciesInfo.executeQuery();
            System.out.println("___________________________________________________________________________________________________");
            System.out.format("%-25s %-18s %-18s %-18s %-20s\n", "Product", "Price", "Price", "Price", "Category");
            System.out.format("%-25s %-18s %-18s %-18s %-20s\n", "", "CAD", "USD", "JPY", "");
            System.out.println("___________________________________________________________________________________________________");
            while (rs.next()) {
                System.out.format("%-25s %-18.2f %-18.2f %-18.2f %-20s\n",
                        rs.getString("Product"),
                        rs.getDouble("Price"),
                        rs.getDouble("PriceUSD"),
                        rs.getDouble("PriceJPY"),
                        rs.getString("Category")
                );
            }
            System.out.println("_________________________________________________________________________________________________");


        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private int insertProduct(String name, String description, double price, int currency_id) throws SQLException {

        queryProduct.setString(1, name);
        ResultSet results = queryProduct.executeQuery();

        if (results.next()) {

            return results.getInt("id");

        } else {

            insertIntoProducts.setString(1, name);
            insertIntoProducts.setString(2, description);
            insertIntoProducts.setDouble(3, price);
            insertIntoProducts.setInt(4, currency_id);
            insertIntoProducts.setString(5, new Timestamp(currentTimeMillis()).toString());

            //this returns integer
            //execute will return boolean
            int affectedRows = insertIntoProducts.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert product!");
            }

            ResultSet generatedKeys = insertIntoProducts.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get id for product");
            }
        }
    }

    private int insertCategory(String name, int subCategory) throws SQLException {

        queryCategory.setString(1, name);
        ResultSet results = queryCategory.executeQuery();

        if (results.next()) {

            return results.getInt("id");

        } else {

            insertIntoCategories.setString(1, name);
            insertIntoCategories.setInt(2, subCategory);
            insertIntoCategories.setString(3, new Timestamp(currentTimeMillis()).toString());

            //this returns integer
            //execute will return boolean
            int affectedRows = insertIntoCategories.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert category!");
            }

            ResultSet generatedKeys = insertIntoCategories.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get id for category");
            }
        }
    }

    public void insertProductCategory(String productName, String productDescription, double productPrice, int currency_id, String categoryName, int subCategory) throws SQLException {

        try {
            conn.setAutoCommit(false);

            int productId = insertProduct(productName, productDescription, productPrice, currency_id);
            int categoryId = insertCategory(categoryName, subCategory);

            //Check if exist on product category already
            queryProductCategory.setInt(1, productId);
            queryProductCategory.setInt(2, categoryId);
            //new Timestamp(currentTimeMillis())

            ResultSet pc = queryProductCategory.executeQuery();
            if (pc.next()) {
                throw new SQLException("This product and category already exist and linked in the database");
            }

            insertIntoProductCategories.setInt(1, productId);
            insertIntoProductCategories.setInt(2, categoryId);
            insertIntoProductCategories.setString(3, new Timestamp(currentTimeMillis()).toString());


            int affectedRows = insertIntoProductCategories.executeUpdate();

            if (affectedRows == 1) {
                System.out.println("Commitment completed successfully");
                conn.commit();
            } else {
                throw new SQLException("The product category insert failed");
            }

        } catch (SQLException e) {
            System.out.println("Insert product category exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("rollback failed " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }

        }

    }


    public void updateProducts(String productName, double productPrice) throws SQLException {

        queryProduct.setString(1, productName);
        ResultSet results = queryProduct.executeQuery();

        if (results.next()) {

            int products_id = results.getInt("id");

            updateProducts.setDouble(1, productPrice);
            updateProducts.setInt(2, products_id);


            int affectedRows = updateProducts.executeUpdate();
            if (affectedRows == 1) {
                System.out.println("updated successfully");
            }

            if (affectedRows != 1) {
                throw new SQLException("Couldn't update product!");
            }

        } else {
            System.out.println("product does not exist");
        }
    }



    public void deleteProductCategory(String productName) throws SQLException {


        queryProduct.setString(1, productName);
        ResultSet results = queryProduct.executeQuery();

        if (results.next()) {

            int products_id = results.getInt("id");
            //update products set active = 0 where id = products_id
            deleteProductCategories.setInt(1,products_id);
            deleteProducts.setInt(1, products_id);
//            deleteProductCategories.executeQuery();

            int affectedRows = deleteProductCategories.executeUpdate();
            int affectedRows2 = deleteProducts.executeUpdate();
            if (affectedRows == 1) {
                System.out.println("Commitment completed successfully");
            }

            if (affectedRows != 1) {
                throw new SQLException("Couldn't delete product_category!");
            }

            if (affectedRows2 != 1) {
                throw new SQLException("Couldn't delete product");
            }

        } else {
            System.out.println("product does not exist");
        }
    }


    //inserting customer should insert card automaticaly

    //change this method to a transaction
    public int insertCustomer(String name, String email, String address, String phone ) throws SQLException{

        queryCustomer.setString(1, email);
        ResultSet results = queryCustomer.executeQuery();

        if (results.next()) {

            return results.getInt("id");

        } else {

            insertIntoCustomers.setString(1, name);
            insertIntoCustomers.setString(2, email);
            insertIntoCustomers.setString(3, address);
            insertIntoCustomers.setString(4, phone);
            insertIntoCustomers.setString(5, new Timestamp(currentTimeMillis()).toString());

            //this returns integer
            //execute will return boolean
            int affectedRows = insertIntoCustomers.executeUpdate();
            if (affectedRows == 1) {
                System.out.println("Commitment completed successfully");
            }

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert customer!");
            }

            ResultSet generatedKeys = insertIntoCustomers.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get id for customer");
            }
        }

    }

    public void updateCustomers(String customerEmail , String customerNewName) throws SQLException {

        queryCustomer.setString(1, customerEmail);
        ResultSet results = queryCustomer.executeQuery();

        if (results.next()) {

            int customer_id = results.getInt("id");

            updateCustomers.setString(1, customerNewName);
            updateCustomers.setInt(2, customer_id);


            int affectedRows = updateCustomers.executeUpdate();
            if (affectedRows == 1) {
                System.out.println("updated successfully");
            }

            if (affectedRows != 1) {
                throw new SQLException("Couldn't update product!");
            }


        } else {
            System.out.println("customer does not exist");
        }

    }


    public void deleteCustomers(String customerEmail) throws SQLException {


        queryCustomer.setString(1, customerEmail);
        ResultSet results = queryCustomer.executeQuery();

        if (results.next()) {

            int customer_id = results.getInt("id");
            //update customers set active = 0 where id = customer_id
            deleteCustomers.setInt(1,customer_id);
            deleteCards.setInt(1, customer_id);
//            deleteProductCategories.executeQuery();

            int affectedRows = deleteCustomers.executeUpdate();
            int affectedRows2 = deleteCards.executeUpdate();
            if (affectedRows == 1) {
                System.out.println("deleted successfully");
            }

//            if (affectedRows != 1) {
//                throw new SQLException("Couldn't delete customer!");
//            }

//            if (affectedRows2 != 1) {
                else {throw new SQLException("Couldn't delete customer");
            }

        } else {
            System.out.println("customer does not exist");
        }
    }

}