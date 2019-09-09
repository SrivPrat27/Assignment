import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartManager {

    List<Book> buyingList = new ArrayList<>();

    HashMap<Book, Integer> bookToQuantityCart = new HashMap<>();

    double price;

    public void addToCart(Book book) {
        buyingList.add(book);
        price += book.getPrice();
    }

    public void removeFromCart(Book book) {
        if (buyingList.contains(book)) {
            buyingList.remove(book);
            price -= book.getPrice();
        } else
            System.out.println("Book not present in cart");
    }

    public void getCartDetails() throws IOException {
        for (Book book : buyingList) {
            BooksObjectManager objectManager = new BooksObjectManager();
            objectManager.displayBookDetailsView(book);
            System.out.println();
        }
    }

    public double getCartPrice() {
        return price;
    }
}
