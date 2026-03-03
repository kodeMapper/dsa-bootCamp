package slidingWindow.templates;

public class Optimal {

    public static void main(String[] args) {
        int l=0, r=0, sum=0, maxL=0, k=14;
        int[] arr = {2,5,1,7,10};
        while(r < arr.length) {
            sum = sum + arr[r];

            if(sum > k) {
                sum = sum - arr[l];
                l++;
            }

            if(sum <= k) {
                maxL = Math.max(maxL, r-l+1);
            }

            r++;
        }

        System.out.println(maxL);
    }
}
