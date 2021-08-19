package linkedlist;

public class palindromeLL {

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){

        LinkedListNode<Integer>curr=head;
        LinkedListNode<Integer>nxt=null;
        LinkedListNode<Integer>prev=null;
    while(curr!=null){

            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }

        return prev;


    }

    public static boolean isPalindrome_2(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> fast=head;
        LinkedListNode<Integer> slow=head;
        if(head==null || head.next==null){
            return true;
        }
        while(fast.next!=null && fast.next.next!=null){

            fast=fast.next.next;
            slow=slow.next;

        }
        LinkedListNode<Integer> temp=head;
        LinkedListNode<Integer> temp2=slow.next;
        slow.next=null;
        LinkedListNode<Integer> part=reverse(temp2);

        while(part!=null){

            if(part.data!=temp.data){

                return false;
            }

            part=part.next;
            temp=temp.next;


        }

        return true;



    }
}
