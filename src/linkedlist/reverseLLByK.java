package linkedlist;

public class reverseLLByK {


    public static LinkedListNode<Integer> kReverseByRecursion(LinkedListNode<Integer> head, int k) {


        if(k==0 || k==1){
            return head;
        }

        LinkedListNode<Integer> temp=head;
        LinkedListNode<Integer> prev=null;
        LinkedListNode<Integer> fwd=null;
        if(head==null){
            return head;
        }

        int count=0;
        while(temp!=null && count<k){

            fwd=temp.next;
            temp.next=prev;
            prev=temp;
            temp=fwd;
            count++;
        }

        if(fwd!=null){
            head.next=kReverseByRecursion(fwd,k);
        }


        return prev;

    }

}
