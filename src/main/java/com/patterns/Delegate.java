package com.patterns;

public class Delegate {
    public static void main(String[] args) {
       A a = new A();
        a.f();
        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();
        painter.setGraphics(new Triangle());
        painter.draw();
        painter.setGraphics(new Circle());
        painter.draw();
    }
}

class A {
    void f() {
        System.out.println("f()");
    }
}

class B {
    A a = new A();

    void f() {
        a.f();
    }
}

interface Graphics {
    void draw();
}

class Triangle implements Graphics {
    @Override
    public void draw() {
        System.out.println("Drawing triangle");
    }
}

class Square implements Graphics {
    @Override
    public void draw() {
        System.out.println("Drawing square");
    }
}

class Circle implements Graphics {
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}

class Painter {
    Graphics graphics;

    void setGraphics(Graphics g) {
        graphics = g;
    }

    void draw() {
        graphics.draw();
    }
}