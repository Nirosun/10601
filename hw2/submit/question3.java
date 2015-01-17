/**
 * Created by niro on 1/17/15.
 */

import java.io.*;
import java.util.*;

public class question3 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("There should be 2 arguments for input file & stopwords file path.");
            return;
        }

        File inputFile = new File(args[0]);
        File stopwordsFile = new File(args[1]);
        //FileReader reader = new FileReader(inputFile);
        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
            String line = inputReader.readLine();
            inputReader.close();
            String[] wordsRaw = line.split(" ");

            BufferedReader stopReader = new BufferedReader(new FileReader(stopwordsFile));
            ArrayList<String> stopwords = new ArrayList<String>();
            while ((line = stopReader.readLine()) != null) {
                stopwords.add(line.trim());
            }

            ArrayList<String> words = new ArrayList<String>();
            HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

            for (String s : wordsRaw) {
                String sl = s.toLowerCase();
                if (stopwords.contains(sl)) {
                    continue;
                }
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
