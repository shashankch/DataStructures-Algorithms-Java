package fundamentals;

public class Output {

	public static int func(int a) {
		a += 10;
		return a;
	}

	public static void main(String[] args) {
		int a = 5;
		func(a);
		System.out.println(a);

		int arr[];
		arr = new int[32];

		System.out.println(arr[2]);

	}

}
