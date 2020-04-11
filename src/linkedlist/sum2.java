package linkedlist;

public class sum2 {

    public static int length(Node<Integer> head) {

        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {

            count++;
            temp = temp.next;
        }

        return count;

    }

    public static Node<Integer> helper2(Node<Integer> head, Node<Integer> temp, int carry[]) {

        if (head == temp) {

            return null;
        }

        Node<Integer> smallans = helper2(head.next, temp, carry);
        int sum = carry[0] + head.data;
        carry[0] = sum / 10;
        sum %= 10;

        Node<Integer> newnode = new Node<Integer>(sum);
        newnode.next = smallans;
        smallans = newnode;

        return smallans;
    }

    public static Node<Integer> helper(Node<Integer> h1, Node<Integer> h2, int carry[]) {

        if (h1 == null) {

            return null;
        }

        Node<Integer> smallans = helper(h1.next, h2.next, carry);

        int sum = (h1.data + h2.data + carry[0]);
        carry[0] = sum / 10;
        sum %= 10;
        Node<Integer> currhead = new Node<>(sum);

        currhead.next = smallans;
        smallans = currhead;

        return smallans;

    }

    public static Node<Integer> addNumbers(Node<Integer> head1, Node<Integer> head2) {
        // Your code goes here

        Node<Integer> res = null;
        int[] carry = new int[1];

        if (head1 == null) {

            res = head2;
            return res;
        }

        if (head2 == null) {

            res = head1;
            return res;
        }

        int len1 = length(head1);
        int len2 = length(head2);

        if (len1 == len2) {

            res = helper(head1, head2, carry);
        } else {

            if (len1 > len2) {

                int d = len1 - len2;
                Node<Integer> temp = head1;
                Node<Integer> curr = null;
                while (d-- >= 0) {
                    curr = temp;
                    temp = temp.next;
                }
                res = helper(curr, head2, carry);
                Node<Integer> bighead = head1;
                Node<Integer> rem = helper2(bighead, curr, carry);
                rem.next = res;
                res = head1;

            } else {

                int d = len2 - len1;

                Node<Integer> temp = head2;
                Node<Integer> curr = null;
                while (d-- >= 0) {
                    curr = temp;
                    temp = temp.next;
                }
                res = helper(head1, curr, carry);
                Node<Integer> bighead = head2;
                Node<Integer> rem = helper2(bighead, curr, carry);
                rem.next = res;
                res = head2;

            }

        }

        if (carry[0] > 0) {

            Node<Integer> tempNode = new Node<>(carry[0]);
            tempNode.next = res;
            res = tempNode;
        }

        return res;

    }

}