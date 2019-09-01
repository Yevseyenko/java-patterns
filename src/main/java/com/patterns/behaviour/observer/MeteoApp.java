package com.patterns.behaviour.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MeteoApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setMeasurements(25, 760);
        station.setMeasurements(-5,745);
    }
}

interface Observed {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
// We have a list of observers that work in different way with calling the same method
class MeteoStation implements Observed {
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p) {
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer {
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("The weather changed. Temperature = " + temp + ", Pressure" + presser);
    }
}

class FileObserver implements Observer {
    public void handleEvent(int temp, int presser) {
        try (PrintWriter pw = new PrintWriter(File.createTempFile("TempPressure", "_txt"))) {
            pw.print("The weather changed. Temperature = " + temp + ", Pressure" + presser);
            pw.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}