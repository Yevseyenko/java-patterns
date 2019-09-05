package com.patterns.behaviour;

public class VisitorApp {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor hooligan = new HooliganVisitor();

        body.accept(hooligan);
        engine.accept(hooligan);

        Element car = new CarElement();
        car.accept( new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());
    }
}

interface Visitor {
    void visit(EngineElement engine);

    void visit(BodyElement body);

    void visit(CarElement car);

    void visit(WheelElement wheel);
}

interface Element {
    void accept(Visitor visitor);
}

class BodyElement implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class WheelElement implements Element {
    private String name;

    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {
    Element[] elements;

    public CarElement() {
        this.elements = new Element[]{
                new WheelElement("forward left"),
                new WheelElement("forward right"), new WheelElement("backward left"),
                new WheelElement("backward right"), new BodyElement(), new EngineElement()
        };
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element elem : elements) {
            elem.accept(visitor);
        }
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {
    public void visit(EngineElement engine) {
        System.out.println("Start engine");
    }

    public void visit(BodyElement body) {
        System.out.println("Knock on body");
    }

    public void visit(CarElement car) {
        System.out.println("Smoke salon");
    }

    public void visit(WheelElement wheel) {
        System.out.println("Knock " + wheel.getName()+" wheel");
    }
}

class MechanicVisitor implements Visitor {
    public void visit(EngineElement engine) {
        System.out.println("Check engine");
    }

    public void visit(BodyElement body) {
        System.out.println("Polish body");
    }


    public void visit(CarElement car) {
        System.out.println("Check salon");
    }

        public void visit(WheelElement wheel) {
            System.out.println("Pump " + wheel.getName()+" wheel");
    }
}