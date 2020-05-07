package revision;

public class interleaveString {

    // here base case is if length of a and b string is zero then return string/
    // count(m,n)=count(m-1 fixing a character,n)+count(m,n-1 fix a char)
    // m and n are length of strings.
    // count represents count of interleaved strings.
    // count(1,0) or count(0,1)==1
    // here appraoch is fixing a character of a string and then recur for rest .

    public static void print_interleave(String a, String b, String ans) {

        // base
        if (a == null) {
            System.out.println(b);
            return;
        }

        if (b == null) {
            System.out.println(a);
            return;
        }

        if (a.length() == 0 && b.length() == 0) {
            System.out.println(ans);

        }

        if (a.length() != 0) {

         
            print_interleave(a.substring(1), b, ans+a.charAt(0));

        }

        if (b.length() != 0) {

            
            print_interleave(a, b.substring(1), ans+ b.charAt(0));
        }

    }

    public static void main(String[] args) {

        String a = "AB";
        String b = "CD";
        print_interleave(a, b, "");
    }

}

