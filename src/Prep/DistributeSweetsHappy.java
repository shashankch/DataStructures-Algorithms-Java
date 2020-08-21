package Prep;

import java.util.Arrays;
import java.util.Scanner;

public class DistributeSweetsHappy {



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int min[] = new int[n];
        int max[] = new int[n];

        for (int i = 0; i < n; i++) {

            min[i] = sc.nextInt();
            max[i] = sc.nextInt();


        }


        Arrays.sort(min);
        Arrays.sort(max);

        int curr = 0, res = 0;
        int sweets = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {


            if (min[i] <= max[j]) {

                curr += 1;
                if (curr > res) {
                    res = curr;
                    sweets = min[i];
                }

                i++;

            } else {

                curr -= 1;
                j++;

            }



        }


        System.out.println(sweets + " " + res);



    }

}
