import java.util.ArrayList;
import java.util.List;

public class BooksObjectManager {

    static List<Books> databaseOfBooks = new ArrayList<Books>();

    static {
        databaseOfBooks.add(new Books("Harry Potter and the Sorcerer's Stone","JK Rowling","545644651","Penguin","English",1995,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Harry Potter and the Chamber of Secrets","JK Rowling","545544651","Penguin","English",1996,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Harry Potter and the Prisoner of Azkaban","JK Rowling","545644651","Penguin","English",1997,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Harry Potter and the Goblet of Fire","JK Rowling","545644651","Penguin","English",1998,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Harry Potter and the Half Blood Prince","JK Rowling","545644651","Penguin","English",1999,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Harry Potter and the Deathly Hallows","JK Rowling","545644651","Penguin","English",2000,620,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Witcher","A Sapkowski","548413212","Orient","English",1997,850,Binding_type.PaperBack));
        databaseOfBooks.add(new Books("Gitanjali","R Tagore", "487846464","Penguin","Hindi",1987,595,Binding_type.Digital));
        databaseOfBooks.add(new Books("Lord of the Rings","JRR Tolkien","1254841466","Landmark","English",1990,659.20,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Game of Thrones","George RR Martin","4856454651","Penguin","English",1982,1240.00,Binding_type.Digital));
        databaseOfBooks.add(new Books("Merchant of Venice","W Shakespeare","5484949445","Orient","English",1862,250,Binding_type.PaperBack));
        databaseOfBooks.add(new Books("As you like it","W Shakespeare","8984949445","Orient","English",1852,270,Binding_type.PaperBack));
        databaseOfBooks.add(new Books("Julius Caesar","W Shakespeare","8584949445","Orient","English",1842,210,Binding_type.PaperBack));
        databaseOfBooks.add(new Books("Gulliver's Travels","J Swift","4549654846","Penguin","English",1986,120,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("How to kill a Mockinbird","H Lee","159745490","Penguin","English",1875,650,Binding_type.Hardbound));
        databaseOfBooks.add(new Books("Fault in our Stars","John Green","159784560","Orient","English",2009,987.32,Binding_type.Digital));
        databaseOfBooks.add(new Books("Murder on the Orient Express","Agatha Cristie","16597784545","Landmark","English",1782,95.00,Binding_type.PaperBack));
        databaseOfBooks.add(new Books("As you like it","W Shakespeare","8984949445","Orient","English",1852,270,Binding_type.PaperBack));
        databaseOfBooks.add(new Books("Crooked House","Agatha Cristie","454975494545","Orient","Emglish",1987,653.00,Binding_type.Hardbound));
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
            System.out.println("You book "+name+" has been Ordered");
        }
        else
        {
            System.out.println("Book not found !! ");
        }
    }

    public void view(){
        System.out.format("%40s %20s %15s %10s %10s %15s %20s %10s","Title","Author","ISBN","Publisher","Language","Published Year","Price","Binding");
        System.out.println();
        for(Books book : databaseOfBooks){
            System.out.format("%40s %20s %15s %10s %10s %15d %20f %10s",book.getBook_title(),book.getAuthor(),book.getISBN(),book.getPublisher(),book.getLanguage(),book.getPublished_year(),book.getPrice(),book.getBinding_type());
            System.out.println();
        }
        System.out.println();
    }


}
