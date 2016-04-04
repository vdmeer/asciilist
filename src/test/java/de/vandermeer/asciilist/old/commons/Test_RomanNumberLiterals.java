/* Copyright 2015 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.asciilist.old.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.vandermeer.asciilist.old.commons.RomanNumberLiterals;

/**
 * Tests for {@link RomanNumberLiterals}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public class Test_RomanNumberLiterals {

	@Test
	public void test_Integer_2_Roman(){
		//TODO
	}

	@Test
	public void test_Roman_2_EnumAr_1(){
		RomanNumberLiterals[] ar;

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(1));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.I, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(2));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.II, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(3));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.III, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(4));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.IV, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(5));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.V, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(6));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.VI, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(7));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.VII, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(8));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.VIII, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(9));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.IX, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(10));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.X, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(11));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.XI, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(12));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.XII, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(50));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.L, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(100));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.C, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(500));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.D, ar[0]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(1000));
		assertEquals(1, ar.length);
		assertEquals(RomanNumberLiterals.M, ar[0]);
	}

	@Test
	public void test_Roman_2_EnumAr_N(){
		RomanNumberLiterals[] ar;

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(13));
		assertEquals(4, ar.length);
		assertEquals(RomanNumberLiterals.X, ar[0]);
		assertEquals(RomanNumberLiterals.I, ar[1]);
		assertEquals(RomanNumberLiterals.I, ar[2]);
		assertEquals(RomanNumberLiterals.I, ar[3]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(14));
		assertEquals(3, ar.length);
		assertEquals(RomanNumberLiterals.X, ar[0]);
		assertEquals(RomanNumberLiterals.I, ar[1]);
		assertEquals(RomanNumberLiterals.V, ar[2]);

		ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(20));
		assertEquals(2, ar.length);
		assertEquals(RomanNumberLiterals.X, ar[0]);
		assertEquals(RomanNumberLiterals.X, ar[1]);
	}

	@Test
	public void test_Ascci7_Visual(){
		System.out.println(RomanNumberLiterals.toAscii(1));
		System.out.println(RomanNumberLiterals.toAscii(2));
		System.out.println(RomanNumberLiterals.toAscii(3));
		System.out.println(RomanNumberLiterals.toAscii(4));
		System.out.println(RomanNumberLiterals.toAscii(5));
		System.out.println(RomanNumberLiterals.toAscii(6));
		System.out.println(RomanNumberLiterals.toAscii(7));
		System.out.println(RomanNumberLiterals.toAscii(8));
		System.out.println(RomanNumberLiterals.toAscii(9));
		System.out.println(RomanNumberLiterals.toAscii(10));
		System.out.println(RomanNumberLiterals.toAscii(11));
		System.out.println(RomanNumberLiterals.toAscii(12));

		System.out.println(RomanNumberLiterals.toAscii(13));
		System.out.println(RomanNumberLiterals.toAscii(14));
		System.out.println(RomanNumberLiterals.toAscii(20));
	}

	@Test
	public void test_Ascci7LC_Visual(){
		System.out.println(RomanNumberLiterals.toAsciiLC(1));
		System.out.println(RomanNumberLiterals.toAsciiLC(2));
		System.out.println(RomanNumberLiterals.toAsciiLC(3));
		System.out.println(RomanNumberLiterals.toAsciiLC(4));
		System.out.println(RomanNumberLiterals.toAsciiLC(5));
		System.out.println(RomanNumberLiterals.toAsciiLC(6));
		System.out.println(RomanNumberLiterals.toAsciiLC(7));
		System.out.println(RomanNumberLiterals.toAsciiLC(8));
		System.out.println(RomanNumberLiterals.toAsciiLC(9));
		System.out.println(RomanNumberLiterals.toAsciiLC(10));
		System.out.println(RomanNumberLiterals.toAsciiLC(11));
		System.out.println(RomanNumberLiterals.toAsciiLC(12));
	
		System.out.println(RomanNumberLiterals.toAsciiLC(13));
		System.out.println(RomanNumberLiterals.toAsciiLC(14));
		System.out.println(RomanNumberLiterals.toAsciiLC(20));
	}

	@Test
	public void test_NumberForms_Visual(){
		System.out.println(RomanNumberLiterals.toNumberForms(1));
		System.out.println(RomanNumberLiterals.toNumberForms(2));
		System.out.println(RomanNumberLiterals.toNumberForms(3));
		System.out.println(RomanNumberLiterals.toNumberForms(4));
		System.out.println(RomanNumberLiterals.toNumberForms(5));
		System.out.println(RomanNumberLiterals.toNumberForms(6));
		System.out.println(RomanNumberLiterals.toNumberForms(7));
		System.out.println(RomanNumberLiterals.toNumberForms(8));
		System.out.println(RomanNumberLiterals.toNumberForms(9));
		System.out.println(RomanNumberLiterals.toNumberForms(10));
		System.out.println(RomanNumberLiterals.toNumberForms(11));
		System.out.println(RomanNumberLiterals.toNumberForms(12));

		System.out.println(RomanNumberLiterals.toNumberForms(13));
		System.out.println(RomanNumberLiterals.toNumberForms(14));
		System.out.println(RomanNumberLiterals.toNumberForms(20));
	}

	@Test
	public void test_NumberFormsLC_Visual(){
		System.out.println(RomanNumberLiterals.toNumberFormsLC(1));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(2));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(3));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(4));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(5));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(6));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(7));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(8));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(9));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(10));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(11));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(12));

		System.out.println(RomanNumberLiterals.toNumberFormsLC(13));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(14));
		System.out.println(RomanNumberLiterals.toNumberFormsLC(20));
	}

	@Test
	public void test_CircledLatinCaptial_Visual(){
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(1));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(2));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(3));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(4));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(5));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(6));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(7));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(8));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(9));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(10));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(11));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(12));

		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(13));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(14));
		System.out.println(RomanNumberLiterals.toCircledLatinCaptial(20));
	}

	@Test
	public void test_CircledLatinSmall_Visual(){
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(1));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(2));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(3));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(4));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(5));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(6));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(7));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(8));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(9));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(10));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(11));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(12));

		System.out.println(RomanNumberLiterals.toCircledLatinSmall(13));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(14));
		System.out.println(RomanNumberLiterals.toCircledLatinSmall(20));
	}

}
