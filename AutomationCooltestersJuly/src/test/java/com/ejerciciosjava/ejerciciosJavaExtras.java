package com.ejerciciosjava;

public class ejerciciosJavaExtras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(isLeapYear(1700));// false
//		System.out.println(isLeapYear(1600));
//		System.out.println(isLeapYear(-1600));// false
//		System.out.println(isLeapYear(2017)); // false
//		System.out.println(isLeapYear(2000));
//		System.out.println(isLeapYear(2020));

//		System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
//		System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));
//		System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
//		System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));

		System.out.println(areEqualByThreeDecimalPlaces2(-3.1756, -3.175));
		System.out.println(areEqualByThreeDecimalPlaces2(3.175, 3.176));
		System.out.println(areEqualByThreeDecimalPlaces2(3.0, 3.0));
		System.out.println(areEqualByThreeDecimalPlaces2(-3.123, 3.123));
		
//		printMegaBytesAndKiloBytes(2500);
//		printMegaBytesAndKiloBytes(5000);

//		System.out.println(getDaysInMonth(1, 2020));
//		System.out.println(getDaysInMonth(2, 2020));
//		System.out.println(getDaysInMonth(2, 2018));
//		System.out.println(getDaysInMonth(-1, 2020));
//		System.out.println(getDaysInMonth(1, -2020));
	}

	static boolean isLeapYear(int year) {

		if (year >= 1 && year <= 9999) {
			if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
				return true;
			}
		}
		return false;
	}// corchete final isleapyear

	static boolean areEqualByThreeDecimalPlaces(double x, double y) {

		String x1 = Double.toString(x), y1 = Double.toString(y), aux1, aux2, aux3, aux4;
		int punto = x1.indexOf('.'), punto2 = y1.indexOf('.');
		aux1 = x1.substring(0, punto);
		aux2 = x1.substring(punto);
		aux3 = y1.substring(0, punto2);
		aux4 = y1.substring(punto2);

		if (aux2.length() > 4 || aux4.length() > 4) {
			aux2 = aux2.substring(0, 4);
			aux4 = aux4.substring(0, 4);
		}

		while (aux2.length() < 4) {
			aux2 += "0";
		}
		while (aux4.length() < 4) {
			aux4 += "0";
		}

		x1 = aux1 + "" + aux2;
		y1 = aux3 + "" + aux4;
		System.out.println(x1);
		System.out.println(y1);

		if (x1.equals(y1)) {
			return true;
		}
		return false;

	}// corchete final areEqualbyThreeDecimalPlaces

	static boolean areEqualByThreeDecimalPlaces2(double x, double y) {
		x = x * 1000;
		y = y * 1000;
		if ((int) x == (int) y) {
			return true;
		} else {
			return false;
		}
	}

	static void printMegaBytesAndKiloBytes(int KyloBytes) {

		if (KyloBytes < 0) {
			System.out.println("Invalid value");
		}

		System.out.println(KyloBytes + " KB = " + (KyloBytes / 1024) + " MB and " + KyloBytes % 1024 + " KB");

	}// corchete final printMegaBytesAndKiloBytes

	static int getDaysInMonth(int month, int year) {
		int Days = 0;
		if ((month < 1 || month > 12) || (year < 1 || year > 9999)) {
			return -1;
		}

		switch (month) {
		case 2:
			if (isLeapYear(year)) {
				Days = 29;
				break;
			} else {
				Days = 28;
				break;
			}
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			Days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			Days = 30;
			break;
		default:
			break;
		}
		return Days;

	}

}
