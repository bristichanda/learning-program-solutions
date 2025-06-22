package org.example;

public class Main {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setWifiCard("Intel AX210")
                .build();

        System.out.println("Gaming PC Configuration:");
        gamingPC.showConfig();

        System.out.println();

        Computer officePC = new Computer.Builder("Intel i3", "8GB")
                .setStorage("500GB HDD")
                .build();

        System.out.println("Office PC Configuration:");
        officePC.showConfig();
    }
}
