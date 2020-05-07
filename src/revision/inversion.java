package revision;

public class inversion {

    // inversion count represents how far array from being sorted..
    // inversion count of sorted array=0

    public static void method1(int arr[]) { // O(N^2) approach..

        int n = arr.length;
        int icount = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {
                    icount++;
                }

            }
        }

        System.out.println(icount);

    }

    // here this method uses the merge sort method..

    public static int merge(int arr[], int temp[], int low, int mid, int high) {

        int i = low, k = low, j = mid;
        int icount = 0;
        while (i <= mid - 1 && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                icount += (mid - i);
            }

        }

        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (i = low; i <= high; i++) {
            arr[i] = temp[i];
        }

        return icount;

    }

    // here first find left and right part icount and then merge icount..
    // for merge icount check if a of i > a of j where i<j then icount=mid-i.
    // here pass the temp array for merge copy of the left and right part.
    public static int method2(int arr[], int temp[], int low, int high) {

        int icount = 0;

        if (low < high) {

            int mid = (low + high) / 2;

            icount += method2(arr, temp, low, mid);
            icount += method2(arr, temp, mid + 1, high);

            icount += merge(arr, temp, low, mid + 1, high);

        }

        return icount;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 20, 6, 4, 5 };
        int temp[] = new int[arr.length];
        int icount = method2(arr, temp, 0, arr.length - 1);

        System.out.println(icount);
    }

}