package com.OOP.clases;

public class Staff {
    private String name;
    private int age;
    private String workPosition;
    private int workExperience;
    private String staffKind;
    private String getWorkPosition(){
        return workPosition;
    }

    public Staff(String name, int age, String position, int exp, String kind){
        setName(name);
        setAge(age);
        setWorkPosition(position);
        setWorkExperience(exp);
        setStaffKind(kind);
    }



    public void tostring(){
        System.out.printf("Інформація про співробітника:\nІм'я: %s\nВік: %d\nТип персоналу: %s\n" +
                "Посада: %s\nДосвід роботи: %d", getName(),getAge(), getStaffKind(), getWorkPosition(), getWorkExperience());
    }

    public int gerWorkExperience(){
        return workExperience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void setStaffKind(String staffKind) {
        this.staffKind = staffKind;
    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public String getStaffKind() {
        return staffKind;
    }
}
