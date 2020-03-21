package recursion;

public class quicksort{



    public static int partition(int arr[],int s,int e){

        int pivotelement=arr[s];
        int count=0;
        for(int i=s+1;i<=e;i++){

            if(arr[i]<pivotelement){
                count++;
            }
        }

        // swap the pivot to the right position..
        int temp=arr[s+count];
        arr[s+count]=pivotelement;
        arr[s]=temp;

        int p=s;
        int q=e;

        while(p<q){

                
            if(arr[p]<pivotelement){

                p++;

            }
            else if(arr[q]>=pivotelement){
                q--;
            }

            else{

                int t=arr[p];
                arr[p]=arr[q];
                arr[q]=t;
                p++;
                q--;

            }
        }



        return count+s;


    }




    public static void quicksortfun(int arr[],int s,int e){


        if(s>=e){
            return ;
        }

        int pivot=partition(arr,s,e);
        quicksortfun(arr, s, pivot-1);
        quicksortfun(arr, pivot+1, e);






    }












    public static void main(String[] args) {




        int arr[]={10,2,3,1,56,23,44,12,3,6,22};

        quicksortfun(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        
    }













}