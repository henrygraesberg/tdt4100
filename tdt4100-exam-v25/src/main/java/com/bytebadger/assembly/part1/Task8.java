package com.bytebadger.assembly.part1;

/**
 * This program demonstrates the use of abstract classes and method overriding in Java.
 * It defines an abstract class Shape with subclasses Circle, Rectangle, and Triangle.
 * Each subclass implements the calculateArea method to compute the area of the respective shape.
 */

abstract class Shape {
    String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double calculateArea();

    public void displayInfo() {
        System.out.println("Shape: " + name);
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width, height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Triangle extends Shape {
    double base, height;

    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Task8 {
    public static void main(String[] args) {
        Shape shape = new Circle(5);
        shape.displayInfo();
        System.out.println("Area: " + shape.calculateArea());

        //Shape rectangle = shape;
        shape = new Rectangle(4, 6);
        //new Rectangle(4,6);
        //rectangle = new Rectangle(4, 6);

        shape.displayInfo();
        System.out.println("Area: " + shape.calculateArea());


    }
}
