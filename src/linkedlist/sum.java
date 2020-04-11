package linkedlist;

public class sum {

    public static Node<Integer> reverse(Node<Integer> head) {

        if (head == null || head.next == null) {

            return head;
        }

        Node<Integer> smallhead = reverse(head.next);

        Node<Integer> tail = head.next;
        tail.next = head;
        head.next = null;

        return smallhead;
    }

    public static Node<Integer> sum(Node<Integer> l1, Node<Integer> l2) {
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;

        l1 = reverse(l1);

        l2 = reverse(l2);

        Node<Integer> head = l1;
        Node<Integer> prev = null;
        int c = 0, sum;
        while (l1 != null && l2 != null) {
            sum = c + l1.data + l2.data;
            l1.data = sum % 10;
            c = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null) {
            if (l2 != null)
                prev.next = l2;
            l1 = prev.next;
            while (l1 != null) {
                sum = c + l1.data;
                l1.data = sum % 10;
                c = sum / 10;
                prev = l1;
                l1 = l1.next;
            }
        }
        if (c > 0)
            prev.next = new Node<Integer>(c);
        return reverse(head);
    }

}