public class EmployeeLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;


    public EmployeeLinkedList() {

        head = null;
        tail = null;

    }

    public void insertNode(Employee employee) {
        //inserts a new node into the list based on a new employee object. Also adjusts head and tail
        EmployeeNode node = new EmployeeNode(employee);

        if(head == null) {
            head = node;
        }

        else {
            tail.setNext(node);
        }

        tail = node;

    }

    public EmployeeNode searchNode(String employeeName) {
        //searches the employees based on employee name and returns the relevant node
        EmployeeNode current = head;

        if(current.getEmployee().getName().equals(employeeName)) {
            return current;
        }

        else {

            while(current.getNext() != null) {

                String name = current.getNext().getEmployee().getName();

                if(name.equals(employeeName)) {
                    return current.getNext();
                }

                else {
                    current = current.getNext();
                }

            }

        }

        return null;

    }

    public void deleteNode(String employeeName) {
        //deletes the first instance of the relevant node
        EmployeeNode current = head;

        if(!current.getEmployee().getName().equals(employeeName)) {

            while(current.getNext() != null) {

                String name = current.getNext().getEmployee().getName();

                if(name.equals(employeeName)) {

                    if(current.getNext().getNext() == null) {
                        tail = current;
                    }

                    current.setNext(current.getNext().getNext());

                    return;

                }

                else {
                    current = current.getNext();
                }

            }

        }

        else {

            head = current.getNext();
            current.setNext(null);

        }

    }

    public void printList(){
        //prints the whole list
        EmployeeNode current = head;
        System.out.println("========Print Start=============");
        System.out.println(current.getEmployee().getName());

        while(current.getNext() != null){

            System.out.println(current.getNext().getEmployee().getName());
            current = current.getNext();

        }

        System.out.println("========Print End=============");

    }

    public void removeAfter(EmployeeNode node) {
        //remove the node that comes after the node that is passed
        if(node != null && node.getNext() != null) {

            if(node.getNext().getNext() == null) {

                node.setNext(null);
                tail = node;

            }

            else {

                node.setNext(node.getNext().getNext());

            }

        }

    }

    public EmployeeLinkedList copy(EmployeeNode node) {
        //copies the linked list starting from the node passed
        EmployeeLinkedList copiedList = new EmployeeLinkedList();
        EmployeeNode current = node;

        while(current != null) {

            copiedList.insertNode(current.getEmployee());
            current = current.getNext();

        }

        return copiedList;

    }

    public void removeDuplicate(String key) {
        //removes all nodes with the key
        EmployeeNode current = head;
        EmployeeNode previous = null;

        while(current != null) {

            String name = current.getEmployee().getName();

            if(name.equals(key)) {

                if(previous == null) {

                    head = current.getNext();

                    if(current.getNext() == null) {

                        tail = null;
                        return;

                    }

                }

                else {

                    previous.setNext(current.getNext());

                    if (current.getNext() == null) {
                        tail = previous;
                    }

                }

            }

            else {
                previous = current;
            }

            current = current.getNext();

        }

    }

    public int max(EmployeeNode node) {
        //returns the maximum salary of an employee in the list
        int temp = 0;
        EmployeeNode current = node;

        if(node == null) {
            return temp;
        }

        else {

            while(current != null) {

                if(current.getEmployee().getSalary() > temp) {
                    temp = current.getEmployee().getSalary();
                }

                current = current.getNext();

            }

            return temp;

        }

    }

    public void clear() {
        //clear the list
        head = null;
        tail = null;

    }

    public String listFormat() {
        //lists out all employees
        EmployeeNode current = head;
        String s = "";

        if(current != null) {

            s += current.getEmployee().getName();

            while(current.getNext() != null) {

                s += ", " + current.getNext().getEmployee().getName();
                current = current.getNext();

            }

        }

        return s;

    }

    @Override
    public String toString() {

        EmployeeNode current = head;
        String s = "========List Start=============\n";

        if(current != null) {
            s += current.getEmployee().getName() + "\n";

            while(current.getNext() != null){

                s += current.getNext().getEmployee().getName() + "\n";
                current = current.getNext();

            }

        }

        s += "========List End=============";

        return s;

    }

    public EmployeeNode getHead() {
        return head;
    }

    public EmployeeNode getTail() {
        return tail;
    }

}
