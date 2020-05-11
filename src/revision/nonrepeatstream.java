package revision;


class Pair {

    public dll head;
    public dll tail;

    public Pair() {
        head = null;
        tail = null;
    }
}


class dll {

    public char data;
    public dll next;
    public dll prev;

    public dll(char data) {

        this.data = data;
    }

}


public class nonrepeatstream {


    public static Pair append(dll head, dll tail, char x) {

        dll newnode = new dll(x);
        if (head == null) {

            head = newnode;
            tail = newnode;
            Pair res = new Pair();
            res.head = head;
            res.tail = tail;
            return res;
        }
        tail.next = newnode;
        newnode.prev = tail;
        tail = newnode;

        Pair ans = new Pair();
        ans.head = head;
        ans.tail = tail;
        return ans;



    }

    public static Pair remove(dll head, dll tail, dll node) {


        if (head == null) {
            return new Pair();
        }

        if (head == node) {
            head = head.next;
        }
        if (tail == node) {
            tail = tail.prev;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        Pair ans = new Pair();
        ans.head = head;
        ans.tail = tail;

        return ans;



    }



    public static void method(String str) {


        dll arr[] = new dll[256];
        Pair ans = new Pair();
        boolean visit[] = new boolean[256];
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (!visit[ch]) {

                if (arr[ch] == null) {

                    ans = append(ans.head, ans.tail, ch);
                    arr[ch] = ans.tail;
                } else {
                    ans = remove(ans.head, ans.tail, arr[ch]);
                    arr[ch] = null;
                    visit[ch] = true;
                }

            }

            if (ans.head != null) {
                System.out.println(ans.head.data + " ");
            }
        }



    }



    public static void main(String[] args) {

        method("geeksforgeeksandgeeksquizfor");
    }
}
