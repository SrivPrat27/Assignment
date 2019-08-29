import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CSVReaderJava {
    public List<Book> initialize()throws IOException {
        FileReader fileReader = new FileReader("/home/pratyush/Testing/File.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        List<Book> listOfBooks = new ArrayList<Book>();

        while ((line = bufferedReader.readLine()) != null) {
            String temp[] = line.split(",");
            System.out.println(temp.length);
            listOfBooks.add(new Book(temp[0],temp[1],temp[2],temp[3],temp[4],Integer.parseInt(temp[5]),Double.parseDouble(temp[6]),BindingType.valueOf(temp[7])));
        }
        return listOfBooks;
    }
}
