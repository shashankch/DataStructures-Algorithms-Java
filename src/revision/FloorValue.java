package revision;

public class FloorValue {

    public static int helper(int array[], int element, int in, int mx) {

        if (in == array.length) {
            return mx;
        }

        if (array[in] <= element && array[in] > mx) {
            mx = array[in];
        }

        return helper(array, element, in + 1, mx);

    }


    public static int findFloor(int[] array, int element) {


        int ans = helper(array, element, 0, Integer.MIN_VALUE);
        return ans;


    }

    public static void main(String[] args) {

    }

}
