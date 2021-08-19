package stacks;


class NodeLL<T> {

        T data;
        NodeLL<T> next;

    public NodeLL(T data) {
        this.data = data;
        }
}

     
class StackEmptyException extends Exception{

}


public class StackLL<T>{

    private NodeLL<T> head;
    private  int size;
    public StackLL() {

        size=0;
        head=null;

    }

    public int size() {

        return size;
    }

    public void push(T data) {




        NodeLL<T> newNodeLL=new NodeLL<T>(data);
        if(head==null){

            head=newNodeLL;
        }


        newNodeLL.next=head;
        head=newNodeLL;
        size++;


    }

    public boolean isEmpty() {

        return size==0;
    }

    public T pop() throws StackEmptyException {

        if(head==null){

            throw new StackEmptyException();
        }

        T data=head.data;
        head=head.next;
        size--;
        return data;
    }

    public T top() throws StackEmptyException {

        if(head==null){

            throw new StackEmptyException();
        }

        return head.data;

    }
}
