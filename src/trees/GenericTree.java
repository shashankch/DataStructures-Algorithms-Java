package trees;

import java.util.LinkedList;
import java.util.Queue;

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


    public static SecondMax findSecondLargest(GenericTreeNode<Integer> root){

        if(root==null){

            SecondMax res=new SecondMax();
            res.first=null;
            res.second=null;

        }

        SecondMax out=new SecondMax();
        out.first=root;
        out.second=null;

        for(GenericTreeNode<Integer>child:root.children){

            SecondMax pair=findSecondLargest(child);
            // pair > root
            if(pair.first.data>out.first.data) {

                //pair second is null
                if (pair.second == null || pair.second.data < out.first.data) {

                    out.first = pair.first;
                    out.second = out.first;
                } else {

                    out.first = pair.first;
                    out.second = pair.second;
                }
            }
            // when pair and out is equal..
            else if(pair.first.data.equals(out.first.data) &&
                    pair.second!=null){
                if(out.second==null || pair.second.data>out.second.data){
                    out.second=pair.second;
                }

            }

            //for second max. check if not equal to curr max and check currsecond<pair first
            else if(pair.first.data!=out.first.data &&
                        (out.second==null || out.second.data<pair.first.data))

                out.second=pair.first;

            }
        return out;
        }


    public static GenericTreeNode<Integer> findNextLargerNode(GenericTreeNode<Integer> root, int n){

        if(root==null){
            return null;
        }

        GenericTreeNode<Integer> next=null;
        if(root.data>n){
            next=root;
        }

        for(GenericTreeNode<Integer> child: root.children){

            GenericTreeNode<Integer> nextpair=findNextLargerNode(child,n);
            if(nextpair!=null){
                if(next==null || next.data>nextpair.data ){
                    next=nextpair;
                }
            }
        }

        return next;
    }


    public static boolean checkIdentical(GenericTreeNode<Integer> root1, GenericTreeNode<Integer> root2){

        if(root1==null && root2==null){
            return true;
        }
        if(root1==null|| root2==null){
            return false;
        }
        if(!root1.data.equals(root2.data)){
            return false;
        }
        if(root1.children.size()!=root2.children.size()){

            return false;
        }
        for(int i=0;i<root1.children.size();i++){

            if(!checkIdentical(root1.children.get(i),root2.children.get(i))){
                return false;
            }

        }

        return true;
    }

//node having sum of children and node is max..
    public static MaxNode maxSumNode(GenericTreeNode<Integer> root){

        if(root==null){
            MaxNode pp=new MaxNode();
            pp.node=null;
            pp.sum=Integer.MIN_VALUE;
            return pp;
        }

        int sum=root.data;
        for(GenericTreeNode<Integer> child: root.children) {
            sum+=child.data;
        }
        MaxNode res=new MaxNode();
        res.node=root;
        res.sum=sum;

            for(GenericTreeNode<Integer> child: root.children){

                MaxNode nextpair=maxSumNode(child);
            if(nextpair.sum>res.sum){
                res=nextpair;
            }
        }

        return res;
    }

    public static int getHeight(GenericTreeNode<Integer> root){

        if(root==null){
            return 0;
        }
        int height=0;
        for(GenericTreeNode<Integer>child:root.children){

            int childHeight=getHeight(child);
            if(childHeight>height){
                height=childHeight;
            }

        }

        return height+1;

    }



    public static int numNodeGreaterX(GenericTreeNode<Integer> root,int x){
        int count=0;
        if(root==null){
            return 0;
        }
        if(root.data>x){
            count++;
        }
        for(GenericTreeNode<Integer>child:root.children){
                count+=numNodeGreaterX(child,x);
        }

        return count;

    }


    public static void printLevelWise(GenericTreeNode<Integer> root) {

        if(root==null){
            return ;
        }

        Queue<GenericTreeNode<Integer>> q=new LinkedList<>();
        GenericTreeNode<Integer> nullNode=new GenericTreeNode<>(Integer.MIN_VALUE);

        q.add(root);
        q.add(nullNode);
        System.out.println(root.data);

        while(!q.isEmpty()){

                GenericTreeNode<Integer> temp=null;
                try{
                }
                catch(Exception e){

                }
                if(temp==nullNode){
                    q.add(nullNode);
                    System.out.println();
                    continue;
                }

                for(GenericTreeNode<Integer> child:temp.children){
                    System.out.println(child.data);
                    q.add(child);
                }
        }
        }


    }

class SecondMax{

    GenericTreeNode<Integer> first;
    GenericTreeNode<Integer> second;

    SecondMax(){

    }


        }
class MaxNode{

    GenericTreeNode<Integer> node;
int sum;

    MaxNode(){

    }


}