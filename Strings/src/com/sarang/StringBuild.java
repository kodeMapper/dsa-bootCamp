package com.sarang;

public class StringBuild {

    public static void main(String[] args) {
        StringBuilder obj = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            obj.append(ch);  // mutable
        }
        System.out.println(obj);
    }
}
