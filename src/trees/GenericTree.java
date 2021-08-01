package trees;

public class GenericTree {

    //depth=0;
    public static void replaceWithDepthValue(GenericTreeNode<Integer> root,int depth){

            if(root==null){
                return;
            }

            root.data=depth;
            for(GenericTreeNode<Integer>child:root.children){

                replaceWithDepthValue(child,depth+1);

            }
        }

    public static int countLeafNodes(GenericTreeNode<Integer> root){

        if(root==null){
            return 0;
        }
        if(root.children.size()==0){
            return 1;
        }

        int count=0;
        for(GenericTreeNode<Integer>child:root.children){
            count+=countLeafNodes(child);
        }

        return count;

    }


    public static GenericTreeNode<Integer> findSecondLargest(GenericTreeNode<Integer> root){

        if(root==null){

            SecondMax res=new SecondMax();
            res.first=null;
            res.second=null;

        }

        SecondMax out=new SecondMax();
        out.first=root;
        out.second=null;

        for(GenericTreeNode<Integer>child:root.children){



        }

    return null;

    }



}

class SecondMax{

    GenericTreeNode<Integer> first;
    GenericTreeNode<Integer> second;

    SecondMax(){

    }


        }
