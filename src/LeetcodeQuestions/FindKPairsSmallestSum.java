package LeetcodeQuestions;

import java.util.*;


class Solution {
    private class Pair {
        Integer u;
        Integer v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resultPairs = new ArrayList<>();
        if (nums1.length == 0) {
            return resultPairs;
        } else if (nums2.length == 0) {
            return resultPairs;
        }
        int totalLength = nums1.length * nums2.length;
        Pair[] pairs = new Pair[totalLength];
        int index = 0;
        for (int ele1 : nums1) {
            for (int ele2 : nums2) {
                pairs[index++] = new Pair(ele1, ele2);
            }
        }
        Queue<Pair> maxHeap = new PriorityQueue(totalLength, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                Integer a = p1.u + p1.v;
                Integer b = p2.u + p2.v;
                return b.compareTo(a);
            }
        });

        for (Pair p : pairs) {
            maxHeap.offer(p);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        for (Pair p : maxHeap) {
            Integer u = p.u;
            Integer v = p.v;
            List<Integer> temp = new ArrayList<>();
            temp.add(u);
            temp.add(v);
            resultPairs.add(temp);
        }
        return resultPairs;
    }
}

public class FindKPairsSmallestSum {



    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> allPairs = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                allPairs.add(new int[] {nums1[i], nums2[j], nums1[i] + nums2[j]});
            }
        }

        List<List<Integer>> kSmallestPairs = new ArrayList<>();

        while (!allPairs.isEmpty() && k-- > 0) {
            int[] currentPair = allPairs.poll();
            kSmallestPairs.add(Arrays.asList(currentPair[0], currentPair[1]));
        }

        return kSmallestPairs;
    }

}
