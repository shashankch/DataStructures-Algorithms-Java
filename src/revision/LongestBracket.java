package revision;

import java.util.HashMap;
import java.util.Stack;

public class LongestBracket {


    public static void solution(String str) {
        long mx = Long.MIN_VALUE;
        HashMap<Long, Integer> mp = new HashMap<>();
        Stack<Integer> stk = new Stack<>();

        stk.push(-1);
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                stk.push(i);
            }

            else {


                stk.pop();

                if (!stk.isEmpty()) {

                    mx = Math.max(mx, i - stk.peek());
                    if (mp.containsKey(mx)) {
                        mp.put(mx, mp.get(mx) + 1);
                    } else {
                        mp.put(mx, 1);
                    }
                } else {

                    stk.push(i);
                }



            }


        }

        if (mx > 0) {

            System.out.print(mx + " " + mp.get(mx) / 2);
        } else {
            System.out.print("0 1");
        }
    }



    public static void main(String[] args) {

    }

}
