package arrays;

import java.util.HashMap;

public class intersection{


    public static void main(String[] args) {
        
        int a[]={2,3,4,53,23,44,11};
        int b[]={2,53,44,6};

        HashMap <Integer,Integer>mp=new HashMap<>();

        for(int i=0;i<a.length;i++){

            if(mp.containsKey(a[i])){
                mp.put(a[i], mp.get(a[i])+1);
            }
            else{
                mp.put(a[i], 1);
            }


        }

        for(int i=0;i<b.length;i++){

            if(mp.containsKey(b[i])){

                System.out.println(b[i]);
                mp.put(b[i], mp.get(b[i])-1);
                
                if(mp.get(b[i])==0){
                    mp.remove(b[i]);
                }
            
            }
            



        }






    }




}