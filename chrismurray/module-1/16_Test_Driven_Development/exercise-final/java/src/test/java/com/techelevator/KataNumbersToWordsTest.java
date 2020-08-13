package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataNumbersToWordsTest {

	@Test
	public void numbers_less_than_20() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals("one", kntw.numberToWords(1));
		assertEquals("two", kntw.numberToWords(2));
		assertEquals("nine", kntw.numberToWords(9));
		assertEquals("ten", kntw.numberToWords(10));
		assertEquals("fourteen", kntw.numberToWords(14));
		assertEquals("nineteen", kntw.numberToWords(19));
	}

	@Test
	public void should_return_20_99() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals("twenty", kntw.numberToWords(20));
		assertEquals("twenty one", kntw.numberToWords(21));
		assertEquals("fifty two", kntw.numberToWords(52));
		assertEquals("ninety eight", kntw.numberToWords(98));
		assertEquals("ninety nine", kntw.numberToWords(99));
	}

	@Test
	public void should_return_100_999() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals("one hundred", kntw.numberToWords(100));
		assertEquals("one hundred one", kntw.numberToWords(101));
		assertEquals("five hundred fifty two", kntw.numberToWords(552));
		assertEquals("nine hundred ninety nine", kntw.numberToWords(999));
	}

	@Test
	public void should_return_over_1000() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals("one hundred twenty five thousand seven hundred ninety three", kntw.numberToWords(125793));
		assertEquals("one million", kntw.numberToWords(1000000));
		assertEquals("seven hundred million", kntw.numberToWords(700000000));
		assertEquals("nine hundred eighty seven million six hundred fifty four thousand three hundred twenty one",
				kntw.numberToWords(987654321));
		assertEquals("nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine",
				kntw.numberToWords(999999999));
	}

	@Test
	public void forgot_about_handling_zero() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals("zero", kntw.numberToWords(0));
	}

	@Test
	public void single_word_to_number() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals(1, kntw.wordsToNumber("one"));
		assertEquals(2, kntw.wordsToNumber("two"));
		assertEquals(9, kntw.wordsToNumber("nine"));
		assertEquals(10, kntw.wordsToNumber("ten"));
		assertEquals(14, kntw.wordsToNumber("fourteen"));
		assertEquals(19, kntw.wordsToNumber("nineteen"));
		assertEquals(20, kntw.wordsToNumber("twenty"));
		assertEquals(70, kntw.wordsToNumber("seventy"));
		assertEquals(90, kntw.wordsToNumber("ninety"));
	}

	@Test
	public void double_words_to_number() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals(21, kntw.wordsToNumber("twenty one"));
		assertEquals(25, kntw.wordsToNumber("twenty five"));
		assertEquals(66, kntw.wordsToNumber("sixty six"));
		assertEquals(77, kntw.wordsToNumber("seventy seven"));
	}

	@Test
	public void triple_words_to_number() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals(550, kntw.wordsToNumber("five hundred fifty"));
		assertEquals(101, kntw.wordsToNumber("one hundred one"));
		assertEquals(2012, kntw.wordsToNumber("two thousand twelve"));
		assertEquals(3000013, kntw.wordsToNumber("three million thirteen"));
		assertEquals(700000000, kntw.wordsToNumber("seven hundred million"));
	}

	@Test
	public void many_words_to_number() {
		KataNumbersToWords kntw = new KataNumbersToWords();
		assertEquals(125793, kntw.wordsToNumber("one hundred twenty five thousand seven hundred ninety three"));
		assertEquals(987654321, kntw.wordsToNumber(
				"nine hundred eighty seven million six hundred fifty four thousand three hundred twenty one"));
		assertEquals(999999999, kntw.wordsToNumber(
				"nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine"));
	}

}
