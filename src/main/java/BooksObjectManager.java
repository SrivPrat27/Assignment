import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BooksObjectManager {

    List<Book> bookList = new ArrayList<Book>();
    BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));

    public BooksObjectManager() throws IOException {
        initializeListOfBooks();
    }

    public void initializeListOfBooks() throws IOException {
        CSVReaderJava csvReaderJava = new CSVReaderJava();
        bookList = csvReaderJava.initialize();
        sortBooks(2, SortOrder.ASC.toString());
    }

    public void store(Book book) {
        // Adding book to the the list where it can be searched and bought.
        bookList.add(book);
    }

    public Book search(String name) {
        // Searching for the book in the list bookList using Binary Search Algorithm
        sortBooks(2, "ASC"); // Sorting on the basis of Title
        long startTime = System.currentTimeMillis();
        int leftIndex = 0;
        int rightIndex = bookList.size() - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (bookList.get(midIndex).getBookTitle().equals(name))
                return bookList.get(midIndex);
            else if (bookList.get(midIndex).getBookTitle().compareTo(name) < 0)
                leftIndex = midIndex + 1;
            else
                rightIndex = midIndex - 1;
        }
        return null;
    }

    public void order(String name) {
        Book book = search(name);
        if (book != null) {
            System.out.println("You book " + name + " has been Ordered");
        } else {
            System.out.println("Book not found !! ");
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

    public void view() throws IOException {
        int continueToDisplay = 1;
        int startIndex = 0;
        int noOfBooksToBeDisplayed = 20;  // No of books displayed at a time.
        while (continueToDisplay == 1) {
            if (startIndex >= bookList.size())
                return;
            System.out.format("%40s %20s %15s %10s %10s %15s %20s %10s", "Title", "Author", "ISBN", "Publisher", "Language", "Published Year", "Price", "Binding");
            System.out.println();
            for (int i = startIndex; i < startIndex + noOfBooksToBeDisplayed && i < bookList.size(); i++) {
                Book eachBook = bookList.get(i);
                System.out.format("%40s %20s %15s %10s %10s %15d %20f %10s", eachBook.getBookTitle(), eachBook.getAuthor(), eachBook.getBookISBN(), eachBook.getPublisher(), eachBook.getLanguage(), eachBook.getPublishedYear(), eachBook.getPrice(), eachBook.getBindingType());
                System.out.println();
            }
            System.out.println("Do you want to go to the next page ? Press 1");
            continueToDisplay = Integer.parseInt(ob.readLine());
            if (continueToDisplay == 1)
                startIndex = startIndex + noOfBooksToBeDisplayed;
            else
                return;
        }

    }

    public void displayBook(Book book) {
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

}
