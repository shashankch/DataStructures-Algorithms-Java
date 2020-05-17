package revision;

import java.util.Deque;
import java.util.LinkedList;

public class SumMinMaxSubarrK {

    // method to find max in subarray of size K using deque in java

    public static void maxsubk(int arr[], int k) {

        int n = arr.length;

        Deque<Integer> dq = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {

            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();

            }
            dq.addLast(i);
        }

        for (; i < n; i++) {

            System.out.println(arr[dq.peek()]);

            while (!dq.isEmpty() && dq.peek() <= (i - k)) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();

            }
            dq.addLast(i);

        }


        System.out.println(arr[dq.peek()]);



    }

    public static int sumMinMax(int arr[], int k) {

        int n = arr.length;
        int sum = 0;
        Deque<Integer> asc = new LinkedList<>();
        Deque<Integer> desc = new LinkedList<>();

        int i;
        for (i = 0; i < k; i++) {

            while (!asc.isEmpty() && arr[asc.peekLast()] >= arr[i]) {
                asc.removeLast();
            }

            while (!desc.isEmpty() && arr[desc.peekLast()] <= arr[i]) {
                desc.removeLast();
            }
            desc.addLast(i);
            asc.addLast(i);
        }


        for (; i < n; i++) {

            sum += (arr[asc.peekFirst()] + arr[desc.peekFirst()]);

            while (!asc.isEmpty() && asc.peek() <= (i - k)) {
                asc.removeFirst();
            }
            while (!desc.isEmpty() && desc.peek() <= (i - k)) {
                desc.removeFirst();
            }


            while (!asc.isEmpty() && arr[asc.peekLast()] >= arr[i]) {
                asc.removeLast();
            }

            while (!desc.isEmpty() && arr[desc.peekLast()] <= arr[i]) {
                desc.removeLast();
            }
            desc.addLast(i);
            asc.addLast(i);

        }

        sum += (arr[asc.peekFirst()] + arr[desc.peekFirst()]);
        return sum;

    }


    public static void main(String[] args) {

        int arr[] = {2, 5, 6, 3, 5};
        int k = 2;
        System.out.println(sumMinMax(arr, k));
    }
}
