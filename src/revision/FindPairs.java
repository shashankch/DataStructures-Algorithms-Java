package revision;

class ListN<t> {

    public t data;
    public ListN<t> forw;
    public ListN<t> backw;

    public ListN(t data) {
        this.data = data;
    }


}


public class FindPairs {

    public static void findPairs(ListN<Integer> head, int n) {
        // Write your code here


        ListN<Integer> start = head;
        ListN<Integer> end = head;

        while (end.forw != null) {
            end = end.forw;
        }

        // System.out.println(start.data+" "+end.data);
        while (start.data < end.data) {

            if (start.data + end.data == n) {
                System.out.println(start.data + " " + end.data);
                start = start.forw;
                end = end.backw;
            }

            else if (start.data + end.data > n) {
                end = end.backw;
            }

            else if (start.data + end.data < n) {
                start = start.forw;
            }


        }



    }

    public static void main(String[] args) {

    }

}
