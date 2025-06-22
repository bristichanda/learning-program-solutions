package org.example;

public class Light {
    private final String room;

    public Light(String room) {
        this.room = room;
    }

    public void turnOn() {
        System.out.println(room + " light is ON");
    }

    public void turnOff() {
        System.out.println(room + " light is OFF");
    }
}
