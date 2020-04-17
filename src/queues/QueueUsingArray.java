package queues;

public class QueueUsingArray {

    private int data[];
    private int front;
    private int rear;
    private int size;
    public QueueUsingArray() {
        
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int capacity) {
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

        rear++;
        data[rear] = element;
        size++;



    }
        
    public int front() throws Exception {

        if (size == 0) {

            throw new Exception();
        }
        return data[front];
    }
    
    public int dequeue() {
      

        int temp = data[front];
        front++;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;


    }



}