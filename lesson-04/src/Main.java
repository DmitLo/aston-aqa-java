import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // сотрудники
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("John Doe", "Manager", "johndoe@example.com", "555-1234", 50000.0, 35);
        employees[1] = new Employee("Jane Smith", "Developer", "janesmith@example.com", "555-5678", 60000.0, 28);
        employees[2] = new Employee("Bob Johnson", "Salesperson", "bobjohnson@example.com", "555-9012", 45000.0, 42);
        employees[3] = new Employee("Alice Lee", "Designer", "alicelee@example.com", "555-3456", 55000.0, 31);
        employees[4] = new Employee("Tom Wilson", "Engineer", "tomwilson@example.com", "555-7890", 70000.0, 45);

        // информация о сотрудниках страше 40
        for (Employee i : employees) {
            if (i.getAge() > 40) {
                System.out.println(i);
            }
        }

        // парк с атттракционами
        Park park = new Park();
        System.out.println(park);
    }
}