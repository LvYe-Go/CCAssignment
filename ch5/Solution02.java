package ch5;

public class Solution02 {
    final static double eps = 1e-8; // double compare
    /**
     * Method: Reducing from the biggest bit presenting double 0.5
     * and test whether the left is bigger than it. 
     * @param args
     * 
     * Time: O(n) (n here is the bits number of num)
     * Space: O(1) No extra space used 
     */
	public static void main(String[] args) {
		double num = 0.72; 
		System.out.println("The present of " + num +" is: " + printBinary(num));
	}
	
	public static String  printBinary(double num){
		if(num >= 1 || num <= 0) {  //corner cases 
			return "ERROR";
		}
		double frac = 0.5;  //  biggest bit presenting double 0.5 
		StringBuilder res = new StringBuilder();
		res.append(".");
		while(num - 0 > eps) {
			if(res.length() > 32) return "ERROR"; // the length is too long 
			if(num >= frac){
				res.append(1);  // if can be present in this bit. append 1 
				num -= frac; 
			}else{
				res.append(0);  
			}
			frac /= 2; // reducing
		}
		return res.toString();
	}
}
