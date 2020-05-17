package revision;

// https://leetcode.com/problems/k-th-symbol-in-grammar/
public class KthSymbolGram {

    // here logic involves finding the parent in the previous row.
    // look this ques. in term of tree node with left child at(2*i+1 odd)
    // and right child at (2*i+2 even) .
    // now if k is odd it will be left child of prev row node parent and otherwise right child
    // if 0 then 01 and if 1 then 10 now find the parent node and then check if 1 or 0.

    public static int method(int n, int k) {

        if (n == 1 && k == 1) {
            return 0;
        }

        int prevRowParent = method(n - 1, (k + 1) / 2);
        if ((k % 2 == 0 && prevRowParent == 0) || (k % 2 == 1 && prevRowParent == 1)) {
            return 1;
        }

        return 0;

    }

    public static void main(String[] args) {

        System.out.println(method(5, 4));
    }

}
