public class Employee {

    //fields for employee data
    private String name;
    private int ID;
    private int salary;

    public Employee(String name, int ID, int salary) {

        this.name = name;
        this.ID = ID;
        this.salary = salary;

    }

    //getter and setter methods for employee data
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
