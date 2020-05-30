package arrays;

import java.util.Arrays;
import java.util.HashMap;


public class maxProfit {

    public static void profit(int arr[]) {

        Arrays.sort(arr);
        int k = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int temp[] = new int[arr.length];
        for (int i = 0; i <= arr.length - 3; i++) {

            int curr = arr[i + 1];
            temp[k++] = curr;
            mp.put(curr, i + 1);


        }

        // for (int i = 0; i < k; i++) {
        //     System.out.println(temp[i]);
        // }
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < k - 1; i++) {
            
            int curr =temp[i];
            int index = mp.get(curr);

            for (int j = i + 1; j < k; j++) {

                int next = temp[j];
                if(mp.get(next)!=index-1 && mp.get(next)!=index+1){
                    if((curr+next)>mx){
                        mx = (curr + next);
                    }
                }
            }

           
        }


        System.out.println("max"+mx);



    }


    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 4, 5, 6,7,8,9};
        int arr2[] = {3, 4, 2};
        profit(arr);
    }


}
