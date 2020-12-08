package com.example.springboot.springboot.models.designmode23.factory;

public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape audi = shapeFactory.getShape("Audi");
        audi.draw();

        Shape bmw = shapeFactory.getShape("Bmw");
        bmw.draw();

        Shape mazDa = shapeFactory.getShape("MazDa");
        mazDa.draw();
    }
}
