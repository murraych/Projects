package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataStringCalculatorTest {

	@Test
	public void basic_string_calculator() {
		KataStringCalculator ksc = new KataStringCalculator();
		assertEquals("KataStringCalculator.add(\"\")", 0, ksc.add("")); // Empty
		assertEquals("KataStringCalculator.add(\"86834\")", 86834, ksc.add("86834")); // One number
		assertEquals("KataStringCalculator.add(\"86834,12388934\")", 12475768, ksc.add("86834,12388934")); // Two numbers
		assertEquals("KataStringCalculator.add(\"86834,12388934,1\")", 12475769, ksc.add("86834,12388934,1")); // Three numbers
	}

	@Test
	public void step_2_unlimited_numbers_string_calculator() {
		KataStringCalculator ksc = new KataStringCalculator();
		assertEquals("KataStringCalculator.add(\"86834,12388934,1,1\")", 12475770, ksc.add("86834,12388934,1,1")); // Step 2, unlimited
		assertEquals("KataStringCalculator.add(\"1,2,3,4,5,6,7,8,9,10\")", 55, ksc.add("1,2,3,4,5,6,7,8,9,10")); // Step 2, unlimited
	}

	@Test
	public void step_3_newline_or_comma_string_calculator() {
		KataStringCalculator ksc = new KataStringCalculator();
		assertEquals("KataStringCalculator.add(\"86834\\n12388934,1\\n1\")", 12475770, ksc.add("86834\n12388934,1\n1")); // Step 3, 2 newline
		assertEquals("KataStringCalculator.add(\"86834,12388934\\n1,1\")", 12475770, ksc.add("86834,12388934\n1,1")); // Step 3, 1 newline
		assertEquals("KataStringCalculator.add(\"86834\\n12388934\\n1\\n1\")", 12475770,
				ksc.add("86834\n12388934\n1\n1")); // Step 3, 3 newline
	}

	@Test
	public void step_4_different_delimiter_string_calculator() {
		KataStringCalculator ksc = new KataStringCalculator();
		assertEquals("KataStringCalculator.add(\"//!\\n1\\n1!2!3!4\")", 10, ksc.add("//!\n1!2!3!4")); //Step 4, ! delimiter
		assertEquals("KataStringCalculator.add(\"//!\\n1\\n1\\n2!3\\n4\")", 10, ksc.add("//!\n1\n2!3\n4")); //Step 4, ! delimiter, mixed
	}

}
