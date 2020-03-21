
package recursion;

public class replacechar{

        public static String replacec(String input,char a,char b) {
        // Write your code here

        if (input.length() == 0) {

            return input;
        }

        String ans = replacec(input.substring(1),a,b);

        if (input.charAt(0) == a) {

            return b+ans;

        }

        return input.charAt(0) + ans;

    }

}