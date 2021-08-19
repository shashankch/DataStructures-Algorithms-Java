package linkedlist;

public class EvenOddLL {


    public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {

        if(head==null){
        return head;

    }

    LinkedListNode<Integer>oh=null;
    LinkedListNode<Integer>ot=null;
    LinkedListNode<Integer>eh=null;
    LinkedListNode<Integer>et=null;

        while(head!=null){


        if((head.data%2)!=0){


            if(oh==null){

                oh=head;
                ot=head;


            }
            else{

                ot.next=head;
                ot=ot.next;
            }
        }
        else{

            if(eh==null){

                eh=head;
                et=head;

            }
            else{

                et.next=head;
                et=et.next;

            }




        }

        head=head.next;
    }


        if(oh==null){
        et.next=null;
        return eh;
    }

        if(eh==null){

        ot.next=null;
        return oh;
    }

    ot.next=eh;
    et.next=null;
        return oh;
//         if(oh!=null){
//         ot.next=null;
//     }
//     if(eh!=null){
//         et.next=null;
//     }

//     if(oh==null){
//         return eh;
//     }

//     if(eh==null){
//         return oh;
//     }
//     else{
//         ot.next=eh;
//     }

//     return oh;
    //write your code here
//
//if(oddehead==null){
//    return evenhead;
//}
//else{
//    oddtail.next=evenhead;
//}
//if(evenhead!=null){
//    eventail.next=null;
//}
//
//return oddhead


}
}
