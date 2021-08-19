package queues;

import java.util.Queue;
import java.util.Stack;

public class ReverseFirstK {

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k){

        if(input.isEmpty() || k<=0){
            return input;
        }

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<k;i++){

            stack.push(input.peek());
            input.remove();
        }


        while(!stack.isEmpty()){
            input.add(stack.peek());
            stack.pop();

        }

        for(int i=0;i<input.size()-k;i++){

            input.add(input.peek());
            input.remove();
        }

        return input;

    }

    public static void reverseQueue(Queue<Integer> q) {

        if(q.isEmpty()){

         return;

        }
    int top=q.remove();
    reverseQueue(q);
        	q.add(top);
}


}
