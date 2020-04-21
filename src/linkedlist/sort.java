package linkedlist;

public class sort {

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