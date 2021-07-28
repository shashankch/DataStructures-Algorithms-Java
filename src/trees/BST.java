package trees;

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

    public void insert(int x) {}
    public boolean deleteData(int x) {
        return false;
    }
    public int size() {
        return size;
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