package revision;

import java.util.Stack;

public class brackets {

    public static void longest_balancedbracket_substring(String str) {
        long mx = 0, c = 0;
        Stack<Integer> stk = new Stack<>();

        stk.push(-1);
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                stk.push(i);
            }

            else {

                stk.pop();

                if (!stk.isEmpty()) {
                    long prev = mx;
                    System.out.println(prev);
                    mx = Math.max(mx, i - stk.peek());
                    if (prev == mx) {
                        c++;
                    }
                } else {
                    // c++;
                    stk.push(i);
                }

            }

        }

        if (mx > 0) {

            System.out.print(mx + " " + c);
        } else {
            System.out.print("0 1");
        }
        // Write your solution here
    }

}