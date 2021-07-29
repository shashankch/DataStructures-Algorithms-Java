package trees;


import trees.Solution.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private BinaryTreeNode<Integer> root;
    private int size;

    private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
        if (node == null) {
            return false;
        }
        if (node.data == x) {
            return true;
        }
        if (x < node.data) {
            return isPresentHelper(node.left, x);
        } else {
            return isPresentHelper(node.right, x);
        }

    }

    public boolean isPresent(int x) {

        return isPresentHelper(root, x);

    }

    public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2){

        if(root==null){
            return;
        }


        if(root.data<k1){

            printNodeFromK1ToK2(root.right,k1,k2);
        }

        if(root.data>=k1 && root.data<=k2){


            printNodeFromK1ToK2(root.left,k1,k2);
            System.out.print(root.data+" ");
            printNodeFromK1ToK2(root.right,k1,k2);

        }
        if(root.data>k2){

            printNodeFromK1ToK2(root.left,k1,k2);
        }

    }

    public static BinaryTreeNode<Integer>ConstructBTFromArray(int arr[],int l,int h){

        if(l>h){
            return null;
        }

        int mid=(l+h)/2;
        BinaryTreeNode<Integer>root=new BinaryTreeNode<Integer>(arr[mid]);

        root.left=ConstructBTFromArray(arr,l,mid-1);
        root.right=ConstructBTFromArray(arr,mid+1,h);

        return root;

    }


        public static LPair ConstructLLFromBST(BinaryTreeNode<Integer> root){

            if(root==null){

                LPair ans=new LPair(null,null);

                return ans;

            }

            LinkedListNode<Integer> r=new LinkedListNode<Integer>(root.data);

            LPair left=ConstructLLFromBST(root.left);

            LPair right =ConstructLLFromBST(root.right);


            if(left.head!=null && right.head!=null){

                left.tail.next=r;
                r.next=right.head;


                LPair res=new LPair(left.head,right.tail);
                return res;

            }
            else if(left.head==null && right.head!=null){

                r.next=right.head;


                LPair res=new LPair(r,right.tail);

                return res;
            }
            else if(right.head==null && left.head!=null){
                left.tail.next=r;

                LPair res=new LPair(left.head,r);

                return res;
            }

            else{
                LPair res=new LPair(r,r);

                return res;

            }

        }
    //lowest common ancestor
    public static int lcaInBST(BinaryTreeNode<Integer> root , int a , int b){
        // Write your code here

        while(root!=null){


            if(root.data>a && root.data>b){

                root=root.left;
            }
            else if(root.data<a && root.data<b){

                root=root.right;
            }

            else{
                break;
            }


        }


        return root.data;

    }


    public static BinaryTreeNode lcaInBST2(BinaryTreeNode<Integer> root , int a , int b){
        // Write your code here

        if(root==null || root.data==a || root.data==b){
            return root;
        }

        if(root.data<a && root.data<b){

            return lcaInBST2(root.right,a,b);
        }


        if(root.data>a && root.data>b){
            return lcaInBST2(root.left,a,b);
        }

        BinaryTreeNode<Integer>left=lcaInBST2(root.left,a,b);
        BinaryTreeNode<Integer>right=lcaInBST2(root.right,a,b);
        if(left!=null && right!=null){
            return root;
        }
        else if(left!=null){
            return left;
        }
        return right;
    }



    public static int replaceWithSumOfGreaterNodes(BinaryTreeNode<Integer>root,int sum){

        if(root==null){
            return sum;
        }
        sum=replaceWithSumOfGreaterNodes(root.right,sum);
        sum+=root.data;
        root.data=sum;

        sum=replaceWithSumOfGreaterNodes(root.left,sum);

        return sum;

    }


    private BinaryTreeNode<Integer> helperinsert(BinaryTreeNode<Integer>node,int x){

        if(node ==null){

            BinaryTreeNode<Integer>newnode=new BinaryTreeNode<>(x);

            return newnode;
        }

        if(node.data>x){

            node.left=helperinsert(node.left,x);

        }

        else{


            node.right=helperinsert(node.right,x);
        }


        return node;


    }


    public void insertData(int x){

        root=helperinsert(root,x);
    }


    private BinaryTreeNode<Integer> helperdelete(BinaryTreeNode<Integer>node,int x){

        if(node==null){

            return null;
        }

        if(node.data>x){

            node.left=helperdelete(node.left,x);
        }

        else if(node.data<x){

            node.right=helperdelete(node.right,x);
        }

        else{

            if(node.left!=null && node.right!=null){

                BinaryTreeNode<Integer>temp=node.right;

                while(temp.left!=null){
                    temp=temp.left;
                }

                node.data=temp.data;

                node.right=helperdelete(node.right,temp.data);



            }
            else if(node.left==null){

                return node.right;

            }
            else{
                return node.left;
            }



        }
        return node;


    }

    public void  deleteData(int x){

        root= helperdelete(root,x);

    }

    // print linked list for each level of tree.
    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
    ArrayList<Node<BinaryTreeNode<Integer>>> ans=new ArrayList<>();

    Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();

        q.add(root);
        q.add(null);
    Node<BinaryTreeNode<Integer>> head=null;
    Node<BinaryTreeNode<Integer>> tail=null;

        	while(!q.isEmpty()){

        BinaryTreeNode<Integer> front=q.remove();

        if(front==null){

            if(q.isEmpty()){
                ans.add(head);
                break;
            }
            q.add(null);
            ans.add(head);
            head=null;
            tail=null;

        }
        else{

            if(front.left!=null){
                q.add(front.left);
            }
            if(front.right!=null){
                q.add(front.right);
            }
            Node<BinaryTreeNode<Integer>> newnode=new Node<>(front,null,null);
            if(head==null){

                head=newnode;
                tail=newnode;


            }
            else{

                tail.next=newnode;
                tail=newnode;

            }

        }

    }


        return ans;


}


    public  Pair helper(BinaryTreeNode<Integer> root){


        if(root==null)
        {

            Pair ans=new Pair();

            ans.max=Integer.MIN_VALUE;
            ans.min=Integer.MAX_VALUE;
            ans.isbst=true;
            ans.height=0;
            return ans;
        }


        Pair left=helper(root.left);
        Pair right=helper(root.right);

        Pair res=new Pair();

        int max=Math.max(root.data,Math.max(left.max,right.max));
        int min=Math.min(root.data,Math.min(left.min,right.min));

        res.max=max;
        res.min=min;

        if(root.data>left.max && root.data<right.min && left.isbst && right.isbst){

            int height=1+Math.max(left.height,right.height);

            res.height=height;
            res.isbst=true;
        }

        else{

            int height=Math.max(left.height,right.height);

            res.height=height;
            res.isbst=false;


        }



        return res;



    }

    // BST  pair find pair with the target sum in bst.
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {

        ArrayList<BinaryTreeNode<Integer>>left=new ArrayList<>();
        ArrayList<BinaryTreeNode<Integer>>right=new ArrayList<>();

        BinaryTreeNode<Integer> leftnode=root;
        BinaryTreeNode<Integer>rightnode=root;


        while(leftnode!=null || rightnode!=null || left.size()>0 && right.size()>0){


            while(leftnode!=null){

                left.add(leftnode);
                leftnode=leftnode.left;

            }

            while(rightnode!=null){

                right.add(rightnode);
                rightnode=rightnode.right;
            }



            BinaryTreeNode<Integer> currleft=left.get(left.size()-1);
            BinaryTreeNode<Integer>currright=right.get(right.size()-1);

            int leftdata=currleft.data;
            int rightdata=currright.data;


            if(leftdata+rightdata>s){

                right.remove(right.size()-1);
                rightnode=currright.left;


            }

            else if(leftdata+rightdata<s){

                left.remove(left.size()-1);
                leftnode=currleft.right;


            }
            else if(leftdata>=rightdata){

                break;
            }

            else{

                System.out.println(leftdata+" "+rightdata);
                right.remove(right.size()-1);
                rightnode=currright.left;

                left.remove(left.size()-1);
                leftnode=currleft.right;

            }

        }



    }



    public static BinaryTreeNode<Integer> constructBSTFromPreorder(int []preorder,int start,int end){


        if(start>end){
            return null;
        }

        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(preorder[start]);

        int i;
        for(i=start;i<=end;i++){

            if(preorder[i]>root.data){
                break;
            }

        }


        int leftstart=start+1;
        int leftend=i-1;
        int rightstart=i;
        int rightend=end;


        root.left=constructBSTFromPreorder(preorder,leftstart,leftend);
        root.right=constructBSTFromPreorder(preorder,rightstart,rightend);


        return root;




    }



    public static BinaryTreeNode<Integer> constructBSTFromLevelOrder(BinaryTreeNode<Integer>root,int val){


        if(root==null){

            root=new BinaryTreeNode<Integer>(val);
            // index++;
            return root;
        }

        if(val<root.data){

            root.left=constructBSTFromLevelOrder(root.left,val);

        }
        else{
            root.right=constructBSTFromLevelOrder(root.right,val);
        }

        return root;



    }


    public static BinaryTreeNode<Integer> constructBST(int[] preorder, int n) {

        BinaryTreeNode<Integer> root=null;

        for(int i=0;i<n;i++){
            root=constructBSTFromLevelOrder(root,preorder[i]);
        }


        return root;
    }



    public static boolean findNodeWhereNotPossibleToADD(BinaryTreeNode<Integer>root,int min,int max){


        if(root==null){

            return false;
        }

        if(max==min){

            return true;

        }

        boolean left=findNodeWhereNotPossibleToADD(root.left,min,root.data-1);
        boolean right=findNodeWhereNotPossibleToADD(root.right,root.data+1,max);

        return left|| right;

    }

//not possible without violation of bst policy...
    public static boolean deadEnd(BinaryTreeNode<Integer> root) {

        return findNodeWhereNotPossibleToADD(root,1,Integer.MAX_VALUE);

    }





}
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

    class LPair{

        public LinkedListNode<Integer> head;
        public LinkedListNode<Integer> tail;

        public LPair(LinkedListNode<Integer> head,LinkedListNode<Integer> tail ){

            this.head=head;
            this.tail=tail;

        }

    }

