package arrays;

public class uniqueElement {


    public static int uniquehelper(int[] arr) {

        int pos = -1;
        boolean unique = true;
        int i, j;
        for (i = 0; i < arr.length; i++) {

            unique = true;
            for (j = 0; j < arr.length; j++) {


                if (i != j && arr[i] == arr[j]) {
                    unique = false;
                }


            }
            if (unique) {


                pos = i;
                break;

            }

        }



        return arr[pos];



    }


    public static int duplicatehelper(int[] arr) {

        int pos = -1;

        int i, j;
        for (i = 0; i < arr.length; i++) {


            for (j = 0; j < arr.length; j++) {


                if (i != j && arr[i] == arr[j]) {

                    pos = i;

                    break;

                }

            }
        }



        return arr[pos];

    }



    public static void main(String[] args) {

    }
}
