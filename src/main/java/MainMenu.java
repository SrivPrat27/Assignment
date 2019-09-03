/**
 * Displays the main menu with all the options.
 */

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainMenu {
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
                    BindingType bindingType;
                    if (binding_input == 1)
                        bindingType = BindingType.Digital;
                    else if (binding_input == 2)
                        bindingType = BindingType.Hardbound;
                    else if (binding_input == 3)
                        bindingType = BindingType.PaperBack;
                    else
                        throw new Exception("Invalid binding type");

                    System.out.println("Enter the price of the book");
                    Double price = Double.parseDouble(ob.readLine());

                    Book book = new Book(title, author, ISBN, publisher, language, year, price, bindingType);
                    booksObjectManager.store(book);

                    System.out.println();
                    // If the user continues to want the app
                    System.out.println("Type 1 if you want to continue !!");
                    continueToShop = !ob.readLine().equals("1") ? 0 : 1;
                    System.out.println();
                    System.out.println("Book added successfully...");
                    //store()
                    break;

                case 2:
                    System.out.println("Enter name of the book to be found");
                    String name = ob.readLine();
                    Book books = booksObjectManager.search(name);
                    System.out.println("Searching for your book.....");
                    long startTime = System.currentTimeMillis();
                    if (books != null) {
                        System.out.println("Time taken to search : "+ (System.currentTimeMillis() - startTime));
                        System.out.println("Book Found");
                        booksObjectManager.displayBook(books);
                        System.out.println("Enter 1 if you want to buy this book");
                        if (ob.readLine().equals("1"))
                            booksObjectManager.order(name);
                    } else {
                        System.out.println("Time taken to search : "+ (System.currentTimeMillis() - startTime));
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
                    System.out.println("Ordering your book...");
                    //order()

                    System.out.println("Type 1 if you want to continue !!");
                    continueToShop = !ob.readLine().equals("1") ? 0 : 1;
                    System.out.println();

                    break;

                case 4:
                    System.out.println("Books Collection...");
                    System.out.println("Select the property you want to filter the collection by : ");
                    System.out.println("1. Author");
                    System.out.println("2. Title");
                    System.out.println("3. Published Year");

                    int filterChoice = Integer.parseInt(ob.readLine());

                    System.out.println("Enter order");
                    System.out.println("ASC");
                    System.out.println("DESC");

                    String order = (ob.readLine());

                    long start = System.currentTimeMillis();
                    booksObjectManager.sortBooks(filterChoice, order);
                    System.out.println("Time taken to Sort : "+(System.currentTimeMillis() - start));
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
