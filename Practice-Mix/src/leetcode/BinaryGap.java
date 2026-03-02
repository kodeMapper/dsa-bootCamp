package leetcode;

public class BinaryGap {
    public static int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        int left = 0;
        int right = 0;
        int maxDist = 0;
        boolean isFirst = false;

        for(right=0; right<binary.length(); right++) {
            if(binary.charAt(right)=='1' && !isFirst) {
                isFirst = true;
                continue;
            }

            else if(binary.charAt(right)=='1' && isFirst) {
                maxDist = Math.max(maxDist, right-left);
                left = right;
//                isFirst = false;
            }
        }

        return maxDist;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(13));;
    }
}
