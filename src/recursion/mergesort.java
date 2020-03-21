
package recursion;

public class mergesort{


    public static void merge(int arr[],int brr[],int dest[]){
        
    }

    public static void mergesortfun(int arr[]){


        if(arr.length<=1) return ;

        int brr[]=new int [arr.length/2];
        int crr[]=new int[arr.length-brr.length];

        for(int i=0;i<arr.length/2;i++){
            brr[i]=arr[i];
        }

        for(int i=arr.length/2;i<arr.length;i++){

            crr[i-arr.length/2]=arr[i];

        }

        mergesortfun(brr);
        mergesortfun(crr);
        merge(brr,crr,arr);




    }













public static void main(String[] args) {
    
}












}