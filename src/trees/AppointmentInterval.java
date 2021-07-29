package trees;
class Interval {
    int start;
    int end;
}

class TreeNodeSp {
    Interval i;
    int max;
    TreeNodeSp left;
    TreeNodeSp right;
}
public class AppointmentInterval {


    //Interval and TreeNode class




    public static TreeNodeSp addinterval(TreeNodeSp root,Interval in){


        if(root==null){

            Interval i=new Interval();
            i.start=in.start;
            i.end=in.end;
            TreeNodeSp newnode=new TreeNodeSp();
            newnode.i=i;
            newnode.max=in.end;
            newnode.left=null;
            newnode.right=null;

            return newnode;

        }


        if(in.start<root.i.start){

            root.left=addinterval(root.left,in);
        }

        else{

            root.right=addinterval(root.right,in);
        }


        if(root.max<in.end){
            root.max=in.end;
        }

        return root;

    }


    public static Interval checkoverlap(TreeNodeSp root,Interval in){

        if(root==null){

            return null;
        }


        if(root.i.start<in.end && in.start<root.i.end){

            return root.i;
        }

        if(root.left!=null && root.left.max>=in.start){

            return checkoverlap(root.left,in);
        }

        return checkoverlap(root.right,in);



    }

    public  static void appointments(Interval[] app, int n) {
        //Write your code here

        TreeNodeSp root=null;

        root=addinterval(root,app[0]);

        for(int i=1;i<n;i++){


            Interval ans=checkoverlap(root,app[i]);

            if(ans!=null){

                System.out.println("["+app[i].start+","+app[i].end+"]"+" - "+"["+ans.start+","+ans.end+"]");

            }

            root=addinterval(root,app[i]);

        }

    }

}
