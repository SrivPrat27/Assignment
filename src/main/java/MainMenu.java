/**
 * Displays the main menu with all the options.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class MainMenu {
    public static void main(String[] args) throws Exception {
        // Menu Display


        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        String path;
        if (args.length == 1)
            path = ob.readLine();
        else
            path = "/home/pratyush/rep/Assignment_Cart/Write.csv";

        long time = System.currentTimeMillis();
        int continueToShop = 0;
        BooksObjectManager booksObjectManager = new BooksObjectManager(path);
        System.out.println("Loading Time : " + (System.currentTimeMillis() - time));

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
            System.out.println("5. View your Cart");
            System.out.println();
            System.out.println("6. Exit ");
            System.out.println();
            System.out.print("Enter your choice : ");

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

                    break;

                case 2:
                    System.out.println("Enter name of the book to be found");
                    String name = ob.readLine();
                    List<Book> booksSearchedFor = booksObjectManager.search(name);
                    System.out.println("Searching for your book.....");
                    if (booksSearchedFor.size() != 0) {
                        System.out.println("Books Found");
                        for (int i = 0; i < booksSearchedFor.size(); i++)
                            booksObjectManager.displayBookDetailsView(booksSearchedFor.get(i));
                    } else
                        System.out.println("Book not found");

                    break;

                case 3:
                    System.out.println("Enter book you want to add to cart !!");
                    String bookTitle = ob.readLine();
                    booksObjectManager.order(bookTitle);

                    break;

                case 4:
                    System.out.println("Books Collection...");
                    System.out.println("Select the property you want to filter the collection by : ");
                    System.out.println("1. Author");
                    System.out.println("2. Title");
                    System.out.println("3. Published Year");

                    int filterChoice = Integer.parseInt(ob.readLine());

                    System.out.println("Enter order");
                    System.out.println("1. ASC");
                    System.out.println("2. DESC");

                    int order = Integer.parseInt(ob.readLine());

                    booksObjectManager.view(filterChoice, order);

                    break;

                case 5:
                    System.out.println("Your Cart : ");
                    booksObjectManager.cartManager.getCartDetails();
                    System.out.println();
                    System.out.println("1. Add number of copies to a book");
                    System.out.println("2. Remove number of copies from a book");
                    System.out.println("3. Remove a book");
                    System.out.println("4. Buy items in the cart");
                    System.out.println("5. Exit");

                    System.out.println("Enter your choice");
                    int choiceCart = Integer.parseInt(ob.readLine());

                    if (choiceCart != 5) {
                        System.out.println("Enter the book ISBN you want to make changes to");
                        String bookIsbnInCart = ob.readLine();
                        Book bookToBeUpdatedInCart = booksObjectManager.cartManager.getBookFromIsbn(bookIsbnInCart);

                        switch (choiceCart) {
                            case 1:
                                System.out.println("Enter No of Copies To ADD");
                                booksObjectManager.cartManager.updateCartByAdding(bookToBeUpdatedInCart, Integer.parseInt(ob.readLine()));

                                break;

                            case 2:
                                System.out.println("Enter No of Copies To REMOVE");
                                booksObjectManager.cartManager.updateCartByRemovingCopies(bookToBeUpdatedInCart, Integer.parseInt(ob.readLine()));

                                break;

                            case 3:
                                booksObjectManager.cartManager.removeFromCart(bookToBeUpdatedInCart);

                                break;

                            case 4:
                                booksObjectManager.cartManager.checkOut();

                                break;
                            case 5:
                                break;

                            default:
                                System.out.println("Wrong Choice !!");
                        }
                    }

                    break;

                case 6:
                    System.out.println("Thank You !!");
                    return;

                default:
                    System.out.println("Incorrect choice!");
                    System.out.println("Try Again");
                    System.out.println();
                    break;
            }
        }
        while (true);
    }
}
