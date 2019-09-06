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
        displayBooksInGroups(filterChoice, order);
        displayHeaderListView();
        if (filterChoice == 1) {
            displayHeaderListView();
            if (order == 1) {
                for (String key : authorToListOfBookMap.keySet()) {
                    List<Book> bookList = authorToListOfBookMap.get(key);
                    for (int i = 0; i < bookList.size(); i++)
                        displayBookListView(bookList.get(i));
                }
            } else {
                for (String key : authorToListOfBookMap.descendingKeySet()) {
                    List<Book> bookList = authorToListOfBookMap.get(key);
                    for (int i = 0; i < bookList.size(); i++)
                        displayBookListView(bookList.get(i));
                }
            }
        } else if (filterChoice == 2) {
            displayHeaderListView();
            if (order == 1) {
                for (String key : titleToListOfBookMap.keySet()) {
                    List<Book> bookList = titleToListOfBookMap.get(key);
                    for (int i = 0; i < bookList.size(); i++)
                        displayBookListView(bookList.get(i));
                }
            } else {
                for (String key : titleToListOfBookMap.descendingKeySet()) {
                    List<Book> bookList = titleToListOfBookMap.get(key);
                    for (int i = 0; i < bookList.size(); i++)
                        displayBookListView(bookList.get(i));
                }
            }
        } else {
            displayHeaderListView();
            if (order == 1) {
                for (Integer key : yearToListOfBookMap.keySet()) {
                    List<Book> bookList = yearToListOfBookMap.get(key);
                    for (int i = 0; i < bookList.size(); i++)
                        displayBookListView(bookList.get(i));
                }
            } else {
                for (Integer key : yearToListOfBookMap.descendingKeySet()) {
                    List<Book> bookList = yearToListOfBookMap.get(key);
                    for (int i = 0; i < bookList.size(); i++)
                        displayBookListView(bookList.get(i));
                }
            }
        }


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

    public void displayBooksInGroups(int filterchoice, int order) {
    }
}

