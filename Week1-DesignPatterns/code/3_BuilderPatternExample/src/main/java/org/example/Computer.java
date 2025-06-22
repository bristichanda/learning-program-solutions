package org.example;


public class Computer {

    private final String cpu;
    private final String ram;

    private final String storage;
    private final String graphicsCard;
    private final String wifiCard;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.wifiCard = builder.wifiCard;
    }

    public static class Builder {
        private final String cpu;
        private final String ram;

        private String storage;
        private String graphicsCard;
        private String wifiCard;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setWifiCard(String wifiCard) {
            this.wifiCard = wifiCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public void showConfig() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + (storage != null ? storage : "N/A"));
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "N/A"));
        System.out.println("Wi-Fi Card: " + (wifiCard != null ? wifiCard : "N/A"));
    }
}

