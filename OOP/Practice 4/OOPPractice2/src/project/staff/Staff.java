package project.staff;

public class Staff {
    protected String name;
    protected String surname;
    protected int age;
    protected String workPosition;
    protected int workExperience;
    protected String category;


    public Staff(String name, String surname, int age, String position, int exp){
        setName(name);
        setSurname(surname);
        setAge(age);
        setWorkPosition(position);
        setWorkExperience(exp);
    }


    public String doResponsibilities(){
        String result = "";
        return result;
    }

    public String reportStatus(){
        String result = "";
        return result;
    }

    public String inspectEquipment(){
        String result = "";
        return result;
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

    public void setSurname(String surname) { this.surname = surname; }

    public void setCategory(String category) { this.category = category; }

}
