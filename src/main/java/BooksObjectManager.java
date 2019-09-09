import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BooksObjectManager {

    long startTime;
    List<Book> bookList = new ArrayList<Book>();
    Map<String, TreeMap> stringTreeMapTreeMap = new TreeMap<>();
    TreeMap<String, List<Book>> titleToListOfBookMap = new TreeMap<>();
    TreeMap<String, List<Book>> authorToListOfBookMap = new TreeMap<>();
    TreeMap<Integer, List<Book>> yearToListOfBookMap = new TreeMap<>();

    BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
    CartManager cartManager = new CartManager();

    public BooksObjectManager() throws IOException {
        initializeListOfBooks();
    }


    public void initializeListOfBooks() throws IOException {
        CSVReaderJava csvReaderJava = new CSVReaderJava();
        //bookList = csvReaderJava.initializeListOfBooksInArrayList();
        stringTreeMapTreeMap = csvReaderJava.initializeBooksMap();
        titleToListOfBookMap = stringTreeMapTreeMap.get("Title");
        authorToListOfBookMap = stringTreeMapTreeMap.get("Author");
        yearToListOfBookMap = stringTreeMapTreeMap.get("Year");
    }

    public void store(Book book) {
        // Adding book to the the list where it can be searched and bought.
        //TODO : Add the book to the maps as well
        bookList.add(book);
    }

    public List<Book> search(String name) {
        // Searching for the book in the list bookList using Binary Search Algorithm
        long startTime = System.currentTimeMillis();
        titleToListOfBookMap = stringTreeMapTreeMap.get("Title");
        if (titleToListOfBookMap.containsKey(name)) {
            return titleToListOfBookMap.get(name);
        } else
            return Collections.emptyList();
    }


    public void order(String name) throws IOException {
        List<Book> books = search(name);
        if (books.size() == 1){
            System.out.println("No of Books You want ?");
            cartManager.addToCart(books.get(0), Integer.parseInt(ob.readLine()));
        }
        else if (books.size() == 0)
            System.out.println("No Books Available");
        else
        {
            for(Book book : books)
            {
                System.out.println("No of Books You want ?");
                cartManager.addToCart(book, Integer.parseInt(ob.readLine()));
            }
        }
        System.out.println("Added To Cart");
    }

    public void view(int filterChoice, int order) throws IOException {
        List<Book> bookArrayList = new ArrayList<>();
        displayHeaderListView();
        startTime = System.currentTimeMillis();
        if (filterChoice == 1) {
            if (order == 1) {
                for (String key : authorToListOfBookMap.keySet()) {
                    bookArrayList.addAll(authorToListOfBookMap.get(key));
                }
            } else {
                for (String key : authorToListOfBookMap.descendingKeySet()) {
                    bookArrayList.addAll(authorToListOfBookMap.get(key));
                }
            }
        } else if (filterChoice == 2) {
            if (order == 1) {
                for (String key : titleToListOfBookMap.keySet()) {
                    bookArrayList.addAll(titleToListOfBookMap.get(key));
                }
            } else {
                for (String key : titleToListOfBookMap.descendingKeySet()) {
                    bookArrayList.addAll(titleToListOfBookMap.get(key));
                }
            }
        } else {
            if (order == 1) {
                for (Integer key : yearToListOfBookMap.keySet()) {
                    bookArrayList.addAll(yearToListOfBookMap.get(key));
                }
            } else {
                for (Integer key : yearToListOfBookMap.descendingKeySet()) {
                    bookArrayList.addAll(yearToListOfBookMap.get(key));
                }
            }
        }
        getPaginatedDisplay(bookArrayList, 20);
    }

    public void displayBookDetailsView(Book book) {
        System.out.println("Title : " + book.getBookTitle());
        System.out.println("Author : " + book.getAuthor());
        System.out.println("Binding Type : " + book.getBindingType());
        System.out.println("ISBN : " + book.getBookISBN());
        System.out.println("Language :" + book.getLanguage());
        System.out.println("Price :" + book.getPrice());
        System.out.println("Published year :" + book.getPublishedYear());
        System.out.println("Publisher :" + book.getPublisher());
        System.out.println();
    }

    public void displayHeaderListView() {
        System.out.format("%40s %20s %15s %10s %10s %15s %20s %10s", "Title", "Author", "ISBN", "Publisher", "Language", "Published Year", "Price", "Binding");
        System.out.println();

    }

    public void displayBookListView(Book book) {
        System.out.format("%40s %20s %15s %10s %10s %15d %20f %10s", book.getBookTitle(), book.getAuthor(), book.getBookISBN(), book.getPublisher(), book.getLanguage(), book.getPublishedYear(), book.getPrice(), book.getBindingType());
        System.out.println();

    }

    public void getPaginatedDisplay(List<Book> bookList, int noOfBooksPerPage) throws IOException {
        int startIndex = 0;
        int choice = 1;
        while (choice == 1 || choice == -1) { // Whether to continue or not
            if (choice == 1) { // Next Page
                startIndex = startIndex + noOfBooksPerPage;
                if (startIndex < 0)    // If a user presses -1 a lot of times , startIndex value keeps on decreasing
                    startIndex = 0;
                for (int i = startIndex; i < startIndex + noOfBooksPerPage && i < bookList.size(); i++) {
                    displayBookListView(bookList.get(i));
                }
                System.out.println();
            }
            if (choice == -1) { // Previous Page
                startIndex = startIndex - noOfBooksPerPage;
                if (startIndex > bookList.size())        // If a user presses 1 a lot of times during the list end
                    startIndex = bookList.size() - noOfBooksPerPage;
                for (int i = startIndex; i < startIndex + noOfBooksPerPage && i > -1; i++)
                    displayBookListView(bookList.get(i));

            }
            System.out.println("Press 1 to go the next page ");
            System.out.println("Press -1 to go the previous page ");
            System.out.println("Press 0 to exit");
            System.out.println("Time taken to display first page : " + (System.currentTimeMillis() - startTime) + "ms");
            choice = Integer.parseInt(ob.readLine());
            if (choice == 0)
                return;
        }
    }
}

