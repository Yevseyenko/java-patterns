package com.java8;

interface Sayable{
    public String say();
}

public class LambdaExpressionExample3 {
    public static void main(String [] args){
        Sayable s=()->{
            return "I have nothing to";
        };
    }
}
