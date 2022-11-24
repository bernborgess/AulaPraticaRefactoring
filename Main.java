import java.util.ArrayList;
import java.util.Scanner;

/**
 * Engenharia de Software
 * Refactoring
 * Bernardo Nogueira Borges
 * 2020006396
 */

class Main {
  public static void main(String[] args) {
    try (Scanner reader = new Scanner(System.in)) {
      System.out.print("> ");
      String cmd = reader.nextLine();
      String help = "Available commands:\n"
          + "\thelp:\tdisplay commands\n"
          + "\texit:\texits the program\n"
          + "\tcreate:\tAdd new movie to collection\n"
          + "\tlist:\tLists movies in collection\n";

      ArrayList<Movie> collection = new ArrayList<Movie>();

      while (!cmd.equals("exit")) {
        switch (cmd) {
          case "exit":
            break;

          case "help":
            System.out.println(help);
            break;

          case "create": {

            System.out.println("Enter Movie name: ");
            String title = reader.nextLine();

            System.out.println("Enter movie code: ");
            int priceCode = reader.nextInt();
            reader.nextLine();

            Movie movie = new Movie(title, priceCode);
            collection.add(movie);
            break;
          }

          case "list": {
            for (Movie movie : collection)
              System.out.println(movie.getTitle() + "\t\t" + movie.getPriceCode());
            break;
          }

          default:
            System.out.println("Invalid command!");
        }

        System.out.print("> ");
        cmd = reader.nextLine();
      }
    }
  }
}