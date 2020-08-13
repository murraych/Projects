package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataRomanNumerals {

	private String[] thousandRoman = new String[] { "", "M", "MM", "MMM" };
	private String[] hundredRoman = new String[] { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	private String[] tenRoman = new String[] { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	private String[] oneRoman = new String[] { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

	public String arabicToRoman(int arabicNum) {
		String romanNum = "";
		romanNum += thousandRoman[arabicNum / 1000];
		arabicNum %= 1000;
		romanNum += hundredRoman[arabicNum / 100];
		arabicNum %= 100;
		romanNum += tenRoman[arabicNum / 10];
		arabicNum %= 10;
		romanNum += oneRoman[arabicNum];
		return romanNum;
	}

	// Step 2: Write a function to convert in the other direction from Roman Numeral to digit.
	public int romanToArabic(String str) {
		Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		int arabicNum = 0;
		char lastCharKey = 'M';
		for (int i = 0; i < str.length(); i++) {
			char charKey = str.charAt(i);
			arabicNum += romanMap.get(charKey);
			if (romanMap.get(lastCharKey) < romanMap.get(charKey)) {
				arabicNum -= 2 * romanMap.get(lastCharKey);
			}
			lastCharKey = charKey;
		}
		return arabicNum;
	}

}

// The following is an interesting alternative solution from a TE student, Liel.
// She uses enums rather than arrays.
//
//public class KataRomanNumerals {
//
//	public static String convertToRomanNumerals(int decimalNumber) {
//		// Example #1
//		// x = 36
//		// Iteration # Decimal number x Highest decimal value v Highest roman numeral (n) Temporary result
//		// 1 36 10 X X
//		// 2 26 10 X XX
//		// 3 16 10 X XXX
//		// 4 6 5 V XXXV
//		// 5 1 1 I XXXVI
//		String result= "";
//		while (decimalNumber >0){
//			for(RomanNumerals romanNumeral : RomanNumerals.values()){
//				if (decimalNumber>=romanNumeral.getNumber()){
//					decimalNumber -= romanNumeral.getNumber();
//					result += romanNumeral.name();
//					break;
//				}
//			}
//		}
//		return result;
//	}
//
//	private enum RomanNumerals {
//		M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40),
//		X(10), IX(9), V(5), IV(4), I(1) ;
//		// Decimal value v Roman numeral (n)
//		// 1 I
//		// 4 IV
//		// 5 V
//		// 9 IX
//		// 10 X
//		// 40 XL
//		// 50 L
//		// 90 XC
//		// 100 C
//		// 400 CD
//		// 500 D
//		// 900 CM
//		// 1000 M
//		private int number;
//		private RomanNumerals(int number) {
//			this.number = number;
//		}
//		public int getNumber() {
//			return number;
//		}
//	}
//}
