package hashTable;

import java.util.ArrayList;
import java.util.List;

public class LC1002 {
    public List<String> commonChars(String[] words) {
        int[] charHash = new int[26];
        List<String> answer = new ArrayList<>();

        if (words.length == 0) {
            return answer;
        }

        // initialize
        for (int i = 0; i < words[0].length(); i++) {
            charHash[words[0].charAt(i) - 'a']++;
        }

        for (int i = 1; i < words.length; i++) { // jump off 1st word
            String word = words[i];
            int[] tempHash = new int[26];
            for (int j = 0; j < word.length(); j++) {
                tempHash[word.charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                charHash[j] = Math.min(charHash[j], tempHash[j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            int num = charHash[i];
            for (int j = 0; j < num; j++) {
                answer.add(String.valueOf((char)('a' + i)));
            }
        }

        return answer;
    }
}
