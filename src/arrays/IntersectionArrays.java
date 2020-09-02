package arrays;

public class IntersectionArrays {


    public static void helper(int[] input1, int[] input2) {

        int n = input1.length;
        int m = input2.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {


                if (input1[i] == input2[j]) {

                    System.out.println(input1[i]);
                    input2[j] = Integer.MIN_VALUE;
                    break;

                }
            }
        }

    }

    public static void main(String[] args) {

    }

}
