public class BloodData {

    private String bloodType;
    private String Rh;

    public BloodData() {

        this.bloodType = BloodGroups.O.name();
        this.Rh = BloodGroups.O.getPositive();

    }

    public BloodData(String bloodType, String Rh) {

        this.bloodType = bloodType;
        this.Rh = Rh;

    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRh() {
        return Rh;
    }

    public void setRh(String Rh) {
        this.Rh = Rh;
    }

    @Override
    public String toString() {
        return bloodType + Rh;
    }
}