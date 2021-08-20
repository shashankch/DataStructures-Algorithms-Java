package hashmaps;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class problems {



    public static String recurr(int num, int den) {

        HashMap<Integer,Integer>mp=new HashMap<>();

        int rem=num%den;

        String res="";

        while(rem!=0 && mp.containsKey(rem)==false){


            mp.put(rem,rem);

            rem*=10;

            res+=(rem/den);

            rem=rem%den;



        }

        return rem==0?"":res;
    }

    public static String findDif(String str){

        String res="";
        for(int i=1;i<str.length();i++){

            int diff=str.charAt(i)-str.charAt(i-1);
            if(diff<0){
                diff+=26;
            }

            res+=(diff+'a');

        }


        return res;



    }

    public static void grouping(String[] arr, int n) {

        HashMap<String,ArrayList<String> >mp=new HashMap<>();

        for(int i=0;i<arr.length;i++){

            String diff=findDif(arr[i]);
            // System.out.println(diff);
            if(mp.containsKey(diff)){

                ArrayList<String>temp=mp.get(diff);
                temp.add(arr[i]);
                mp.put(diff,temp);
            }
            else{

                ArrayList<String>temp=new ArrayList<>();
                temp.add(arr[i]);
                mp.put(diff,temp);
            }

        }

        for(Map.Entry<String,ArrayList<String> >entry:mp.entrySet()){

            ArrayList<String> temp=entry.getValue();

            for(int i=0;i<temp.size();i++){

                System.out.print(temp.get(i)+" ");
            }

            System.out.println();
        }


    }

    public static boolean ispairexist(int[] arr, int n, int k) {


        if(n%2!=0){

            return false;
        }



        HashMap<Integer,Integer>mp=new HashMap<>();

        for(int i=0;i<n;i++){

            int mod=arr[i]%k;
            if(mp.containsKey(mod)){

                mp.put(mod,mp.get(mod)+1);

            }
            else{
                mp.put(mod,1);
            }

        }


        for(int i=0;i<n;i++){

            int mod=arr[i]%k;

            if(mod==0){

                if(mp.get(mod)%2!=0){
                    return false;
                }

            }

            else if(2*mod==k){

                if(mp.get(mod)%2!=0){
                    return false;
                }
            }

            else{
                if(mp.get(k-mod)!=mp.get(mod)){
                    return false;
                }

            }

        }

        return true;

    }

    public static void itineary(HashMap<String, String> input) {

        HashMap<String,String>rev=new HashMap<>();


        for(Map.Entry<String,String>entry:input.entrySet()){

            rev.put(entry.getValue(),entry.getKey());


        }

        String start="";
        for(Map.Entry<String,String>entry:input.entrySet()){

            if(!rev.containsKey(entry.getKey())){

                start=entry.getKey();
                break;
            }


        }

        while(input.containsKey(start)==true){

            System.out.println(start+" -> "+input.get(start));

            start=input.get(start);

        }

    }
}
