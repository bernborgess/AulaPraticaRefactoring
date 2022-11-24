import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Engenharia de Software
 * Refactoring
 * Bernardo Nogueira Borges
 * 2020006396
 */

class Main {
  static Customer customer = null;
  static ArrayList<Movie> collection = new ArrayList<Movie>();
  static String help = "Available commands:\n"
      + "\thelp:\tdisplay commands\n"
      + "\tcreate:\tAdd new movie to collection\n"
      + "\tlist:\tLists movies in collection\n"
      + "\trent:\tRents a movie\n"
      + "\tstat:\tChecks rent statement\n"
      + "\texit:\texits the program\n";

  public static void main(String[] args) {

    try (Scanner reader = new Scanner(System.in)) {
      // LOGIN
      System.out.println("Welcome to ES Movies!\n"
          + "What is your name? : ");
      String name = reader.nextLine();
      customer = new Customer(name);

      System.out.print("> ");
      String cmd = reader.nextLine();

      while (!cmd.equals("exit")) {
        exec(cmd, reader);
        System.out.print("> ");
        cmd = reader.nextLine();
      }
    }
  }

  private static void exec(String cmd, Scanner reader) {
    switch (cmd) {
      case "exit":
        break;

      case "help":
        System.out.println(help);
        break;

      case "create": {

        System.out.println("Enter Movie name: ");
        String title = reader.nextLine();

        System.out.print("Enter movie code:\n"
            + "0:\tRegular\n"
            + "1:\tNew Release\n"
            + "2:\tChildrens\n"
            + "> ");

        try {

          int priceCode = reader.nextInt();
          reader.nextLine();
          if (priceCode < 0 || 2 < priceCode) {
            System.out.println("Invalid code!");
            break;
          }
          Movie movie = new Movie(title, priceCode);
          collection.add(movie);
        } catch (Exception e) {
          reader.nextLine();
          System.out.println("Code must be a number!");
        }
        break;
      }

      case "list": {
        Formatter fmt = new Formatter();
        fmt.format("%15s %15s\n", "NAME", "CODE");
        for (Movie movie : collection)
          fmt.format("%14s  %14s\n", movie.getTitle(), movie.getPriceCode());
        System.out.println(fmt);
        break;
      }

      case "rent":
        rent(reader);
        break;

      case "stat":
        System.out.println(
            customer.statement());
        break;

      default:
        System.out.println("Invalid command!");
    }

  }

  private static void rent(Scanner reader) {
    System.out.println("Enter movie title: ");
    try {
      String title = reader.nextLine();
      Movie rentMovie = null;
      for (Movie movie : collection)
        if (movie.getTitle().equals(title)) {
          rentMovie = movie;
        }
      if (rentMovie == null)
        throw new Exception("Movie not found in collection!");

      System.out.println("For how many days will you rent? :");
      int daysRented = reader.nextInt();
      reader.nextLine();
      if (daysRented <= 0)
        throw new Exception("Invalid number of days!");

      Rental rental = new Rental(rentMovie, daysRented);
      customer.addRental(rental);

    } catch (Exception e) {
      reader.nextLine();
      System.out.println("Invalid Parameters!");
    }
  }

}