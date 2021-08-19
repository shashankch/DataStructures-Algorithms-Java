package linkedlist;

public class DeleteNnodes {

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {

        if(M==0|| head==null){

            return null;
        }

        if(N==0){
            return head;
        }

        LinkedListNode<Integer> temp=head;
        LinkedListNode<Integer>curr;

        int i=1;
        while(temp!=null){


            for( i=1;i<M && temp!=null;i++){

                temp=temp.next;

            }

            if(temp==null){
                return head;
            }

            curr=temp.next;

            for(i=1;i<=N && curr!=null;i++){

                curr=curr.next;

            }

            temp.next=curr;
            temp=curr;
        }
         return head;

    }


    public static LinkedListNode<Integer> skipMdeleteN2(LinkedListNode<Integer> head, int M, int N) {

        if(M==0|| head==null){

            return null;
        }

        if(N==0){
            return head;
        }

        LinkedListNode<Integer> curr=head;
        LinkedListNode<Integer>temp=null;


        while(curr!=null){

            int yes=0;
            int no=0;
            while(curr!=null && yes<M){

                if(temp==null){
                    temp=curr;
                }
                else{

                    temp.next=curr;
                    temp=curr;
                }

                curr=curr.next;
                yes+=1;

            }

            while(curr!=null && no<N){

                curr=curr.next;
                no+=1;
            }

        }

        if(temp!=null){
            temp.next=null;
        }
        return head;

    }
}
