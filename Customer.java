import java.util.Enumeration;
import java.util.Vector;

public class Customer {
  private String _name;
  private Vector<Rental> _rentals = new Vector<Rental>();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    // double totalAmount = 0;
    // int frequentRenterPoints = 0;

    Enumeration<Rental> rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();

      // frequentRenterPoints += each.getFrequentRenterPoints();

      result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
      // totalAmount += each.getCharge();

    }
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";

    result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
        " frequent renter points";

    return result;
  }

  private double getTotalCharge() {
    double result = 0;
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

  private double getTotalFrequentRenterPoints() {
    double result = 0;
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }
}
