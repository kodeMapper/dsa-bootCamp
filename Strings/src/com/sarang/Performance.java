package com.sarang;

public class Performance {

    public static void main(String[] args) {

        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            series = series + ch; // --> "a", "ab", "abc", "abcd", "abcde", ....... as we doing this, each time, new object is being created. Old objects becomes garbage. Hence wastage of memory

            // what if we had a datatype which could be modified unlike Strings. So we could do changes in a single object instead of creating new ones --------> We can use StringBuilder (class)
            System.out.println(series);
        }

        System.out.println(series);
    }
}
