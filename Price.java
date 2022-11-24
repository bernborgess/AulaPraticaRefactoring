public abstract class Price {
  public abstract int getPriceCode();

  public double getCharge(int daysRented) {
    switch (getPriceCode()) {
      case Movie.REGULAR:
        return (daysRented > 2) ? (daysRented - 2) * 1.5 + 2
            : 2;

      case Movie.NEW_RELEASE:
        return daysRented * 3;

      case Movie.CHILDRENS:
        return (daysRented > 3) ? (daysRented - 3) * 1.5 + 1.5
            : 1.5;
    }
    return 0.0;

  }
}
