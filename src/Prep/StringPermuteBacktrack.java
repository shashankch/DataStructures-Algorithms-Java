package Prep;

public class StringPermuteBacktrack {


    public static String swapfun(String str, int i, int j) {

        char temp[] = str.toCharArray();

        char t = temp[i];
        temp[i] = temp[j];
        temp[j] = t;

        return new String(temp);

    }



    public static void helper(String str, int l, int h) {


        if (l == h) {

            System.out.println(str);

        }

        for (int i = l; i <= h; i++) {


            str = swapfun(str, l, i);

            helper(str, l + 1, h);

            str = swapfun(str, l, i);



        }



    }


    public static void main(String[] args) {

        helper("ABC", 0, 2);

    }

}
