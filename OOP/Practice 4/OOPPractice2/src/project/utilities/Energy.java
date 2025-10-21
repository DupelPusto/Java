package project.utilities;

public class Energy extends PublicUtilities {

    private static final String UNIT = "kW";
    private static final String TYPE = "Energy";
    private static final double LIMIT = 300;

    public Energy() {
        setUtilType(TYPE);
        setConsumeLimit(LIMIT);
        setUtilPrice(4.3);
    }



    public String computePayment() {
        return super.computePayment(getUtilPrice(), getConsumed(), UNIT);
    }


    public String limitRemainingCompute() {
        return super.limitRemainingCompute(LIMIT, getConsumed(), UNIT);
    }

}
