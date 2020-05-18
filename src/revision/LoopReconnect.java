package revision;

public class LoopReconnect {

    public static ListNode<Integer> method(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<Integer> temp = head;
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                break;
            }



        }

        if (slow == fast) {

            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        ListNode<Integer> val = fast.next;
        // System.out.println(fast.next.data);
        fast.next = null;

        ListNode<Integer> mx = null;
        // ListNode<Integer>prev=null;

        while (temp.next != null) {

            if (temp.data > val.data) {

                mx = (mx == null || mx.data > temp.data) ? temp : mx;

            }

            temp = temp.next;

        }

        fast.next = mx;



        return head;

    }



    public static void main(String[] args) {

    }

}
