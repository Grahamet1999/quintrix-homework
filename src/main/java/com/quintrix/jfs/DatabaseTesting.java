package com.quintrix.jfs;

import java.sql.SQLException;
import com.quintrix.jfs.models.DatabaseModel;

public class DatabaseTesting {

  static String table = "PEOPLE";

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub

    DatabaseModel database = new DatabaseModel();

    try {
      database.createTable(table);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      database.tableInsert(table, "Robert", "Hillsman");
      database.tableInsert(table, "Trevor", "Clinton");
      database.tableInsert(table, "Simone", "Costanzo");
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      // database.tableDelete(table, "Robert", "Hillsman");
      // database.tableDelete(table, "Trevor", "Clinton");
      database.tableDelete(table, "Simone", "Costanzo");
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      System.out.println(database.selectAll(table));
    } catch (SQLException e) {
      e.printStackTrace();
    }

  } // main

}
