package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class Fruit{
private double volume;
}

class Apple extends Fruit{
    private String color;
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}

class Pear extends Fruit{
    private String form;
    public void setForm(String form){
        this.form = form;
    }
    public String getForm(){
        return this.form;
    }
}


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        Apple apple = new Apple();
        apple.setColor("Green");

        Pear pear = new Pear();
        pear.setForm("Oval");

        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(pear);
        System.out.println(fruits);
        for (Fruit fruit: fruits){
            System.out.println(fruit);
        }

        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,3,4));
        Integer[] moreInts = {4,5,6};
        collection.addAll(Arrays.asList(moreInts));
        System.out.printf(collection.toString());
    }
}