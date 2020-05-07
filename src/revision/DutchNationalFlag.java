package revision;

public class DutchNationalFlag {

    // sort012 : first method is just count the freq of 0,1,2 and print;

    // method2

    public static void sort012(int arr[]) {

        int mid = 0, low = 0, high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 1) {
                mid++;

            } else if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                mid++;
                high--;
            }

        }

    }

}