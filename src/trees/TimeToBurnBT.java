package trees;


class KeepTrack{

    int max;
    int above;
    int below;

    KeepTrack(int max,int above,int below){

        this.max=max;
        this.above=above;
        this.below=below;
    }
}

public class TimeToBurnBT {

    public KeepTrack getTime(BinaryTreeNode<Integer>root,int start){

        if(root==null){

            return new KeepTrack(-1,-1,0);
        }

        KeepTrack left=getTime(root.left,start);
        KeepTrack right=getTime(root.right,start);

        KeepTrack ans=new KeepTrack(-1,-1,0);

        //root equals to start node
        if(root.data==start){

            ans.above=0;
            ans.below=Math.max(left.below,right.below);
            ans.max=ans.below;
        }

        // start node in left subtree
        if(left.above!=-1){

            ans.max=Math.max(left.max,Math.max(left.below,left.above+right.below+1));
            ans.above=left.above+1;
            ans.below=left.below;

        }
        //start in right subtree
        else if(right.above!=-1){
            ans.max=Math.max(right.max,Math.max(right.below,right.above+left.below+1));
            ans.above=right.above+1;
            ans.below=right.below;
        }
        //start not present in the subtree
        else{
            ans.max=-1;
            ans.below=Math.max(left.below,right.below)+1;
            ans.above=-1;
        }

        return ans;
    }
}
