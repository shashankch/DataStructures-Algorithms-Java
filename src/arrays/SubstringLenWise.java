package arrays;

public class SubstringLenWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "pqrs";
		int n = str.length();

		for (int len = 1; len <= n; len++) {

			for (int start = 0; start <= n - len; start++) {

				int end = start + len - 1;

				System.out.println(str.substring(start, end + 1));

			}

		}

	}

}
