package com.quintrix.jfs.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseModel {

  static final String DB_URL = "jdbc:mysql://localhost/";
  static final String USER = "root";
  static final String PASS = "Ethantho5_";


  public static Connection getConnection() throws Exception {

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("MySQL JDBC Driver Registered!");
    } catch (ClassNotFoundException e) {
      System.out.println("MySQL JDBC Driver not found !!");
    }

    try {
      Connection connection = DriverManager.getConnection(DB_URL + "PEOPLE", USER, PASS);
      System.out.println("Connected to Database ... ");
      return connection;
    } catch (SQLException e) {
      Connection connection = DriverManager.getConnection(DB_URL + "PEOPLE", USER, PASS);
      System.out.println("Connected to Database ... ");
      Statement stmnt = connection.createStatement();
      String sql;
      try {
        sql = "CREATE DATABASE PEOPLE";
        stmnt.executeUpdate(sql);
        System.out.println("Database PEOPLE created");
      } catch (Exception d) {
        // TODO: handle exception
        System.out.println("Database PEOPLE already exists!");
      }
      e.printStackTrace();
    }
    return null;
  }

  public void createTable(String tableName) throws Exception {

    try {
      Connection connection = getConnection();
      PreparedStatement create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS "
          + tableName
          + "(id int NOT NUll AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
      create.executeUpdate();
      System.out.println("Table Created");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Function completed.");
    }

  }

  public void tableInsert(String TableName, String First, String Last) throws Exception {

    String first = First;
    String last = Last;

    try {

      Connection connection = getConnection();
      PreparedStatement insert = connection.prepareStatement("INSERT IGNORE INTO " + TableName
          + " (first,last) VALUES('" + first + "','" + last + "')");
      insert.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Insert completed");
    }

  }

  public void tableDelete(String TableName, String First, String Last) throws Exception {

    try {

      Connection connection = getConnection();
      PreparedStatement delete = connection.prepareStatement(
          "DELETE FROM " + TableName + " WHERE first = '" + First + "' AND last = '" + Last + "'");
      delete.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Delete completed");
    }

  }

  public ArrayList<String> selectAll(String TableName) throws Exception {

    try {

      Connection connection = getConnection();
      PreparedStatement search =
          connection.prepareStatement("SELECT id,first,last FROM " + TableName);
      ResultSet result = search.executeQuery();

      ArrayList<String> array = new ArrayList<String>();
      while (result.next()) {
        String temp = result.getString("id") + " " + result.getString("first") + " "
            + result.getString("last");
        array.add(temp);
      }
      System.out.println("All records have been found");
      return array;
    } catch (SQLException e) {
      System.out.println("error has occured");
      e.printStackTrace();
    }
    return null;
  }



}
