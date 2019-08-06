package com.patterns;

public class AbstractFactory {
    public static void main(String[] args) {
        DeviceFactory deviceFactory = getFactoryByCountryCode("EN");
        Mouse m = deviceFactory.getMouse();
        Keyboard k = deviceFactory.getKeyboard();
        Touchpad t = deviceFactory.getTouchpad();
        m.click();
        k.println();
        t.track(10,5);
    }

    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupporterd Country Code: " + lang);
        }
    }
}

interface Mouse {
    void click();

    void dbclick();

    void scroll(int deraction);
}

interface Keyboard {
    void print();

    void println();
}

interface Touchpad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    Touchpad getTouchpad();
}

class RuMouse implements Mouse {
    public void click() {
        System.out.println("Klik");
    }

    @Override
    public void dbclick() {
        System.out.println("Dvoinoi click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Skrollim vverch");
        else if (direction < 0)
            System.out.println("Skrollim vniz");
        else
            System.out.println("Ne skrollim");
    }
}

class RuKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Pechataem stroku");
    }

    @Override
    public void println() {
        System.out.println("Pechataem stroku s pervodom stroki");
    }
}

class RuTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Peredvinulis na " + s + "pixelej");
    }
}

class EnMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Click");
    }

    @Override
    public void dbclick() {
        System.out.println("Double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Scroll up");
        else if (direction < 0)
            System.out.println("Scroll down");
        else
            System.out.println("Don't scroll");
    }
}

class EnKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Print");
    }

    @Override
    public void println() {
        System.out.println("Print Line");
    }
}

class EnTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved " + s + "pixeles");
    }
}

class RuDeviceFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new RuMouse();
    }

    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}

class EnDeviceFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new EnMouse();
    }

    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}