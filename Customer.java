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

  public Enumeration<Rental> getRentals() {
    return _rentals.elements();
  }

  public String statement() {
    return new TextStatement().value(this);
  }

  public double getTotalCharge() {
    double result = 0;
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

  public double getTotalFrequentRenterPoints() {
    double result = 0;
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

  public String htmlStatement() {
    return new HtmlStatement().value(this);

  }
}
