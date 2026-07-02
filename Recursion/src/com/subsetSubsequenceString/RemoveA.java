package com.subsetSubsequenceString;

public class RemoveA {

    static void removeA(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        if(ch != 'a') removeA(p + ch, up.substring(1));
        else removeA(p, up.substring(1));
    }

    public static void main(String[] args) {
        String str = "abcdddaca";
        removeA("", str);
    }
}
