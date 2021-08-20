package recursion;

public class ReverseNo {




    public static int helper(int num,int len){


        if(len==1){

            return num;
        }

        else{
         int mod=num%10;
         return (mod)*(int)(Math.pow(10,len-1))+helper(num/10,len-1);


        }

    }

    public static int reverseInteger(int num) {
     int temp= Math.abs(num);
        int c=0;

        while(temp>0){

            temp/=10;
            c++;
        }

        return helper(num,c);

    }

    public static double helper(int n){


        if(n==1){
            return 0;
        }

        double smallans=helper(n-1);

        return smallans+Math.log(n);



    }


}
