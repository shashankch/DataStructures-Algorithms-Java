package recursion;

public class ways {
	public static int helper(int input[], int target, int csum, int i) {


		if (i == input.length) {
			if (csum == target)
				return 1;
			else
				return 0;
		}


		//recursive calls

		//include element +
		int add = helper(input, target, csum + input[i], i + 1);


		//include element -
		int sub = helper(input, target, csum - input[i], i + 1);

		// not included

		int exc = helper(input, target, csum, i + 1);


		return add + sub + exc;


	}

	public static int numberOfWays(int[] input, int sum) {
		//Your Code goes here



		int ans= helper(input,sum,0,0);
		if(sum==0){
			return  ans-1;

		}

		else{
			return ans;
		}
	}

}
    
    
    
    
    
    
    
    

    
    