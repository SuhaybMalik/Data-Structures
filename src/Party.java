public class Party {

    private int guests;

    public Party(int g) {

            guests = g;

    }

    public void setGuests(int g) {

        guests = g;

    }

    public int getGuests() {

        return guests;

    }

    public String displayInvitation() {

        return "Please come to my party!";

    }

}
