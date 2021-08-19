package stacks;

import java.util.Stack;

public class findCelebs {

    public static int celebrity(int[][] arr, int n) {

        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            stack.push(i);
        }


        while(stack.size()>1){

            int a=stack.peek();
            stack.pop();
            int b=stack.peek();
            stack.pop();

            if(arr[a][b]==1){

                stack.push(b);
            }
            else{

                // stack.pop();
                stack.push(a);

            }

        }

        int celeb=stack.peek();
        stack.pop();

        for(int i=0;i<n;i++){

            if(i!=celeb && (arr[celeb][i]==1 || arr[i][celeb]==0)){
                return -1;
            }

        }
   return celeb;

    }
}
