package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("dog.jpg");

        // First access - image loads from remote server
        image1.display();

        System.out.println();

        // Second access - image is cached
        image1.display();

        System.out.println();

        // Load another image
        Image image2 = new ProxyImage("cat.jpg");
        image2.display();
    }
}