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
        this.name = name;
        this.age = age;
        this.workPosition = position;
        this.workExperience = exp;
        this.staffKind = kind;
    }

    public void tostring(){
        System.out.printf("Інформація про співробітника:\nІм'я: %s\nВік: %d\nТип персоналу: %s\n" +
                "Посада: %s\nДосвід роботи: %d", name,age, staffKind, workPosition, workExperience);
    }



    public int gerWorkExperience(){
        return workExperience;
    }


}
