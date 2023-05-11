package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {


      try {
        // step-1 register the driver
        Class.forName("com.mysql.jdbc.Driver");

        // 2- connection object creation
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store","root", "Ritesh_90");


        // 3- statement object creation
        Statement statement = connection.createStatement();
      //  Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
/*
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into Customers(first_name, last_name, birth_date, address, city, state)\n" +
          "Values (?, ?, ?, ?,?, ?)");
        preparedStatement.setString(1,"nkdebug");
        preparedStatement.setString(2,"blr");
        preparedStatement.setString(3,"1990-01-01");
        preparedStatement.setString(4,"2nd Main Road Kasturi Nagar");
        preparedStatement.setString(5,"blr");
        preparedStatement.setString(6,"KA");

        */


        // 4- execution of query
       // int res = preparedStatement.executeUpdate();
       // System.out.println(res + " "+ "records updated");

     /*   PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE Customers set first_name=? where customer_id=?");
        preparedStatement1.setString(1, "pkdebug");
        preparedStatement1.setInt(2, 13);
         int res = preparedStatement1.executeUpdate();
         System.out.println(res + " "+ "records updated");

    */
        int result = statement.executeUpdate("ALTER TABLE customers\n" +
          "        add Email varchar(255);");
        System.out.println(result + " "+ "records updated");


      /*


          // scrollable resultset
        ResultSet resultSet = statement.executeQuery("select * from customers");
        resultSet.absolute(6);
        System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2) + " "+ resultSet.getString(8));


        // DELETE
                int result = statement.executeUpdate("DELETE from Customers where customer_id=12");
                System.out.println(result + " "+ "records updated");
       // UPDATE

        int result = statement.executeUpdate("UPDATE Customers set first_name='rahul' where customer_id=12");
        System.out.println(result + " "+ "records updated");

       // CREATE
        int result = statement.executeUpdate("INSERT into Customers(first_name, last_name, birth_date, address, city, state)\n" +
          "Values ('nkdebug', 'blr', '1992-01-01', 'bengaluru','city', 'IN')");
        System.out.println(result + " "+ "records updated");


       // READ
       ResultSet resultSet = statement.executeQuery("select * from customers");
        while(resultSet.next()) {
          System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2) + " "+ resultSet.getString(8));
        }
    */
        // 5- close connection
        connection.close();

      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }

    }
}
