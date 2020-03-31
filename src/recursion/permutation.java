package recursion;

public class permutation {

    public static void permute(String input, String output) {

        if (input.length() == 0) {

            System.out.println(output);
            return;
        }

        for (int i = 0; i < input.length(); i++) {

            permute(input.substring(0, i) + input.substring(i + 1), output + input.charAt(i));

        }

    }

    public static void main(String[] args) {

        String input="abc";
        permute(input,"");


    }

}