package linkedlist;

public class AdditionLL {

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;

        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        while (curr != null) {
            LinkedListNode<Integer> temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;
    }

    public static LinkedListNode<Integer> addNumbers(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {

        if(l2 == null) return l1;
        if(l1 == null) return l2;


        l1 = reverse(l1);


        l2 = reverse(l2);

        LinkedListNode<Integer> head = l1;
        LinkedListNode<Integer> prev = null;
        int c = 0,sum;
        while(l1 != null && l2 != null)
        {
            sum = c + l1.data + l2.data;
            l1.data = sum % 10;
            c = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 != null||l2 != null)
        {
            if(l2 != null) prev.next = l2;
            l1 = prev.next;
            while(l1 != null)
            {
                sum = c + l1.data;
                l1.data = sum % 10;
                c = sum / 10;
                prev = l1;
                l1 = l1.next;
            }
        }
        if(c > 0) prev.next = new LinkedListNode<Integer>(c);
        return reverse(head);

    }

}
