package strings;

import java.util.Scanner;

public class ConvertIntoPalindrome {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        
        Scanner sc=new Scanner(System.in);
        
       String  number=sc.next();
        int k=sc.nextInt();
        
        StringBuffer temp=new StringBuffer(number);
        
        
        // first to check all the changes required.
        
          int start=0,end=number.length()-1;
        
        while(start<end){
            
            
            if(number.charAt(start)!=number.charAt(end)) {
                
                
                if(number.charAt(start)>number.charAt(end)){
                    
                    temp.setCharAt(start,number.charAt(start));
                     temp.setCharAt(end,number.charAt(start));
                }
                else{
                     temp.setCharAt(start,number.charAt(end));
                     temp.setCharAt(end,number.charAt(end));
                }
                
                
                k--;
            }
            
            
            start++;
            end--;
            
        }
        
        
        if(k<0){
            
            System.out.print("NOT POSSIBLE");
        }
        
        else{
          //  System.out.print
            int low=0;
            int high=number.length()-1;
            
            
            while(low<=high){
                
                
                if(low==high && k>0){
                    
                    
                    temp.setCharAt(low,'9');
                    
                }
                
                
                if(temp.charAt(low)<'9'){
                    
                    
                    if(k>=2 && ((number.charAt(low)==temp.charAt(low)) && (number.charAt(high)==temp.charAt(high))) ) {
                        
                         temp.setCharAt(low,'9');
                     temp.setCharAt(high,'9');
                        
                        
                        k-=2;
                    }
                    
                       else if(k>=1  && ((number.charAt(low)==temp.charAt(low)) || (number.charAt(high)==temp.charAt(high)) ) ){
                                
                         temp.setCharAt(low,'9');
                     temp.setCharAt(high,'9');
                               
                             k--;  
                           }
                           
                           
                    }
                
                
                low++;
                high--;
                
                }
             System.out.print(temp);
            
            }
        
        
       
        
        
        

	}

}