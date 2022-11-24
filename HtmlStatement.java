public class HtmlStatement extends Statement {

  protected String getHeader(Customer aCustomer) {
    return "<h1>Rentals for <em>" + aCustomer.getName()
        + "</em><h1><p>\n";
  }

  protected String getRentalContent(Rental aRental) {
    return aRental.getMovie().getTitle() + ": "
        + String.valueOf(aRental.getCharge()) + "<br>\n";
  }

  protected String getFooter(Customer aCustomer) {
    return "<p>You owe <em>"
        + String.valueOf(aCustomer.getTotalCharge())
        + "</em><p>\n"
        + "On this rental you earned <em>"
        + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
        + "</em> frequent renter points<p>";
  }
}
