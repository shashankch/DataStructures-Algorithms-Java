package Prep;

import java.util.HashMap;

public class MaxdistBtwOccur {


    public static void main(String[] args) {

        int arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};

        HashMap<Integer, Integer> mp = new HashMap<>();
        int max = 0;

        for (int i = 0; i < arr.length; i++) {

            if (!mp.containsKey(arr[i])) {

                mp.put(arr[i], i);
            } else {

                max = Math.max(max, i - mp.get(arr[i]));
            }

        }

        System.out.println(max);


    }


}
