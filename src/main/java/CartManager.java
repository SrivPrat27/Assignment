import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class CartManager {

    List<Book> buyingList = new ArrayList<>();

    LinkedHashMap<Book, Integer> bookToQuantityCart = new LinkedHashMap<>();

    double price;

    public void addToCart(Book book, int noOfBooks) {
        if (!bookToQuantityCart.containsKey(book)) {
            bookToQuantityCart.put(book, noOfBooks);
        } else {
            bookToQuantityCart.put(book, bookToQuantityCart.get(book) + noOfBooks);
        }
        price = price + book.getPrice() * noOfBooks;
/*
        buyingList.add(book);
        price += book.getPrice();
*/
    }

    public void updateCartByAdding(Book book, int noOfCopies) {
        if (bookToQuantityCart.containsKey(book)) {
            bookToQuantityCart.put(book, bookToQuantityCart.get(book) + noOfCopies);
        } else
            System.out.println("Book Not Present In Cart");
    }

    public void updateCartByRemovingCopies(Book book, int noOfCopies) {
        if(noOfCopies > bookToQuantityCart.get(book))
        {
            removeFromCart(book);
            return ;
        }
        if (bookToQuantityCart.containsKey(book)) {
            bookToQuantityCart.put(book, bookToQuantityCart.get(book) - noOfCopies);
        } else
            System.out.println("Book Not Present In Cart");

    }

    public void removeFromCart(Book book) {
        int countOfBooksInCart = bookToQuantityCart.get(book);
        if (bookToQuantityCart.containsKey(book)) {
            bookToQuantityCart.remove(book);
            price = price - countOfBooksInCart * book.getPrice();
        } else {
            System.out.println("Book not present in cart");
        }
        /*if (buyingList.contains(book)) {
            buyingList.remove(book);
            price -= book.getPrice();
        } else
            System.out.println("Book not present in cart");*/
    }

    public void getCartDetails() throws IOException {
        Set<Book> bookSet = bookToQuantityCart.keySet();
        for (Book book : bookSet) {
            displayCart(book);
        }
        System.out.println("Total Amount : " + getCartPrice());

    }

    public double getCartPrice() {
        return price;
    }

    public void displayCart(Book book) {
        // TODO : Temporary fix as calling the same function in BooksObjectManager is takingf a lot of time unusually .
        System.out.println("Title : " + book.getBookTitle());
        System.out.println("Author : " + book.getAuthor());
        System.out.println("Binding Type : " + book.getBindingType());
        System.out.println("ISBN : " + book.getBookISBN());
        System.out.println("Language :" + book.getLanguage());
        System.out.println("Price :" + book.getPrice());
        System.out.println("Published year :" + book.getPublishedYear());
        System.out.println("Publisher :" + book.getPublisher());
        System.out.println("Quantity :" + bookToQuantityCart.get(book));
        System.out.println();
    }

    public Book getBookFromIsbn(String Isbn) {
        Set<Book> bookSet = bookToQuantityCart.keySet();
        for (Book book : bookSet) {
            if (book.getBookISBN().equals(Isbn))
                return book;
        }
        return null;
    }

    public void checkOut(){
        System.out.println("Total Price : " + getCartPrice());
        price = 0.0;
        bookToQuantityCart.clear();
    }
}
