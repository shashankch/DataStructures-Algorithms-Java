package Prep;

import java.util.Scanner;

public class TrafficLightGreen {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        int temp[] = new int[n];
        for (int i = 1; i <= n; i++) {
            char bulb = sc.next().charAt(0);

            if (bulb == 'G')
                arr[i] = 0;
            if (bulb == 'R')
                arr[i] = 1;
            if (bulb == 'Y')
                arr[i] = 2;
        }

        int k = sc.nextInt();
        int sum = 0;
        int a = 0, b = 0, answer = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] += sum;
            if ((arr[i] + 1) % 3 == 0) {
                temp[i] = 1;
                answer += 1;
                sum += 1;
            } else if ((arr[i] + 2) % 3 == 0) {
                temp[i] = 2;
                answer += 2;
                sum += 2;
            } else
                temp[i] = 0;
            if (i >= k)
                sum = sum - temp[++a];
        }

        System.out.println(answer);

    }

}
