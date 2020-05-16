package revision;

import java.util.Stack;

public class FindMaxinStack {

    Stack<Integer> stk = new Stack<>();
    int max;

    public void getMax() {

        if (stk.empty()) {
            System.out.println("no element");
        } else {
            System.out.println(max);
        }
    }

    public void peek() {

        if (stk.empty()) {
            System.out.println("stack is empty");
        }

        int top = stk.peek();

        if (top > max) { // here it means max contains the top element.
            System.out.println(max);
        } else {
            System.out.println(top);
        }

    }


    public void pop() {

        if (stk.isEmpty()) {
            System.out.println("empty");
            return;
        }

        int top = stk.peek();
        stk.pop();
        if (top > max) {
            System.out.println(max);
            max = 2 * max - top;
        } else {
            System.out.println(top);
        }

    }


    public void push(int elem) {

        if (stk.isEmpty()) {

            max = elem;
            stk.push(elem);
            return;
        }

        if (elem > max) {
            stk.push(2 * elem - max);
            max = elem;
        } else {
            stk.push(elem);
        }


    }


    public static void main(String[] args) {

        FindMaxinStack obj = new FindMaxinStack();
        obj.push(3);
        obj.pop();
        obj.getMax();
    }



}
