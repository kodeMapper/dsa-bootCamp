package binarySearchTree.questions;

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
        b.right = e;

        nthLevel(root, 2);
    }
}
