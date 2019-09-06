import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class CSVReaderJava {

    BufferedReader bufferedReader;
    FileReader fileReader;
    String line = null;

    public List<Book> initializeListOfBooksInArrayList() throws IOException {

        fileReader = new FileReader("Write.csv");
        bufferedReader = new BufferedReader(fileReader);

        List<Book> listOfBooks = new ArrayList<Book>();

        //TODO : What if the title contains a "," itself
        while ((line = bufferedReader.readLine()) != null) {

            String temp[] = line.split(",");
            listOfBooks.add(new Book(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), Double.parseDouble(temp[6]), BindingType.valueOf(temp[7])));

        }

        return listOfBooks;
    }

    public Map<String, TreeMap> initializeBooksMap() throws IOException {
        fileReader = new FileReader("Write.csv");
        bufferedReader = new BufferedReader(fileReader);

        TreeMap<String, TreeMap> mapContainingAllMaps = new TreeMap<>();
        TreeMap<String, List<Book>> titleToListOfBooksMap = new TreeMap<>();
        TreeMap<String, List<Book>> authorToListOfBooksMap = new TreeMap<>();
        TreeMap<Integer, List<Book>> yearToListOfBooksMap = new TreeMap<>();

        while ((line = bufferedReader.readLine()) != null) {

            String temp[] = line.split(",");
            String title = temp[0];
            String author = temp[1];
            int year = Integer.parseInt(temp[5]);
            initializeAuthorTitletoListOfBooksMap(titleToListOfBooksMap, temp, title);
            initializeAuthorTitletoListOfBooksMap(authorToListOfBooksMap, temp, author);
            Book inputBook = new Book(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), Double.parseDouble(temp[6]), BindingType.valueOf(temp[7]));
            if (!yearToListOfBooksMap.containsKey(year)) {
                ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(inputBook));
                yearToListOfBooksMap.put(year, bookList);
            } else {
                List<Book> tempList = yearToListOfBooksMap.get(year);
                tempList.add(inputBook);
                yearToListOfBooksMap.put(year, tempList);
            }
        }

        mapContainingAllMaps.put("Title", titleToListOfBooksMap);
        mapContainingAllMaps.put("Author", authorToListOfBooksMap);
        mapContainingAllMaps.put("Year", yearToListOfBooksMap);
        return mapContainingAllMaps;
    }

    private void initializeAuthorTitletoListOfBooksMap(TreeMap<String, List<Book>> stringListTreeMap, String[] temp, String Key) {
        Book inputBook = new Book(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), Double.parseDouble(temp[6]), BindingType.valueOf(temp[7]));
        if (!stringListTreeMap.containsKey(Key)) {
            ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(inputBook));
            stringListTreeMap.put(Key, bookList);
        } else {
            List<Book> tempList = stringListTreeMap.get(Key);
            tempList.add(inputBook);
            stringListTreeMap.put(Key, tempList);
        }
    }
}

