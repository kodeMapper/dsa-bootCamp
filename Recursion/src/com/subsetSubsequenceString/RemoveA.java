package com.subsetSubsequenceString;

public class RemoveA {

    // pass string in args
    static void removeA(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        if(ch != 'a') removeA(p + ch, up.substring(1));
        else removeA(p, up.substring(1));
    }

    // pass string in body
    static String removeAandReturn(String up) {
        if (up.isEmpty()) {
            return "";
        }

        if(up.charAt(0) == 'a') return removeAandReturn(up.substring(1));
        else return up.charAt(0) + removeAandReturn(up.substring(1));
    }

    public static void main(String[] args) {
        String str = "abcdddaca";
//        removeA("", str);
        System.out.println(removeAandReturn(str));
    }
}
