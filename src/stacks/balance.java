package stacks;

import java.util.Stack;

public class balance {

    public static boolean solution(String exp) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            if (exp.charAt(i) == '{' || exp.charAt(i) == '[' || exp.charAt(i) == '(') {
                s.push(exp.charAt(i));
            }

            else if (exp.charAt(i) == '}' || exp.charAt(i) == ']' || exp.charAt(i) == ')') {

                if (s.empty()) {
                    return false;
                }
                char top = s.pop();
                if (exp.charAt(i) == '}' && top == '{') {
                    continue;
                } else if (exp.charAt(i) == ']' && top == '[') {
                    continue;
                } else if (exp.charAt(i) == ')' && top == '(') {
                    continue;
                }

                else {
                    return false;
                }

            }

        }

        if (s.isEmpty()) {
            return true;
        }
        else {
            return false;
        }

    }

}