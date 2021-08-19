package stacks;

class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class StackWithMidOp {


    public Node head;
    public Node mid;
    public int size;

    StackWithMidOp() {

        head=null;
        mid=null;
        size=0;


    }

    public void push(int element) {

        Node newnode=new Node(element);

        if(head==null){
            head=newnode;
            mid=newnode;
            size++;
            return;
        }
        else{

            newnode.prev=head;
            head.next=newnode;
            head=newnode;
            size++;
            if(size%2==1){
                mid=mid.next;
            }
        }

    }

    public int pop() {
        // Return 0 if the stack is empty
        if(head==null){
            return 0;
        }

        Node temp=head;
        head=head.prev;
        int del=temp.data;
        size--;
        if(size%2==0){
            mid=mid.prev;
        }

        return del;

    }

    public int getmiddle() {
        // Return 0 if the stack is empty
        if(head==null){

            return 0;

        }

        return mid.data;
    }

    public int removeMiddle() {

        if(mid==null){
            return 0;
        }

        int val=mid.data;
        Node p=mid.prev;
        Node fwd=mid.next;
        size--;
        if(size%2==1){
            mid=mid.next;
        }
        else{
            mid=mid.prev;
        }

        if(p!=null){
            p.next=fwd;
        }
        if(fwd!=null){
            fwd.prev=p;
        }
        return val;
    }

    public void print() {

        if(head==null) return;
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
    }
}
