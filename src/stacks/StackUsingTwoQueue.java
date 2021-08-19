package stacks;
import java.util.*;
public class StackUsingTwoQueue<T> {

    public  Queue<T> a;
    public  Queue<T> b;
    public  int size;

    public StackUsingTwoQueue(){

        a=new LinkedList<T>();
        b=new LinkedList<T>();
        size=0;
    }

    public void push(T data){
        a.add(data);
        size++;

    }

    public T pop() {

        while(a.size()!=1){

            b.add(a.peek());
            a.remove();
        }
        T data=a.remove();
        size--;

        Queue<T>temp=a;
        a=b;
        b=temp;
        return data;

    }

    public int getSize(){

        return size;
    }

    public T top(){

        while(a.size()!=1){

            b.add(a.peek());
            a.remove();
        }
        T data=a.peek();
        a.remove();
        b.add(data);

        Queue<T>temp=a;
        a=b;
        b=temp;
        return data;

    }

    public Queue<T> getQueue(){
     return a;
    }

}
