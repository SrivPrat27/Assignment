/**
 * Stores all the properties of a book.
 **/
public class Books {

    private String book_title;

    private String author;

    private String ISBN;

    private String publisher;

    private String language;

    private int published_year;

    private double price;

    private Binding_type binding_type;

    public Books(String book_title, String author, String ISBN, String publisher, String language, int published_year, double price, Binding_type binding_type) {
        this.book_title = book_title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.language = language;
        this.published_year = published_year;
        this.price = price;
        this.binding_type = binding_type;

    }

    public String getBook_title() {
        return book_title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public int getPublished_year() {
        return published_year;
    }

    public double getPrice() {
        return price;
    }

    public Binding_type getBinding_type() {
        return binding_type;
    }



}
