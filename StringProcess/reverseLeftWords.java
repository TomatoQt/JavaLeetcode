package StringProcess;

public class reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
        }

        return sb.toString();
    }
}
