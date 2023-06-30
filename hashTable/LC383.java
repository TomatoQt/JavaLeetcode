package hashTable;

import java.util.HashMap;
import java.util.Map;

public class LC383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char item = magazine.charAt(i);
            // haven't put in
            if (!charCount.containsKey(item)) {
                charCount.put(item, 1);
            } else { // +1 based on previous value
                int itemCount = charCount.get(item);
                charCount.put(item, ++itemCount);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char item  = ransomNote.charAt(i);
            if (!charCount.containsKey(item) || charCount.get(item) == 0) {
                return false;
            } else {
                int itemCount = charCount.get(item);
                charCount.put(item, --itemCount);
            }
        }

        return true;
    }
}
