class Employee {
  private String name;
  private int yearJoined;
  private double basicSalary;

  // Constructors
  public Employee() {

  }

  public Employee(String name, int yearJoined, double basicSalary) {
    this.name = name;
    this.yearJoined = yearJoined;
    this.basicSalary = basicSalary;
  }

  // Getters and Setters
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYearJoined() {
    return this.yearJoined;
  }

  public void setYearJoined(int yearJoined) {
    this.yearJoined = yearJoined;
  }

  public double getBasicSalary() {
    return this.basicSalary;
  }

  public void setBasicSalary(double basicSalary) {
    this.basicSalary = basicSalary;
  }

  // User defined methods
  @Override
  public String toString() {
    String title = "\nEmployee"; 
    String sep = "\n-------------------------------------------------------------------";
    String name = "\nName: " + this.getName();
    String yearJoined = "\nYear Joined: " + this.getYearJoined();
    String basicSalary = String.format("\nBasic Salary: RM %.2f", this.getBasicSalary());

    return title + sep + name + yearJoined + basicSalary;
  }

  @Override
  public boolean equals(Object obj) {
    Employee employeeToCheck = (Employee) obj;
    return this.name.equals(employeeToCheck.getName());
  }

  public double calculateSalary() {
    return this.basicSalary;
  }
}

class CommissionEmployee extends Employee {
  private double grossSale, commissionRate;

  // Constructors
  public CommissionEmployee() {
    this("", 0, 0.0, 0.0, 0.0);
  }

  public CommissionEmployee(String name, int yearJoined, double basicSalary, double grossSale, double commissionRate) {
    super(name, yearJoined, basicSalary);
    this.grossSale = grossSale;
    this.commissionRate = commissionRate;
  }

  public double getGrossSale() {
    return this.grossSale;
  }

  public void setGrossSale(double grossSale) {
    this.grossSale = grossSale;
  }

  public double getCommissionRate() {
    return this.commissionRate;
  }

  public void setCommissionRate(double commissionRate) {
    this.commissionRate = commissionRate;
  }

  // User definied methods
  @Override
  public String toString() {
    String title = "\nCommission Employee"; 
    String sep = "\n-------------------------------------------------------------------";
    String name = "\nName: " + this.getName();
    String yearJoined = "\nYear Joined: " + this.getYearJoined();
    String basicSalary = String.format("\nBasic Salary: RM %.2f", this.getBasicSalary());
    String grossSale = String.format("\nGross Sale: RM %.2f", this.getGrossSale());
    String commisionRate = String.format("\nCommission Rate: RM %.2f", this.getCommissionRate());

    return title + sep + name + yearJoined + basicSalary + grossSale + commisionRate;
  }

  @Override
  public boolean equals(Object obj) {
    CommissionEmployee comEmpToCheck = (CommissionEmployee) obj;

    return super.equals(comEmpToCheck);
  }

  @Override
  public double calculateSalary() {
    return this.getBasicSalary() + this.grossSale * this.commissionRate;
  }
}

class Clerk extends Employee {
  private double allowance;
  private int overtimeHours;
  private double overtimeRate;

  // Constructors
  public Clerk() {
    this("", 0, 0.0, 0.0, 0, 0.0);
  }

  public Clerk(String name, int yearJoined, double basicSalary, double allowance, int overtimeHours,
      double overtimeRate) {
    super(name, yearJoined, basicSalary);
    this.allowance = allowance;
    this.overtimeHours = overtimeHours;
    this.overtimeRate = overtimeRate;
  }

  // Getters and Setters
  public double getAllowance() {
    return this.allowance;
  }

  public void setAllowance(double allowance) {
    this.allowance = allowance;
  }

  public int getOvertimeHours() {
    return this.overtimeHours;
  }

  public void setOvertimeHours(int overtimeHours) {
    this.overtimeHours = overtimeHours;
  }

  public double getOvertimeRate() {
    return this.overtimeRate;
  }

  public void setOvertimeRate(double overtimeRate) {
    this.overtimeRate = overtimeRate;
  }

  // User defined methods
  @Override
  public String toString() {
    String title = "\nClerk"; 
    String sep = "\n-------------------------------------------------------------------";
    String name = "\nName: " + this.getName();
    String yearJoined = "\nYear Joined: " + this.getYearJoined();
    String basicSalary = String.format("\nBasic Salary: RM %.2f", this.getBasicSalary());
    String allowance = String.format("\nAllowance: RM %.2f", this.getAllowance());
    String overtimeHours = "\nOvertime Hours: " + this.getOvertimeHours();
    String overtimeRate = String.format("\nOvertime Rate: RM %.2f", this.getOvertimeRate());

    return title + sep + name + yearJoined + basicSalary + allowance + overtimeHours + overtimeRate;
  }

  @Override
  public boolean equals(Object obj) {
    Clerk clerkToCheck = (Clerk) obj;

    return super.equals(clerkToCheck);
  }

  @Override
  public double calculateSalary() {
    return this.getBasicSalary() + this.allowance + this.overtimeHours * this.overtimeRate;
  }
}

public class P6Q3 {
  private static void printElements(Employee[] empArray) {
    for (Employee emp : empArray) {
      System.out.println(emp + String.format("\nMonthly Salary: RM %.2f", emp.calculateSalary()));
    }
  }
  public static void main(String[] args) {
    Employee[] empArray = new Employee[3];

    empArray[0] = new Employee("Marcus Lee", 2019, 3000.0);
    empArray[1] = new CommissionEmployee("David Lee", 2019, 3000.0, 300.0, 5.0);
    empArray[2] = new Clerk("Pinky Lee", 2019, 3000.0, 500.0, 10, 12.0);

    printElements(empArray);

    Employee empToCheck = new Employee("Marcus Lee", 2019, 3000.0);
    CommissionEmployee comEmpToCheck = new CommissionEmployee("David Chan", 2019, 3000.0, 300.0, 5.0);
    Clerk clerkToCheck = new Clerk("Pinky Lee", 2019, 3000.0, 500.0, 10, 12.0);

    System.out.println(String.format("\nEmployee Check\n---------------------\n%s == %s is [%b]\n", empArray[0].getName(), empToCheck.getName(), empArray[0].equals(empToCheck)));
    System.out.println(String.format("Commission Employee Check\n---------------------\n%s == %s is [%b]\n", empArray[1].getName(), comEmpToCheck.getName(), empArray[1].equals(comEmpToCheck)));
    System.out.println(String.format("Clerk Check\n---------------------\n%s == %s is [%b]\n", empArray[2].getName(), clerkToCheck.getName(), empArray[2].equals(clerkToCheck)));
  }
}