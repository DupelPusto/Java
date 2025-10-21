package project.common;

public class Driver {
    private long phonenumber;
    private String email;
    private String name;
    private String surname;
    private Transport transport;




    public Driver(String name, String surname, long phonenumber, String email){
        setName(name);
        setSurname(surname);
        setPhonenumber(phonenumber);
        setEmail(email);

    }

    @Override
    public String toString() {
        String res = getName() + " " + getSurname() + ", " + getEmail() + ", " + getPhonenumber();
        return res;
    }


    public void setPhonenumber(long phonenumber) {
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

    public void setTransport(Transport transport) { this.transport = transport; }

    public long getPhonenumber() {
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
