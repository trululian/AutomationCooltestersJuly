package com.ejerciciosjava;

public class ejerciciosJavaExtras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isLeapYear(1700));// false
		System.out.println(isLeapYear(1600));
		System.out.println(isLeapYear(-1600)); // false
		System.out.println(isLeapYear(2017)); // false
		System.out.println(isLeapYear(2000));
	}

	static boolean isLeapYear(int year) {

		if (year >= 1 && year <= 9999) {
			if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
				return true;
			}
		}
		return false;
	}

}
