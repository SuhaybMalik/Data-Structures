import java.util.Date;

public class Couple {

    private Person bride;
    private Person groom;

    public Couple(Person b, Person g) {

        bride = b;
        groom = g;

    }

    public void setBride(Person b) {
        bride = b;
    }

    public Person getBride() {
        return bride;
    }

    public void setGroom(Person g) {
        groom = g;
    }

    public Person getGroom() {
        return groom;
    }

}
