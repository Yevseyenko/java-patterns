package com.patterns.behaviour.state;

public class StateApp {
    public static void main (String [] args){
        Human human = new Human();
        human.setState(new Work());
//        human.doSomething();
//        human.doSomething();
//        human.doSomething();
        for(int i=0 ; i<10;i++){
            human.doSomething();
        }
    }
}

class Human {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

//State
//Changing states going on inside Work or it can be inside of context
interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {
    public void doSomething(Human context) {
        System.out.println("Working!!!");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity {
    private int count = 0;

    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Relaxing (Zzz)");
            count++;
          // context.setState(this);
        }else {
            context.setState(new Work());
        }
    }
}