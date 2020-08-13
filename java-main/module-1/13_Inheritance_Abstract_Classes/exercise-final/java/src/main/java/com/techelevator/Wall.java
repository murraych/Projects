package com.techelevator;

/**
 * Wall
 */
public abstract class Wall {

    private String name;
    private String color;

    public abstract int getArea();

    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}