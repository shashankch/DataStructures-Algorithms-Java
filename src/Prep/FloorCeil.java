package Prep;

public class FloorCeil {


    // binary search approach

    // other
    public static void helper(int arr[], int x) {


        int fInd = -1, cInd = -1;
        int n = arr.length;

        int fDist = Integer.MAX_VALUE, cDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (arr[i] >= x && cDist > (arr[i] - x)) {
                cInd = i;
                cDist = arr[i] - x;
            }


            if (arr[i] <= x && fDist > (x - arr[i])) {
                fInd = i;
                fDist = x - arr[i];
            }
        }

        System.out.println("floor" + arr[fInd] + "  ceil" + arr[cInd]);
    }

    public static void main(String[] args) {



    }

}
