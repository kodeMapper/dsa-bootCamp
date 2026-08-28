package binarySearchTree.basics;

public class SizeMaxSumHeight {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // 1. Size of the Tree (Total number of nodes)
    public static int size(Node root) {
        if (root == null) return 0; // if leaf node (count itself only)
        return 1 + size(root.left) + size(root.right);
    }

    // 2. Sum of all nodes in the Tree
    public static int sum(Node root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    // 3. Maximum value node in the Tree
    public static int max(Node root) {
        if (root == null) return Integer.MIN_VALUE; // in case of negative values (if positive then we can take 0)
        return Math.max(root.val,
                        Math.max(max(root.left), max(root.right)));
    }

    // 4. Height of the Tree (Measured in levels)
    public static int height(Node root) {
        if (root == null) return 0;

        // Note: If you want height in terms of edges, add this base case:
        // if (root.left == null && root.right == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // (HW) 5. Minimum value node in the Tree
    public static int min(Node root) {
        if (root == null) return Integer.MAX_VALUE; // in case of negative values (if positive then we can take 0)
        return Math.min(root.val,
                Math.min(min(root.left), min(root.right)));
    }

    // (HW) 6. Product of nodes of Tree
    public static int prod(Node root) {
        if (root == null) return 1; // in case of negative values (if positive then we can take 0)
        return root.val * prod(root.left) * prod(root.right);
    }

    public static void main(String[] args) {
        // Constructing the same tree
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

        // Function Calls
        System.out.println("Size of the tree: " + size(root));
        System.out.println("Sum of the tree: " + sum(root));
        System.out.println("Max value in the tree: " + max(root));
        System.out.println("Height of the tree: " + height(root));
        System.out.println("Min value of the tree: " + min(root));
        System.out.println("Product of the tree: " + prod(root));
    }
}