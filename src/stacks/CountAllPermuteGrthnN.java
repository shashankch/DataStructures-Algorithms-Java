package stacks;

import java.util.Stack;

//17  : 16
//1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16 and 17 are the numbers whose all
//        permutation is greater than the number itself. So, output 16.
public class CountAllPermuteGrthnN {

    public static int permutations(int n) {

        int count=0;
        Stack<Integer> stack=new Stack<>();

        for(int i=1;i<=9;i++){

            if(i<=n){
                stack.push(i);
                count++;
            }
        }


        while(!stack.isEmpty()){

            int top=stack.peek();
            stack.pop();

            for(int i=top%10;i<=9;i++){

                int val=top*10+i;
                if(val<=n){

                    stack.push(val);
                    count++;

                }

            }

        }

       return count;


    }


        public static boolean checkSmallest(int n){

            int prev=9;
            while(n>0){

                int curr=n%10;
                if(prev<curr) {
                    return false;
                }

                prev=curr;
                n/=10;

            }

            return true;
        }




        public static int permutations2(int n) {

            int count=0;
            for(int i=1;i<=n;i++){
                if(checkSmallest(i)){
                    count++;
                }
            }

    return count;
        }
}
