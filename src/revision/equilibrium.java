package revision;

public class equilibrium {

    public static void method1(int arr[]) { // O(N)

        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i]; // here sum represents the right sum
        }

        int left = 0; // left sum..
        for (int i = 0; i < n; i++) {
            sum -= arr[i];

            if (left == sum) {
                System.out.println(i);
                break;
            }
            left += arr[i];
        }

    }

    public static void method2(int arr[]) // O(N^2)
    {

        int n = arr.length;
        int left, right;
        for (int i = 0; i < n; i++) {

            left = 0;
            for (int j = 0; j < i; j++) {
                left += arr[j];
            }

            right = 0;
            for (int j = i + 1; j < n; j++) {
                right += arr[j];
            }

            if (left == right) {
                System.out.println(i);
                break;
            }

        }

    }

    public static void main(String[] args) {

    }

}