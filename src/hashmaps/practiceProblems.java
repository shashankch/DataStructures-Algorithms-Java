package hashmaps;

import java.util.*;
public class practiceProblems {

    public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr)
    {
        if(arr.size()==1){

            if(arr.get(0)==0){
                return 1;
            }
            else{
                return 0;
            }
        }


        int mx=0;
        int len=0;
        HashMap<Integer,Integer>mp=new HashMap<>();
        int cum=0;
        mp.put(arr.get(0),0);

        for(int i=1;i<arr.size();i++){
            cum+=arr.get(i);

            if(arr.get(i)==0 && mx==0){
                mx=1;
            }

            if(mp.containsKey(cum) || cum==0){
                if(mp.containsKey(cum)){
                    len=i-mp.get(cum);
                }
                if(cum==0){
                    len=i+1;
                }

                if(len>mx){
                    mx=len;
                }
            }

            else{

                mp.put(cum,i);
            }



        }

        return mx;
    }


    public static void findPairsDifferenceK(int[] input, int k){

        HashMap<Integer,Integer> mp=new HashMap<>();


        for(int i=0;i<input.length;i++){

            if(mp.containsKey(input[i])){

                mp.put(input[i],mp.get(input[i])+1);
            }
            else{
                mp.put(input[i],1);
            }
        }

        int count1=0;
        int count2=0;
        for(int i=0;i<input.length;i++){

            if(k==0){
                count1=mp.get(input[i]);
                int total=((count1-1)*count1)/2;
                while(total-->0){
                    System.out.println(input[i]+" "+input[i]);
                }
            }
            else{
                if(mp.containsKey(input[i]-k) ){
                    count1=mp.get(input[i]);
                    count2=mp.get(input[i]-k);

                    int total=count1*count2;
                    while(total-->0){
                        System.out.println((input[i]-k)+" "+input[i]);
                    }

                }
                if(mp.containsKey(input[i]+k)){
                    count1=mp.get(input[i]);
                    count2=mp.get(input[i]+k);

                    int total=count1*count2;
                    while(total-->0){
                        System.out.println(input[i]+" "+(input[i]+k));
                    }
                }


            }

            mp.put(input[i],0);
        }
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {

        int n=arr.length;
        HashMap<Integer,Boolean> mp=new HashMap<>();
        HashMap<Integer,Integer>pos=new HashMap<>();

        for(int i=0;i<n;i++){


            mp.put(arr[i],true);
            pos.put(arr[i],i);

        }
        int mx=1,start=0;

        for(int i=0;i<n;i++){


            int len=0;
            int val=arr[i];
            int curr=arr[i];
            int index=i;
            while(mp.containsKey(val) && mp.get(val)==true){

                len++;
                mp.put(val,false);
                val+=1;
            }

            val=curr-1;

            while(mp.containsKey(val) && mp.get(val)==true){
                len++;
                // curr=val;

                mp.put(val,false);
                index= pos.get(val);
                val-=1;
                // index-=1;
            }

            if(mx<len){
                mx=len;
                start=index;
            }
            else if(mx==len){

                if(index<start){
                    start=index;
                }
            }

            //  mp.put(arr[i],false);

        }

        ArrayList<Integer> out=new ArrayList<>();
        out.add(arr[start]);
        int value=arr[start];
        mx--;

        while(mx!=0)
        {
            value+=1;
            out.add(value);

            mx--;

        }

        return out;


    }
    // remove all duplicates
    public static String uniqueChar(String str){

        HashMap<Character,Boolean> mp=new HashMap<>();

        for(int i=0;i<str.length();i++){
            mp.put(str.charAt(i),true);

        }
        String ans="";
        for(int i=0;i<str.length();i++){

            if(mp.get(str.charAt(i))==true){
                ans+=str.charAt(i);
                mp.put(str.charAt(i),false);
            }

        }

        return ans;

    }

    public static void PairSumToZERO(int[] arr, int size) {

        HashMap<Integer,Integer>mp=new HashMap<>();
        int sum=0;
        for(int i=0;i<size;i++){

            if(mp.containsKey(sum-arr[i])){

                int count=mp.get(sum-arr[i]);

                for(int j=0;j<count;j++){

                    if((sum-arr[i])<arr[i]){
                        System.out.println((sum-arr[i])+" "+arr[i]);
                    }
                    else{
                        System.out.println(arr[i]+" "+(sum-arr[i]));
                    }
                }
            }
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],mp.get(arr[i])+1);
            }
            else{
                mp.put(arr[i],1);
            }
        }

    }

  public static void intersection(int[] arr1, int[] arr2){

        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int i:arr1){

            if(mp.containsKey(i)){

                mp.put(i,mp.get(i)+1);
            }

            else
                mp.put(i,1);
        }
         for(int i:arr2){
            if(mp.containsKey(i)){
                if(mp.get(i)>0){
                    System.out.println(i);
                }
                mp.put(i,mp.get(i)-1);
                //  mp.put(i,false);
            }
        }

    }

    public static int maxFrequencyNumber(int[] arr){

        HashMap<Integer,Integer> mp=new HashMap<>();
        int countmax=Integer.MIN_VALUE;
        int ans=-1;
        for(int i=0;i<arr.length;i++){

            if(mp.containsKey(arr[i])){

                int val=mp.get(arr[i]);
                mp.put(arr[i],val+1);

            }
            else{

                mp.put(arr[i],1);
            }

        }

        for( int str:arr){

            if(mp.get(str)>countmax){

                ans=str;
                countmax=mp.get(str);
            }
        }

        return ans;

    }
}
