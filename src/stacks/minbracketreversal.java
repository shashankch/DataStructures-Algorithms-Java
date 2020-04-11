package stacks;

import java.util.Stack;

public class minbracketreversal {

    public static int countrev(String inp) {

        if (inp.length() == 0) {
            return 0;
        }

        if (inp.length() % 2 != 0) {

            return -1;
        }
        Stack<Character> s = new Stack<>();
        int n = inp.length();
        for (int i = 0; i < n; i++) {

            if (inp.charAt(i) == '{') {
                s.push(inp.charAt(i));

            } else {

                if (!s.empty() && s.peek() == '{') {
                    s.pop();
                } else {
                    s.push(inp.charAt(i));
                }

            }

        }

        int ans = 0;
        while (!s.empty()) {

            char one = s.pop();

            char two = s.pop();

            if (one == two) {
                ans += 1;
            } else {
                ans += 2;
            }

        }
        return ans;

    }

    public static void main(String[] args) {

        String str = "}}}{";
        System.out.println(countrev(str));
    }

}