package revision;


public class ImplStackinArray {

    // implementation of two stacks using single array..
    int arr[];
    int size;
    int top1;
    int top2;

    public ImplStackinArray(int n) {

        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;

    }


    public void push1(int x) {


        if (top1 < top2 - 1) {

            top1++;
            arr[top1] = x;

        } else {
            System.out.println("overflow");
        }


    }

    public void push2(int x) {

        if (top1 < top2 - 1) {

            top2++;
            arr[top2] = x;
        }

        else {
            System.out.println("overflow");
        }


    }


    public int pop1() {

        if (top1 >= 0) {

            int top = arr[top1];
            top1--;
            return top;
        } else {
            return -1;
        }



    }

    public int pop2() {

        if (top2 < size) {

            int top = arr[top2];
            top2--;
            return top;
        } else {
            return -1;
        }

    }



    public static void main(String[] args) {

        ImplStackinArray stack = new ImplStackinArray(5);
        stack.push1(4);
        int val = stack.pop1();
        System.out.println(val);
    }

}
