package recursion;

//F(n)=(1)+(2 * 3)+(4 * 5 * 6)+...n
public class FindNthTerm {


    public static long helper(int curr,int till,int n){

        int i;
        long prod=1;
        if(till==n+1){
            return 0;
        }

        for(i=curr;i<curr+till;i++){
            prod*=i;
        }


        return prod+helper(i,till+1,n);

    }



    public static long helper(int n,int i,int curr,long sum){


        if(i==n+1){
         return sum;

        }

        int count=i;
        long series=1;
        while(count>0){

            series*=curr;
            curr++;

            count--;

        }

        long ans=helper(n,i+1,curr,sum+series);


        return ans;


    }


    public static long Fnth_term(int n) {
       return helper(n,1,1,0);
    }

}
