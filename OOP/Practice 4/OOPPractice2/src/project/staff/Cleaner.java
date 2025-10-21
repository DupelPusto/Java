package project.staff;

public class Cleaner extends Staff {

    public Cleaner(String name, String surname, int age, String position, int exp) {
        super(name, surname, age, position, exp);
        setCategory("Secure staff");
    }

    @Override
    public String doResponsibilities() {
        String res = "From cleaner " + this.name + " " + this.surname + ": I will clean the floor from now";
        return res;
    }

    @Override
    public String reportStatus() {
        String res = "From cleaner " + this.name + " " + this.surname + ": I`m going to have a lunch";
        return res;
    }

    @Override
    public String inspectEquipment() {
        String res = "From cleaner " + this.name + " " + this.surname + ": I have to inspect my equipment, maybe one of them is broken";
        return res;
    }
}
