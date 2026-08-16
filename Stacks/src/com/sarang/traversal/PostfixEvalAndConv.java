package com.sarang.traversal;

import java.util.Stack;

public class PostfixEvalAndConv {
    public static void main(String[] args) {
        String str = "953+4*6/-"; // Postfix string
        Stack<Integer> val = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<String> pre = new Stack<>();

        // Loop forwards for Postfix
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
                in.push(ch + "");
                pre.push(ch + "");
            } else {
                // Evaluation Work (v2 pops first!)
                int v2 = val.pop();
                int v1 = val.pop();
                if (ch == '+') val.push(v1 + v2);
                if (ch == '-') val.push(v1 - v2);
                if (ch == '*') val.push(v1 * v2);
                if (ch == '/') val.push(v1 / v2);

                // Postfix to Infix -> v1 + op + v2
                String inV2 = in.pop();
                String inV1 = in.pop();
                in.push("(" + inV1 + ch + inV2 + ")");

                // Postfix to Prefix -> op + v1 + v2
                String preV2 = pre.pop();
                String preV1 = pre.pop();
                pre.push(ch + preV1 + preV2);
            }
        }

        System.out.println("Evaluated Value: " + val.peek());
        System.out.println("Infix: " + in.peek());
        System.out.println("Prefix: " + pre.peek());
    }
}