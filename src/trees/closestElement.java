package trees;

class sol{

    int ans;
}

public class closestElement {

    static int minima,ans;
    public static void  absolutediff2(BinaryTreeNode<Integer>root,int k){

        if(root==null){

            return;
        }

        if(root.data==k){

            ans=root.data;
            minima=0;

        }

        int diff=Math.abs(k-root.data);
        if(diff<minima){
            minima=diff;
            ans=root.data;
        }

        if(k<root.data){

            absolutediff2(root.left,k);

        }
        else{
            absolutediff2(root.right,k);

        }

    }

    public static void  absoluteDiff(BinaryTreeNode<Integer>root,int k,int min,sol ob){

        if(root==null){

            return;
        }

        if(root.data==k){

            ob.ans=root.data;
            return;
        }

        int diff=Math.abs(k-root.data);
        if(diff<min){
            min=diff;
            ob.ans=root.data;
        }

        if(k<root.data){

            absoluteDiff(root.left,k,min,ob);

        }
        else{
            absoluteDiff(root.right,k,min,ob);

        }

    }


    public static int minDiff(BinaryTreeNode<Integer> root, int k) {
        //Write your code here

        sol ob=new sol();
        absoluteDiff(root,k,Integer.MAX_VALUE,ob);

        return ob.ans;

    }

}
