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

//another way

    public static int countallnodes(BinaryTreeNode<Integer> root){

        if(root==null){
            return 0;
        }
        return 1+countallnodes(root.left)+countallnodes(root.right);


    }

    public static int kthSmallestNode2(BinaryTreeNode<Integer> root,int K){

        if(root==null){
                return Integer.MIN_VALUE;
        }
        int leftsmallest=countallnodes(root.left);

        if(leftsmallest>=K){
                return kthSmallestNode2(root.left,K);
        }

        else if(leftsmallest==K-1){
                return root.data;
        }
        else {
                return kthSmallestNode(root.right, K-leftsmallest-1);
        }
    }


}
