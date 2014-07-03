package palindrome;

// Project Euler 36

public class Palindrome {

	public static boolean isPalindrome(int n){
		boolean result = false;
		String num = Integer.toString(n);
		String revnum = new StringBuffer(num).reverse().toString();
		if (num.equals(revnum)){
			result = true;
		}
		return result;
	}
	
	public static String toBinary(int n) {
		String result;
		int newn;
		if (n == 0){
			return "";
		}
		if (n %2 == 1){
			result = "1";
			newn = (n-1)/2;
		} else {
			result = "0";
			newn = n/2;
		}
		return toBinary(newn) + result;
	}
	
	public static boolean isBinPal(String bin){
		boolean result = false;
		String revbin = new StringBuffer(bin).reverse().toString();
		if (bin.equals(revbin)){
			result = true;
		}
		return result;
	}
	
	public static boolean isDoubleBasePal(int n){
		boolean result = false;
		String bin = toBinary(n);
		if (isPalindrome(n) && isBinPal(bin)){
			result = true;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000000; i++){
			if (isDoubleBasePal(i)){
				sum += i;
			}
		}
		System.out.print(sum);
	}
}
