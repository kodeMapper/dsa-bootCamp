package codeforces;

import java.util.*;

public class Contest1091 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int T = 1; T <=t; T++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];

            for(int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }

            long sum = 0;

            for(int i=0; i<n; i++) {
                sum += a[i];
            }

            System.out.println("Sum: " + sum);

            if(sum % 2 != 0 || n*k % 2 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
