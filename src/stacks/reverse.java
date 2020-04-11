package stacks;

import java.util.Stack;

public class reverse {

    public static void reversestack(Stack<Integer> s1, Stack<Integer> s2) {

        if (s1.size() <= 1) {
            return;
        }

        int top = s1.pop();
        reversestack(s1, s2);

        while (!s1.isEmpty()) {
            int a = s1.pop();
            s2.push((a));
        }
        s1.push(top);
        while (!s2.isEmpty()) {
            int a = s2.pop();
            s1.push((a));
        }

    }

}