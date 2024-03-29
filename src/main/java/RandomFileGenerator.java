import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFileGenerator {
    public static void main(String args[]) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Write.csv"));

        long startTime = System.currentTimeMillis();

        for (int j = 0; j < 1000000; j++) {

            // For assigning random Strings to first five fields (Title, author, ISBN, Publisher, Language) of Book
            StringBuilder stringBuilder = new StringBuilder("");

            stringBuilder.append("Book-"+generateRandomString());
            stringBuilder.append(",");

            for (int i = 1; i < 5; i++) {

                stringBuilder.append(generateRandomString());
                stringBuilder.append(",");

            }

            stringBuilder.append(getRandomValueForPublishedYear());
            stringBuilder.append(",");

            stringBuilder.append(getRandomValueForPrice());
            stringBuilder.append(",");

            stringBuilder.append(getRandomValueForBindingType());
            stringBuilder.append("\n");

            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }

        bufferedWriter.close();

        long closeTime = System.currentTimeMillis();

    }

    public static String generateRandomString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 4; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public static int getRandomValueForPublishedYear() {

        int minYear = 1800;
        int maxYear = 2019;

        int year = minYear + (int) (Math.random() * ((maxYear - minYear) + 1));

        return year;
    }

    public static double getRandomValueForPrice() {

        int minPrice = 100;
        int maxPrice = 2000;

        double price = minPrice + (float) (Math.random() * ((maxPrice - minPrice) + 1));

        return price;
    }

    public static String getRandomValueForBindingType() {

        List<String> bindingTypes = new ArrayList<>();

        bindingTypes.add("Digital");
        bindingTypes.add("PaperBack");
        bindingTypes.add("Hardbound");

        Random random = new Random();
        return bindingTypes.get(random.nextInt(bindingTypes.size()));

    }

}
