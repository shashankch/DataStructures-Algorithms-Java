package trees;

public class MedianBST {

    public static BinaryTreeNode<Integer> inorderpred(BinaryTreeNode<Integer>root){

        BinaryTreeNode<Integer>temp=root.left;

        while(temp.right!=root && temp.right!=null){

            temp=temp.right;
        }

        return temp;
    }

    public static int count(BinaryTreeNode<Integer>root){

        BinaryTreeNode<Integer> curr=root;

        int count=0;
        while(curr!=null){

            if(curr.left==null){

                count++;
                curr=curr.right;

            }

            else{

                BinaryTreeNode<Integer>pr=inorderpred(curr);

                if(pr.right==null){

                    pr.right=curr;
                    curr=curr.left;

                }
            else{

                    pr.right=null;

                    count++;
                    curr=curr.right;

                }

            }

        }
         return count;

    }

    public static int median(BinaryTreeNode<Integer> root) {
        int nodes=count(root);
        boolean even=false;
        if(nodes%2==0){
            even=true;
        }
        BinaryTreeNode<Integer> curr=root;
        BinaryTreeNode<Integer>prev=null;
        int count=0;
        while(curr!=null){

            if(curr.left==null){

                count++;

                if(!even && count==(nodes+1)/2){

                    return curr.data;
                }

                if(even && count==nodes/2+1){

                    return (prev.data+curr.data)/2;
                }

                prev=curr;
                curr=curr.right;

            }

            else{

                BinaryTreeNode<Integer>pr=inorderpred(curr);

                if(pr.right==null){

                    pr.right=curr;
                    curr=curr.left;

                }

                else{

                    pr.right=null;

                    count++;


                    if(!even && count==(nodes+1)/2){

                        return curr.data;
                    }

                    if(even && count==nodes/2+1){

                        return (prev.data+curr.data)/2;
                    }

                    prev=curr;
                    curr=curr.right;

                }

            }

        }

        return 0;
    }

}
