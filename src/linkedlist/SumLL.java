package linkedlist;



class Some{
    LinkedListNode<Integer> head;
    int carry;
    Some(LinkedListNode<Integer> head,int carry){
        this.head=head;
        this.carry=carry;
    }
}

public class SumLL {



    public static int length(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> temp = head;
        int count = 0;
        while (temp != null) {

            count++;
            temp = temp.next;
        }

        return count;

    }

    public static Some helper2(LinkedListNode<Integer> head1, LinkedListNode<Integer> temp,int carry,LinkedListNode<Integer> head){


        int sum=0;
        if (head != temp) {

            Some smallans = helper2(head1.next,temp,carry,head);
            sum = smallans.carry + head1.data;
            carry = sum / 10;
            sum %= 10;

            LinkedListNode<Integer> newnode = new LinkedListNode<Integer>(sum);
            newnode.next = smallans.head;

            return new Some(newnode,carry);
        }

        return new Some(head,carry);
    }

    public static Some helper(LinkedListNode<Integer> h1, LinkedListNode<Integer> h2, int carry) {

        if (h1 == null) {

            return new Some(null,0);
        }

        Some smallans = helper(h1.next, h2.next, carry);

        int sum = (h1.data + h2.data + smallans.carry);
        carry = sum / 10;
        sum %= 10;
        LinkedListNode<Integer> currhead = new LinkedListNode(sum);

        currhead.next = smallans.head;


        return new Some(currhead,carry);

    }

    public static LinkedListNode<Integer> addNumbers(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> temp = null;

        if (head1 == null) {

            head = head2;
            return head;
        } else if (head2 == null) {

            head = head1;
            return head;
        }

        int len1 = length(head1);
        int len2 = length(head2);

        int carry = 0;
        Some p = null;

        if (len1 == len2) {

            p = helper(head1, head2, 0);
            carry = p.carry;
            head = p.head;
        } else {

            int diff = Math.abs(len1 - len2);
            if (len1 < len2) {
                LinkedListNode<Integer> t = head1;
                head1 = head2;
                head2 = t;
            }
            temp = head1;
            while (diff > 0) {
                temp = temp.next;
                diff -= 1;
            }


        p = helper(temp, head2, 0);
        carry = p.carry;
        head = p.head;

        p=helper2(head1,temp,carry,head);
        head=p.head;
        carry=p.carry;

    }

        if (carry > 0) {

            LinkedListNode<Integer> tempNode = new LinkedListNode(carry);
            tempNode.next = head;
            head = tempNode;
        }

        return head;

    }

}
