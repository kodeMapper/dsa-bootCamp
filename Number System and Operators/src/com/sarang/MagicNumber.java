package com.sarang;
/*
    Q. Find nth magic number
    1st magic number --> write 1 in binary and multiply it with powers of 5
    0    0      1
    *    *      *
    5^3 + 5^2 + 5^1 = 5

    approach -
    convert the number in binary --> we need the last bit --> hence & with 1 will give us the last digit --> multiply it with 5^i --> right shift --> repeat the process
 */
public class MagicNumber {

    public static void main(String[] args) {
        int n = 6;
        int ans = 0;
        int base = 5;

        while(n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base *= 5;
        }

        System.out.println(ans);
    }
}
