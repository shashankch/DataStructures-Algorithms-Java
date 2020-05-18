package revision;

public class GenerateParanthesis {

    public static void generate(String str, int n, int i, int open, int close) {

        if (i == 2 * n) {
            System.out.println(str);
        }

        if (open < n) {
            generate(str + "(", n, i + 1, open + 1, close);
        }

        if (open > close) {
            generate(str + ")", n, i + 1, open, close + 1);
        }


    }

    public static void generateImp(String str, int n, int open, int close) {

        if (close == n) {
            System.out.println(str);

        }

        if (open < n) {
            generateImp(str + "(", n, open + 1, close);
        }
        if (open > close) {
            generateImp(str + ")", n, open, close + 1);
        }



    }

    public static void main(String[] args) {

        generate("", 5, 0, 0, 0);
        generateImp("", 5, 0, 0);
    }

}
