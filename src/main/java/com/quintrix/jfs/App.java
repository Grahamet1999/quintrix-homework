package com.quintrix.jfs;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    // Primitive Data Types

    // boolean
    boolean True = true;
    boolean False = false;

    // char
    char firstLetter = 'a';
    char lastLetter = '\r';

    // byte
    byte b = 100;

    // short
    short s = 30000;

    // int
    int ii = 100000000;

    // long
    long l = 1234567890;

    // Float
    float f = 3.145f;

    // Double
    double d = 3.13457599923384753929348D;


    // OVERFLOW

    int i = Integer.MAX_VALUE;
    int j = i + 1;

    System.out.println("Overflow example integer: " + j);

    double dd = Double.MAX_VALUE;
    double ddd = dd + 1;

    System.out.println("Overflow example double: " + ddd);

    System.out.println("Hello World!");
  }
}
