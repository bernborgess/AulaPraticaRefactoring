import java.util.Enumeration;

public abstract class Statement {
  protected abstract String getHeader(Customer aCustomer);

  protected abstract String getRentalContent(Rental aRental);

  protected abstract String getFooter(Customer aCustomer);

  public String value(Customer aCustomer) {
    Enumeration<Rental> rentals = aCustomer.getRentals();
    String result = getHeader(aCustomer);
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += getRentalContent(each);
    }

    result += getFooter(aCustomer);
    return result;
  }

}
