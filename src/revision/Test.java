package revision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

  

// •      dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
// •                ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
// •                ["Quesadilla", "Chicken", "Cheese", "Sauce"],
// •                ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]    



public static int helper(int arr[],int x,int l,int h){
    
    //out of bound
    if(l>h){
        
        return 0;
    }
    
    //not possible
    if(x<0){
        
        return -1;
    }
    
    if (x == 0) {
    
        return 1;
    }
    
    int waysleft = 0;
    int waysright=0;
    if(arr[l]<=x){
        
        waysleft+= helper(arr,x-arr[l],l+1,h);  //o
    }
    
    else if(arr[h]<=x){
        
        waysright+=helper(arr,x-arr[h],l,h-1);  //1
    }
    
    
    System.out.println("left:"+waysleft+"righ:"+waysright);
    return Math.min(waysleft,waysright);
    
}

  
public static int ways(int arr[], int x) {


    return helper(arr, x, 0, arr.length - 1);

}
 


    public static void main(String[] args) {




        int arr[] = {1, 1, 4, 2, 3};

        System.out.println(ways(arr,5));



    }



}


