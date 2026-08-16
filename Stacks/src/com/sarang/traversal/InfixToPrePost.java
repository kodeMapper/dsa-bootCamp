package com.sarang.traversal;

import java.util.Stack;

public class InfixToPrePost {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";

        // Stacks to store the prefixes and postfixes
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                pre.push(ch + "");
                post.push(ch + "");
            } else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    char o = op.pop();

                    // Prefix work -> op + v1 + v2
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    pre.push(o + preV1 + preV2);

                    // Postfix work -> v1 + v2 + op
                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    post.push(postV1 + postV2 + o);
                }
                op.pop(); // Remove '('
            } else {
                while (op.size() > 0 && op.peek() != '(' && precedence(op.peek()) >= precedence(ch)) {
                    char o = op.pop();

                    // Prefix work
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    pre.push(o + preV1 + preV2);

                    // Postfix work
                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    post.push(postV1 + postV2 + o);
                }
                op.push(ch);
            }
        }

        // Clear out remaining elements
        while (op.size() > 0) {
            char o = op.pop();

            String preV2 = pre.pop();
            String preV1 = pre.pop();
            pre.push(o + preV1 + preV2);

            String postV2 = post.pop();
            String postV1 = post.pop();
            post.push(postV1 + postV2 + o);
        }

        System.out.println("Prefix: " + pre.peek());
        System.out.println("Postfix: " + post.peek());
    }

    // Helper function for precedence
    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}