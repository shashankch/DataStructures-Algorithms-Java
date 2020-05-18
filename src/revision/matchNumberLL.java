package revision;

public class matchNumberLL {


    public static boolean CheckRepresentaion(ListNode<Integer> head1, ListNode<Integer> head2) {

        if (head1 == null && head2 == null) {
            return true;
        }

        if (head1 == null || head2 == null) {
            return false;
        }

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();


        while (head1 != null && head2 != null) {

            num1.append(head1.data);
            num2.append(head2.data);
            head1 = head1.next;
            head2 = head2.next;



        }

        while (head1 != null) {
            num1.append(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            num2.append(head2.data);
            head2 = head2.next;
        }
        while (num1.charAt(0) == '0') {
            num1.deleteCharAt(0);
        }
        while (num2.charAt(0) == '0') {
            num2.deleteCharAt(0);
        }



        return (num1.toString().compareTo(num2.toString()) != 0) ? false : true;
    }


    public static String convert(int n) {

        if (n == 0) {
            return "0";
        }
        String s = "";
        char t;
        while (n > 0) {
            t = (char) (n % 10);
            s = t + s;
            n /= 10;
        }

        return s;
    }

    // problem with this method...c++
    public static boolean method(ListNode<Integer> a, ListNode<Integer> b) {

        String one = "", two = "";

        boolean zero = false;

        while (a.next != null) {

            zero = true;
            if (a != null || one.length() != 0) {
                one += convert(a.data);
            }
            a = a.next;

        }

        if (zero == true && one.length() != 0) {
            one = "0";
        }
        zero = false;

        while (b.next != null) {
            zero = true;
            if (b != null || two.length() != 0) {
                two += convert(b.data);
            }

            b = b.next;
        }

        if (zero == true && two.length() != 0) {
            two = "0";
        }

        return one.equals(two);

    }

    public static void main(String[] args) {

        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> head2 = new ListNode<Integer>(14);

        System.out.println(CheckRepresentaion(head, head2));

    }

}
