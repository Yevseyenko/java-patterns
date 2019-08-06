package com.patterns;

public class Command {

}

interface Commander{
    void execute();
}

//Reciver
class  Comp{
    void start (){
        System.out.println("Start");
    }
    void stop(){
        System.out.println("Stop");
    }
    void reset(){
        System.out.println("Reset");
    }
}
class StartCommand implements Commander{
    public void execute(){

    }
}