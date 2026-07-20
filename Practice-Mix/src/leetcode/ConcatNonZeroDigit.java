package leetcode;

public class ConcatNonZeroDigit {
    public static long sumAndMultiply(int n) {
        long ans = 0;
        long sum = 0;
        int mul=1;
        int x=0;

        while(n>0) {
            int rem = n % 10;
            if(rem != 0) {
                x = x + rem*mul;
                mul *= 10;
            }

            n = n/10;
        }

        int temp = x;
        while(temp>0) {
            int rem = temp % 10;
            sum += rem;
            temp /= 10;
        }

        ans = (long)(x * sum);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sumAndMultiply(10203004));
    }
}
