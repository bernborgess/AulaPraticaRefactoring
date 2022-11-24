import java.util.Enumeration;

public class HtmlStatement extends Statement {

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

  private String getHeader(Customer aCustomer) {
    return "<h1>Rentals for <em>" + aCustomer.getName()
        + "</em><h1><p>\n";
  }

  private String getRentalContent(Rental aRental) {
    return aRental.getMovie().getTitle() + ": "
        + String.valueOf(aRental.getCharge()) + "<br>\n";
  }

  private String getFooter(Customer aCustomer) {
    return "<p>You owe <em>"
        + String.valueOf(aCustomer.getTotalCharge())
        + "</em><p>\n"
        + "On this rental you earned <em>"
        + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
        + "</em> frequent renter points<p>";
  }
}
