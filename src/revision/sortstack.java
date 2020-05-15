package revision;

import java.util.Stack;

public class sortstack {
    

    public static void sortinsert(Stack<Integer> stk, int elem) {

        if (stk.isEmpty() || elem > stk.peek()) {
            stk.push(elem);
            return;
        }

        
            int top = stk.pop();
            sortinsert(stk, elem);
            stk.push(top);
        

    }





    public static void sort(Stack<Integer>stk) {

        if (stk.isEmpty()) {
            return;
        }

        int top = stk.pop();
        sort(stk);

        sortinsert(stk, top);






    }

    public static void main(String[] args) {

    }
}