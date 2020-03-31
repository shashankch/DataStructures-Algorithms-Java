package arrays;

public class insertion {

    public static void main(String[] args) {

        int arr[] = { 2, 3, 434, 22, 422, 44, 111 };

        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {

                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }

        }

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int curr = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > curr; j--) {

                arr[j + 1] = arr[j];

            }

            arr[j + 1] = curr;

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}