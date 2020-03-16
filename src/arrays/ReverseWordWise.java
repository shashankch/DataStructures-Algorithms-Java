package arrays;

public class ReverseWordWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String input="Welcome to Coding Ninjas";
		  int n=input.length();
	        
	        int start=0;
	        String rev="";
	        for(int i=0;i<n;i++){
	            
	            
	            if(input.charAt(i)==' ' || i==input.length()-1){
	            
	            	if(i==input.length()-1) {
	            		int end=input.length();
	            		 String temp=input.substring(start,end);
	            		rev=temp+" "+rev;
	 	                
	            	}
	            	else {
	            		int end=i-1;
	            		 String temp=input.substring(start,end+1);
	            		rev=temp+" "+rev;
	 	                start=i+1;
	            		
	            	}
	               
	               
	               
	              
	                
	            }
	         
	           
	            
	            
	        }
	        
	       System.out.println(rev);
		
		
		
	}

}
