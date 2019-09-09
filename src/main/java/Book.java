import java.util.Comparator;
/**
 * Stores all the properties of a book.
 **/
public class Book {

    private String bookTitle;

    private String author;

    private String bookISBN;

    private String publisher;

    private String language;

    private int publishedYear;

    private double price;

    private BindingType bindingType;

    private int quantiy = Integer.MAX_VALUE ;

    //For sort books operation.

    public Book() {
    }
    public Book(String bookTitle, String author, String bookISBN, String publisher, String language, int publishedYear, double price, BindingType bindingType) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.bookISBN = bookISBN;
        this.publisher = publisher;
        this.language = language;
        this.publishedYear = publishedYear;
        this.price = price;
        this.bindingType = bindingType;

    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public double getPrice() {
        return price;
    }

    public BindingType getBindingType() {
        return bindingType;
    }

    public int getQuantiy() {
        return quantiy;
    }

}



