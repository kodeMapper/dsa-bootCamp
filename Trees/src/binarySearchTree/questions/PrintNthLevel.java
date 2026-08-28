package binarySearchTree.questions;

import binarySearchTree.basics.SizeMaxSumHeight;

public class PrintNthLevel {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    static void nthLevel(Node root, int n) {
        if(root == null) return;
        if(n == 1) System.out.print(root.val+ " ");
        nthLevel(root.left, n-1); // left
        nthLevel(root.right, n-1); // right
    }

    public static int height(Node root) {
        if (root == null) return 0;

        // Note: If you want height in terms of edges, add this base case:
        // if (root.left == null && root.right == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static void main() {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;

        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;

        Node e = new Node(6);
        Node f = new Node(7);
        b.left = e;
        b.right = f;

        nthLevel(root, 2); // for printing a specific level
        System.out.println();
        System.out.println();

        // to print the whole tree (in level order traversal),
        int level = height(root) + 1;
        for(int i=1; i<=level; i++) {
            nthLevel(root, i);
            System.out.println();
        }
    }
}
