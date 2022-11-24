public class ChildrensPrice extends Price {
  public int getPriceCode() {
    return Movie.CHILDRENS;
  }

  public double getCharge(int daysRented) {
    return (daysRented > 3) ? (daysRented - 3) * 1.5 + 1.5
        : 1.5;
  }
}
