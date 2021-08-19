package queues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatChar {

    public static void nonrep(String str) {


        int freq[]=new int[26];

        Queue<Character> q=new LinkedList<Character>();

        for(int i=0;i<str.length();i++){


            q.add(str.charAt(i));
            freq[str.charAt(i)-'a']++;


            while(!q.isEmpty()) {

                if(freq[q.peek()-'a']>1)
                {
                q.remove();

                }
                else{
                    System.out.print(q.peek());
                }
            }
            if(q.isEmpty()){
                System.out.println("-1");
            }


        }

        System.out.println();

    }
}
