import java.io.BufferedReader;
import java.io.IOException;

public class fileReader {
    public static void main(String args[]) throws IOException {
        String pathFile = "/home/pratyush/Testing/File.csv";
        String line = "";
        String splitBy = ",";
        String row[];

        BufferedReader ob = new BufferedReader(new java.io.FileReader(pathFile));
        while ((line = ob.readLine()) != null) {
            row = line.split(splitBy);
            Book book = new Book(row[0],row[1],row[2],row[3],row[4],Integer.parseInt(row[5]),Double.parseDouble(row[6]), BindingType.valueOf(row[7]));
            System.out.print(row[0]+" "+row[1]+" "+row[2]+" "+row[3]+" "+row[4]+" "+row[5]+" "+row[6]+" "+row[7]+"  ");
        }

    }
}
