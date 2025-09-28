import java.time.LocalDateTime;

public class Transport {
    private String carModel;
    private String carGovnumber;
    private LocalDateTime enterDate;
    private LocalDateTime exitDate;

    public static void getTransportInfo(){
        return;
    }

    public Transport(){

    }

    public Transport(String model, String carnumber){
        this.carModel = model;
        this.carGovnumber = carnumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void tostring(){
        System.out.printf("Інформація про транспорт: \nМарка та модель автомобіля: %s\nДержавний номерний знак: %s\n",
                carModel,carGovnumber);
    }
}
