package com.quintrix.jfs;

import com.quintrix.jfs.models.DatabaseModel;

public class DatabaseTesting {

  static final String DB_URL = "jdbc:mysql://localhost:3306/";
  static final String USER = "root";
  static final String PASS = "Ethantho5_";


  public static void main(String[] args) {
    // TODO Auto-generated method stub

    DatabaseModel database = new DatabaseModel();

    try {
      database.createTable("PEOPLE");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      database.tableInsert("PEOPLE", "Robert", "Hillsman");
      database.tableInsert("PEOPLE", "Trevor", "Clinton");
      database.tableInsert("PEOPLE", "Simone", "Costanzo");
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      database.tableDelete("PEOPLE", "Robert", "Hillsman");
      database.tableDelete("PEOPLE", "Trevor", "Clinton");
      database.tableDelete("PEOPLE", "Simone", "Costanzo");
    } catch (Exception e) {
      e.printStackTrace();
    }

  } // main

}
