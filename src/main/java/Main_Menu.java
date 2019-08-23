import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Menu {
    public void main() throws IOException {
        // Menu Display

        System.out.println("Welcome to Book Store");
        System.out.println();
        System.out.println("1. Store a new book");
        System.out.println();
        System.out.println("2. Search for a book");
        System.out.println();
        System.out.println("3. Order a book");
        System.out.println();
        System.out.print("Enter your choice : ");

        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(ob.readLine());

        switch (choice)
        {
            case 1:
                System.out.println("Storing a new book in the database");
                //store()
                break;

            case 2:
                System.out.println("Searching for your book");
                //search()
                break;

            case 3:
                System.out.println("Ordering your book ");
                //order()
                break;

            default:
                System.out.println("Incorrect choice!");
                break;
        }
    }
}
