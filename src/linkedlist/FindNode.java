package linkedlist;

public class FindNode {
    public static int helper(LinkedListNode<Integer>head,int n){


        if(head==null){
            return -1;
        }

        if(head.data==n){

            return 0;
        }

        int small= helper(head.next,n);
        if(small==-1){
            return -1;
        }
        return small+1;

    }

}
