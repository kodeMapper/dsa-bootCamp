package binarySearchTree.questions;

import java.util.LinkedList;
import java.util.Queue;

public class BfsUsingQueue {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static void bfs(Node root) { // iterative way (no recursion)
        Queue<Node> q = new LinkedList<>();
        if(root != null) q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
            System.out.print(temp.val + " ");
            q.remove();
        }
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

        bfs(root);
    }
}
