package test;

public class Check {

    public static void main(String[] args) {

        String arr[] = {"JSN|Fuse", "JSN|TransID101", "JSN|TransID102", "RECON_RESULT"};
        int count = 0;
        for (String obj : arr) {
            if (obj.equals("JSN|Fuse")) {

                System.out.println("In 1st case");
            } else if (obj.startsWith("JSN")) {
                count++;
            }
        }

        System.out.println("count:" + count);

    }

    


}
