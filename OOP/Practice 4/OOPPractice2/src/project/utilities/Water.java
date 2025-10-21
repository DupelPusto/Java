package project.utilities;

public class Water extends PublicUtilities {

    private static final double LIMIT = 35;
    private static final String UNIT = "m3";
    private static final String TYPE = "Water";

    public Water() {
        setUtilType(TYPE);
        setConsumeLimit(LIMIT);
        setUtilPrice(29.3);
    }



    public String computePayment() {
        return super.computePayment(getUtilPrice(), getConsumed(), UNIT);
    }


    public String limitRemainingCompute() {
        return super.limitRemainingCompute(LIMIT, getConsumed(), UNIT);
    }
}
