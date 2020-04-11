package linkedlist;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> right;
    LinkedListNode<T> down;

    LinkedListNode(T data) {
        this.data = data;
        this.right = null;
        this.down = null;
    }
}

public class flatlinked {

    public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        LinkedListNode<Integer> one = head1;
        LinkedListNode<Integer> two = head2;
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;

        while (one != null && two != null) {

            if (one.data < two.data) {

                if (head == null) {

                    head = one;
                    tail = one;
                    one = one.down;
                }

                else {

                    tail.down = one;
                    tail = tail.down;
                    one = one.down;

                }

            } else {

                if (head == null) {

                    head = two;
                    tail = two;
                    two = two.down;
                } else {

                    tail.down = two;
                    tail = tail.down;
                    two = two.down;

                }

            }
        }

        if (one != null) {
            tail.down = one;
        }

        if (two != null) {
            tail.down = two;
        }

        return head;
    }

    public static LinkedListNode<Integer> flat(LinkedListNode<Integer> head) {

        if (head == null || head.right == null) {
            return head;

        }

        LinkedListNode<Integer> res = flat(head.right);

        return merge(head, res);

    }

}