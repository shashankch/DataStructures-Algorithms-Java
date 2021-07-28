package strings;

public class KMPSearch
{

    public static boolean search(String str,String pat){

        int n=str.length();
        int m=pat.length();

        int lps[]=new int[m];

        computeLPS(pat,m,lps);

        int i=0,j=0;

        while(i<n){

            if(str.charAt(i)==pat.charAt(j)){

                i++;
                j++;

            }
            if(j==m){
                return true;
            }
            else if(i<n && str.charAt(i)!=pat.charAt(j)){

                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }

            }



        }

        return false;


    }

    public static void computeLPS(String pat,int m,int[] lps){

        int i=1,j=0;
        lps[0]=0;
        while(i<m){

            if(pat.charAt(i)==pat.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    lps[i]=j;
                    i++;
                }
            }


        }

    }



}
