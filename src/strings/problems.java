package strings;

public class problems {

    public static String reverseWordWise(String input) {
         int n=input.length();

        int start=0;
        String rev="";
        for(int i=0;i<n;i++){


            if(input.charAt(i)==' ' || i==input.length()-1){

                if(i==input.length()-1) {
                    int end=input.length();
                    String temp=input.substring(start,end);
                    rev=temp+" "+rev;

                }
                else {
                    int end=i-1;
                    String temp=input.substring(start,end+1);
                    rev=temp+" "+rev;
                    start=i+1;

                }

            }

        }

        return rev;

    }

    public static boolean isPermutation(String input1, String input2) {

        int n=input1.length();
        int m=input2.length();
        int freq[]=new int[256];
        if(n!=m){
            return false;
        }

        for(int i=0;i<n;i++){


            freq[(int)input1.charAt(i)]++;


        }
         for(int i=0;i<m;i++){


            freq[(int)input2.charAt(i)]--;


        }

        for(int i=0;i<256;i++){


            if(freq[i]!=0){

                return false;
            }


        }

        return true;

    }

    public static String removeConsecutiveDuplicates(String input) {

        int n=input.length();

        String ans="";

        for(int i=0;i<n;i++){
         while(i+1<n && input.charAt(i)==input.charAt(i+1)){
                i++;
            }

            ans+=input.charAt(i);


        }

        return ans;

    }

    public static String reverseEachWord(String input) {
        int n=input.length();

        int start=0;
        String rev="";
        for(int i=0;i<n;i++){


            if(input.charAt(i)==' ' || i==input.length()-1){

                if(i==input.length()-1) {
                    int end=input.length();
                    String temp="";
                    for(int k=end-1;k>=start;k--){

                        temp+=input.charAt(k);

                    }


                    rev+=temp+" ";


                }
                else {
                    int end=i-1;
                    String temp="";
                    for(int k=end;k>=start;k--){

                        temp+=input.charAt(k);

                    }

                    rev+=temp+" ";
                    start=i+1;

                }

            }

        }

        return rev;

    }

    public static String removeAllOccurrencesOfChar(String input, char c) {

        int n=input.length();

        String ans="";
        for(int i=0;i<n;i++){

            if(input.charAt(i)!=c){

                ans+=input.charAt(i);

            }

        }
     return ans;

    }

    public static char highestOccuringCharacter(String inputString) {

        int n=inputString.length();

        int freq[]=new int[256];


        for(int i=0;i<n;i++){

            freq[(int)inputString.charAt(i)]++;

        }

        int max=Integer.MIN_VALUE;
        int pos=-1;
        for(int i=0;i<256;i++){

            if(freq[i]!=0){

                if(freq[i]>=max){

                    max=freq[i];
                    pos=i;
                }

            }



        }


        return (char)pos;

    }



    public static String compress(String inputString) {
        String ans="";
        int n=inputString.length();
        for(int i=0;i<n;i++){

            int cnt=1;
            while( i+1<n && inputString.charAt(i)==inputString.charAt(i+1) )
            {


                cnt++;
                i++;
            }

            ans+=inputString.charAt(i);
            if(cnt!=1)
                ans+=cnt;

        }

        return ans;


    }

}
