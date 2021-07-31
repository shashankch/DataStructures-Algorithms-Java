package trees;

public class KthSmallBST {

    static int pos=0;
    public static int kthSmallestNode(BinaryTreeNode<Integer> root,int K){

        if(root==null){

            return Integer.MIN_VALUE;
        }

        int leftsmallest=kthSmallestNode(root.left,K);

        if(leftsmallest!=Integer.MIN_VALUE){

            return leftsmallest;
        }

        pos++;

        if(pos==K){

            return root.data;
        }

        return kthSmallestNode(root.right,K);

    }


}
