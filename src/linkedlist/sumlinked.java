package linkedlist;

class Pair {

    Node<Integer> head;
    int carry;

    public Pair(Node<Integer> head, int carry) {

        this.head = head;
        this.carry = carry;
    }

}

public class sumlinked {

    public static int length(Node<Integer> head) {

        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {

            count++;

            temp = temp.next;
        }

        return count;

    }
    

    publc 









}