package revision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval {

    int start;
    int end;

    Interval(int start, int end) {

        this.start = start;
        this.end = end;
    }

}


public class MergeOverlapInterval {


    public static void mergeinterval(Interval arr[]) {

        if (arr.length <= 0) {
            return;
        }

        Arrays.sort(arr, new Comparator<Interval>() {

            public int compare(Interval a, Interval b) {

                return a.start - b.start;
                // here -1,0,1 represent asc,equal,desc..
            }
        });

        Stack<Interval> stk = new Stack<>();

        stk.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            Interval top = stk.peek();

            if (top.end < arr[i].start) {

                stk.push(arr[i]);
            } else if (top.end < arr[i].end) {

                top.end = arr[i].end;
                stk.pop();
                stk.push(top);


            }



        }

        while (!stk.isEmpty()) {
            Interval ans = stk.pop();
            System.out.println(ans.start + " " + ans.end);
        }



    }



    public static void main(String[] args) {

        int n = 4;
        Interval arr[] = new Interval[n];
        arr[0] = new Interval(6, 8);
        mergeinterval(arr);

    }



}
