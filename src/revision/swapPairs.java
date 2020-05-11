package revision;



public class swapPairs {


    public static ListNode<Integer> swap1(ListNode<Integer> head) {


        ListNode<Integer> temp = head;
        ListNode<Integer> prev = null;
        ListNode<Integer> ans = null;


        int count = 1;
        while (temp != null) {

            if (prev == null) {

                ListNode<Integer> fwd = temp;
                int i = 0;
                while (i < count) {
                    fwd = fwd.next;
                    i++;
                }


                head = head.next;
                temp.next = fwd.next;
                fwd.next = temp;
                prev = fwd;
                ans = prev;
            } else {
                ListNode<Integer> fwd = temp;
                int i = 0;
                while (i < count) {
                    fwd = fwd.next;
                    i++;
                }
                prev.next = fwd;
                temp.next = fwd.next;
                fwd.next = temp;
                prev = fwd;


            }

            temp = temp.next;



        }

        return ans;

    }

    public static ListNode<Integer> swap2(ListNode<Integer> head) {
        ListNode<Integer> temp = head;
        ListNode<Integer> prev = null;
        ListNode<Integer> c1 = null, c2 = null, p1 = null, p2 = null;


        int count = 0;
        while (temp != null) {

            p1 = prev;
            c1 = temp;
            c2 = temp.next;
            p2 = temp;
            int i = 0;
            while (c2 != null && i < count) {
                p2 = c2;
                c2 = c2.next;
                i++;
            }


            if (p1 != null) {
                p1.next = c2;
            } else {
                head = c2;
            }
            if (p2 != null) {
                p2.next = c1;
            }

            else {
                head = c1;
            }


            ListNode<Integer> t = c2.next;
            c2.next = c1.next;
            c1.next = t;


            prev = temp;
            temp = temp.next;
            count++;



        }

        return head;
    }

    public static ListNode<Integer> swap3(ListNode<Integer> head) {


        if (head == null || head.next == null)

        {
            return head;

        }

        ListNode<Integer> temp = head.next;
        head.next = temp.next;
        temp.next = head;

        ListNode<Integer> p1 = head, p2 = head.next, c1 = null, c2 = null;
        int count = 2;

        while (true) {
            int i = 1;
            while (p2 != null && p2.next != null && i != count) {

                p2 = p2.next;
                i++;
            }

            if (p2 == null || p2.next == null) {
                // return temp;
                break;
            }

            c1 = p1.next;
            c2 = p2.next;

            p1.next = c2;
            p2.next = c1;

            ListNode<Integer> t = c2.next;
            c2.next = c1.next;
            c1.next = t;

            count++;

            p2 = t;
            p1 = c1;



        }

        return temp;
    }



}
