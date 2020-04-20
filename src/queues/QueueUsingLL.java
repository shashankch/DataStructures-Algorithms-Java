package queues;

import java.util.LinkedList;
import java.util.Queue;

class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        // next=null
    }

}

public class QueueUsingLL<T> {

    private Node<T> fron;
    private Node<T> rear;
    int size;

    public QueueUsingLL() {
        fron = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        Node<T> newnode = new Node<T>(data);

        if (fron == null) {
            fron = newnode;
            rear = newnode;

        } else {
            rear.next = newnode;
            rear = newnode;
        }

        size++;

    }

    public T front() {
        if (fron == null) {

        }

        Node<T> temp = fron;

        return temp.data;
    }

    public T dequeue() {
        if (fron == null) {

        }

        Node<T> temp = fron;

        fron = fron.next;
        size--;
        if (size == 0) {
            fron = null;
            rear = null;
        }

        return temp.data;

    }

    public static void main(String[] args) {
        // it is an interface but stack and ll are class.
        // so here methods are defined but method body is not defined.so we have to
        // implement
        // other option is to use class which has implemented queue: which is LinkedList
        // class.
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add(39);
        qu.size();
        qu.poll();
        qu.size();
        qu.remove();
        qu.peek();

    }

}