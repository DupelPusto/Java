public class Driver {
    private int phonenumber;
    private String email;
    private String name;
    private String surname;
    public Transport transport;



    public Driver(){}
    public Driver(String name, String surname, int phonenumber, String email){
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
        this.email = email;

    }

    public void tostring() {

        System.out.printf("Інформація про водія:\nІм'я: %s\nПрізвище: %s\nЕлектронна пошта: %s\nНомер телефона: %d\n",
                name, surname,email,phonenumber);
    }
}
