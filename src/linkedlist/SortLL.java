package linkedlist;



class DoublyLinkedListNode<T> {
    T data;
    DoublyLinkedListNode<T> next;
    DoublyLinkedListNode<T> prev;

    DoublyLinkedListNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class SortLL {



    public class Solution {

        public static DoublyLinkedListNode<Integer>  merge(DoublyLinkedListNode<Integer>head1,DoublyLinkedListNode<Integer>head2){

            DoublyLinkedListNode<Integer> one=head1;
            DoublyLinkedListNode<Integer> two=head2;
            DoublyLinkedListNode<Integer> head=null;
            DoublyLinkedListNode<Integer> tail=null;

            if(head1==null){
                return head2;
            }
            if(head2==null){
                return head1;
            }

            while(one!=null && two!=null){


                if(one.data<two.data){


                    if(head==null){

                        head=one;
                        tail=one;
                        one=one.next;
                    }

                    else{

                        tail.next=one;
                        one.prev=tail;
                        tail=tail.next;
                        one=one.next;


                    }

                }
                else{


                    if(head==null){


                        head=two;
                        tail=two;
                        two=two.next;
                    }
                    else{

                        tail.next=two;
                        two.prev=tail;
                        tail=tail.next;
                        two=two.next;

                    }

                }
            }


            if(one!=null){
                tail.next=one;
                one.prev=tail;
            }

            if(two!=null){
                tail.next=two;
                two.prev=tail;
            }

            return head;
        }

        public static DoublyLinkedListNode<Integer> reverse(DoublyLinkedListNode<Integer> head){


            if(head==null ||head.next==null){
                return head;

            }

            DoublyLinkedListNode<Integer> smallans=reverse(head.next);
            smallans.prev=null;
            head.prev=head.next;
            head.next.next=head;

            head.next=null;

            return smallans;





        }

        public static DoublyLinkedListNode<Integer> sorting(DoublyLinkedListNode<Integer> head) {
            //Your Code Goes Here

            if(head==null || head.next==null){
                return head;
            }

            DoublyLinkedListNode<Integer> incstart=head.next;
            //  DoublyLinkedListNode<Integer> decstart=head;

            while(incstart!=null && incstart.data>=incstart.prev.data){

                incstart=incstart.next;
            }

            if(incstart==null){

                return head;
            }


            DoublyLinkedListNode<Integer> list1=head;
            DoublyLinkedListNode<Integer> list2=incstart;
            list2.prev.next=null;
            list2.prev=null;


            DoublyLinkedListNode<Integer> revhead=reverse(list2);

            DoublyLinkedListNode<Integer> ans=merge(list1,revhead);


            return ans;


        }

    }
}
