package binarySearchTree.basics;

public class Traversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void preOrder(Node root) {
        // root -- left -- right
        if(root == null) return;
        System.out.print(root.val+" "); // root
        preOrder(root.left); // left
        preOrder(root.right); // right
    }

    public static void inOrder(Node root) {
        // left -- root -- right
        if(root == null) return;
        inOrder(root.left); // left
        System.out.print(root.val+" "); // root
        inOrder(root.right); // right
    }

    public static void postOrder(Node root) {
        // left -- right -- root
        if(root == null) return;
        postOrder(root.left); // left
        postOrder(root.right); // right
        System.out.print(root.val+" "); // root
    }

    // "pip" stands for Pre-In-Post
    public static void pip(Node root) {
        if (root == null) return;

        // 1. PRE-ORDER position (Node is visited for the FIRST time)
        System.out.print(root.val + " ");

        pip(root.left); // Call to the left subtree

        // 2. IN-ORDER position (Node is visited for the SECOND time)
        System.out.print(root.val + " ");

        pip(root.right); // Call to the right subtree

        // 3. POST-ORDER position (Node is visited for the THIRD and final time)
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        // Constructing a basic tree
        //       1
        //      / \
        //     2   3
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

        System.out.println("Euler Tour (Pre, In, and Post simultaneously):");
        pip(root);
        // Expected Output for this tree: 1 2 2 2 1 3 3 3 1

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}
