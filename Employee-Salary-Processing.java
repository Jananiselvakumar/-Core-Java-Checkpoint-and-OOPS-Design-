import java.util.Scanner;

abstract class Employee {
    private int employeeId;
    private String employeeName;

    Employee(int id, String name) {
        this.employeeId = id;
        this.employeeName = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    double salary;

    FullTimeEmployee(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    double calculateSalary() {
        return salary;
    }
}

class ContractEmployee extends Employee {
    int days;
    double rate;

    ContractEmployee(int id, String name, int days, double rate) {
        super(id, name);
        this.days = days;
        this.rate = rate;
    }

    double calculateSalary() {
        return days * rate;
    }
}

public class Employee-Salary-Processing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();
        int id = sc.nextInt();
        String name = sc.next();

        Employee e;

        if (choice == 1) {
            double amount = sc.nextDouble();
            e = new FullTimeEmployee(id, name, amount);
        } else {
            int d = sc.nextInt();
            double r = sc.nextDouble();
            e = new ContractEmployee(id, name, d, r);
        }

        System.out.println("Employee ID: " + e.getEmployeeId());
        System.out.println("Employee Name: " + e.getEmployeeName());
        System.out.printf("Salary: %.2f%n", e.calculateSalary());

        sc.close();
    }
}
