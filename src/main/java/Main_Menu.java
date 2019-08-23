/**
 * Displays the main menu with all the options.
 *
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Menu {
    public static void main(String args[]) throws Exception {
        // Menu Display

        int continueToShop = 0;
        BooksObjectManager booksObjectManager = new BooksObjectManager();

        do {
            System.out.println("Welcome to Book Store");
            System.out.println();
            System.out.println("1. Store a new book");
            System.out.println();
            System.out.println("2. Search for a book");
            System.out.println();
            System.out.println("3. Order a book");
            System.out.println();
            System.out.println("4. View the collection");
            System.out.println();
            System.out.print("Enter your choice : ");

            BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.parseInt(ob.readLine());

            switch (choice) {
                case 1:
                    System.out.println("Storing a new book in the database");
                    System.out.println();

                    System.out.println("Enter the title of the book");
                    String title = ob.readLine();

                    System.out.println("Enter the author of the book");
                    String author = ob.readLine();

                    System.out.println("Enter the ISBN of the book");
                    String ISBN = ob.readLine();

                    System.out.println("Enter the publisher of the book");
                    String publisher = ob.readLine();

                    System.out.println("Enter the language of the book");
                    String language = ob.readLine();

                    System.out.println("Enter the published year of the book");
                    int year = Integer.parseInt(ob.readLine());

                    System.out.println("Enter the binding type of the book");
                    System.out.println();
                    System.out.println("1 for Digital");
                    System.out.println("2 for Hardbound");
                    System.out.println("3 for PaperBack");
                    int binding_input = Integer.parseInt(ob.readLine());
                    // Taking binding_input from user of binding type which can only be one of these three kinds.
                    Binding_type binding_type;
                    if (binding_input == 1)
                        binding_type = Binding_type.Digital;
                    else if (binding_input == 2)
                        binding_type = Binding_type.Hardbound;
                    else if (binding_input == 3)
                        binding_type = Binding_type.PaperBack;
                    else
                        throw new Exception("Invalid binding type");

                    System.out.println("Enter the price of the book");
                    Double price = Double.parseDouble(ob.readLine());

                    Books book = new Books(title, author, ISBN, publisher, language, year, price, binding_type);
                    booksObjectManager.store(book);

                    System.out.println();
                    System.out.println("Type 1 if you want to continue !!");
                    continueToShop = !ob.readLine().equals("1") ? 0 : 1;
                    System.out.println();
                    //store()
                    break;

                case 2:
                    System.out.println("Enter name of the book to be found");
                    String name = ob.readLine();
                    Books books = booksObjectManager.search(name);
                    if (books != null) {
                        System.out.println("Book Found");
                        System.out.println("Title : " + books.getBook_title());
                        System.out.println("Author : " + books.getAuthor());
                        System.out.println("Binding Type : " + books.getBinding_type());
                        System.out.println("ISBN : " + books.getISBN());
                        System.out.println("Language :" + books.getLanguage());
                        System.out.println("Price :" + books.getPrice());
                        System.out.println("Published year :" + books.getPublished_year());
                        System.out.println("Publisher :" + books.getPublisher());
                        System.out.println();
                    } else {
                        System.out.println("Book not found");
                    }

                    System.out.println("Type 1 if you want to continue !!");
                    continueToShop = !ob.readLine().equals("1") ? 0 : 1;
                    System.out.println();

                    //search()
                    break;

                case 3:
                    System.out.println("Enter book you want to buy !!");
                    booksObjectManager.order(ob.readLine());
                    //order()

                    System.out.println("Type 1 if you want to continue !!");
                    continueToShop = !ob.readLine().equals("1") ? 0 : 1;
                    System.out.println();

                    break;

                case 4:
                    System.out.println("Books Collection...");
                    booksObjectManager.view();

                    System.out.println("Type 1 if you want to continue !!");
                    continueToShop = !ob.readLine().equals("1") ? 0 : 1;
                    System.out.println();

                    break;

                default:
                    System.out.println("Incorrect choice!");
                    System.out.println("Try Again");
                    System.out.println();
                    break;
            }
        }
        while (continueToShop == 1);
        System.out.println("Thank You !!");
    }
}
