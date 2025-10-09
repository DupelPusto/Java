package com.OOP.clases;

public class Driver {
    private int phonenumber;
    private String email;
    private String name;
    private String surname;
    public Transport transport;



    public Driver(){}
    public Driver(String name, String surname, int phonenumber, String email){
        setName(name);
        setSurname(surname);
        setPhonenumber(phonenumber);
        setEmail(email);

    }

    public void tostring() {

        System.out.printf("Інформація про водія:\nІм'я: %s\nПрізвище: %s\nЕлектронна пошта: %s\nНомер телефона: %d\n",
                getName(), getSurname(),getEmail(),getPhonenumber());
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


}
