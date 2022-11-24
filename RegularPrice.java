public class RegularPrice extends Price {
  public int getPriceCode() {
    return Movie.REGULAR;
  }

  public double getCharge(int daysRented) {
    return (daysRented > 2) ? (daysRented - 2) * 1.5 + 2
        : 2;
  }
}
