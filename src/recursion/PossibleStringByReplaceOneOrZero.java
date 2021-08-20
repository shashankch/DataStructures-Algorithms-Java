package recursion;

//? by 1 or 0  110?01?1
public class PossibleStringByReplaceOneOrZero {



    public static void helper2(String ans , int i){

        if(i==ans.length()){

            System.out.println(ans);
            return ;

        }
        if(ans.charAt(i)=='?'){

            String ans1=ans.substring(0,i)+'0'+ans.substring(i+1);
            String ans2=ans.substring(0,i)+'1'+ans.substring(i+1);
            helper2(ans1 ,i+1);
            helper2(ans2,i+1);

            return;
        }
            helper2(ans,i+1);

    }

    public static void helper(char ans[],int i){

        if(i==ans.length){

            System.out.println(ans);
            return ;

        }
        if(ans[i]=='?'){

            ans[i]='0';
            helper(ans,i+1);
            ans[i]='1';
            helper(ans,i+1);
            ans[i]='?';

        }

        else{
            helper(ans,i+1);
        }

    }

    public static void printAllPossibleStrings(String str) {

        char ans[]=str.toCharArray();
        helper(ans,0);

    }
}
