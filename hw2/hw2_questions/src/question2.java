import java.io.*;
import java.util.*;

/**
 * Created by niro on 1/16/15.
 */
public class question2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("There should be 1 argument for file path.");
            return;
        }

        File inputFile = new File(args[0]);
        //FileReader reader = new FileReader(inputFile);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            reader.close();

            String[] wordsRaw = line.split(" ");
            ArrayList<String> words = new ArrayList<String>();
            HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

            for (String s : wordsRaw) {
                String sl = s.toLowerCase();
                if (!words.contains(sl)) {
                    wordCount.put(sl, 1);
                    words.add(sl);
                }
                else {
                    wordCount.put(sl, wordCount.get(sl) + 1);
                }
            }

            String tmp;
            for (int i = 0; i < words.size() - 1; i ++) {
                for (int j = i; j < words.size(); j ++) {
                    if (words.get(i).compareTo(words.get(j)) > 0) {
                        tmp = words.get(i);
                        words.set(i, words.get(j));
                        words.set(j, tmp);
                    }
                }
            }

            for (int i = 0; i < words.size(); i ++) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(words.get(i) + ":" + wordCount.get(words.get(i)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
