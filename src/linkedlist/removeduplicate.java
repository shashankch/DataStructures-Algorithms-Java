package linkedlist;

import java.util.HashMap;

public class removeduplicate {

    //delete node in LL
    public static void deleteNode(LinkedListNode<Integer> node) {

        int val=node.next.data;

        node.data=val;
        node.next=node.next.next;


    }

    public static node rdup(node head) {

        node temp = head;

        int mx = 0;

        while (temp != null) {

            if (temp.data > mx) {
                mx = temp.data;
            }

            temp = temp.next;

        }

        temp = head;

        HashMap<Integer, Boolean> mp = new HashMap<>();

        while (temp != null) {

            if (mp.containsKey(temp.data) && mp.get(temp.data) == true) {

                temp.data = mx + 1;
                mx = mx + 1;
            } else {
                mp.put(temp.data, true);
            }

            temp = temp.next;

        }

        return head;

    }

    public static void main(String[] args) {

        node one = new node(1);
        node two = new node(1);
        node three = new node(2);
        node four = new node(7);
        node five = new node(7);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        node t = rdup(one);
        while (t != null) {

            System.out.print(t.data + "->");
            t = t.next;
        }

    }

}