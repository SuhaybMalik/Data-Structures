//used as rough-work file to test my functions

public class TestEmployee {

    public static void main(String[] args) {
        //testing the methods for our linked list

        Employee suhayb = new Employee("Suhayb", 69, 55000);
        Employee matt = new Employee("Matt", 44, 64500);
        Employee lucian = new Employee("Lucian", 445, 44000);
        Employee kadin = new Employee("Kadin", 65, 99000);

        EmployeeLinkedList list = new EmployeeLinkedList();
        list.insertNode(suhayb);
        list.insertNode(matt);
        list.insertNode(suhayb);
        list.insertNode(lucian);
        list.insertNode(kadin);
        list.insertNode(suhayb);

        System.out.println(list.toString());
        EmployeeLinkedList list2 = new EmployeeLinkedList();
        System.out.println(list2.toString());


    }

}