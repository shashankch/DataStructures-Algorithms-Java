package trees;

public class InorderSuccessor {



    public static BinaryTreeNode<Integer> getMin(BinaryTreeNode<Integer> node)
    {
        BinaryTreeNode<Integer> current = node;


        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


    public static BinaryTreeNode<Integer> inorderSuccesor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {

        if(node==null){
            return null;
        }
        else if(node.right!=null){
            return getMin(node.right);
        }
        else{
            BinaryTreeNode<Integer> ancestor=root;
            BinaryTreeNode<Integer> succ=null;
            while(ancestor!=null){

                if(node.data<ancestor.data){
                    succ=ancestor;
                    ancestor=ancestor.left;
                }
                else if(node.data>ancestor.data){

                    ancestor=ancestor.right;

                }
                else{

                    break;
                }


            }
            return succ;
        }


    }

    static BinaryTreeNode<Integer> next,res;
public static void reverseInorder(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer>node){

        if(root==null) {
            return;
        }
        reverseInorder(root.right,node);
        if(root==node){
            res=next;
        }

        next=root;
        reverseInorder(root.left,node);

}



    public static BinaryTreeNode<Integer> inorderSuccesor2(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {

            res=null;
            next=null;
            reverseInorder(root,node);
            return res;

    }
}
