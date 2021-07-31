package trees;

public class setParentPointer {



    public static Node LevelFormToBST(int arr[],int i,int n,Node root) {

        if(i>=n){
            return root;
        }

        if(root==null){

            root=new Node(arr[i],null,null);

        }

        if(2*i+1<n  && arr[2*i+1]!=-1){

            root.left=LevelFormToBST(arr,2*i+1,n,root.left);


        }
        if(2*i+2<n && arr[2*i+2]!=-1){

            root.right=LevelFormToBST(arr,2*i+2,n,root.right);


        }

        return root;


    }



    public static Node LevelFormToBST2(int arr[],Node<Integer>root) {

        Node node[]=new Node[arr.length];

        int size=0;
        for(int i=0;i<arr.length;i++){

            node[i]=new Node(arr[i],null,null);
            size++;

            if(i>0){
                int parent=(i-1)/2;
                if(i==2*parent+1){
                    node[parent]=node[i];
                }
                else{
                    node[parent].right=node[i];
                }
            }
        }


        root=node[0];
        setParent(root,null);
        return root;

    }





    public static void inorder(Node root){


        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }

    public static void setParent(Node root,Node parent){

        if(root==null){
            return;
        }

        root.parent=parent;
        parent=root;
        setParent(root.left,parent);
        setParent(root.right,parent);



    }



    public static Node solve(int[] arr){

        int n=arr.length;


        Node root=null;
        root=LevelFormToBST(arr,0,arr.length,root);
        Node parent=null;
        setParent(root,parent);
        // inorder(root);

        return root;
    }
}
