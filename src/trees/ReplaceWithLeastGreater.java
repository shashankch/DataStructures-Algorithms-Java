package trees;


class succ{

    public NodeX s;

}

class NodeX{

    public int val;
    public NodeX left;
    public NodeX right;

    public NodeX(int val){

        left=null;
        right=null;
        this.val=val;

    }


}

// another approach to get successor...
//public static NodeX getSucc(NodeX root,int curr){
//
//    NodeX node=getNode(root,curr);
//    if(node==null){
//        return null;
//    }
//    else if(node.right!=null){
//        return getMin(node.right);
//    }
//    else{
//        NodeX ancestor=root,NodeX succ=null;
//        while(node!=ancestor){
//
//            if(node.data<ancestor.data){
//                succ=ancestor;
//                ancestor=ancestor.left;
//            }
//            else{
//                ancestor=ancestor.right;
//            }
//
//
//        }
//        return succ;
//    }
//
//}



public class ReplaceWithLeastGreater {

    public static NodeX createbst(NodeX root,int val,succ obj)
    {

        if(root==null){

            root=new NodeX(val);
            return root;
        }


        if(val<root.val){

            obj.s=root;
            root.left= createbst(root.left,val,obj);
        }
        else{

            root.right=createbst(root.right,val,obj);
        }


        return root;
    }


    public static void replace(int[] arr, int n) {
        //Write your code here

        NodeX root=null;
        succ obj=new succ();
        for(int i=n-1;i>=0;i--){

            obj.s=null;

            root=createbst(root,arr[i],obj);


            if(obj.s!=null){
                arr[i]=obj.s.val;
            }

            else{
                arr[i]=-1;
            }


        }

    }
}
