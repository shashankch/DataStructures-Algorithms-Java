package trees;
import strings.KMPSearch.*;

import static strings.KMPSearch.search;

public class SubTree {

    public static Pairs helper(TreeNode T ,TreeNode S){


        if(T==null && S==null){

            return new Pairs(T,S,true);
        }

        if(T==null || S==null){

            return new Pairs(T,S,false);
        }


        if(T.val==S.val){

            Pairs left=helper(T.left,S.left);
            Pairs right=helper(T.right,S.right);

            if(left.isSub &&right.isSub){

                return new Pairs(T,S,true);
            }
        }

        Pairs ifleft=helper(T.left,S);
        Pairs ifright=helper(T.right,S);

        return new Pairs(T,S,ifleft.isSub||ifright.isSub);
    }

    public static boolean isSubtree(TreeNode T, TreeNode S) {
        // Write your code here

        return helper(T,S).isSub;

    }


    public static boolean anotherApproach(TreeNode T,TreeNode S){

        if(T==S){
            return true;
        }
        if(T==null){
            return false;
        }

        if(!search(inorder(T),inorder(S)) || !search(postorder(T),postorder(S))){
            return false;
        }

        return true;
    }


    public static String inorder(TreeNode root){

        if(root==null){
            return null;
        }

        return inorder(root.left)+" "+root.val+" "+inorder(root.right);

    }


    public static String postorder(TreeNode root){

        if(root==null){
            return null;
        }

        return postorder(root.left)+" "+postorder(root.right)+" "+root.val;

    }

}
