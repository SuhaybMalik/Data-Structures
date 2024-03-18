public class Pizza {

    private String[] toppings = new String[10];
    private double price;
    private String stringDescription;

    public Pizza(String[] t, int n) {

        for(int i = 0; i < t.length; i++) {
            toppings[i] = t[i];
        }

        price = 14 + (2 * n);
        stringDescription = "Your Selected toppings are: ";

        if(t.length == 0) {
            stringDescription += "No Toppings Selected";
        }

        else {

            for (int i = 0; i < t.length; i++) {

                if (i < t.length - 1) {
                    stringDescription += t[i] + ", ";
                }

                else {
                    stringDescription += t[i];
                }

            }

        }

    }

    public void setToppings(String[] t) {

        for(int i = 0; i < t.length; i++) {
            toppings[i] = t[i];
        }

    }

    public String[] getToppings() {
        return toppings;
    }

    public void setPrice(double p) {
        price = p;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return stringDescription += ". The price of a pizza is $" + price;
    }

}
