package com.sarang;

public class SquareRootBS {

    public static void main(String[] args) {
        int n = 40;
        int till_decimal = 3;

        System.out.printf("%.3f", sqrt(n, till_decimal));
    }

    // Time: O(log(n))
    static double sqrt(int n, int till_decimal) {
        int s = 0;
        int e = n;

        double root = 0.0;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (m * m == n) {
                return m;
            }

            if (m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
                root = m;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < till_decimal; i++) {
            while (root * root <= n) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }

        return root;
    }
}
