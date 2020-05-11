package revision;

import java.util.Stack;

public class nextlargerelem {



    public static void nextgreater(int arr[]) {

        int n = arr.length;

        Stack<Integer> stk = new Stack<>();

        stk.push(arr[0]);

        for (int i = 1; i < n; i++) {

            while (!stk.isEmpty() && arr[i] > stk.peek()) {
                System.out.print(arr[i] + " ");
                stk.pop();


            }

            stk.push(arr[i]);

        }

        while (!stk.isEmpty()) {

            System.out.print("-1 ");
            stk.pop();
        }


    }

    public static void main(String[] args) {

        int arr[] = {11, 13, 21, 3};
        nextgreater(arr);
    }


}
