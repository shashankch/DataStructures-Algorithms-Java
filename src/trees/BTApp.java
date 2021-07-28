package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BTApp {
    public static int numNodesGreaterX(BinaryTreeNode<Integer> root,int x){
		
        if(root==null){
            return 0;
        }

        int count=(root.data>x)?1:0;
        
        if(root.left!=null){
            
          count+=numNodesGreaterX(root.left,x);
        }
        if(root.right!=null) {
            
            return numNodesGreaterX(root.right,x);
        }
        
        return count;
	}


    public static int largestNode(BinaryTreeNode<Integer> root){

        if(root==null){
            return -1;
        }

        int left=largestNode(root.left);
        int right=largestNode(root.right);
        return Math.max(root.data,Math.max(left,right));

    }


    public static int heightBT(BinaryTreeNode<Integer> root) {
	
		if(root==null){
            return 0;
        }
        
        return 1+Math.max(heightBT(root.left),heightBT(root.right) );
	}


    public static void helper(BinaryTreeNode<Integer>root,int dep){
        
        
        if(root==null){
            return;
        }
        
      
    	

     root.data=dep;
        
     helper(root.left,dep+1);
       helper(root.right,dep+1);
        
   
        
        
    }
    
    public static void inorder(BinaryTreeNode<Integer>root){
        
        if(root==null){
            return;
        }
        
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
        
        
    }
    
    
    
	static void replaceDepth(BinaryTreeNode<Integer> n1) {
	
        
     helper(n1,0);
     
        inorder(n1);
    
        
        
	}

    public static void printAtDepth(BinaryTreeNode<Integer> n1,int k) {

        if(n1== null){
            return;
        }
        if(k==0){
            System.out.println(n1.data);
        }
        printAtDepth(n1.left,k-1);
        printAtDepth(n1.right,k-1);
    }


    public static int nodesAtDistK(BinaryTreeNode<Integer>root,int node,int k){
        
        if(root==null){
            return -1;
        }
        
        if(root.data==node){
            
            printAtDepth(root,k);
            return 0;
        }
        
        
        int ld=nodesAtDistK(root.left,node,k);
        
        if(ld!=-1){
            
            if(ld+1==k){
                System.out.println(root.data);
            }
            else{
                
                printAtDepth(root.right,k-ld-2);
            }
            
            return 1+ld;
            
        }
        
        int rd=nodesAtDistK(root.right,node,k);
        
        if(rd!=-1){
            
            if(rd+1==k){
                System.out.println(root.data);
            }
            else{
                
                printAtDepth(root.left,k-rd-2);
            }
            
            return 1+rd;
            
        }
  
      return -1;  
        
        
    }
	

    public static int numleaves(BinaryTreeNode<Integer> root) {

        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            return 1;
        }

        return numleaves(root.left)+numleaves(root.right);
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
	
		if(root==null)
        {
            return false;
            
        }
        
        if(root.data==x){
            return true;
        }
        
        boolean left=isNodePresent(root.left,x);
        boolean right=isNodePresent(root.right,x);
        
        
        return left|| right;
        
        
	}


    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		
		
			if(root==null){
                return ;
            }
      
       if(root.left!=null && root.right==null){
            
            System.out.println(root.left.data);
           
            
        }
        
        else if(root.left==null && root.right!=null){
            
            
            System.out.println(root.right.data);
            
            
        }
        
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
        
        
        
	}

    public static void mirror(BinaryTreeNode<Integer> root){
	
        if(root==null){
            return ;
        }
        
        mirror(root.left);
        mirror(root.right);

       
        BinaryTreeNode<Integer> temp=root.left;
        root.left=root.right;
        root.right=temp;
  
	}

    public static Pair helperDiameterTree(BinaryTreeNode<Integer> root){
        	
        if(root==null){
            
            return new Pair(0,0);
            

        }
        
        Pair left=helperDiameterTree(root.left);
        Pair right=helperDiameterTree(root.right);
        
        //longest dist between deepest nodes left and right subtree
        int dist=left.height+right.height+1;

        
        
        int diameter=Math.max(dist,Math.max(left.diameter,right.diameter));
        int height=1+Math.max(left.height,right.height);
        return new Pair(height,diameter);

    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
        if(root==null){
            return ;
        }
        
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            BinaryTreeNode<Integer>front=q.poll();
            System.out.print(front.data+":");
            if(front.left!=null){
                System.out.print("L:"+front.left.data+",");
                q.add(front.left);
            }
            else{
                 System.out.print("L:"+"-1"+",");
            
            }
            if(front.right!=null){
                System.out.println("R:"+front.right.data);
                q.add(front.right);
            }
            else{
             System.out.println("R:"+"-1");
               
            }
            
        }
        
		
	}


    public static BinaryTreeNode<Integer>helper(int[] pre, int presi, int preei, int[] in, int insi, int inei){
        
        if(preei<presi){
            
            return null;
        }
        BinaryTreeNode<Integer>root=null;
        int rootdata=pre[presi];
        if(rootdata!=-1){
            
            root= new BinaryTreeNode<>(rootdata);
        }
        
        int i;
        for(i=insi;i<=inei;i++){
            
            if(rootdata==in[i]){
                break;
            }
            
            
        }
    
        int leftpresi=presi+1;
      
        int leftinsi=insi;
        int leftinei=i-1;
        
        int rightpreei=preei;
        int rightinsi=i+1;
        int rightinei=inei;
        
        int len=leftinei-leftinsi+1;
    	int leftpreei=leftpresi+len-1;
        int rightpresi=leftpreei+1;  
        root.left=helper(pre,leftpresi,leftpreei,in,leftinsi,leftinei);
        root.right=helper(pre,rightpresi,rightpreei,in,rightinsi,rightinei);
        
        return root;
    
    }

	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre,
			int[] in){
		
        		return helper(pre,0,pre.length-1,in,0,in.length-1);
        }



        public static BinaryTreeNode<Integer>helper11(int post[],int postsi,int postei,int in[],int insi,int inei){
        
            if(postei<postsi){
                
                return null;
            }
            BinaryTreeNode<Integer>root=null;
            int rootdata=post[postei];
            if(rootdata!=-1){
                
                root=new BinaryTreeNode<Integer>(rootdata);
            }
            
            int i;
            for(i=insi;i<=inei;i++){
                
                if(rootdata==in[i]){
                    break;
                }
                
                
            }
       
            int leftpostsi=postsi;
          
            int leftinsi=insi;
            int leftinei=i-1;
            
            int rightpostei=postei-1;
            int rightinsi=i+1;
            int rightinei=inei;
            
            int len=leftinei-leftinsi+1;
            int leftpostei=leftpostsi+len-1;
            int rightpostsi=leftpostei+1;


            root.left=helper(post,leftpostsi,leftpostei,in,leftinsi,leftinei);
            root.right=helper(post,rightpostsi,rightpostei,in,rightinsi,rightinei);
            
            return root;
            
            
            
            
            
        }
        
        
    
        public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post,
                int[] in){
            
                    
                return helper11(post,0,post.length-1,in,0,in.length-1);
    
            
        }



        public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
            
            if(root==null){
                return ;
            }
            
           BinaryTreeNode<Integer>copy=new BinaryTreeNode<>(root.data);
           
               
            BinaryTreeNode<Integer>temp=root.left;
           
            root.left=copy;
            copy.left=temp;
          
            insertDuplicateNode(copy.left);
            insertDuplicateNode(root.right);
            
          
            
            
        }

}



	



