package LeetcodeQuestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class Pair implements Comparable<Pair> {
    int element;
    int frequency;

    Pair(int element, int frequency) {
        this.element = element;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Pair other) {
        return this.frequency - other.frequency;
    }

}
public class TopKFreqElement {


   

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll().element;
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
    
}
