import java.io.FileWriter;
import java.io.IOException;

public class RandomFileGenerator {
    public static void main(String args[]) throws IOException {
        Book book;
        for(int i=0;i<1000;i++)
        {
            FileWriter csvWriter = new FileWriter("/home/pratyush/Testing/new.csv");
            StringBuilder sb = null ;
            for(int j=0;j<5;j++)
            {
                sb.append(generateRandomString());
                sb.append(",");
            }
            sb.append(String.valueOf((int)(Math.random())));
            sb.append(",");
            sb.append(String.valueOf((Math.random())));
            sb.append(",");
            sb.append("Digital");
            sb.append("\n");
            csvWriter.write(sb.toString());
        }
    }

    public static String generateRandomString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}
