package revision;

public class ImplKstackinArray {


    int arr[];
    int top[];

    int next[];

    int free;
    int k, n;

    ImplKstackinArray(int k, int n) {

        this.k = k;
        this.n = n;
        free = 0;
        arr = new int[n];
        next = new int[n];
        top = new int[k];

        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        for (int i = 0; i < n - 1; i++) {

            next[i] = i + 1;
        }
        next[n - 1] = -1;

    }

    public boolean isfull() {

        return free == -1;
    }

    public boolean isempty(int stk) {

        return top[stk] == -1;
    }

    // here for pushing check if free is -1 (i.e no spots left free) all full.
    // checking whether free spot represented by free variable in arr
    // is equal to -1 or not.
    // if not full:
    // then store elem in the free index variable of arr.
    // update free to next of ith to represent next free spot.
    // update top of stack by ith free index.
    // but before that insert top of stack index to next of i to make connection with prev.elem.
    // here next array index represent the next index elements. used for making connections.



    public void push(int stk, int x) {

        if (isfull()) {
            System.out.println("overflow");
            return;
        } else {
            int i = free;
            free = next[i];
            next[i] = top[stk];
            top[stk] = i;
            arr[i] = x;

        }


    }

    // for pop operation first check if stack is not empty by
    // checking whether top of stk is -1 or not.
    // if not: take out the index of top of that stack.
    // and replace top by next of i which is storing prev.elem index.
    // now point free to ith index as this is free now.
    // also change next of i to point to free index of the array.
    public int pop(int stk) {

        if (isempty(stk)) {
            System.out.println("overflow");
            return -1;
        } else {

            int i = top[stk];
            top[stk] = next[i];

            next[i] = free;

            free = i;

            return arr[i];

        }



    }



}
