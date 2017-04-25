package com.example.laksh_pc.facapp;


public class Student {

    private String name, regno,ap;

    public Student(String name, String regno, String ap) {
        this.name = name;
        this.regno = regno;
        this.ap = ap;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }
}
