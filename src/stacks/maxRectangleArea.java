package stacks;

import java.util.Stack;

/**
 * maxRectangleArea
 */
public class maxRectangleArea {

    public static int maxhist(int arr[]) {

        Stack<Integer> stack = new Stack<>();


        int mx = 0;
        int i = 0;
        for (; i < arr.length;) {

            if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
                stack.push(i++);


            } else {
                int topvalue = arr[stack.peek()];
                stack.pop();
                if (!stack.isEmpty()) {


                    mx = Math.max(mx, (topvalue * (i - stack.peek() - 1)));
                } else {


                    mx = Math.max(mx, (topvalue * i));
                }


            }

        }

        while (!stack.isEmpty()) {

            int topvalue = arr[stack.peek()];
            stack.pop();
            if (!stack.isEmpty()) {


                mx = Math.max(mx, (topvalue * (i - stack.peek() - 1)));
            } else {


                mx = Math.max(mx, (topvalue * i));
            }



        }


        return mx;



    }



    public static void main(String[] args) {


        int mat[][]=new int[10][10];
        int mx = 0;
        int n=mat.length,m=mat[0].length;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 1) {
                    mat[i][j] = mat[i][j] + mat[i - 1][j];
                }
            }

            mx = Math.max(mx, maxhist(mat[i]));

        }

        if (m != 0)
            mx = Math.max(mx, maxhist(mat[0]));


        System.out.print(mx);



    }



}
