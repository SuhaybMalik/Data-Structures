import java.util.Date;

public class Wedding {

    private Date localDate;
    private Couple coupleBeingMarried;
    private String location;
    private String theme;

    public Wedding(Date d, Couple c, String l, String t) {

        localDate = d;
        coupleBeingMarried = c;
        location = l;
        theme = t;

    }

    public void setLocalDate(Date d) {
        localDate = d;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setCoupleBeingMarried(Couple c) {
        coupleBeingMarried = c;
    }

    public Couple getCoupleBeingMarried() {
        return coupleBeingMarried;
    }

    public void setLocation(String l) {
        location = l;
    }

    public String getLocation() {
        return location;
    }

    public void setTheme(String t) {
        theme = t;
    }

    public String getTheme() {
        return theme;
    }

}
