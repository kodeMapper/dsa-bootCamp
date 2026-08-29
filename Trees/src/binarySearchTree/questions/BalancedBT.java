package binarySearchTree.questions;

public class BalancedBT {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(Node root) {
        if(root == null) {
            return true;
        }

        int left = height(root.left);
        if(root.left != null) left++; // hmne root.left pass kiya tha (as a node), toh hme complete left wali height nhi milegi. root --> root.left wala 1 connection miss ho gya hoga hmse. toh voh add krlo
        int right = height(root.right);
        if(root.right != null) right++;

        if(Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(Node root) {
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }


    static void main() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        System.out.println(isBalanced(a));
    }
}
