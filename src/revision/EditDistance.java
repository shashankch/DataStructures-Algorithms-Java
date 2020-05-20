package revision;

public class EditDistance {


    public static int edit(String s1, String s2) {


        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }


        if (s1.charAt(0) == s2.charAt(0)) {
            return edit(s1.substring(1), s2.substring(1));
        }

        else {

            // insert
            int x = edit(s1.substring(1), s2) + 1;


            // delete
            int y = edit(s1, s2.substring(1)) + 1;

            // replace
            int z = edit(s1.substring(1), s2.substring(1)) + 1;

            return Math.min(x, Math.min(y, z));

        }



    }



    public static void main(String[] args) {

        System.out.println(edit("geek", "geeks"));

    }


}
