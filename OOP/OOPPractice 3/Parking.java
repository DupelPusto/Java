package com.OOP.clases;

public class Parking {
    private boolean isFree = true;
    private boolean isPaid = false;
    private boolean isPaidbyCash;
    private String parkplaceInfo;
    private String isfree;
    private String ispaid;
    private String paymenttype;





    public Parking(boolean isFree, boolean isPaid, Transport transport, boolean ispaidbycash){
        setFree(isFree);
        setPaid(isPaid);
        if (ispaidbycash){
            setPaidbyCash(true);
        }else{
            setPaidbyCash(false);
        }
        this.parkplaceInfo = transport.getCarModel();
    }


    public void tostring() {
        if(isFree){
            isfree = "Вільне";
            parkplaceInfo = "Вільне";
        } else {
            isfree = "Зайняте";
        }

        if (isPaid){
            ispaid = "Сплачено";
        }else {
            ispaid = "Несплачено";
        }

        if (isPaid == false) {
            paymenttype = "Несплачено";
        }


        if(isPaidbyCash){
            paymenttype = "Готівка";
        }else {
            paymenttype = "Безготівкова";
        }

        System.out.printf("Інформація про паркувальне місце:\n: \nВільне місце: %s\nЗапаркований транспорт: %s\nОплачено: %s\n" +
                "Форма оплати: %s\n",isfree, parkplaceInfo,ispaid,paymenttype);
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setPaidbyCash(boolean paidbyCash) {
        isPaidbyCash = paidbyCash;
    }
}
