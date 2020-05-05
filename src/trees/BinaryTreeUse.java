package trees;

import java.util.*;
//import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeTreeInput(boolean isRoot, int parentdata, boolean isleft) {

        if (isRoot) {
            System.out.println("Enter root data");
        } else {

            if (isleft) {
                System.out.println("enter left child of" + parentdata);
            }

            else {
                System.out.println("enter right child of" + parentdata);
            }

        }

        Scanner sc = new Scanner(System.in);
        int rootdata = sc.nextInt();
        if (rootdata == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        BinaryTreeNode<Integer> leftchild = takeTreeInput(false, rootdata, true);
        BinaryTreeNode<Integer> rightchild = takeTreeInput(false, rootdata, false);
        root.left = leftchild;
        root.right = rightchild;

        return root;

    }

    public static int maxnode(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return -1;
        }

        int leftmax = maxnode(root.left);
        int rightmax = maxnode(root.right);

        return Math.max(root.data, Math.max(leftmax, rightmax));
    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);

        return root;

    }

    public static int height(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public static BalancedTree isbalancedbetter(BinaryTreeNode<Integer> root) {

        if (root == null) {
            int height = 0;
            boolean isBal = true;
            BalancedTree ans = new BalancedTree();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }

        BalancedTree left = isbalancedbetter(root.left);
        BalancedTree right = isbalancedbetter(root.right);

        boolean isBal = true;
        int height = 1 + Math.max(left.height, right.height);

        if (Math.abs(left.height - right.height) > 1) {
            isBal = false;
        }

        if (!left.isBalanced || !right.isBalanced) {

            isBal = false;
        }
        BalancedTree ans = new BalancedTree();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }

    public static boolean isbalanced(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return true;
        }

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        if (Math.abs(leftheight - rightheight) > 1) {
            return false;
        }

        boolean isLeftBalanced = isbalanced(root.left);
        boolean isRightBalanced = isbalanced(root.right);

        return isLeftBalanced && isRightBalanced;

    }

    public static ArrayList<Integer> nodetorootpath(BinaryTreeNode<Integer> root, int x) {

        if (root == null) {
            return null;
        }
        if (root.data == x) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> left = nodetorootpath(root.left, x);
        if (left != null) {
            left.add(root.data);
            return left;
        }

        ArrayList<Integer> right = nodetorootpath(root.right, x);

        if (right != null) {
            right.add(root.data);
            return right;
        }

        return null;
    }

}