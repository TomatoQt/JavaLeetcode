package hashTable;

public class LC242 {
    public boolean isAnagram(String s, String t) {
        int[] s_count = new int[26];
        int[] t_count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            s_count[temp - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            t_count[temp - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s_count[i] != t_count[i]) {
                return false;
            }
        }
        return true;
    }
}
