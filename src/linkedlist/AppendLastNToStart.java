package linkedlist;

public class AppendLastNToStart {

    public static int length(LinkedListNode<Integer>head){

        LinkedListNode<Integer>temp=head;
        int count=0;
        while(temp!=null){

            count++;
            temp=temp.next;
        }

        return count;

    }
    public static LinkedListNode<Integer> append(LinkedListNode<Integer> root, int n) {


        int len=length(root);


        LinkedListNode<Integer> temp=root;
        int count=0;
        while(count<(len-n-1)){

            temp=temp.next;


            count++;


        }

        LinkedListNode<Integer> small=temp.next;
        temp.next=null;
        temp=small;
        while(temp.next!=null){

            temp=temp.next;


        }

        temp.next=root;

        root=small;

        return root;



    }

    public static LinkedListNode<Integer> appendFastSlowApproach(LinkedListNode<Integer> head, int n) {


      if(n==0|| head==null){
          return head;
      }

    LinkedListNode<Integer> fast=head;
      LinkedListNode<Integer>slow=head;
      LinkedListNode<Integer> init=head;
      for(int i=0;i<n;i++){
          fast=fast.next;
      }
      while(fast.next!=null){
          slow=slow.next;
          fast=fast.next;
      }

      LinkedListNode<Integer> temp=slow.next;
      slow.next=null;
      fast.next=init;
      head=temp;

      return head;

    }
}
