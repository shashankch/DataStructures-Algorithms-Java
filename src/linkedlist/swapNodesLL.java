package linkedlist;

public class swapNodesLL {

    public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){

        if(head==null){

            return head;
        }

        LinkedListNode<Integer> curr=head;
        LinkedListNode<Integer> prev=null;
        LinkedListNode<Integer> c1=null,c2=null,p1=null,p2=null;
        int pos=0;

        while(curr!=null){

            if(pos==i){

                p1=prev;
                c1=curr;


            }

            if(pos==j){


                p2=prev;
                c2=curr;

            }

            pos++;
            prev=curr;
            curr=curr.next;

        }

        if(p1!=null){

            p1.next=c2;


        }
        else{

            head=c2;
        }

        if(p2!=null){
            p2.next=c1;
        }
        else{
            head=c1;
        }

        LinkedListNode<Integer> temp=c2.next;
        c2.next=c1.next;

        c1.next=temp;


        return head;



    }
}
