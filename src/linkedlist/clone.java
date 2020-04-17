package linkedlist;

public class clone {
    /*
     * Structure of the Node used for implementing the Linked List
     * 
     * class Node<T> { T data; Node<T> next; Node<T> arb;
     * 
     * Node(T data) { this.data = data; this.next = null; this.arb = null; } }
     * 
     */

    public class Solution {

        public static Node<Integer> clone(Node<Integer> head) {
            // Your code goes here

            // if(head==null ){
            // return head;
            // }

            Node<Integer> temp = head;
            while (temp != null) {
                Node<Integer> nxt = temp.next;
                int data = temp.data;

                Node<Integer> newnode = new Node<>(data);

                temp.next = newnode;
                temp.next.next = nxt;

                temp = nxt;

            }

            temp = head;

            while (temp != null) {

                if (temp.next != null) {

                    if (temp.arb != null) {
                        temp.next.arb = temp.arb.next;
                    } else {
                        temp.next.arb = temp.arb;
                    }
                }
                if (temp.next != null) {
                    temp = temp.next.next;
                } else {
                    temp = temp.next;
                }

            }

            temp = head;
            Node<Integer> clone = head.next;
            Node<Integer> ans = clone;

            while (temp != null && clone != null) {

                if (temp.next != null) {
                    temp.next = temp.next.next;
                }

                if (clone.next != null) {
                    clone.next = clone.next.next;
                }

                temp = temp.next;

                clone = clone.next;

            }

            return ans;

        }
    }
}


 int n=budget.length;
        Arrays.sort(budget);
        int mx=n*budget[0];
        
        
        for(int i=1;i<n;i++){
            
            int curr=(n-i)*budget[i];
            if(curr>mx){
               mx=curr;
            }
            
        }
        
        return mx;