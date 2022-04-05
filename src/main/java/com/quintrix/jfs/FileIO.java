package com.quintrix.jfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class FileIO {

  public static void main(String[] args) {
    // Creating file

    // java.io package
    File file = new File("c://temp//testFile1.txt");

    // Create the file
    try {
      if (file.createNewFile()) {
        System.out.println("File is created!");
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    FileWriter writer = null;
    try {
      writer = new FileWriter(file);
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    try {
      writer.write("Test data");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      writer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }



    // java.nio package
    Path path = Paths.get("dataPath/test.text");

    boolean doesFileExist = Files.exists(path, new LinkOption[] {LinkOption.NOFOLLOW_LINKS});

    List<String> lines = Arrays.asList("1st line", "2nd line");

    try {
      Files.write(Paths.get("file6.txt"), lines, StandardCharsets.UTF_8);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // Files.write(Paths.get("file6.txt"),lines,StandardCharsets.UTF_8,
    // StandardOpenOption.CREATE,StandardOpenOption.APPEND);


    // Fileoutput stream

    String data = "Test data";

    FileOutputStream out = null;
    try {
      out = new FileOutputStream("c://temp//testFile2.txt)");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      out.write(data.getBytes());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      out.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
