package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC93 {
    public boolean judger(String str) {
        int len = str.length();
        // 超过3位
        if (len > 3)
            return false;
        // 有先导0
        if (len > 1 && str.indexOf("0") == 0)
            return false;
        // 超过255
        if (Integer.parseInt(str) > 255)
            return false;

        return true;
    }

    private List<String> path;
    private List<String> result;

    public void restoreHelper(String s, int startIndex) { // before, not included
        if (startIndex >= s.length() && path.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String value : path) {
                sb.append(value);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1); // 去掉最后多余的"."
            result.add(sb.toString());
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i + 1);
            if (path.size() < 4) { // 保证path不超过4个元素
                path.add(subStr);
                if (judger(subStr))
                    restoreHelper(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        path = new ArrayList<>();
        result = new ArrayList<>();

        restoreHelper(s, 0);
        return result;
    }
}
