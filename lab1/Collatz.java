/**
 * Class that prints the Collatz sequence starting from a given number.
 *
 * @author KIYI
 */
public class Collatz {

    /**
     * 考拉兹猜想（Collatz conjecture）
     * 是指对于每一个正整数，如果它是奇数，则对它乘3再加1，如果它是偶数，则对它除以2，如此循环，最终都能够得到1。
     * f ( n ) = { n / 2 if ( n mod 2 ) = 0
     *             3 * n + 1 if ( n mod 2 ) = 1 }
     */
    public static int nextNumber(int n) {
        if (n % 2 == 0) {
            return n /= 2;
        } else {
            return n * 3 + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

