package linkedlist;

public class sort {


    public static LinkedListNode<Integer> deleteIthNodeRec(LinkedListNode<Integer> head, int i){

        if(head==null){

            return head;
        }


        if(i==0){

            return head.next;
        }

        LinkedListNode<Integer>smallhead=deleteIthNodeRec(head.next,i-1);

        head.next=smallhead;

        return head;

    }
    public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {


        if(head==null || head.next==null){

            return head;
        }


        LinkedListNode<Integer> smallhead=reverse_R(head.next);

        LinkedListNode<Integer> temp=head;
        temp.next.next=head;

        temp.next=null;


        return smallhead;




    }


public static int printMiddel(LinkedListNode<Integer> head) {

    if(head==null || head.next==null){
        return head.data;
    }
    LinkedListNode<Integer> slow=head;
    LinkedListNode<Integer> fast=head.next;

        while(fast!=null && fast.next!=null){

        fast=fast.next.next;
        slow=slow.next;


    }
        return slow.data;

}
    public static node reverse(node head) {

        if (head == null || head.next == null) {
            return head;
        }

        node curr = head;
        node prev = null, fwd = null;

        while (curr != null) {

            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;

        }

        head = prev;
        return head;

    }

    public static node merge(node h1, node h2) {

        node one = h1;
        node two = h2;
        node head = null;
        node tail = null;

        while (one != null && two != null) {

            if (one.data < two.data) {

                if (head == null) {
                    head = one;
                    tail = one;
                    one = one.next;
                } else {

                    tail.next = one;
                    one.prev = tail;
                    tail = one;
                    one = one.next;
                }
            } else {

                if (head == null) {
                    head = two;
                    tail = two;
                    two = two.next;
                } else {
                    tail.next = two;
                    two.prev = tail;
                    tail = two;
                    two = two.next;
                }

            }

        }

        if (one != null) {
            tail.next = one;
            one.prev = tail;

        }

        if (two != null) {
            tail.next = two;
            two.prev = tail;
        }

        return head;

    }

    public static node sortll(node head) {

        if (head == null || head.next == null) {
            return head;
        }

        node curr = head.next;

        while (curr != null && curr.data >= curr.prev.data) {
            curr = curr.next;
        }

        if (curr == null) {
            return head;
        }

        curr.prev.next = null;
        curr.prev = null;

        node rev = reverse(curr);

        return merge(rev, head);

    }


    public static int length(LinkedListNode<Integer>head){

        LinkedListNode<Integer>temp=head;
        if(head==null){
            return 0;
        }

        return 1+length(head.next);

    }

    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head )
    {

        int n=length(head);

        for(int i=0;i<n-1;i++){

            LinkedListNode<Integer>prev=null;
            LinkedListNode<Integer> curr=head;

            for(int j=0;j<n-i-1;j++){

                if(curr.data<=curr.next.data){

                    prev=curr;
                    curr=curr.next;

                }

                else{
                    if(prev!=null){

                        LinkedListNode<Integer> fwd=curr.next;
                        prev.next=fwd;
                        curr.next=fwd.next;
                        fwd.next=curr;
                        prev=fwd;
                    }
                    else{

                        LinkedListNode<Integer> fwd=curr.next;

                        curr.next=fwd.next;
                        fwd.next=curr;
                        head=fwd;
                        prev=fwd;

                    }


                }

            }


        }


        return head;

    }


    public static void main(String[] args) {

        node one = new node(1);
        node two = new node(4);
        node three = new node(6);
        node four = new node(7);
        node five = new node(8);
        node six = new node(5);
        node seven = new node(3);
        node eight = new node(2);

        one.next = two;
        two.prev = one;
        two.next = three;
        three.prev = two;
        three.next = four;
        four.prev = three;
        four.next = five;
        five.prev = four;
        five.next = six;
        six.prev = five;
        six.next = seven;
        seven.prev = six;
        seven.next = eight;
        eight.prev = seven;

        node temp = one;
        node ans = sortll(temp);

        while (ans != null) {
            System.out.print(ans.data + "->");
            ans = ans.next;
        }

    }

}