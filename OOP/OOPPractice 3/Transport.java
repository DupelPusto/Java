package com.OOP.clases;

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
        setCarModel(model);
        setCarGovnumber(carnumber);
    }



    public void tostring(){
        System.out.printf("Інформація про транспорт: \nМарка та модель автомобіля: %s\nДержавний номерний знак: %s\n",
                getCarModel(),getCarGovnumber());
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarGovnumber(String carGovnumber) {
        this.carGovnumber = carGovnumber;
    }

    public String getCarGovnumber() {
        return carGovnumber;
    }

    public String getCarModel() {
        return carModel;
    }


}
