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

    // if we want to remove a string("apple") instead of a character ('a')
    static String removeAppleAndReturn(String up) {
        if (up.isEmpty()) {
            return "";
        }

        if(up.startsWith("apple")) return removeAppleAndReturn(up.substring(5));
        else return up.charAt(0) + removeAppleAndReturn(up.substring(1));
    }

    // if we want to remove "app" only if its not the part of "apple"
    static String removeAppAndReturn(String up) {
        if (up.isEmpty()) {
            return "";
        }

        if(up.startsWith("app") && !up.startsWith("apple")) return removeAppAndReturn(up.substring(3));
        else return up.charAt(0) + removeAppAndReturn(up.substring(1));
    }

    public static void main(String[] args) {
        String str = "abcdappledaca";
//        removeA("", str);
//        System.out.println(removeAandReturn(str));
//        System.out.println(removeAppleAndReturn(str));
        System.out.println(removeAppAndReturn("abcappbshrapple"));
    }
}
