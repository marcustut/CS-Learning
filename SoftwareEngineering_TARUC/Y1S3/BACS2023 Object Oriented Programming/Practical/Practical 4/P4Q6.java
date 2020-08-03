import java.util.Scanner;

class Order {
  private OrderedItem[] OrderedItems;
  private int totalItems;

  Order() {
    this(null);
  }

  Order(OrderedItem[] Ordered_Items) {
    this.OrderedItems = Ordered_Items;
    this.totalItems = Ordered_Items.length;
  }

  public int getTotalItems() {
    return this.totalItems;
  }

  public OrderedItem[] getOrderedItems() {
    return this.OrderedItems;
  }

  public void setTotalItems(int totalItems) {
    this.totalItems = totalItems;
  }

  public void setOrderedItems(OrderedItem[] OrderedItems) {
    this.OrderedItems = OrderedItems;
  }

  public double calcGrandTotal() {
    double grandTotal = 0;

    for (int i=0; i<this.OrderedItems.length; i++) {
      grandTotal += this.OrderedItems[i].calcSubtotal();
    }

    return grandTotal;
  }
}

class OrderedItem {
  private int quantity;
  private double weight;
  private Cake cake;

  OrderedItem() {
    this(0, 0.0, null);
  }

  OrderedItem(int quantity, double weight, Cake cake) {
    this.quantity = quantity;
    this.weight = weight;
    this.cake = cake;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getWeight() {
    return this.weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public Cake getCake() {
    return this.cake;
  }

  public void setCake(Cake cake) {
    this.cake = cake;
  }

  public double calcSubtotal() {
    return this.quantity * this.cake.getPrice();
  }
}

class Cake {
  private double price;
  private String flavour;

  Cake() {
    this(0.0, "");
  }
  
  Cake(double price, String flavour) {
    this.price = price;
    this.flavour = flavour;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getFlavour() {
    return this.flavour;
  }

  public void setFlavour(String flavour) {
    this.flavour = flavour;
  }

  public static double calcCakePrice(double oriPrice, double weight) {
    if (weight == 1) return oriPrice;
    else if (weight == 2) return oriPrice * weight - 5;
    else if (weight == 3) return oriPrice * weight - 15;
    else return -1;
  }
}

public class P4Q6 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final String[] flavours = { "Chocolate Moist", "Strawberry", "Blueberry", "American Chocolate", "Tiramisu" };
    final int[] weights = { 1, 2, 3 };

    Cake[] chocoMoistCakes = { new Cake(Cake.calcCakePrice(40.0, weights[0]), flavours[0]),
                               new Cake(Cake.calcCakePrice(40.0, weights[1]), flavours[0]), 
                               new Cake(Cake.calcCakePrice(40.0, weights[2]), flavours[0]), };
                               
    Cake[] strawberryCakes = { new Cake(Cake.calcCakePrice(50.0, weights[0]), flavours[1]),
                              new Cake(Cake.calcCakePrice(50.0, weights[1]), flavours[1]), 
                              new Cake(Cake.calcCakePrice(50.0, weights[2]), flavours[1]), };

    Cake[] blueberryCakes = { new Cake(Cake.calcCakePrice(45.0, weights[0]), flavours[2]),
                              new Cake(Cake.calcCakePrice(45.0, weights[1]), flavours[2]), 
                              new Cake(Cake.calcCakePrice(45.0, weights[2]), flavours[2]), };

    Cake[] americanChocoCakes = { new Cake(Cake.calcCakePrice(55.0, weights[0]), flavours[3]),
                                  new Cake(Cake.calcCakePrice(55.0, weights[1]), flavours[3]), 
                                  new Cake(Cake.calcCakePrice(55.0, weights[2]), flavours[3]), };

    Cake[] tiramisuCakes = { new Cake(Cake.calcCakePrice(30.0, weights[0]), flavours[4]),
                             new Cake(Cake.calcCakePrice(30.0, weights[1]), flavours[4]), 
                             new Cake(Cake.calcCakePrice(30.0, weights[2]), flavours[4]), };

    Cake[][] cakesAvailable = { chocoMoistCakes, strawberryCakes, blueberryCakes, americanChocoCakes, tiramisuCakes };

    System.out.println("Mickey Cake House");
    System.out.print("\nHow many types of cake you would like to order: ");
    int numTypes = scanner.nextInt();

    System.out.println("\n  No Flavours                1kg       2kg       3kg");
    
    for (int i=0; i<flavours.length; i++) System.out.printf("  %d. %-20s RM%6.2f  RM%6.2f  RM%6.2f\n", (i+1), flavours[i], cakesAvailable[i][0].getPrice(), cakesAvailable[i][1].getPrice(), cakesAvailable[i][2].getPrice());

    System.out.println();

    OrderedItem[] userOrderedItems = new OrderedItem[numTypes];

    for (int i=0; i<numTypes; i++) {
      System.out.printf("\nCake item %d\n", (i+1));
      System.out.println("--------------");
      System.out.print("Enter your choice of cake flavour (1 - 5): ");
      int flavourIndex = scanner.nextInt();

      System.out.print("Enter the weight of the cake (1 - 1kg, 2 - 2kg and 3 - 3kg): ");
      int cakeWeight = scanner.nextInt();

      System.out.print("Enter quantity ordered: ");
      int cakeQuantity = scanner.nextInt();

      userOrderedItems[i] = new OrderedItem(cakeQuantity, cakeWeight, cakesAvailable[flavourIndex-1][cakeWeight-1]);
    }

    scanner.close();

    Order userOrder = new Order(userOrderedItems);

    System.out.println();
    System.out.println("\n\nOrder Details:");
    System.out.println("----------------");
    System.out.println("No Cake Flavour        Weight    Unit Price(RM)  Quantity  Total Price(RM)");
    System.out.println("-- ------------        ------    --------------  --------  ---------------");
    for (int i=0; i<numTypes; i++) System.out.printf("%d  %-18s %5.0fkg %14.2f %12d %16.2f\n", (i+1), userOrder.getOrderedItems()[i].getCake().getFlavour(), userOrder.getOrderedItems()[i].getWeight(), userOrder.getOrderedItems()[i].getCake().getPrice(), userOrder.getOrderedItems()[i].getQuantity(), userOrder.getOrderedItems()[i].calcSubtotal());
    System.out.println("--------------------------------------------------------------------------");
    System.out.printf("%58s %15.2f", "Grand Total:", userOrder.calcGrandTotal());
  }
}