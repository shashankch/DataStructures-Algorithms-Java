package Prep;

import java.util.Stack;

public class SimplifyExpression {


    public static String  helper(String str) {


        int n = str.length();
        char temp[] = new char[n];
        int index = 0;
        Stack<Character> stk = new Stack<>();
        stk.push('0');
        for (int i = 0; i < n; i++) {


            if (str.charAt(i) == '+') {

                if (stk.peek() == '1') {

                    temp[index++] = '-';
                }
                if (stk.peek() == '0') {
                    temp[index++] = '+';
                }
            }

            else if (str.charAt(i) == '-') {

                if (stk.peek() == '1') {

                    temp[index++] = '+';
                }
                if (stk.peek() == '0') {
                    temp[index++] = '-';
                }
            } else if (str.charAt(i) == '(' && i > 0) {

                if (str.charAt(i - 1) == '-') {

                    char ans = stk.peek() == '1' ? '0' : '1';
                    stk.push(ans);
                }
                if (str.charAt(i - 1) == '+') {

                    stk.push(stk.peek());
                }



            }

            else if (str.charAt(i) == ')') {

                stk.pop();
            }

            else {
                // a,b,c for this
                temp[index++] = str.charAt(i);

            }


        }


        String res = new String(temp);

        return res;



    }



    public static void main(String[] args) {

       System.out.println( helper("a-(b-c-(d+e))-f"));
    }

}
