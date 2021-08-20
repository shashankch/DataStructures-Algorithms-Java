package recursion;

public class NdigitwithGivenSum {

    public static void helper(int digits,int sum,String ans){

        if(sum<0 || digits<0){

            return;
        }

        if(sum==0 && digits==0){

            System.out.print(ans+" ");
            return;
        }
         if(ans.length()==0){


            for(int i=1;i<=9;i++){

                helper(digits-1,sum-i,ans+i);

            }

        }
      else{
         for(int j=0;j<=9;j++){

                helper(digits-1,sum-j,ans+j);

            }

        }

    }


    private static void find(String output,int n,int sum){

            if(n>0 && sum>=0){
                char temp='0';
                if(output==""){
                    temp='1';
                }

                for(;temp<='9';temp++){
                    find(output+temp,n-1,sum-(temp-'0'));
                }

            }

            else if(n==0 && sum==0){
                System.out.println(output+" ");
            }

    }

    public static void find(int digits, int sum) {

        helper(digits,sum,"");

    }

}
