package StringProcess;

public class LC541 {
    public static void invert(char[] charSeq, int start, int end) { // [start, end)
        int left = start, right = end - 1;

        while (left < right) {
            char temp = charSeq[left];
            charSeq[left] = charSeq[right];
            charSeq[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] charSeq = s.toCharArray();
        int start = 0, end = s.length();

        if (end < k) {
            invert(charSeq, 0, end);
            return new String(charSeq);
        }

        while (start < end) {
            start += 2 * k;
            /*
            核心逻辑：
            每隔2k个字符，反转前k个。
            情况1. 字符串长度不足k，全部反转
            情况2. 字符串长度大于2k，不足3k。2k到end之间也需要反转
             */
            invert(charSeq, start - 2 * k, Math.min(start - k, end));
        }

        return new String(charSeq);
    }
}
