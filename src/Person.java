import java.util.Date;

public class Person {

    private String firstName;
    private String lastName;

    public Person(String f, String l) {

        firstName = f;
        lastName = l;

    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public String getLastName() {
        return lastName;
    }

}