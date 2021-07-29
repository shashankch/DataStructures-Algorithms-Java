package trees;

import java.util.Scanner;

class Node<T> {
    T data;
    Node left;
    Node right;
    Node parent;
    Node next;

    Node(T data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public static Node helper(int arr[], int i, int n, Node root) {

       

        if (root == null) {

            root = new Node(arr[i], null, null);
          
        }

        if (2 * i + 1 < n && arr[2 * i + 1] != -1) {

            root.left = helper(arr, 2 * i + 1, n, root.left);

        }
         if (2 * i + 2 < n && arr[2 * i + 2] != -1) {

            root.right = helper(arr, 2 * i + 2, n, root.right);

        }

        return root;

    }

    public static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static void setParent(Node root, Node parent) {

        if (root == null) {
            return;
        }

        root.parent = parent;
        parent = root;
        setParent(root.left, parent);
        setParent(root.right, parent);

    }

    public static Node solve(int[] arr) {

        int n = arr.length;

        Node root = null;
        root = helper(arr, 0, arr.length, root);
       // Node parent = null;
       // setParent(root, parent);
        inorder(root);

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";

        str += node.left == null ? "." : node.left.data;
        str += " => " + node.data + ("[" + (node.parent != null ? node.parent.data : "null") + "]") + " <= ";
        str += node.right == null ? "." : node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Node root = null;

        Scanner scn = new Scanner(System.in);

        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        root = solve(arr);
        display(root);
    }

}
