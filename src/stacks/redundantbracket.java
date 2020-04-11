package stacks;

import java.util.Stack;

public class redundantbracket {

    public static boolean checkred(String input) {

        Stack<Character> s = new Stack<>();
        // boolean flag = false;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) != ')') {
                s.push(input.charAt(i));

            } else {

                if (s.peek() == '(') {
                    return true;
                } else {

                    while (s.peek() != '(' && !s.empty()) {

                        s.pop();
                    }
                    if (s.empty()) {
                        continue;
                    } else {
                        s.pop();
                    }

                }

            }

        }

        return false;

    }

    public static void main(String []args) {

        String str = "(c+(a + b))";
        System.out.print(checkred(str));
    }

}