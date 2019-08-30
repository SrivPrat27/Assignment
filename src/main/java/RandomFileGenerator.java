import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RandomFileGenerator {
    public static void main(String args[]) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/pratyush/Testing/Write.csv"));
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < 1000000; j++) {
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < 5; i++) {
                stringBuilder.append(generateRandomString());
                stringBuilder.append(",");
            }
            stringBuilder.append((int) (Math.random()));
            stringBuilder.append(",");
            stringBuilder.append(Math.random());
            stringBuilder.append(",");
            stringBuilder.append("Digital");
            stringBuilder.append("\n");
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        long closeTime = System.currentTimeMillis();
        System.out.println(closeTime - startTime);
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
