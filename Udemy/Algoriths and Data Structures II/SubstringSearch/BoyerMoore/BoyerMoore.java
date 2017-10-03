package BoyerMoore;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {

	private Map<Character, Integer> mismatchShiftsTable;
	private String text;
	private String pattern;

	public BoyerMoore(String text, String pattern) {
		this.pattern = pattern;
		this.text = text;
		this.mismatchShiftsTable = new HashMap<>();
	}

	public void precomputeShifts() {

		int lengthOfPattern = this.pattern.length();

		for (int index = 0; index < lengthOfPattern; index++) {
			char actualCharacter = this.pattern.charAt(index);
			int maxShift = Math.max(1, lengthOfPattern - index - 1);
			this.mismatchShiftsTable.put(actualCharacter, maxShift);
		}
	}

	public boolean search() {

		int lengthOfPattern = this.pattern.length();
		int lengthOfText = this.text.length();
		int numOfSkips;

		for (int i = 0; i <= lengthOfText - lengthOfPattern; i += numOfSkips) {

			numOfSkips = 0;

			for (int j = lengthOfPattern - 1; j >= 0; j--) {
				if (pattern.charAt(j) != text.charAt(i + j)) {

					if ( this.mismatchShiftsTable.get(pattern.charAt(j)) != null ) {
						numOfSkips = this.mismatchShiftsTable.get(pattern.charAt(j));
						break;
					} else {
						numOfSkips = lengthOfPattern;
						break;
					}
				}
			}

			if (numOfSkips == 0) return true;
		}

		return false;
	}
}
