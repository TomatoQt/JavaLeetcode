package hashTable;

import java.util.HashMap;
import java.util.Map;

public class LC383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 记录26个字母的出现次数
        int[] alphabet = new int[26];

        // 统计可用字母数量
        for (int i = 0; i < magazine.length(); i++) {
            char item = magazine.charAt(i);
            alphabet[item - 'a']++;
        }

        // 消耗字母
        for (int i = 0; i < ransomNote.length(); i++) {
            char item = ransomNote.charAt(i);
            // 不够用，false
            if (--alphabet[item - 'a'] < 0)
                return false;
        }

        return true;
    }
}
