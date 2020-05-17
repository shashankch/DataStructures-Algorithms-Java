package revision;


class PetrolPump {

    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {

        this.petrol = petrol;
        this.distance = distance;
    }

}


public class circularTour {


    // In this ques we are given pairs {petrol pump capacity,dist to next pump}
    // find the index of pump from where truck can complete entire circle.
    // pump are at dist in circular dist. and truck has infinite capacity.



    public static int findstart(PetrolPump arr[]) {

        int start = 0;
        int end = 1;

        int n = arr.length;
        int currPetrol = arr[start].petrol - arr[start].distance;

        while (end != start || currPetrol < 0) {


            while (currPetrol < 0 && end != start) {

                currPetrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;

                if (start == 0) {
                    return -1;
                }

            }

            currPetrol += arr[end].petrol - arr[end].distance;
            end = (end + 1) % n;


        }

        return start;

    }

    public static void main(String[] args) {

        PetrolPump arr[] = {new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3)};
        System.out.println(findstart(arr));

    }

}
