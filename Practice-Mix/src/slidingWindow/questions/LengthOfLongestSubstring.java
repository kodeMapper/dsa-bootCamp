package slidingWindow.questions;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxCount = 0;
        int count = 0;
        int l = 0;

        char[] arr = s.toCharArray();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (map.containsKey(c) && map.get(c) >= l) {
                l = map.get(c) + 1;
            }

            map.put(c, r);
            maxCount = Math.max(maxCount, r - l + 1);
        }

        return maxCount;
    }
}
