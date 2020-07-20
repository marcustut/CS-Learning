import java.util.Scanner;
import java.util.regex.Pattern;

class Registration {
  private Owner owner;
  private Car car;
  private int registrationNum;
  private static int registrationIndex = 1000;

  // Constructors
  public Registration(Owner owner, Car car) {
    this.owner = owner;
    this.car = car;
    this.registrationNum = getRegistrationIndex();
  }

  // Getters and Setters
  public Owner getOwner() {
    return this.owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public Car getCar() {
    return this.car;
  }

  public void setCar(Car car) {
    this.car = car;
  }
  
  public int getRegistrationNum() {
    return this.registrationNum;
  }

  public void setRegistrationNum() {
    System.out.println("Registration can't be changed, it's a static variable.");
  }

  // Public Methods
  public String toString() {
    String ownerDetails = this.owner.toString();
    String carDetails = this.car.toString();
    String registrationDetails = String.format("%-10d %-31s %s", this.registrationNum, ownerDetails, carDetails);
    // String registrationDetails = String.format("%d       %s      %s %s %s %d %s %s %.1f\n", this.registrationNum, this.owner.getOwnerName(), this.owner.getOwnerIC(), this.car.getCarPlate(), this.car.getColor(), this.car.getYearManufactured(), this.car.getMake().getMake(), this.car.getMake().getModel(), this.car.getMake().getEngineCap());
    return registrationDetails;
  }

  // Static Methods
  private static int getRegistrationIndex() {
    registrationIndex++;
    return registrationIndex;
  }
}

class Owner {
  private String ownerIC, ownerName;

  // Constructors
  public Owner() {
    this("", "");
  }

  public Owner(String ownerIC, String ownerName) {
    this.ownerIC = ownerIC;
    this.ownerName = ownerName;
  }

  // Getters and Setters
  public String getOwnerIC() {
    return this.ownerIC;
  }

  public void setOwnerIC(String ownerIC) {
    this.ownerIC = ownerIC;
  }

  public String getOwnerName() {
    return this.ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  // User Defined Methods
  public String toString() {
    String onwerDetails = String.format("%-15s %s", this.ownerName, this.ownerIC);
    return onwerDetails;
  }
}

class Car {
  private int yearManufactured;
  private String color, carPlate;
  private CarType make;

  // Constructors
  public Car() {
    this(0, "", "", null);
  }

  public Car(int yearManufactured, String color, String carPlate, CarType make) {
    this.yearManufactured = yearManufactured;
    this.color = color;
    this.carPlate = carPlate;
    this.make = make;
  }

  // Getter and Setters
  public int getYearManufactured() {
    return this.yearManufactured;
  }

  public void setYearManufactured(int yearManufactured) {
    this.yearManufactured = yearManufactured;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getCarPlate() {
    return this.carPlate;
  }

  public void setCarPlate(String carPlate) {
    this.carPlate = carPlate;
  }

  public CarType getMake() {
    return this.make;
  }

  public void setMake(CarType make) {
    this.make = make;
  }

  // User Defined Methods
  public String toString() {
    String carDetails = String.format("%-12s %-8s %-8d", this.carPlate, this.color, this.yearManufactured);
    String makeDetails = this.make.toString();
    return carDetails + makeDetails;
  }
}

class CarType {
  private String make, model;
  private double engineCap;

  // Constructors
  public CarType() {
    this("", "", 0.0);
  }

  public CarType(String make, String model, double engineCap) {
    this.make = make;
    this.model = model;
    this.engineCap = engineCap;
  }

  // Getters and Setters
  public String getMake() {
    return this.make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getEngineCap() {
    return this.engineCap;
  }

  public void setEngineCap(double engineCap) {
    this.engineCap = engineCap;
  }

  public String toString() {
    String carTypeDetails = String.format("%-9s %-13s %.1f", this.make, this.model, this.engineCap);
    return carTypeDetails;
  }
}

class P4Q5 {
  private static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("Welcome to the Car-registration System.");

    int numCars = 0;

    do {
      System.out.print("How many cars would you like to register today?\n>");
      String input;
      input = scanner.nextLine(); 

      // Validate if input is a positive integer
      Pattern p = Pattern.compile("^[1-9]+[0-9]*$");
      if (p.matcher(input).matches())
        numCars = Integer.parseInt(input);
      else
        System.out.printf("(%s) is not a valid input. Only positive integer is accepted.\n", input);
    } while (numCars <= 0);

    Car[] cars = new Car[numCars];
    CarType[] carTypes = { new CarType("Toyota", "Vios", 1.5),
                           new CarType("Nissan", "Teana", 2.0),
                           new CarType("Honda", "City", 1.6) };
    Owner[] owners = new Owner[numCars];
    Registration[] registrations = new Registration[numCars];

    String color, carPlate, ownerIC, ownerName;
    int yearManufactured, carNum;

    for (int i=0; i<numCars; i++) {
      // Taking input from users
      System.out.printf("-- Car %d\n", i+1);
      System.out.print("Below are the available car types:\n1. Toyota Vios (1.5L)\n2. Nissan Teana (2.0L)\n3. Honda City (1.6L)\n\n");
      System.out.print("Enter the car you want: ");
      carNum = Integer.parseInt(scanner.nextLine());

      System.out.print("Enter the color of the car: ");
      color = scanner.nextLine();

      System.out.print("Enter the car plate of the car: ");
      carPlate = scanner.nextLine();

      System.out.print("Enter the year manufactued of the car: ");
      yearManufactured = Integer.parseInt(scanner.nextLine());

      System.out.print("Enter the Owner's IC: ");
      ownerIC = scanner.nextLine();

      System.out.print("Enter the Owner's Name: ");
      ownerName = scanner.nextLine();

      // Creating the car object
      cars[i] = new Car(yearManufactured, color, carPlate, carTypes[carNum-1]);
      // Creating the owner object
      owners[i] =  new Owner(ownerIC, ownerName);
      // Creating the registration object
      registrations[i] = new Registration(owners[i], cars[i]);
    }

    System.out.printf("\nCar Registration Listing\n");
    System.out.printf("Reg No.    Name            IC No.          Plate No.    Color    Year    Make      Model       Capacity\n");
    for (int i=0; i<numCars; i++) {
      System.out.println(registrations[i].toString());
    }

    scanner.close();
  }
}