
package arrays;

public class sort01 {

    
    public static void helper2(int[] arr) {
        

        int l = 0;
        int h = arr.length - 1;

        while (l < h) {


            if (arr[l] == 0) {
                l++;
            } else if (arr[h] == 1) {
                h--;
            } else if (arr[l] == 1 && arr[h] == 0) {

                int temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
            }



        }

    }

public static void main(String[] args) {
    

    int arr[]={0,1,1,0,1,0,1};
    int n=7;


    int zero=0,curr=0;
    while(curr<n){

        if(arr[curr]==0){
            int temp=arr[curr];
            arr[curr]=arr[zero];
            arr[zero]=temp;
            zero++;
        }

        curr++;
    }

    for(int i=0;i<n;i++){
        
        System.out.println(arr[i]);
    }



}









}