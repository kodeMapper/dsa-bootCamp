package com.sarang.traversal;

import java.util.Stack;

public class PrefixEvalAndConv {
    public static void main(String[] args) {
        String str = "-9/*+5346"; // Prefix string
        Stack<Integer> val = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<String> post = new Stack<>();

        // Loop backwards for Prefix
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
                in.push(ch + "");
                post.push(ch + "");
            } else {
                // Evaluation Work
                int v1 = val.pop();
                int v2 = val.pop();
                if (ch == '+') val.push(v1 + v2);
                if (ch == '-') val.push(v1 - v2);
                if (ch == '*') val.push(v1 * v2);
                if (ch == '/') val.push(v1 / v2);

                // Prefix to Infix -> v1 + op + v2
                String inV1 = in.pop();
                String inV2 = in.pop();
                in.push("(" + inV1 + ch + inV2 + ")");

                // Prefix to Postfix -> v1 + v2 + op
                String postV1 = post.pop();
                String postV2 = post.pop();
                post.push(postV1 + postV2 + ch);
            }
        }

        System.out.println("Evaluated Value: " + val.peek());
        System.out.println("Infix: " + in.peek());
        System.out.println("Postfix: " + post.peek());
    }
}