package hashmaps;

import java.util.*;
import java.util.Map;

public class practiceProblems {

    // find if ptr is anagram in all the substring of str find all the start indices in str.
    public static ArrayList<Integer> findAnagramsIndices(String str,int n,String ptr, int m){

        int fstr[]=new int[26];
        int fptr[]=new int[26];

        Arrays.fill(fptr,0);
        Arrays.fill(fstr,0);

        ArrayList<Integer>anagramIndices=new ArrayList<>();

        for(int i=0;i<m;i++){

            fptr[ptr.charAt(i)-'A']+=1;
            fstr[str.charAt(i)-'A']+=1;

        }

        boolean check=true; // check if starting index forms anagram
        for(int j=0;j<26;j++){


            if(fptr[j]!=fstr[j]){
                check=false;
                break;
            }
        }

        if(check){

            anagramIndices.add(0);
        }

        for(int i=m;i<n;i++){

            fstr[str.charAt(i)-'A']+=1;
            fstr[str.charAt(i-m)-'A']-=1;

            check=true;
            for(int j=0;j<26;j++){


                if(fptr[j]!=fstr[j]){
                    check=false;
                    break;
                }
            }

            if(check){

                anagramIndices.add(i-m+1);
            }

        }

        return anagramIndices;
    }

    public int longestSubstringwithKdistinctChar(String str,int k,int n){

        int []freq=new int[26];
        Set<Character> window=new HashSet<Character>();
        int size=-1;

        for(int low=0,high=0;high<n;high++) {
            window.add(str.charAt(high));
            freq[str.charAt(high) - 'a']++;

            while (window.size() > k) {

                if (--freq[str.charAt(low) - 'a'] == 0) {
                    window.remove(str.charAt(low));
                }
                low++;
            }
            if (size < high - low + 1 && window.size() == k) {
                size = high - low + 1;
            }
        }
            return size;

    }

    public static int longestSubstringwithoutRepeat(String str){

        if(str.length()==0){
            return 0;
        }
        HashMap<Character,Integer>mp=new HashMap<>();
        int i=0,j=0;
        while(j<str.length() && mp.get(str.charAt(j))==null){
            mp.put(str.charAt(j),j);
            j++;
        }
        int length=j-i;
        while(j<str.length() && i<str.length()){

            while(i<str.length() && str.charAt(i)!=str.charAt(j)){

                mp.remove(str.charAt(i));
                i++;
            }
            mp.remove(str.charAt(i));
            i++;
            while(j<str.length() && mp.get(str.charAt(j))==null){
                mp.put(str.charAt(j),j);
                j++;
            }

            length=(j-i>length?j-i:length);

        }

        return length;

    }


    // recurring sequence of digits when fraction is converted into decimal
    public static String recurr(int num, int den) {

        HashMap<Integer,Integer>mp=new HashMap<>();
        int rem=num%den;
        String res="";
        while(rem!=0 && mp.containsKey(rem)==false){
            mp.put(rem,rem);
            rem*=10;
            res+=(rem/den);
            rem=rem%den;
        }

        return rem==0?"":res;
    }


    // group string with having shifted version of each other
    public static String findDif(String str){

        String res="";
        for(int i=1;i<str.length();i++){

            int diff=str.charAt(i)-str.charAt(i-1);
            if(diff<0){
                diff+=26;
            }

            res+=(diff+'a');

        }


        return res;



    }

    public static void grouping(String[] arr, int n) {

        HashMap<String,ArrayList<String> >mp=new HashMap<>();

        for(int i=0;i<arr.length;i++){

            String diff=findDif(arr[i]);
            // System.out.println(diff);
            if(mp.containsKey(diff)){

                ArrayList<String>temp=mp.get(diff);
                temp.add(arr[i]);
                mp.put(diff,temp);
            }
            else{

                ArrayList<String>temp=new ArrayList<>();
                temp.add(arr[i]);
                mp.put(diff,temp);
            }

        }

        for(Map.Entry<String,ArrayList<String> >entry:mp.entrySet()){

            ArrayList<String>temp=entry.getValue();

            for(int i=0;i<temp.size();i++){

                System.out.print(temp.get(i)+" ");
            }

            System.out.println();
        }


    }

    //divide into pairs where sum of every pair is divisible by k
    //all remainders (use (arr[i] % k)+k)%k for handling the case of negative integers as well).
    public static boolean ispairexist(int[] arr, int n, int k) {

        if(n%2!=0){

            return false;
        }
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int mod=arr[i]%k;
            if(mp.containsKey(mod)){
                mp.put(mod,mp.get(mod)+1);
            }
            else{
                mp.put(mod,1);
            }
        }
        for(int i=0;i<n;i++){
            int mod=arr[i]%k;
            if(mod==0){
                if(mp.get(mod)%2!=0){
                    return false;
                }
            }
            else if(2*mod==k){
                if(mp.get(mod)%2!=0){
                    return false;
                }
            }
            else{
                if(mp.get(k-mod)!=mp.get(mod)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void itineary(HashMap<String, String> input) {

        HashMap<String,String>rev=new HashMap<>();


        for(Map.Entry<String,String>entry:input.entrySet()){

            rev.put(entry.getValue(),entry.getKey());


        }

        String start="";
        for(Map.Entry<String,String>entry:input.entrySet()){

            if(!rev.containsKey(entry.getKey())){

                start=entry.getKey();
                break;
            }


        }
         while(input.containsKey(start)==true){

            System.out.println(start+" -> "+input.get(start));

            start=input.get(start);

        }


    }

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
