package project.utilities;



public class PublicUtilities {
    String utilType;
    double utilPrice;
    double consumed;
    double consumeLimit;

    public PublicUtilities() {
    }


    protected String computePayment(double price, double consumed, String unit){
        double res = price * consumed;
        String result = String.format("Payment size is %.3f UAH for %.3f %s", res, consumed, unit);
        return result;
    }

    protected String limitRemainingCompute(double limit, double consumed, String unit){
        double res = limit - consumed;
        String result = String.format("%.3f %s is remaining for present period", res, unit);
        return result;
    }


    public void setUtilType(String utilType) { this.utilType = utilType; }

    public void setUtilPrice(double utilPrice) { this.utilPrice = utilPrice; }

    public void setConsumed(double consumed) { this.consumed = consumed; }

    public void setConsumeLimit(double consumeLimit) { this.consumeLimit = consumeLimit; }


    public double getConsumed() { return consumed; }

    public double getUtilPrice() { return utilPrice; }
}
