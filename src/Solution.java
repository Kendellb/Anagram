import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.lang.Math.abs;
import static java.util.stream.Collectors.joining;

class Result {
    public static int anagram(String s) {
        int changes = 0;
        int middle = s.length() / 2;
        if ( s.length() % 2 != 0 ) {
            return -1;
        }
        //String [] parts = {s.substring(0,middle),s.substring(middle)};
        char[] char1 = s.substring(0, middle).toCharArray();
        char[] char2 = s.substring(middle).toCharArray();
        HashMap<Character, Integer> sub1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> sub2 = new HashMap<Character, Integer>();

        for (char c : char1) {
            if ( sub1.containsKey(c) ) {
                sub1.put(c, sub1.get(c + 1));
            } else {
                sub1.put(c, 1);
            }
        }
        for (char c : char2) {
            if ( sub2.containsKey(c) ) {
                sub2.put(c, sub2.get(c + 1));
            } else {
                sub2.put(c, 1);
            }
        }
        for(char c : sub1.keySet())
            if(sub1.containsKey(c) && sub2.containsKey(c)){
            changes += abs(sub1.get(c) - sub2.get(c));
            }
            else
                changes += sub1.get(c);

        return changes;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0,q).forEach(qItr ->{
                try {
                    String s = bufferedReader.readLine();

                    int result = Result.anagram(s);
                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
bufferedReader.close();
bufferedWriter.close();
    }
}
