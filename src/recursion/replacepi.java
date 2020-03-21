package recursion;

public class replacepi{


public static String replacep(String str){

    if(str.length()<=1){
        return str;
    }

    if(str.charAt(0)=='p' && str.charAt(1)=='i'){

        String ans=replacep(str.substring(2));
        return "3.14"+ans;
    }
    else{
        String ans= replacep(str.substring(1));

        return str.charAt(0)+ans;
    }

}

public static void main(String[] args) {
    

    String str="ppiafdfpidfpi";
   String ans= replacep(str);
    System.out.println(ans);
}


}