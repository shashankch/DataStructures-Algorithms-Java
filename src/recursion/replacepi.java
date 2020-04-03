package recursion;

public class replacepi {

    public static String replacep(String str) {

        if (str.length() <= 1) {
            return str;
        }

        String ans = replacep(str.substring(2));
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {

            return "3.14" + ans;
        }

        return str.substring(0, 2) + ans;

    }

    public static void main(String[] args) {

        String str = "ppiafdfpidfpi";
        String ans = replacep(str);
        System.out.println(ans);
    }

}