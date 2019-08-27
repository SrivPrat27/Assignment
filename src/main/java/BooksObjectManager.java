import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BooksObjectManager {

    static List<Book> databaseOfBooks = new ArrayList<Book>();

    static {
        // Initialises the list during runtime
        databaseOfBooks.add(new Book("Harry Potter and the Sorcerer's Stone","JK Rowling","545644651","Penguin","English",1995,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("Harry Potter and the Chamber of Secrets","JK Rowling","545544651","Penguin","English",1996,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("Harry Potter and the Prisoner of Azkaban","JK Rowling","545644651","Penguin","English",1997,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("Harry Potter and the Goblet of Fire","JK Rowling","545644651","Penguin","English",1998,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("Harry Potter and the Half Blood Prince","JK Rowling","545644651","Penguin","English",1999,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("Harry Potter and the Deathly Hallows","JK Rowling","545644651","Penguin","English",2000,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("Witcher","A Sapkowski","548413212","Orient","Polish",1997,850,Binding_type.PaperBack));
        databaseOfBooks.add(new Book("Gitanjali","R Tagore", "487846464","Penguin","Hindi",1987,595,Binding_type.Digital));
        databaseOfBooks.add(new Book("Lord of the Rings","JRR Tolkien","1254841466","Landmark","English",1990,659.20,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("Game of Thrones","George RR Martin","4856454651","Penguin","English",1982,1240.00,Binding_type.Digital));
        databaseOfBooks.add(new Book("Merchant of Venice","W Shakespeare","5484949445","Orient","English",1862,250,Binding_type.PaperBack));
        databaseOfBooks.add(new Book("As you like it","W Shakespeare","8984949445","Orient","English",1852,270,Binding_type.PaperBack));
        databaseOfBooks.add(new Book("Julius Caesar","W Shakespeare","8584949445","Orient","English",1842,210,Binding_type.PaperBack));
        databaseOfBooks.add(new Book("Gulliver's Travels","J Swift","4549654846","Penguin","English",1986,120,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("How to kill a Mockinbird","H Lee","159745490","Penguin","English",1875,650,Binding_type.Hardbound));
        databaseOfBooks.add(new Book("Fault in our Stars","John Green","159784560","Orient","English",2009,987.32,Binding_type.Digital));
        databaseOfBooks.add(new Book("Murder on the Orient Express","Agatha Cristie","16597784545","Landmark","English",1782,95.00,Binding_type.PaperBack));
        databaseOfBooks.add(new Book("As you like it","W Shakespeare","8984949445","Orient","English",1852,270,Binding_type.PaperBack));
        databaseOfBooks.add(new Book("Crooked House","Agatha Cristie","454975494545","Orient","Emglish",1987,653.00,Binding_type.Hardbound));
    }

    public BooksObjectManager() {
    }

    public void store(Book book){
        // Adding book to the the list where it can be searched and bought.
        databaseOfBooks.add(book);
    }

    public Book search(String name){
        // Searching for the book in the list databaseOfBooks
        for(Book book : databaseOfBooks){
            if(book.getBookTitle().equals(name))
                return book;
        }
        return null;
    }

    public void order(String name){
        Book book = search(name);
        if(book!=null){
            System.out.println("You book "+name+" has been Ordered");
        }
        else
        {
            System.out.println("Book not found !! ");
        }
    }

    public void view(int filterChoice, int order){
        Book book = new Book();
        if(filterChoice == 1)
        {
            if(order == 1)
                Collections.sort(databaseOfBooks, book.bookAuthorComparator);
            else
                Collections.sort(databaseOfBooks, Collections.reverseOrder(book.bookAuthorComparator));
        }
        else if(filterChoice == 2)
        {
            if(order == 1)
                Collections.sort(databaseOfBooks, book.bookNameComparator);
            else
                Collections.sort(databaseOfBooks, Collections.reverseOrder(book.bookNameComparator));
        }
        else if(filterChoice == 3)
        {
            if(order == 1)
                Collections.sort(databaseOfBooks, book.bookPublishedYearComparator);
            else
                Collections.sort(databaseOfBooks, Collections.reverseOrder(book.bookPublishedYearComparator));
        }
        // View all the books present in the collection
        System.out.format("%40s %20s %15s %10s %10s %15s %20s %10s","Title","Author","ISBN","Publisher","Language","Published Year","Price","Binding");
        System.out.println();
        for(Book eachBook : databaseOfBooks){
            System.out.format("%40s %20s %15s %10s %10s %15d %20f %10s",eachBook.getBookTitle(),eachBook.getAuthor(),eachBook.getBookISBN(),eachBook.getPublisher(),eachBook.getLanguage(),eachBook.getPublishedYear(),eachBook.getPrice(),eachBook.getBinding_type());
            System.out.println();
        }
        System.out.println();
    }

    public void toString(Book book)
    {
        System.out.println("Title : " + book.getBookTitle());
        System.out.println("Author : " + book.getAuthor());
        System.out.println("Binding Type : " + book.getBinding_type());
        System.out.println("ISBN : " + book.getBookISBN());
        System.out.println("Language :" + book.getLanguage());
        System.out.println("Price :" + book.getPrice());
        System.out.println("Published year :" + book.getPublishedYear());
        System.out.println("Publisher :" + book.getPublisher());
        System.out.println();
    }

}
