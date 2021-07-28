package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTApp2 {

    public static PairAns minMax(BinaryTreeNode<Integer> root) {
	
        if(root==null){
            
            PairAns ans=new PairAns();
            ans.min=Integer.MAX_VALUE;
            ans.max=Integer.MIN_VALUE;
            
            return ans;
        }
        
        PairAns left=minMax(root.left);
        PairAns right=minMax(root.right);
        
        int max=Math.max(root.data,Math.max(left.max,right.max));
        int min=Math.min(root.data,Math.min(left.min,right.min));
        
        PairAns res=new PairAns();
        res.min=min;
        res.max=max;
        
        return res;

	}

    public static void printLevelWise(BinaryTreeNode<Integer> root){
	
        if(root==null){
            return ;
        }
        
        Queue<BinaryTreeNode<Integer>>q=new LinkedList<BinaryTreeNode<Integer>>();
        
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            
            BinaryTreeNode<Integer>front=q.poll();
            
            if(front==null){
                
               if(q.isEmpty()){
                   break;
               } 
            	q.add(null);
               System.out.println(); 
              
                
            }
            else{
             System.out.print(front.data+" "); 
             if(front.left!=null){
                q.add(front.left);
            }
             if(front.right!=null){
                q.add(front.right);
            }
            
            
            }
            
            
        }

    }


    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer>root,int k,String str){
        
        
        if(root==null){
            return;
        }
    
    if(root.left==null && root.right==null && root.data==k){
        
        str+=root.data;
        System.out.println(str);
        str="";
        
    }
    
    rootToLeafPathsSumToK(root.left,k-root.data,str+root.data+" ");
    rootToLeafPathsSumToK(root.right,k-root.data,str+root.data+" ");
  
}


public static void inOrderwithoutRecursionwithStack(BinaryTreeNode<Integer> root) {
  
    Stack<BinaryTreeNode<Integer>> stk=new Stack<BinaryTreeNode<Integer>>();
   
    BinaryTreeNode<Integer>curr=root;
    while(!stk.isEmpty() || curr!=null){
        
        while(curr!=null){
        stk.push(curr);
        
        curr=curr.left;
        }
        
            curr=stk.pop();
            System.out.print(curr.data+" ");
        
                curr=curr.right;
              
         
    }
  
}



public static BinaryTreeNode<Integer>findinorderPred(BinaryTreeNode<Integer>root){
            
    BinaryTreeNode<Integer> temp=root.left;
    //BinaryTreeNode<Integer> prev=null;
    while(temp.right!=root && temp.right!=null){
        
      //  prev=temp;
        temp=temp.right;
    }
    

    return temp;

}


public static void inOrderWithoutRecursionwithoutStack(BinaryTreeNode<Integer> root) {

BinaryTreeNode<Integer>curr=root;

while(curr!=null){
    
    
    if(curr.left==null){
        
        System.out.print(curr.data+" ");
        curr=curr.right;
    }
    else{
    BinaryTreeNode<Integer> inpred=findinorderPred(curr);
    
    if(inpred.right==null){
        
        inpred.right=curr;
        curr=curr.left;
        
    }
    else{
        
        inpred.right=null;
        System.out.print(curr.data+" ");
        curr=curr.right;
        
    }
    
}

}

}

public static void preOrder(BinaryTreeNode<Integer> root) {
    //Write your code here
    
    BinaryTreeNode<Integer>curr=root;
    
    while(curr!=null){
        
        
        if(curr.left==null){
            
            System.out.print(curr.data+" ");
            curr=curr.right;
            
        }
        else{
        
        BinaryTreeNode<Integer>temp=curr.left;
        while(temp.right!=null && temp.right!=curr){
            
            temp=temp.right;
        }
        
        
        if(temp.right==null){
             System.out.print(curr.data+" ");
            temp.right=curr;
            curr=curr.left;
        }
        else{
            
            temp.right=null;
            curr=curr.right;
            
        }
        
        }   
    }
}


public static void IterativepostOrder(BinaryTreeNode<Integer> root) {
    
    Stack<BinaryTreeNode<Integer>> helper=new Stack<>();
    Stack<BinaryTreeNode<Integer>> post=new Stack<>();
    
    helper.push(root);
   
    while(!helper.isEmpty()){
        
        
            
            BinaryTreeNode<Integer> temp=helper.pop();
         post.push(temp);
             
            if(temp.left!=null){
                
                
                helper.push(temp.left);
            }
        
        if(temp.right!=null){
                helper.push(temp.right);
            }
           
                
            
            }
    
    
        while(!post.isEmpty()){
            
           BinaryTreeNode<Integer> temp=post.peek();
            System.out.print(temp.data+" ");
            post.pop();
        }
    
    }


    public static int helpindex=0;
    	public static BinaryTreeNode<Integer> helper(int preor[],char preorLN[],int n,BinaryTreeNode<Integer>root){
            	
            	int index=helpindex;
            	
            		if(index==n){
                        
                        return null;
                    }
        
             root=new BinaryTreeNode<>(preor[index]);
            helpindex++;
            if(preorLN[index]=='N'){
                    
                  root.left=helper(preor,preorLN,n,root.left);
                    
                    root.right=helper(preor,preorLN,n,root.right);
                }
            
           
        
            
            	
           	return root;	
            
            
        }


        public static void helper(BinaryTreeNode<Integer>root,int matrix[][],int len){
             
            if(root==null){
                return;
            }
           
           helper(root.left,matrix,len);
           helper(root.right,matrix,len);
            
            
            if(root.left!=null)
            {
                
                
                matrix[root.data][root.left.data]=1;
                
                for(int j=0;j<len;j++){
                    
                    if(matrix[root.left.data][j]==1){
                        matrix[root.data][j]=1;
                    }
                }
                
                
                
                
            }
            
            if(root.right!=null){
                
                 
                matrix[root.data][root.right.data]=1;
                
                for(int j=0;j<len;j++){
                    
                    if(matrix[root.right.data][j]==1){
                        matrix[root.data][j]=1;
                    }
                }
                
                
                
                
            }
            
            
        }
    
    	public static int length(BinaryTreeNode<Integer>root){
            
            if(root==null){
                
                return 0;
            }
            
            return 1+length(root.left)+length(root.right);
            
            
            
            
        }
        public static void ancestor(BinaryTreeNode<Integer> root, int[][] matrix) {
            
        	int len=length(root);
           helper(root,matrix,len);
           
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            
            
            
            
        }
    


}
    

