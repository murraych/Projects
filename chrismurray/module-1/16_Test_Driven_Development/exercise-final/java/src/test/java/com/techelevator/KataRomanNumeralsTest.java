package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataRomanNumeralsTest {

	@Test
	public void single_roman_numerals_1s_5s() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals("I", krn.arabicToRoman(1));
		assertEquals("V", krn.arabicToRoman(5));
		assertEquals("X", krn.arabicToRoman(10));
		assertEquals("L", krn.arabicToRoman(50));
		assertEquals("C", krn.arabicToRoman(100));
		assertEquals("D", krn.arabicToRoman(500));
		assertEquals("M", krn.arabicToRoman(1000));
	}

	@Test
	public void double_roman_numerals_2s_4s_6s_9s_11s() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals("II", krn.arabicToRoman(2));
		assertEquals("IV", krn.arabicToRoman(4));
		assertEquals("VI", krn.arabicToRoman(6));
		assertEquals("IX", krn.arabicToRoman(9));
		assertEquals("XI", krn.arabicToRoman(11));
		assertEquals("XX", krn.arabicToRoman(20));
		assertEquals("XL", krn.arabicToRoman(40));
		assertEquals("LX", krn.arabicToRoman(60));
		assertEquals("XC", krn.arabicToRoman(90));
		assertEquals("CX", krn.arabicToRoman(110));
		assertEquals("CC", krn.arabicToRoman(200));
		assertEquals("CD", krn.arabicToRoman(400));
		assertEquals("DC", krn.arabicToRoman(600));
		assertEquals("CM", krn.arabicToRoman(900));
		assertEquals("MC", krn.arabicToRoman(1100));
		assertEquals("MM", krn.arabicToRoman(2000));
	}

	@Test
	public void triple_roman_numerals_3s_7s() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals("III", krn.arabicToRoman(3));
		assertEquals("VII", krn.arabicToRoman(7));
		assertEquals("XXX", krn.arabicToRoman(30));
		assertEquals("LXX", krn.arabicToRoman(70));
		assertEquals("CCC", krn.arabicToRoman(300));
		assertEquals("DCC", krn.arabicToRoman(700));
		assertEquals("MMM", krn.arabicToRoman(3000));
	}

	@Test
	public void quadruple_roman_numerals_8s() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals("VIII", krn.arabicToRoman(8));
		assertEquals("LXXX", krn.arabicToRoman(80));
		assertEquals("DCCC", krn.arabicToRoman(800));
	}

	@Test
	public void assorted_roman_numerals() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals("MCCLIII", krn.arabicToRoman(1253));
		assertEquals("DCCXXIV", krn.arabicToRoman(724));
		assertEquals("MMCMXCIX", krn.arabicToRoman(2999));
		assertEquals("III", krn.arabicToRoman(3));
		assertEquals("LXVII", krn.arabicToRoman(67));
	}

	// Step 2: Tests for the new romanToArabic method
	@Test
	public void single_letter_roman_numerals() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals(1, krn.romanToArabic("I"));
		assertEquals(5, krn.romanToArabic("V"));
		assertEquals(10, krn.romanToArabic("X"));
		assertEquals(50, krn.romanToArabic("L"));
		assertEquals(100, krn.romanToArabic("C"));
		assertEquals(500, krn.romanToArabic("D"));
		assertEquals(1000, krn.romanToArabic("M"));
	}

	@Test
	public void double_letter_roman_numerals() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals(2, krn.romanToArabic("II"));
		assertEquals(4, krn.romanToArabic("IV"));
		assertEquals(6, krn.romanToArabic("VI"));
		assertEquals(9, krn.romanToArabic("IX"));
		assertEquals(11, krn.romanToArabic("XI"));
		assertEquals(20, krn.romanToArabic("XX"));
		assertEquals(40, krn.romanToArabic("XL"));
		assertEquals(60, krn.romanToArabic("LX"));
		assertEquals(90, krn.romanToArabic("XC"));
		assertEquals(110, krn.romanToArabic("CX"));
		assertEquals(200, krn.romanToArabic("CC"));
		assertEquals(400, krn.romanToArabic("CD"));
		assertEquals(600, krn.romanToArabic("DC"));
		assertEquals(900, krn.romanToArabic("CM"));
		assertEquals(1100, krn.romanToArabic("MC"));
		assertEquals(2000, krn.romanToArabic("MM"));
	}

	@Test
	public void triple_letter_roman_numerals() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals(3, krn.romanToArabic("III"));
		assertEquals(7, krn.romanToArabic("VII"));
		assertEquals(30, krn.romanToArabic("XXX"));
		assertEquals(70, krn.romanToArabic("LXX"));
		assertEquals(300, krn.romanToArabic("CCC"));
		assertEquals(700, krn.romanToArabic("DCC"));
		assertEquals(3000, krn.romanToArabic("MMM"));
	}

	@Test
	public void quadruple_letter_roman_numerals() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals(8, krn.romanToArabic("VIII"));
		assertEquals(80, krn.romanToArabic("LXXX"));
		assertEquals(800, krn.romanToArabic("DCCC"));
	}

	@Test
	public void various_roman_numerals() {
		KataRomanNumerals krn = new KataRomanNumerals();
		assertEquals(1253, krn.romanToArabic("MCCLIII"));
		assertEquals(724, krn.romanToArabic("DCCXXIV"));
		assertEquals(2999, krn.romanToArabic("MMCMXCIX"));
		assertEquals(3, krn.romanToArabic("III"));
		assertEquals(67, krn.romanToArabic("LXVII"));
	}

}
