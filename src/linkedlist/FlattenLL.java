package linkedlist;

public class FlattenLL {


    public static LinkedListNode<Integer>last;
    public static LinkedListNode<Integer> flattenList(LinkedListNode<Integer> node) {

        if(node==null){

            return null;
        }
        last=node;
        LinkedListNode<Integer>nxt=node.next;
        if(node.down!=null){

            node.next=flattenList(node.down);

        }

        if(nxt!=null){

            last.next=flattenList(nxt);

        }
        return node;
    }

    //depth wise...IMP
    public static LinkedListNode<Integer> flattenList2(LinkedListNode<Integer> node) {

        if(node==null){

            return null;
        }

        LinkedListNode<Integer>nxt=node.next;

        node.next=flattenList(node.down);

        LinkedListNode<Integer>tail=node;

        if(tail.next!=null){
          tail=tail.next;
        }

      tail.next=flattenList2(nxt);
      return node;
    }


    //flatten Multilevel LL..
    public static void flattenListCorrect(Node hp) {

        if(hp==null){
            return ;
        }


Node tail=hp;

        while(tail.next!=null)
        {

            tail=tail.next;
        }

        Node curr=hp;

        while(curr!=null){


            if(curr.down!=null){

                tail.next=curr.down;

                Node temp=curr.down;

                while(temp.next!=null){

                    temp=temp.next;
                }

                tail=temp;
            }

            curr=curr.next;
        }


    }

    //flatten Multilevel LL..
    public static void flattenListCorrect2(Node hp) {

        if(hp==null){
            return ;
        }


        Node tail=hp;
        Node temp=hp;

        while(temp.next!=null)
        {

            temp=temp.next;
        }

        tail=temp;

        while(hp!=null){

            if(hp.down!=null){

                tail.next=hp.down;
                hp.down=null;

                while(tail.next!=null){
                    tail=tail.next;
                }
            }

            hp=hp.next;
        }


    }


    public static LinkedListNode<Integer> merge(LinkedListNode<Integer>head1,LinkedListNode<Integer>head2){

        LinkedListNode<Integer> one=head1;
        LinkedListNode<Integer> two=head2;
        LinkedListNode<Integer> head=null;
        LinkedListNode<Integer> tail=null;

        while(one!=null && two!=null){


            if(one.data<two.data){


                if(head==null){

                    head=one;
                    tail=one;
                    one=one.down;
                }

                else{

                    tail.down=one;
                    tail=tail.down;
                    one=one.down;


                }

            }
            else{


                if(head==null){
                    head=two;
                    tail=two;
                    two=two.down;
                }
                else{

                    tail.down=two;
                    tail=tail.down;
                    two=two.down;

                }

            }
        }


        if(one!=null){
            tail.down=one;
        }

        if(two!=null){
            tail.down=two;
        }

        return head;
    }

    public static LinkedListNode<Integer> merge2(LinkedListNode<Integer>head1,LinkedListNode<Integer>head2){

       if(head1==null){
           return head2;
       }
       if(head2==null){
           return head1;
       }

       LinkedListNode<Integer> head=null;

       if(head1.data<head2.data){
           head=head1;
           head.down=merge2(head1.down,head2);
       }
       else{
           head=head2;
           head.down=merge2(head1,head2.down);
       }

       return head;

    }

    public static LinkedListNode<Integer> flat(LinkedListNode<Integer> head) {


        if(head==null || head.right==null)
        {
            return head;

        }

        LinkedListNode<Integer>res=flat(head.right);

        return merge(head,res);

    }


}
