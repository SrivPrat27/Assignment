import java.util.ArrayList;
import java.util.List;

public class BooksObjectManager {

    static List<Books> databaseOfBooks = new ArrayList<Books>();

    static {
        databaseOfBooks.add(new Books("Harry Potter","JK Rowling","545644651","Penguin","English",1995,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Witcher","A Sapkowski","548413212","Orient","English",1997,850,Binding_type.PaperBack));
        databaseOfBooks.add(new Books("Gitanjali","R Tagore", "487846464","Penguin","Hindi",1987,595,Binding_type.Digital));

    }

    public BooksObjectManager() {
    }

    public void store(Books book){
        // Adding book to the the list where it can be searched and bought.
        databaseOfBooks.add(book);
        System.out.println("Book added successfully...");
    }

    public Books search(String name){
        // Searching for the book in the list databaseOfBooks
        System.out.println("Searching for your book.....");
        for(Books book : databaseOfBooks){
            if(book.getBook_title().equals(name))
                return book;
        }
        return null;
    }

    public void order(String name){
        System.out.println("Ordering your book...");
        Books books = search(name);
        if(books!=null){
            System.out.println("Congrats !! Ordered");
        }
        else
        {
            System.out.println("Book not found !! ");
        }
    }

    public void view(){
        System.out.format("%20s %15s %15s %10s %10s %10s %20s %10s","Title","Author","ISBN","Publisher","Language","Published Year","Price","Binding");
        System.out.println();
        for(Books book : databaseOfBooks){
            System.out.format("%20s %15s %15s %10s %10s %10d %20f %10s",book.getBook_title(),book.getAuthor(),book.getISBN(),book.getPublisher(),book.getLanguage(),book.getPublished_year(),book.getPrice(),book.getBinding_type());
            System.out.println();
        }
        System.out.println();
    }


}
