package com.sarang.traversal;

import java.util.Stack;

public class InfixEval {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;

            // If the character is a digit
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48); // converting char to int
            } else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '-') val.push(v1 - v2);
                    if (op.peek() == '+') val.push(v1 + v2);
                    if (op.peek() == '*') val.push(v1 * v2);
                    if (op.peek() == '/') val.push(v1 / v2);
                    op.pop();
                }
                op.pop(); // Removing '('
            } else {
                if (ch == '+' || ch == '-') {
                    // Work until lower precedence or '(' is at the top
                    while (op.size() > 0 && op.peek() != '(') {
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek() == '-') val.push(v1 - v2);
                        if (op.peek() == '+') val.push(v1 + v2);
                        if (op.peek() == '*') val.push(v1 * v2);
                        if (op.peek() == '/') val.push(v1 / v2);
                        op.pop();
                    }
                    op.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    while (op.size() > 0 && op.peek() != '(' && (op.peek() == '*' || op.peek() == '/')) {
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek() == '*') val.push(v1 * v2);
                        if (op.peek() == '/') val.push(v1 / v2);
                        op.pop();
                    }
                    op.push(ch);
                }
            }
        }

        // Final evaluation of remaining elements
        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            if (op.peek() == '-') val.push(v1 - v2);
            if (op.peek() == '+') val.push(v1 + v2);
            if (op.peek() == '*') val.push(v1 * v2);
            if (op.peek() == '/') val.push(v1 / v2);
            op.pop();
        }

        System.out.println(val.peek());
    }
}