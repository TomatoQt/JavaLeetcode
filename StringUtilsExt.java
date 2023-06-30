import java.util.ArrayList;
import java.util.List;

public class StringUtilsExt {
    /**
     * @param source 源字符串
     * @param prefix 开头字符串
     * @param suffix 结尾字符串
     * @return 在source中找出所有以prefix开头并且以suffix结尾的子串
     */

    public static List<String> findSubString(String source, String prefix, String suffix) {
        List<String> res = new ArrayList<>();
        List<String> prefixes = new ArrayList<>();
        int pIndex = 0;
        for (int i = 0; i < source.length() - prefix.length(); i++) {
            if (source.charAt(i) == prefix.charAt(pIndex)) {
                pIndex++;
                if (pIndex == prefix.length() - 1)
                    prefixes.add(source.substring(i - prefix.length() + 1));
            } else pIndex = 0;
        }

        int sIndex = suffix.length() - 1;
        for (String item : prefixes) {
            for (int i = item.length() - 1; i > item.length() - suffix.length(); i--) {
                if (source.charAt(i) == suffix.charAt(sIndex)) {
                    sIndex--;
                    if (sIndex == 0)
                        res.add(item.substring(i));
                } else {
                    sIndex = suffix.length() - 1;
                }
            }
        }

        return res;
    }
}
