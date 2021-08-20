package recursion;

//binary no
public class NdigitMoreOnethanZero {

    public static void helper2(int n,int zero,int one,String ans){

        if(one<zero){
            return;
        }
        if(n==0){
            System.out.println(ans);
            return;

        }

        helper(n-1,zero,one+1,ans+"1");
        helper(n-1,zero+1,one,ans+"0");

    }
    public static void helper(int n,int zero,int one,String ans){

           if(n==0){
            System.out.println(ans);
            return;

        }

        helper(n-1,zero,one+1,ans+"1");

        if(one>zero){
            helper(n-1,zero+1,one,ans+"0");

        }

    }

    public static void printBinary(int n) {

        helper(n,0,0,"");

    }



}
