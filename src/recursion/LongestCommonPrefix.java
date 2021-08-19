package recursion;

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
}
