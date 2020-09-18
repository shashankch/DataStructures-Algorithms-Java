package LeetcodeQuestions;

import java.util.PriorityQueue;

public class kthlargestElementStream {


    PriorityQueue<Integer> pq;
    int size = 0;

    public kthlargestElementStream(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>();
        for (int i=0; i<k && i<nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i=k; i<nums.length; i++) {
            if (nums[i]>pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        this.size = k;
    }

    public int helper(int val) {
        if (pq.size() < size) {
            pq.add(val);
            return pq.peek();
        } else if (val < pq.peek()) {
            return pq.peek();
        } else {
            pq.poll();
            pq.add(val);
            return pq.peek();
        }
    }

    
    public static void main(String[] args) {

        int k = 3;
        int[] nums = {4, 5, 8, 2};
        kthlargestElementStream kthLargest = new kthlargestElementStream(k, nums);
        System.out.println(kthLargest.helper(3));

    }


}





