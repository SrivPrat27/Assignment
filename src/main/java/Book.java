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

    private Binding_type binding_type;

    public Book(String bookTitle, String author, String bookISBN, String publisher, String language, int published_year, double price, Binding_type binding_type) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.bookISBN = bookISBN;
        this.publisher = publisher;
        this.language = language;
        this.publishedYear = published_year;
        this.price = price;
        this.binding_type = binding_type;

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

    public Binding_type getBinding_type() {
        return binding_type;
    }



}
