package arrays;
import java.util.Arrays;

public class PairSum {
	public static void pairSum(int[] arr, int num){
		
        Arrays.sort(arr);
        
        int l=0,h=arr.length-1;
        
        while(l<h){
            
            
            if(arr[l]+arr[h]==num){
                
                int end=h;
               while(arr[l]+arr[end--]==num){
                  System.out.println(arr[l]+" "+arr[h]);
               }
               l++;
                
                
            }
            else if(arr[l]+arr[h]>num){
                
                h--;
               
                
                
            }
            
            else {
                
                l++;
            }
            
            
            
            
            
        }
        
        
        
	}
}
