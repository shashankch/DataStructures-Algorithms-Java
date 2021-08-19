package stacks;

import java.util.Stack;

public class StockSpan {

    public static int[] stockSpan(int[] price) {

        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int out[]=new int[price.length];
        out[0]=1;

        for(int i=1;i<price.length;i++){

            while(!stack.isEmpty() && price[stack.peek()]<price[i]){
                stack.pop();
            }

            if(stack.isEmpty()){

                out[i]=i+1;
            }
            else{
                out[i]=i-stack.peek();
            }

            stack.push(i);
        }

        return out;
    }
}
