class Employee {
  private String name;
  private double salary;

  public Employee() {
    this.name = "";
    this.salary = 0.0;
  }

  public Employee(String employeeName) {
    this.name = employeeName;
  }

  public Employee(String employeeName, double currentSalary) {
    this.name = employeeName;
    this.salary = currentSalary;
  }

  public void raiseSalary(double percent) {
    salary = salary + (salary * percent / 100.0);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return this.salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
}

public class P4Q1 {
  public static void main(String[] args) {
    Employee marcus = new Employee("Marcus Lee", 5000.0);

    System.out.println("P4Q2b");
    System.out.printf("Employee Name: %s\nBefore Salary Raise: %.2f", marcus.getName(), marcus.getSalary());

    double newSalary = marcus.getSalary() + (marcus.getSalary() * 8 / 100.0);
    marcus.setSalary(newSalary);

    System.out.printf("\nAfter Salary Raise: %.2f\n", marcus.getSalary());

    Employee dennis = new Employee();
    dennis.setName("Dennis Lau");
    dennis.setSalary(3000.0);

    Employee liana = new Employee("Liana Ling");
    liana.setSalary(4000.0);

    Employee higherSalaryEmployee;

    if (dennis.getSalary() > liana.getSalary()) 
      higherSalaryEmployee = dennis;
    else
      higherSalaryEmployee = liana;

    System.out.println("\nP4Q2c");
    System.out.printf("Employee with higher salary\nName: %s\nSalary: %.2f\n", higherSalaryEmployee.getName(), higherSalaryEmployee.getSalary());
    System.out.printf("Total salary of %s and %s is %.2f", dennis.getName(), liana.getName(), dennis.getSalary()+liana.getSalary());
  }
}