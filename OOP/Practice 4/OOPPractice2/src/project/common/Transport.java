package project.common;


public class Transport {
    private String carModel;
    private String carMark;
    private String carGovnumber;
    private short id = 0;
    private Driver driver;



    public Transport(String mark, String model, String carnumber){
        setCarMark(mark);
        setCarModel(model);
        setCarGovnumber(carnumber);
    }

    public void showTransportInfo(){
        System.out.printf("\nTransport info: \nDriver: %s\nMark: %s\nModel: %s\nGovernment number: %s\nIs located on parking place № %d\n",
                driver.toString(), getCarMark(), getCarModel(),getCarGovnumber(), getId());
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarGovnumber(String carGovnumber) {
        this.carGovnumber = carGovnumber;
    }

    public void setId(short id) { this.id = id; }

    public void setCarMark(String carMark) { this.carMark = carMark; }

    public void setDriver(Driver driver) { this.driver = driver; }

    public String getCarGovnumber() {
        return carGovnumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarMark() { return carMark; }

    public short getId() { return id; }

}
