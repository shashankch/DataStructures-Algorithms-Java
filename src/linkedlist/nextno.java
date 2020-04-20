package linkedlist;

class node {
    int data;
    node next;

    public node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class nextno {

    public static node reverse(node head) {

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

    public static node nextnumber(node head) {

        node rev = reverse(head);

        int carry = 1;

        node temp = rev;
        node prev = null;
        while (temp != null) {

            int sum = (temp.data + carry) % 10;
            carry = (temp.data + carry) / 10;
            temp.data = sum;
            prev = temp;
            temp = temp.next;
        }

        if (carry > 0) {
            node newnode = new node(carry);
            prev.next = newnode;
            prev = newnode;
        }

        return prev;

    }

    public static void main(String[] args) {

        node one = new node(9);
        node two = new node(9);
        one.next = two;
        node head = one;
        node ans = nextnumber(head);
        node temp = ans;
        while (temp != null) {
            System.out.println(temp.data + "->");
            temp = temp.next;

        }

    }

}