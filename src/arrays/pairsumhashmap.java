package arrays;

import java.util.HashMap;

public class pairsumhashmap{


public static void main(String[] args) {
    
        int arr[]={1,3,6,2,5,4,3,2,4};
        int n=9;
        int tar=7;

        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<n;i++){

            int pair=tar-arr[i];
            if(mp.containsKey(pair)){
                
                int count=mp.get(pair);

                    while(count>0){
                    System.out.println(pair+" "+arr[i]);
                   // mp.put(pair,mp.get(pair)-1);

                        count--;
                    }
                }

            
            else{
                mp.put(arr[i], 1);
            }


        }





}













}