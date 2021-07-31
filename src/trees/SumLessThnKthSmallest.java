package trees;


class BSTNode{
    int data;
    BSTNode left;
    BSTNode right;
    int sum;
    int size;
    BSTNode(int data){
        this.data=data;
    }

}
public class SumLessThnKthSmallest {


    public static int kth=0;
    public static int solve(BSTNode node, int k){

        if(node==null){

            return 0;
        }

        Integer sum=solve(node.left,k);
        if(kth>=k){
            return sum;
        }

        kth++;

        sum= node.data + sum;
        if(kth>=k){

            return sum;

        }

        return sum+solve(node.right,k);

    }

    static int summ=0;

    public static void calculate(BSTNode root){

        if(root==null){

           return ;
        }

        calculate(root.left);
        calculate(root.right);

        root.size=1+root.left.size+root.right.size;
        root.sum=root.data+root.left.sum+root.right.sum;
    }

    public static void SumLessThanKthSmallest(BSTNode root,int k ){

            if(root==null){
                return;
            }
            if(k<=root.left.size){
                SumLessThanKthSmallest(root.left,k);
            }
            else if(k== root.left.size+1){
                summ+=root.left.sum+root.data;
            }
            else{
                summ+=root.left.sum+root.data;
                SumLessThanKthSmallest(root.right,k-root.left.size-1);
            }



    }




}
