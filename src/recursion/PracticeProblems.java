package recursion;

public class PracticeProblems {


    public static double findGeometricSum(int k){

        if(k==0){

            return 1;
        }

        //recursive
        double smallans=findGeometricSum(k-1);

        double finalans=smallans+(1/(Math.pow(2,k)));


        return finalans;

    }


    private static boolean palindrome(String input,int low ,int high){

        if(low>high){
            return true;

        }

        if(input.charAt(low)!=input.charAt(high)){
            return false;
        }

        return palindrome(input,low+1,high-1);
    }


    private static int sumdigit(int input,int sum){

        if(input==0){

            return sum;

        }

        int rem=input%10;

        return sumdigit(input/10,sum+rem);
    }

    public static int multiplyTwoInt(int m,int n){

        if(n==0|| m==0){
            return 0;
        }

        return multiplyTwoInt(m,n-1);

    }


    public static int countZeroes(int input){

        if(input<10){
            if(input==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(input%10==0){
            return countZeroes(input/10)+1;
        }
        else{
            return countZeroes(input/10);
        }

    }


    //took last char
    public static int convertStringToInt2(String input){

        if(input.length()==1){

            return input.charAt(0)-'0' ;
        }
        int smallans=convertStringToInt(input.substring(0,input.length()-1));

        int last=input.charAt(input.length()-1)-'0';

        return smallans*10+last;

    }

    //took first char
    public static int convertStringToInt(String input){

        if(input.length()==1){

            return input.charAt(0)-'0' ;
        }
         int smallans=convertStringToInt(input.substring(1));

        int val=input.charAt(0)-'0';

        return val*(int)(Math.pow(10,input.length()-1))+smallans;

    }


    //add stars in btw identical chars
    public static String addStars2(String s) {

        if(s.length()<=1){
            return s;
        }
        String res=addStars2(s.substring(1));
        if(s.charAt(0)==s.charAt(1)){

            res=s.charAt(0)+"*"+s.charAt(1)+res.substring(1);
        }
        else{
           res=s.charAt(0)+res;
        }

        return res;
    }

    public static String addStars(String s) {

        if(s.length()<=1){
            return s;
        }
        if(s.charAt(0)==s.charAt(1)){

            String ans=s.substring(0,1)+"*"+s.substring(1);

            return addStars(ans);

        }

        else{

            return s.charAt(0)+addStars(s.substring(1));

        }

    }


//    a. The string begins with an 'a'
//    b. Each 'a' is followed by nothing or an 'a' or "bb"
//    c. Each "bb" is followed by nothing or an 'a'
    public static boolean checkAB(String input,int si){


        if(si==input.length())
        {


            return true;
        }


        if(input.charAt(si)=='a'){


            if( si+2<input.length() && (input.charAt(si+1)=='b' && input.charAt(si+2)=='b') ){

                return checkAB(input,si+3);

            }

            else{

                return checkAB(input,si+1);
            }


        }

        return false;

    }

    public static boolean checkAB2(String str){

        if(str.length()==0){
            return true;
        }

        if(str.charAt(0)=='a'){

            if(str.substring(1).length()>1 && str.substring(1,3).equals("bb")){
                return checkAB2(str.substring(3));
            }
            else{
                return checkAB2(str.substring(1));
            }
        }

        return false;
    }



    public static int staircase(int n){

        if(n==2){
            return 2;
        }

        if(n==1 || n==0){
            return 1;
        }

        return staircase(n-1)+staircase(n-2)+staircase(n-3);

    }


}
