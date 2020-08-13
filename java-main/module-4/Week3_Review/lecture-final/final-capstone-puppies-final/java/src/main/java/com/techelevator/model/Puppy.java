package com.techelevator.model;

/**
 * Puppy
 */
public class Puppy {

    private int id;
    private String name;
    private int weight;
    private String gender;
    private boolean paperTrained;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isPaperTrained() {
        return paperTrained;
    }

    public void setPaperTrained(boolean paperTrained) {
        this.paperTrained = paperTrained;
    }

    public Puppy(String name, int weight, String gender, boolean paperTrained) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
        this.paperTrained = paperTrained;
    }

    public Puppy(int id, String name, int weight, String gender,
            boolean paperTrained) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.gender = gender;
        this.paperTrained = paperTrained;
    }

    public Puppy() {
    }

}