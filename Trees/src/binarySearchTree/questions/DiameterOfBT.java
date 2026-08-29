package binarySearchTree.questions;

public class DiameterOfBT {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int diameterOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;

        int leftAns = diameterOfBinaryTree(root.left);
        int rightAns = diameterOfBinaryTree(root.right);
        int mid = height(root.left) + height(root.right);
        if (root.left != null)
            mid++;
        if (root.right != null)
            mid++;
        int max = Math.max(mid, Math.max(leftAns, rightAns));

        return max;
    }

    static void main() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(diameterOfBinaryTree(a));
    }
}
