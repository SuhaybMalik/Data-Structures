public enum BloodGroups {

    A("+", "-"), B("+", "-"), AB("+", "-"), O("+", "-");
    private final String positive;
    private final String negative;

    BloodGroups(String positive, String negative) {

        this.positive = positive;
        this.negative = negative;

    }

    public String getNegative() {
        return negative;
    }

    public String getPositive() {
        return positive;
    }

}
