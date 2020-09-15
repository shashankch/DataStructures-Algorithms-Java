package LeetcodeQuestions;

class cNode{

    int data;
    cNode next;
    public cNode(int data){
        this.data=data;
    }

}



public class detectCircleLL {
    
    // func to detect circular
    public static boolean detect(cNode head){


        cNode fast=head;
        cNode slow=head;

        while(fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){

                return true;
            }
            


        }

        return false;

    }

    public static cNode startPoint(cNode head){

        cNode fast=head;
        cNode slow=head;
        boolean flag=false;

        while(fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){

                flag=true;
                break;
            }
        }

        if(flag==false){
            return null;
        }

        fast=head;


        while(slow!=fast){

            slow=slow.next;
            fast=fast.next;
        }

        return slow;

    }






        public static void main(String[] args) {

            cNode head=new cNode(3);
            head.next=new cNode(2);
            head.next.next=new cNode(1);
            head.next.next=head;

            System.out.println(startPoint(head).data);
            System.out.println(detect(head));
            
        }

}
