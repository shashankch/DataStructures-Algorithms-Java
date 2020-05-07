package revision;

public class GenerateBalBrackets {

    public static void helper(String str, int n, int i, int open, int close) {

        if (i == 2 * n) {

            System.out.println(str);
            // str="";
        }

        if (open < n) {

            str += "(";

            helper(str, n, i + 1, open + 1, close);

        }
        if (open > close) {

            str += ")";

            helper(str, n, i + 1, open, close + 1);

        }

    }

    public static void helper2(String str, int n, int open, int close) {

        if (close == n) {
            System.out.println(str);
            str = "";
        }

        if (open < n) {
            helper2(str + "(", n, open + 1, close);
        }

        if (open > close) {
            helper2(str + ")", n, open, close + 1);
        }
    }

    public static void printWellFormedParanthesis(int n) {

        // helper("",n,0,0,0);
        helper2("", n, 0, 0);
    }

}