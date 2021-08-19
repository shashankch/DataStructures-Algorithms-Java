package stacks;
import java.util.*;
public class MorningAssembly {

    public static class Pair{
        long data;
        long frequency;

        Pair(long data,long frequency){
            this.data = data;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {

        Stack<Pair> stackLL = new Stack<>();
        HashMap<Pair,Pair> map = new HashMap<>();
        long output = 0;

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long a[] = new long[n];

        for(int i=0;i<n;i++){
            a[i] = in.nextLong();
        }

        for(int i=0;i<n;i++){

            Pair p = new Pair(a[i],1);
            if(stackLL.isEmpty()){
                stackLL.push(p);
            }
            else{
                while(!stackLL.isEmpty() && stackLL.peek().data<=a[i]){
                    output+= stackLL.peek().frequency;
                    if(stackLL.peek().data == a[i]){
                        p.frequency+= stackLL.peek().frequency;
                    }
                    stackLL.pop();
                }
                if(!stackLL.isEmpty()){
                    output++;
                }
                stackLL.push(p);
            }
            //map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        //System.out.println(map);
        System.out.println(output);
    }
}
