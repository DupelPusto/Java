public class Parking {
    private boolean isFree = true;
    private boolean isPaid = false;
    private boolean isPaidbyCash;
    private String parkplaceInfo;
    private String isfree;
    private String ispaid;
    private String paymenttype;





    public Parking(boolean isFree, boolean isPaid, Transport transport, boolean ispaidbycash){
        this.isFree = isFree;
        this.isPaid = isPaid;
        if (ispaidbycash){
            this.isPaidbyCash = true;
        }else{
            this.isPaidbyCash = false;
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
}
