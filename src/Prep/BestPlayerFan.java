package Prep;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/practice-problems/algorithm/the-best-player-1/editorial/

class fan implements Comparable<fan> {


    String name;
    int quote;

    public fan(String name, int quote) {

        this.name = name;
        this.quote = quote;

    }



    @Override
    public int compareTo(fan o) {

        if (this.quote == o.quote) {

            return this.name.compareTo(o.name);
        }

        return o.quote - this.quote;


    }

}


public class BestPlayerFan {



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String temp[] = sc.nextLine().trim().split(" ");
        int t = Integer.parseInt(temp[0]);
        int i = 0;
        int mxfan = Integer.parseInt(temp[1]);
        fan[] arr = new fan[t];
        while (i < t) {

            String inp[] = sc.nextLine().trim().split(" ");
            int n = Integer.parseInt(inp[1]);

            arr[i] = new fan(inp[0], n);
            i++;

        }

        Arrays.sort(arr);

        for (int k = 0; k < mxfan; k++) {

            System.out.println(arr[k].name + " " + arr[k].quote);
        }

    }


}
