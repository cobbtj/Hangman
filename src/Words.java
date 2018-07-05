import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Words extends Main{
    public static String getWord() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("/home/xpanxion/Words.txt"));
//        File file = new File("/home/xpanxion/Words.txt");
        String line = reader.readLine();
        List<String> words = new ArrayList<String>();
        while(line != null) {
            String[] wordsLine = line.split(" ");
            for(String word : wordsLine) {
                words.add(word);
            }
            line = reader.readLine();
        }

        Random rand = new Random(System.currentTimeMillis());
        String randomWord = words.get(rand.nextInt(words.size()));
        return randomWord;
    }
}
