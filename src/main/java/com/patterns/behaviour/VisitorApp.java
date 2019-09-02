package com.patterns.behaviour;

public class VisitorApp {
    public static void main (String [] args){

    }
}

interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
}

interface Element{
    void accept(Visitor visitor);
}

class BodyElement implements Element {
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}

class EngineElement implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}