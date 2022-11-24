public class Movie {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private Price _price;

  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode);
  }

  public int getPriceCode() {
    return _price.getPriceCode();
  }

  public void setPriceCode(int arg) {
    switch (arg) {
      case REGULAR:
        _price = new RegularPrice();
        break;
      case CHILDRENS:
        _price = new ChildrensPrice();
        break;
      case NEW_RELEASE:
        _price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("Incorrect Price Code");
    }
  }

  public String getTitle() {
    return _title;
  }

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

  public int getFrequentRenterPoints(int daysRented) {
    return ((getPriceCode() == Movie.NEW_RELEASE)
        && daysRented > 1) ? 2 : 1;
  }
}