package com.patterns;

public class Facade {

    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//
//        DVDRom dvd = new DVDRom();
//        dvd.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("Turning power on");
    }

    void off() {
        System.out.println("Turning power off");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        System.out.println("Disc is loaded");
        data = true;
    }

    void unload() {
        System.out.println("Disc is loaded");
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Copying data from dvd in progress");
        } else {
            System.out.println("Insert dvd with data");
        }
    }
}
