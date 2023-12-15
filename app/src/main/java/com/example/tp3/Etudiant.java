package com.example.tp3;

public class Etudiant {
    private int id;
    private String name;
    private String lastName;
    private int mark;

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

    public String getLastName() {
        return lastName;
    }

    public Etudiant(int id, String name, String lastName, int mark) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mark = mark;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
