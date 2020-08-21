package Prep;

public class specialPalindrome {


    public static int helper(String str) {


        // for all same character

        int n = str.length();
        int i = 0;


        int sameChar[] = new int[n];
        int result = 0;
        while (i < n) {

            int j = i + 1;

            int count = 1;
            while (j < n && str.charAt(i) == str.charAt(j)) {

                j++;
                count++;
            }

            result += (count * (count + 1) / 2);
            sameChar[i] = count;

            i = j;


        }

        for (int k = 0; k < n; k++) {

            System.out.println(sameChar[k]);
        }

        // for odd length mid char is different

        // stored count of occurence of char for each index

        for (int j = 1; j < n; j++) {


            // check if prev char is same then assign same freq.

            if (str.charAt(j) == str.charAt(j - 1)) {
                sameChar[j] = sameChar[j - 1];
            }
            // check for each char if prev and next are equal then take min freq.
            // middle should be different..
            if (j > 0 && j < (n - 1) && str.charAt(j - 1) == str.charAt(j + 1)
                    && str.charAt(j) != str.charAt(j - 1)) {

                result += Math.min(sameChar[j - 1], sameChar[j + 1]);
            }


        }

        // remove single chars substring..
        // return result-n; else below return
        return result;



    }



    public static void main(String[] args) {

        int ans = helper("mnonopoO");
        System.out.println("ans:" + ans);

    }
}
