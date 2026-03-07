package slidingWindow.questions;

public class NumberofSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";
        int n = s.length();
        int[] count = new int[3];
        int left = 0, result = 0;
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += n - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        System.out.println(result);
    }
}
