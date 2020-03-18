package fundamentals;

public class Rotatearray {

	public static void rotate(int[] arr, int d) {

		int i = 0;
		while (i < d) {

			int temp = arr[0];
			int j = 1;
			for (; j < arr.length; j++) {

				arr[j - 1] = arr[j];

			}

			arr[j - 1] = temp;

			i++;
		}

	}

	public static void rotate2(int[] arr, int d) {

		int n = arr.length;
		int temp[] = new int[d];
		for (int i = 0; i < d; i++) {

			temp[i] = arr[i];
		}

		for (int i = 0; i < n - d; i++) {

			arr[i] = arr[i + d];

		}
		int k = 0;
		for (int i = n - d; i < n; i++) {

			arr[i] = temp[k++];

		}

	}

	public static void rotate3(int arr[], int d) {

		int n = arr.length - 1;
		// reverse the entire array..
		for (int i = 0; i < n / 2; i++) {

			int temp = arr[i];
			arr[i] = arr[n - i];
			arr[n - i] = temp;
		}

		// reverse the n-d part of the array.
		for (int i = 0; i < (n - d) / 2; i++) {

			int temp = arr[i];
			arr[i] = arr[n - d - i];
			arr[n - d - i] = temp;

		}

		// reverse last d elements of the array..
		int l = n - d + 1;

		for (int i = 0; i < d / 2; i++) {

			int temp = arr[l];
			arr[l] = arr[n];
			arr[n] = temp;
			l++;
			n--;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 2;

		rotate3(arr, d);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
