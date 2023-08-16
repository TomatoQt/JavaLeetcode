package StringProcess;

// 正则表达式貌似不处理字符串的前导和后置的匹配部分
public class LC151 {
    public String reverseWords(String s) {
        // 去除首尾及中间的多余空格
        StringBuilder sb = removeSpaces(s);

        // 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);

        // 反转单个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    private StringBuilder removeSpaces(String str) {
        int left = 0, right = str.length() - 1;
        StringBuilder res = new StringBuilder();

        // 去除首尾多余空格
        while (str.charAt(left) == ' ') left++;
        while (str.charAt(right) == ' ') right--;

        while (left <= right) {
            // 遇到非空格就append，遇到空格了，只保留已经在res中的那个
            if (str.charAt(left) != ' ' || res.charAt(res.length() - 1) != ' ')
                res.append(str.charAt(left));
            left++;
        }

        return res;
    }

    private void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);

            left++;
            right--;
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int left = 0, right = left + 1;

        while (right < sb.length()) {
            // 找到要反转的区间[left, right - 1]
            while (right < sb.length() && sb.charAt(right) != ' ') right++;
            reverseString(sb, left, right - 1);

            left = right + 1;
            right = left + 1;
        }
    }
}
