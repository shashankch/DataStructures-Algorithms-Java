package linkedlist;

import java.util.*;

class Node<T> {
    T data;
    Node<T> next;
    Node<T> arb;
    Node<T> down;
    Node(T data) {
        this.data = data;
        this.next = null;
        this.arb = null;
        this.down=null;
    }
}



public class CloneLL {

    public static Node<Integer> clone(Node<Integer> head) {

        if(head==null ){
            return head;
        }

        Map<Node<Integer>,Node<Integer> >mp=new HashMap<>();

        Node<Integer>curr=head;
        Node<Integer>clone=null;
        while(curr!=null){

            clone=new Node<Integer>(curr.data);
            mp.put(curr,clone);

            curr=curr.next;
        }


        curr=head;

        while(curr!=null){


            clone=mp.get(curr);
            clone.next=mp.get(curr.next);
            clone.arb=mp.get(curr.arb);
            curr=curr.next;



        }

        return mp.get(head);

    }

    public static Node<Integer> cloneLLAnotherApproach(Node<Integer> head){

            if(head==null){
                return null;
            }
            Node<Integer>current=head;

            // add cloned nodes
            while(current!=null){
                Node<Integer> temp=current.next;
                Node<Integer> newNode=new Node<>(current.data);
                current.next=newNode;
                newNode.next=temp;
                current=temp;

            }

            current=head;
            // adding arb pointer...
            while(current!=null){

                if(current.next!=null){
                    if(current.arb!=null){
                        current.next.arb=current.arb.next;
                    }
                    else{
                        //current.arb equals NULL..
                        current.next.arb=current.arb;
                    }
                }
                if(current.next!=null){
                    current=current.next.next;
                }
                else{
                    current=current.next;
                }
            }

            // separate two LL..
            Node<Integer> origin=head;
            Node<Integer> cp=head.next;
            Node<Integer> temp=cp;
            while(origin!=null && cp!=null){

                if(origin.next!=null){

                    origin.next=origin.next.next;
                }
                if(cp.next!=null){
                    cp.next=cp.next.next;
                }

                origin=origin.next;
                cp=cp.next;
            }

        return temp;
    }
}
