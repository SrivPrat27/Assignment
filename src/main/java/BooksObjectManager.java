import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.*;

public class BooksObjectManager {

    List<Book> bookList = new ArrayList<Book>();
    Map<String, TreeMap> stringTreeMapTreeMap = new TreeMap<>();
    TreeMap<String, List<Book>> titleToListOfBookMap = new TreeMap<>();
    TreeMap<String, List<Book>> authorToListOfBookMap = new TreeMap<>();
    TreeMap<Integer, List<Book>> yearToListOfBookMap = new TreeMap<>();

    BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));

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
        sortBooks(2, SortOrder.ASC.toString());
    }

    public void store(Book book) {
        // Adding book to the the list where it can be searched and bought.
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


    public void order(String name) {
        List<Book> books = search(name);
        if (books.size() == 1)
            displayBookDetailsView(books.get(0));
        else if (books.size() == 0)
            System.out.println("No Books Available");
        else {
            for (Book book : books) {
                displayBookDetailsView(book);
                System.out.println();
            }
        }
    }

    public void sortBooks(int filterChoice, String order) {
        Book book = new Book();
        Comparator<Book> bookComparator;

        if (filterChoice == 1)
            bookComparator = book.bookAuthorComparator;
        else if (filterChoice == 3)
            bookComparator = book.bookPublishedYearComparator;
        else
            bookComparator = book.bookNameComparator;

        if (SortOrder.DESC.toString().equals(order))
            Collections.sort(bookList, Collections.reverseOrder(bookComparator));
        else
            Collections.sort(bookList, bookComparator);

        // View all the books present in the collection
    }

    public void view(int filterChoice, int order) throws IOException {
        int continueToDisplay = 1;
        int startIndex = 0;
        int noOfBooksToBeDisplayed = 20;  // No of books displayed at a time.
        List<Book> bookArrayList = new ArrayList<>();
        displayHeaderListView();
        if (filterChoice == 1) {
            displayHeaderListView();
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
            displayHeaderListView();
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
            displayHeaderListView();
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
        while (choice == 1 || choice == -1) {
            if (choice == 1) {
                startIndex = startIndex + noOfBooksPerPage;
                if(startIndex < 0)    // If a user presses -1 a lot of times , startIndex value keeps on decreasing
                    startIndex = 0 ;
                for (int i = startIndex; i < startIndex + noOfBooksPerPage && i < bookList.size(); i++) {
                    displayBookListView(bookList.get(i));
                }
            }
            if (choice == -1) {
                startIndex = startIndex - noOfBooksPerPage;
                if(startIndex > bookList.size())        // If a user presses 1 a lot of times during the list end
                    startIndex = bookList.size() - noOfBooksPerPage ;
                for (int i = startIndex; i < startIndex + noOfBooksPerPage && i > -1; i++)
                    displayBookListView(bookList.get(i));
                // Previous Page
            }
            System.out.println("Press 1 to go the next page ");
            System.out.println("Press -1 to go the previous page ");
            System.out.println("Press 0 to exit");
            choice = Integer.parseInt(ob.readLine());
            if (choice == 0)
                return;
        }
    }
}

