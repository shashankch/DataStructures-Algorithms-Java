package LeetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void generate(String str, int n, int i, int open, int close, List<String> res) {

        if (i == 2 * n) {
            res.add(str);
        }

        if (open < n) {
            generate(str + "(", n, i + 1, open + 1, close, res);
        }

        if (open > close) {
            generate(str + ")", n, i + 1, open, close + 1, res);
        }


    }

    public List<String> generateParenthesis(int n) {


        List<String> res = new ArrayList<>();
        generate("", n, 0, 0, 0, res);


        return res;
    }

    public static void main(String[] args) {



    }

}
