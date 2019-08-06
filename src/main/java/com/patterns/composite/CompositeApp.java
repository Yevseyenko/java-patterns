package com.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {

    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();

        Shape square3 = new Square();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();

        Composite composit = new Composite();
        Composite composit1 = new Composite();
        Composite composit2 = new Composite();
        composit1.addComponent(square1);
        composit1.addComponent(square2);
        composit1.addComponent(triangle1);

        composit2.addComponent(square3);
        composit2.addComponent(circle1);
        composit2.addComponent(circle2);
        composit2.addComponent(circle3);

        composit.addComponent(composit1);
        composit.addComponent(composit2);

        composit.draw();
    }
}

interface Shape {
    void draw();
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Hello I am square");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Hello I am Triangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Hello I am Circle");
    }
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}