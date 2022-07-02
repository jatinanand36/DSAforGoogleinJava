package string;

import java.util.Scanner;

public class NinjaOperation {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.next();
//	Boolean isPalindrome = checkPalindromI(s);
//	System.out.println("Is palindrom : "+ isPalindrome);
	int ans = 0;
	int length = s.length();
	for(int i = length ; i >= 2; i--) {
		if(checkPalindromR(s.substring(0, i))) {
//			System.out.println("True");
			break;
		} else {
//			System.out.println("False");
			ans++;
		}
	}
	System.out.println("Ans "+ans);
}

private static Boolean checkPalindromI(String s) {
	// TODO Auto-generated method stub
	int l = s.length();
    String reverse = "";
	for(int i =l -1; i >= 0; i--) {
		reverse = reverse + s.charAt(i) + "";
	}
//	System.out.println("Reverse "+reverse);
//	System.out.println("Main "+ s);
	return reverse.equalsIgnoreCase(s);
}

private static Boolean checkPalindromR(String s) {
	// TODO Auto-generated method stub

	int l = s.length();
	if(l ==0) {
		return true;
	}
	return checkP(s,0,l-1);
//    String reverse = "";
//	for(int i =l -1; i >= 0; i--) {
//		reverse = reverse + s.charAt(i) + "";
//	}
//	System.out.println("Reverse "+reverse);
//	System.out.println("Main "+ s);
//	return reverse.equalsIgnoreCase(s);
}

private static Boolean checkP(String s, int i, int j) {
	// TODO Auto-generated method stub
	if(i == j) {
		return true;
	}
	if((s.charAt(i)) != (s.charAt(j))) {
		return false;
	}
	if(i<j+1) {
		return checkP(s, i+1, j-1);
	}
	return true;
}

}
