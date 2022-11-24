public class TextStatement extends Statement {

  protected String getHeader(Customer aCustomer) {
    return "Rental Record for " + aCustomer.getName() + "\n";
  }

  protected String getRentalContent(Rental aRental) {
    return "\t" + aRental.getMovie().getTitle()
        + "\t" + String.valueOf(aRental.getCharge()) + "\n";
  }

  protected String getFooter(Customer aCustomer) {
    return "Amount owed is "
        + String.valueOf(aCustomer.getTotalCharge()) + "\n"
        + "You earned "
        + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
        + " frequent renter points";
  }
}
