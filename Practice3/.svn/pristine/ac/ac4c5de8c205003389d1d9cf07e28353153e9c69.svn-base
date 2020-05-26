package ua.nure.filonitch.practice3;

public class Part5 {
	public static final int TEST_NUMBER = 18;
	private static final String[] romanSymbols = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	private static final int[] arabicSymbols = { 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	public static final int FIFTY = 50;
	public static final int HUNDRED = 100;

	public static void main(String[] args) {

		System.out.println(decimal2Roman(TEST_NUMBER));
		System.out.println(roman2Decimal("XCVIII"));
	}

	public static String decimal2Roman(int aNumber) {
		StringBuilder strbuild = new StringBuilder();
		int de;
		int indexOfnum = 0;
		while (indexOfnum < arabicSymbols.length) {
			de = aNumber / arabicSymbols[indexOfnum];
			for (int k = 0; k < de; k++) {
				strbuild.append(romanSymbols[indexOfnum]);
			}
			aNumber -= de * arabicSymbols[indexOfnum];
			indexOfnum++;
		}
		return strbuild.toString();
	}

	public static int roman2Decimal(java.lang.String romanNumber) {
		int dec = 0;
		int lastNum = 0;
		String romanNum = romanNumber;
		for (int m = romanNum.length() - 1; m >= 0; m--) {
			char convertToDecimal = romanNum.charAt(m);

			switch (convertToDecimal) {
			case 'I':
				dec = processOfDecimal(1, lastNum, dec);
				lastNum = 1;
				break;

			case 'V':
				dec = processOfDecimal(5, lastNum, dec);
				lastNum = 5;
				break;

			case 'X':
				dec = processOfDecimal(10, lastNum, dec);
				lastNum = 10;
				break;

			case 'L':
				dec = processOfDecimal(FIFTY, lastNum, dec);
				lastNum = FIFTY;
				break;

			case 'C':
				dec = processOfDecimal(HUNDRED, lastNum, dec);
				lastNum = HUNDRED;
				break;
			default:
				break;
			}
		}
		return dec;
	}

	public static int processOfDecimal(int dec, int lastNum, int lastDec) {
		if (lastNum > dec) {
			return lastDec - dec;
		} else {
			return lastDec + dec;
		}
	}
}
