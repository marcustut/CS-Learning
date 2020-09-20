abstract class PatientBill {
  protected int visitID;
  protected String name;
  private static int index = 1000;

  public PatientBill(String name) {
    this.visitID = index;
    this.name = name;
    index++;
  }

  abstract double totalCharges(); 

  @Override
  public String toString() {
    return "";
  }
}

class OutpatientBill extends PatientBill {
  private static final double REGISTRATION_FEE = 30.00;
  private double consultationFees;

  public double totalCharges() {
    return REGISTRATION_FEE * this.consultationFees;
  }
}

class ImpatientBill extends PatientBill {
  private static final double ROOM_RATE = 50.00;
  private double specialistCharges, labCharges;
  private String roomType;
  private int stayDuration;

  public double totalCharges() {
    return this.specialistCharges + this.labCharges + (this.stayDuration * ROOM_RATE);
  }
}

public class P7Q1 {
  public static void main(String[] args) {

  }
}