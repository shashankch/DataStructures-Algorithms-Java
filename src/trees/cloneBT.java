package trees;

import java.util.ArrayList;

public class cloneBT {
    public static BinaryTreeNode<Integer> helper1(BinaryTreeNode<Integer>root){
            
            
        if(root==null){
                return null;
            }
        
        BinaryTreeNode<Integer>newnode=new BinaryTreeNode<Integer>(root.data);
        
        BinaryTreeNode<Integer>temp=root.left;
        root.left=newnode;
        newnode.left=temp;
       
        if(temp!=null){
       temp.left=helper1(temp);
        }
            
        root.left.right=helper1(root.right);
        
       return root.left;
        
    }

    public static void helper2(BinaryTreeNode<Integer>root){
        
        if(root==null){
            return;
        }
        
        
        if(root.random!=null){
            
            root.left.random=root.random.left;
        }
        if(root.left!=null){
        helper2(root.left.left);
        }
        if(root.right!=null){
        helper2(root.right);
        
        }
        
        
    }


    public static void helper3(BinaryTreeNode<Integer>root,BinaryTreeNode<Integer>croot){
        
            if(root==null){
                return ;
            }
            
            
            if(croot.left!=null)
            {
                
            BinaryTreeNode<Integer>temp=croot.left.left;
            root.left=root.left.left;
            croot.left=temp;
                
                
            }
        else{
            
            root.left=null;
        }
        
        
        helper3(root.left,croot.left);
        helper3(root.right,croot.right);

    }

    public static BinaryTreeNode<Integer> clonedTree(BinaryTreeNode<Integer> root) {
        
        
            
            //duplicate create..
            BinaryTreeNode<Integer>croot=helper1(root);
            
            // attach random pointers
            helper2(root);
        
        
            //separate tree..
            helper3(root,croot);
        
        
        
        
        return croot;
        
        
        
    } 


    public static BinaryTreeNode<Integer> root;
    
    
    
    public static void helperBT(int par[],BinaryTreeNode<Integer>nodes[],int i){
        
            
            if(nodes[i]!=null){
                return;
            }
        
            if(nodes[i]==null){
                
                nodes[i]=new BinaryTreeNode<Integer>(i);
                
            }
        
            if(par[i]==-1){
                
                root=nodes[i];
                return;
            }
        
            if(nodes[par[i]]==null){
                
                helperBT(par,nodes,par[i]);
            }
            
            BinaryTreeNode<Integer>temp=nodes[par[i]];
        
            if(temp.left==null){
                temp.left=nodes[i];
            }
            else{
                temp.right=nodes[i];
            }
        
        
        
        
    }
//construct from array of values of parent of the node where index is weight of each node.root is -1.
    public static BinaryTreeNode<Integer> constructBT(int[] parent, int n) {
       
       
       BinaryTreeNode<Integer> nodes []=null;
        
        // for(int i=0;i<n;i++){
            
        //     nodes[i]=null;
            
        // }
        
        
        for(int i=0;i<n;i++){
            
            helperBT(parent,nodes,i);
        }
        
        
        return root;
        
        
    }

//tilt - absolute difference of left subtree and right subtree. for null it is zero.
    public static int tilt=0;
    
    	public static int tilt(BinaryTreeNode<Integer>root){
            
            if(root==null){
                return 0;
                
            }
            
            int leftsum=tilt(root.left);
            int rightsum=tilt(root.right);
            
            
            tilt+=Math.abs(leftsum-rightsum);
            
            return root.data+leftsum+rightsum;
            
            
            
        }


        public static void serialize(BinaryTreeNode<Integer> root, ArrayList<Integer> tree) {
            //Write your code here
            
            if(root==null){
                tree.add(-1);
                return;
            }
            
            tree.add(root.data);
            
            serialize(root.left,tree);
            serialize(root.right,tree);
            
            
            
            
        }
    	public static int hindex=0;
    	public static BinaryTreeNode<Integer>helperDeserialize(BinaryTreeNode<Integer>root,ArrayList<Integer>tree,int n){
            
            int index=hindex;	
            if(index==n){
                
                return null;
            }
            
            if(tree.get(index)==-1){
                
                hindex++;
                return null;
            }
            
            root=new BinaryTreeNode<Integer>(tree.get(index));
            hindex++;
            root.left=helperDeserialize(root.left,tree,n);
            root.right=helperDeserialize(root.right,tree,n);
            
            
            return root;
            
            
        }
    

        public static BinaryTreeNode<Integer> deSerialize(ArrayList<Integer> tree) {
            //Write your code here
            int n=tree.size();
            BinaryTreeNode<Integer>root=null;
          root=helperDeserialize(root,tree,n);
         return root;	
            
        }

        public static Pairs helper(TreeNode T ,TreeNode S){
        
       
            if(T==null && S==null){
                
                return new Pairs(T,S,true);
            }
            
            if(T==null || S==null){
                
                return new Pairs(T,S,false);
            }
            
            
            if(T.val==S.val){
                
                Pairs left=helper(T.left,S.left);
                Pairs right=helper(T.right,S.right);
                
                if(left.isSub &&right.isSub){
                    
                    return new Pairs(T,S,true);
                }
            }
            
            Pairs ifleft=helper(T.left,S);
            Pairs ifright=helper(T.right,S);
            
            return new Pairs(T,S,ifleft.isSub||ifright.isSub); 
        }
        
        public static boolean isSubtree(TreeNode T, TreeNode S) {
            // Write your code here
           
            return helper(T,S).isSub;
                
        }
}


