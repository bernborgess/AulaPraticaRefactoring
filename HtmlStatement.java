import java.util.Enumeration;

public class HtmlStatement extends Statement {
  public String value(Customer aCustomer) {
    Enumeration<Rental> rentals = aCustomer.getRentals();
    String result = "<h1>Rentals for <em>" + aCustomer.getName()
        + "</em><h1><p>\n";
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += each.getMovie().getTitle() + ": "
          + String.valueOf(each.getCharge()) + "<br>\n";
    }
    result += "<p>You owe <em>" + String.valueOf(aCustomer.getTotalCharge())
        + "</em><p>\n";
    result += "On this rental you earned <em>" +
        String.valueOf(aCustomer.getTotalFrequentRenterPoints())
        + "</em> frequent renter points<p>";
    return result;
  }
}
