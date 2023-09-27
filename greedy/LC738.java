package greedy;

public class LC738 {
    public int monotoneIncreasingDigits(int n) {
        StringBuilder numStr = new StringBuilder(Integer.toString(n));
        int flag = numStr.length();

        for (int i = numStr.length() - 1; i > 0; i--) {
            if (numStr.charAt(i) < numStr.charAt(i - 1)) {
                flag = i;
                numStr.setCharAt(i - 1, (char)('0' + Character.getNumericValue(numStr.charAt(i - 1)) - 1));
            }
        }

        for (int i = flag; i < numStr.length(); i++)
            numStr.setCharAt(i, '9');

        return Integer.parseInt(numStr.toString());
    }
}
