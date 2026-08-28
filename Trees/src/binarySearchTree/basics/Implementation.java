package binarySearchTree.basics;

public class Implementation {
    // Node class definition
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // Display function to print the tree recursively
    public static void display(Node root) {
        // Base case: if node is null, stop recursion
        if (root == null) return;

        // Print current node and its children
        System.out.print(root.val + " -> ");
        if (root.left != null) System.out.print(root.left.val + ", ");
        else System.out.print("null, ");

        if (root.right != null) System.out.print(root.right.val);
        else System.out.print("null");

        System.out.println();

        // Recursive calls for left and right subtrees
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        // Constructing the tree manually
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

        // Display the constructed tree
        display(root);
    }
}