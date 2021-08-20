package recursion;

import java.util.Locale;

public class LongestCommonPrefix {

    public static String helper(String common, String check, String prefix, int i){

        if(i>=common.length() || i>=check.length()){

            return prefix;

        }
        if(common.charAt(i)!=check.charAt(i)){

            return prefix;

        }
        String ans=helper(common,check,prefix+common.charAt(i),i+1);
         return ans;

    }





    public static void answer(String input[]) {

        String curr=input[0];

        for(int i=1;i<input.length;i++){

            curr=helper(curr,input[i],"",0);


        }

        System.out.print(curr);

    }


    public static String prefix(String out1,String out2){

        String out="";
        int n1=out1.length(),n2=out2.length();
        for(int i=0,j=0;i<n1 && j<n2;i++,j++){
            if(out1.charAt(i)!=out2.charAt(j)){
                break;
            }

            out=out+out1.charAt(i);
        }

        return out;

    }



    //divide and conquer approach
    public static String divide(String input[],int start,int end){

        if(start==end){
            return input[start];
        }
        if(end>start){
            int mid=start+(end-start)/2;
            String out1=divide(input,start,mid);
            String out2=divide(input,mid+1,end);

            return prefix(out1,out2);
        }
        return "";
    }





    public static void answer2(String input[]){

        System.out.println(divide(input,0,input.length-1));
    }






}
