package revision;

import java.util.Stack;

public class infixpostfix {


    // infix a operator b
    // postfix a b operator


    public static int prec(char ch) {


        if (ch == '+' || ch == '-') {
            return 1;
        }

        if (ch == '*' || ch == '/') {
            return 2;
        }

        if (ch == '^') {
            return 3;
        }

        return -1;


    }



    public static String inpost(String in) {

        String res = "";

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < in.length(); i++) {

            char ch = in.charAt(i);

            if (Character.isLetterOrDigit(ch)) {

                res += ch;
            }

            else if (ch == '(') {
                stk.push(ch);
            }

            else if (ch == ')') {

                while (!stk.isEmpty() && stk.peek() != '(') {

                    res += stk.pop();

                }

                if (!stk.isEmpty() && stk.peek() != '(') {

                    return "invalid";

                } else {
                    stk.pop();
                }


            }

            // operators conditions .
            else {

                while (!stk.isEmpty() && prec(stk.peek()) >= prec(ch)) {

                    if (stk.peek() == '(') {
                        return "invalid";
                    }
                    res += stk.pop();
                }

                stk.push(ch);

            }



        }

        // left over
        while (!stk.isEmpty()) {
            if (stk.peek() == '(') {
                return "invalid";
            }
            res += stk.pop();
        }

        return res;

    }

    public static void main(String[] args) {


        System.out.println(inpost("a+b*(c^d-e)^(f+g*h)-i"));
    }

}
