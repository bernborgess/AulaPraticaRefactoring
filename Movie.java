public class Movie {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private int _priceCode;

  public Movie(String title, int priceCode) {
    _title = title;
    _priceCode = priceCode;
  }

  public int getPriceCode() {
    return _priceCode;
  }

  public void setPriceCode(int arg) {
    _priceCode = arg;
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
}