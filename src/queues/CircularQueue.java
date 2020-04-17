package queues;

public class CircularQueue {

    private int data[];
    private int front;
    private int rear;
    private int size;

    public CircularQueue() {

        data = new int[5];
        front = -1;
        rear = -1;
    }

    public CircularQueue(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;

    }

    public int size() {
        return size;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) throws Exception {

        if (size == data.length) {
            throw new Exception();
        }

        if (size == 0) {
            front = 0;
        }
        // rear++;
        // if (rear == data.length) {
        // rear = 0;
        // }
        rear = (rear + 1) % size;
        data[rear] = element;
        size++;

    }

    public int front() throws Exception {

        if (size == 0) {

            throw new Exception();
        }
        return data[front];
    }

    public int dequeue() throws Exception {

        if (size == 0) {
            throw new Exception();
        }

        int temp = data[front];
        // front++;
        // if (front == data.length) {
        // front = 0;
        // }
        front = (front + 1) % size;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;

    }

}