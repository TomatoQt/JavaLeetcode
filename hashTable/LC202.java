package hashTable;

import java.util.HashSet;
import java.util.Set;

public class LC202 {
    public boolean isHappy(int n) {
        Set<Integer> sumHash = new HashSet<>();

        while (n != 1) {
            n = getSumForEachDigit(n);
            if (sumHash.contains(n))
                return false;
            else
                sumHash.add(n);
        }

        return true;
    }

    public static int getSumForEachDigit(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        sum += n * n;
        return sum;
    }
}
