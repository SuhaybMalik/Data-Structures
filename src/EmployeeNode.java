public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next;


    public EmployeeNode(Employee employee) {

        this.employee = employee;
        next = null;

    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

}
