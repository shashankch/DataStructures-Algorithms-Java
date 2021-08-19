package linkedlist;


class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    // only flatten ll cases
    public LinkedListNode<T> down;

    public LinkedListNode<T> right;

    public LinkedListNode<T> arb;


    public LinkedListNode(T data) {
        this.setData(data);
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}