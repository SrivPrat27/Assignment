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

    public Book(){
    }

    public Book(String bookTitle, String author, String bookISBN, String publisher, String language, int published_year, double price, BindingType bindingType) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.bookISBN = bookISBN;
        this.publisher = publisher;
        this.language = language;
        this.publishedYear = published_year;
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

    public Comparator<Book> bookNameComparator = new Comparator<Book>() {
        public int compare(Book book1, Book book2) {
            String bookTitle1 = book1.getBookTitle();
            String bookTitle2 = book2.getBookTitle();

            return bookTitle1.compareTo(bookTitle2);
        }
    };

    public Comparator<Book> bookPublishedYearComparator = new Comparator<Book>() {
        public int compare(Book book1, Book book2) {
            int bookYear1 = book1.getPublishedYear();
            int bookYear2 = book2.getPublishedYear();

            return bookYear1-bookYear2;
        }
    };

    public Comparator<Book> bookAuthorComparator = new Comparator<Book>() {
        public int compare(Book book1, Book book2) {
            String author1 = book1.getAuthor();
            String author2 = book2.getAuthor();

            return author1.compareTo(author2);
        }
    };

}



