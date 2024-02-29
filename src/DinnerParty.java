public class DinnerParty extends Party {

    private int dinnerChoice;
    private String preferences;

    public DinnerParty(int g, int d, String p) {

        super(g);
        dinnerChoice = d;
        preferences = p;

    }

    public void setDinnerChoice(int d) {

        dinnerChoice = d;

    }

    public int getDinnerChoice() {

        return dinnerChoice;

    }

    public void setPreferences(String p) {

        preferences = p;

    }

    public String getPreferences() {

        return preferences;

    }

}