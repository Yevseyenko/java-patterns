package com.patterns;
//In this pattern we have one class which connects few objects in chaining depends on previous
public class StateApp {
    public static void main(String[] args) {
        Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for (int i = 0; i < 10; i++) {
            radio.nextStation();
            radio.play();
        }
    }
}

interface Station {
    void play();
}

class Radio7 implements Station {
    public void play() {
        System.out.println("Radio 7...");
    }
}

class RadioDFM implements Station {
    public void play() {
        System.out.println("Radio DFM...");
    }
}

class VestiFM implements Station {
    public void play() {
        System.out.println("Vesti FM...");
    }
}

//Context depends on state it would have different behaviour
//Radio can play in different way depends on station

class Radio {
    Station station;

    void setStation(Station st) {
        station = st;
    }

    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new VestiFM());
        } else if (station instanceof VestiFM) {
            setStation(new Radio7());
        }
    }

    void play() {
        station.play();
    }
}