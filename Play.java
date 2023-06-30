import java.util.Scanner;
import java.util.Stack;

public class Play {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        while (m-- > 0) {
            int q = scanner.nextInt();
            int[] f = new int[q + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = q; j >= a[i] * a[i]; j--) {
                    f[j] = Math.max(f[j], f[j - a[i] * a[i]] + 1);
                }
            }
            System.out.print(f[q] + " ");
        }
    }
}
