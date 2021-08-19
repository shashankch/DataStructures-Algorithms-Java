package test;

import java.util.Stack;

public class Check {


    public static int balance(String str){

        Stack<Character>stk=new Stack<>();

        int count=0;
        for(int i=0;i<str.length();i++) {

            char ch = str.charAt(i);
            int open=0;
            int close=0;

            if(ch=='{'){
                stk.push(ch);
            }

        }
return 0;
    }



    public static void main(String[] args) {

        String test="}}}{";
        System.out.println("count:"+balance(test));

    }


}
