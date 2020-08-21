package Prep;

public class MinOperationNtozero {



    public static void main(String[] args) {


        int n = 8;

        int count = 0;
        while (n != 0) {

            if (n % 2 == 0) {

                n /= 2;
            } else {

                n -= 1;
            }

            count += 1;


        }


        System.out.println(count);
    }


}
