package revision;

public class InternetAddress {

    public static void solution(String str) {

        String res = "";
        int index = 0;
        if (str.charAt(0) == 'h') {

            res += "http://";
            index = 4;

        } else {
            res += "ftp://";
            index = 3;
        }

        int pos = -1;
        for (int i = str.length() - 2; i >= index; i--) {

            if (str.charAt(i) == 'r' && str.charAt(i + 1) == 'u') {
                pos = i;

            }
        }
        if (pos >= 0 && pos < str.length()) {
            res += str.substring(index, pos);

            if (pos == str.length() - 2) {
                res += ".ru/";
            } else {
                res += ".ru/";
                res += str.substring(pos + 2);
            }


        }

        System.out.println(res);


    }

    public static void main(String[] args) {

        solution("httpsunrux");
    }
}
