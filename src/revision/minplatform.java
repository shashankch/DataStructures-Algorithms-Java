package revision;

import java.util.Arrays;

public class minplatform {

    public static void method1(int arr[], int dep[]) { // O(N^2)

        int mx = 1, platform = 1, n = arr.length;

        for (int i = 0; i < n; i++) {

            platform = 1;
            for (int j = i + 1; j < n; j++) {

                // check for overlap if if arrival of any train lies btw another train
                // time interval check both ways.

                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])) {
                    platform++;
                }

            }

            mx = Math.max(mx, platform);

        }
        System.out.println(mx);
    }

    public static void method2(int arr[], int dep[]) { // O(NlogN + N)

        Arrays.sort(arr);
        Arrays.sort(dep);

        // here it is similar to merging two sorted array...

        int i = 1, j = 0;
        int platform = 1, mx = 1;
        int n = arr.length;
        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            }

            else if (arr[i] > dep[j]) {
                platform--;
                j++;
            }

            mx = Math.max(mx, platform);
        }

        System.out.println(mx);
    }

    public static void method3(int arr[], int dep[]) {

        int platform = 1;
        int time[] = new int[2361];
        int mx = 0;
        // in a day max time is 2360.
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // inc for arrival and dec for departure.

            time[arr[i]]++;

            time[dep[i] + 1]--;
        }

        for (int i = 1; i < 2361; i++) {
            time[i] = time[i] + time[i - 1];
            mx = Math.max(platform, time[i]);
        }

        System.out.println(mx);

    }

}