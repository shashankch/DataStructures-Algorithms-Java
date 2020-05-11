package revision;


class Lnode {

    public int data;
    public Lnode next;

    public Lnode(int data) {

        this.data = data;
        next = null;
    }

}


public class deletegreaternoderight {


    public static Lnode reverse(Lnode head) {

        Lnode curr = head;
        Lnode prev = null, fwd = null;

        while (curr != null) {

            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;

        }


        return prev;



    }



    public static Lnode method(Lnode head) {


        head = reverse(head);

        Lnode curr = head;
        Lnode temp = null;
        Lnode mx = head;
        while (curr != null && curr.next != null) {

            if (curr.next.data < mx.data) {

                temp = curr.next;
                curr.next = temp.next;
                temp.next = null;


            } else {
                curr = curr.next;
                mx = curr;
            }


        }

        head = reverse(head);

        return head;

    }



    public static void main(String[] args) {


        Lnode head = null;

        head = new Lnode(12);
        head.next = new Lnode(15);
        head.next.next = new Lnode(10);
        head.next.next.next = new Lnode(11);
        head.next.next.next.next = new Lnode(5);

        head = method(head);

        Lnode temp = head;

        while (temp != null) {


            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }



}
