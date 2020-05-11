package revision;





public class arbnextincreasingnode {


	public static ListNode<Integer> findmid(ListNode<Integer> start) {

		if (start == null) {
			return null;
		}



		ListNode<Integer> slow = start;
		ListNode<Integer> fast = start.arbitrary;

		while (fast != null && fast.arbitrary != null) {

			slow = slow.arbitrary;
			fast = fast.arbitrary.arbitrary;

		}


		return slow;

	}

	public static ListNode<Integer> merge(ListNode<Integer> a, ListNode<Integer> b) {

		ListNode<Integer> head = new ListNode<Integer>(0);
		ListNode<Integer> h = head;

		while (a != null && b != null) {

			if (a.data < b.data) {

				head.arbitrary = a;
				a = a.arbitrary;
			} else {
				head.arbitrary = b;
				b = b.arbitrary;
			}

			head = head.arbitrary;

		}

		if (a == null) {
			head.arbitrary = b;
		}
		if (b == null) {
			head.arbitrary = a;
		}

		return h.arbitrary;



	}


	public static ListNode<Integer> merge2(ListNode<Integer> a, ListNode<Integer> b) {


		if (a == null) {
			return b;

		}

		if (b == null) {
			return a;
		}

		ListNode<Integer> head = null;

		if (a.data <= b.data) {


			head = a;

			head.arbitrary = merge(a.arbitrary, b);



		}

		else {

			head = b;
			head.arbitrary = merge(a, b.arbitrary);

		}

		return head;



	}



	public static ListNode<Integer> sort(ListNode<Integer> head) {

		if (head == null || head.arbitrary == null) {
			return head;
		}


		ListNode<Integer> mid = findmid(head);
		ListNode<Integer> second = mid.arbitrary;

		mid.arbitrary = null;


		ListNode<Integer> l = sort(head);
		ListNode<Integer> r = sort(second);



		return merge(l, r);



	}

	public static ListNode<Integer> method(ListNode<Integer> head) {

		ListNode<Integer> temp = head;

		while (temp != null) {

			temp.arbitrary = temp.next;
			temp = temp.next;


		}

		ListNode<Integer> ans = sort(head);

		return ans;



	}


}

