package revision;

public class rotatestring2places {

    public static boolean method(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        String clock = "", anti = "";
        int len = a.length();

        clock = clock + b.substring(2) + b.substring(0, 2);

        anti = anti + b.substring(len - 2, len) + b.substring(0, len - 2);

        return a.equals(clock) || b.equals(anti);

    }

    public static void main(String[] args) {
        
    }

}