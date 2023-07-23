package com.promineotech;

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		
		if(a > 0 && b > 0) {
			
		} else if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
			
		}
		return a + b;
			
		
	}
	/*
	 * My created method
	 * created a method named multiply. It takes two int parameters and returns a product.
	 */
	public int multiply(int a , int b) {
		return a * b;
	}
	
	public int randomNumberSquared() {
		return getRandomInt() * getRandomInt();
		
	}
	
	public int getRandomInt() {
		Random random = new Random();
		
		return random.nextInt(10) + 1;
	}
}
