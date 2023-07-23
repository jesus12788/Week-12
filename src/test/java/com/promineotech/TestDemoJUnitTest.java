package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
	}

	@ParameterizedTest
	//Might need to add package below
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
		
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		
		return Stream.of(
			arguments(2, 4, 6, false),
			arguments(10, 10, 20, false),
			arguments(-2, 2, 0, true),
			arguments(-2, -2, -4, true),
			arguments(0, 10, 10, true)
			
		);
		
	}
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	/*
	 * My created Test
	 * Passed in 2 for int a and 4 for int b and should be equal to 8 because 2 x 4 = 8. 
	 * Test ran and passed. The Test assures that if the code is changed in TestDemo.java for the method
	 * (multiply) then the J Unit test will fail. 
	 */
	@Test
	//My created Test
	void assertThatPairsAreMulipliedCorrectly() {
		
		assertThat(testDemo.multiply(2, 4)).isEqualTo(8);
	/*
	 * 
	 */
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	

}
