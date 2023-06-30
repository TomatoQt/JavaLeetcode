package StringProcess;

// 正则表达式貌似不处理字符串的前导和后置的匹配部分
public class LC151 {
    public String reverseWords(String s) {
        s = s.trim(); // remove front end spaces
        String[] split = s.split("\\s+");// spaces

        // reverse
        int left = 0, right = split.length - 1;
        while (left < right) {
            String temp = split[left];
            split[left] = split[right];
            split[right] = temp;
            left++;
            right--;
        }

        // join
        return String.join(" ", split);
    }
}
