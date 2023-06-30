package StringProcess;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        char[] charSeq = s.toCharArray();
        StringBuilder res = new StringBuilder();

        for (char c : charSeq) {
            if (c == ' ')
                res.append("%20");
            else
                res.append(c);
        }

        return res.toString();
    }
}
