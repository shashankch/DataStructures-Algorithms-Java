package linkedlist;

public class IntersectionLL {

    public static int length(LinkedListNode<Integer> head){

        int count=0;
        LinkedListNode<Integer> temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }

        return count;

    }

    public static int changelist(LinkedListNode<Integer> h1,LinkedListNode<Integer> h2) {
       
        LinkedListNode<Integer>a=null,b=null;
        int len1=length(h1);
        int len2=length(h2);
        int d=0;
        if(len1>len2){

            d=len1-len2;
            a=h1;
            b=h2;
        }
        else{
            d=len2-len1;
            a=h2;
            b=h1;
        }




        for(int i=0;i<d;i++){

            if(a==null){
                return -1;
            }

            a=a.next;
        }

        while(b!=null && a!=null){

            if(a.data==b.data){

                return a.data;
            }
            a=a.next;
            b=b.next;
        }

        return -1;
    }

}
