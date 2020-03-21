
package recursion;

public class replacex{

    public static String removeX(String input) {
        // Write your code here

        if (input.length() == 0) {

            return input;
        }

        String ans = removeX(input.substring(1));

        if (input.charAt(0) == 'x') {

            return ans;

        }

        return input.charAt(0) + ans;

    }


}