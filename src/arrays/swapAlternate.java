package arrays;

public class swapAlternate {


    public static void helper(int[] input) {

        int n = input.length;
        for (int i = 0; i < n - 1; i += 2) {



            int temp = input[i];
            input[i] = input[i + 1];
            input[i + 1] = temp;



        }

    }

    public static void main(String[] args) {
        
    }

}
