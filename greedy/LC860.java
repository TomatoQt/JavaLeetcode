package greedy;

import java.util.ArrayList;
import java.util.List;

public class LC860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            int money = bills[i];
            if (money == 5)
                five++;
            else if (money == 10) {
                five--;
                ten++;
            } else if (money == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0)
                return false;
        }
        return true;
    }
}
