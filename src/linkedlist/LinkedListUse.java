package linkedlist;

public class LinkedListUse {

    public static Node<Integer> createLinkedList() {

        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        n1.next = n2;
        n2.next = n3;

        return n1;

    }

    public static int length(Node<Integer> head) {

       
        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {

            count++;
            temp = temp.next;
        }

        return count;

    }

    public static Node<Integer> append(Node<Integer> root, int n) {

        int len = length(root);

        Node<Integer> temp = root;
        int count = 0;
        while (count < (len - n - 1)) {

            temp = temp.next;

            count++;

        }

        Node<Integer> small = temp.next;
        temp.next = null;
        temp = small;
        while (temp.next != null) {

            temp = temp.next;

        }

        temp.next = root;

        root = small;

        return root;

    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(10);
        System.out.println(n1.data);
        System.out.println(n1.next);

        Node<Integer> head = createLinkedList();

    }

}