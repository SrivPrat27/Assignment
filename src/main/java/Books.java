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


}
