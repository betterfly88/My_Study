package com.bingo.numberPicker;

import java.util.ArrayList;

public class NumberPicker {

	public static int randomNumberPicker(int range) {

		int pick = (int) (Math.random() * range)+1;
		
		return pick;
	}

	public static ArrayList<Integer> numberSequenceMaker(int numberRange, int needNumberSize) {
		ArrayList<Integer> numberingList = new ArrayList<Integer>();
		while (numberingList.size() < needNumberSize) {
			int pick = randomNumberPicker(numberRange);
			if(!isAlreadyPickedNumber(pick, numberingList)) {
				numberingList.add(pick);
			}
		}
		return numberingList;
	}

	private static boolean isAlreadyPickedNumber(int numberForCheck, ArrayList<Integer> alreadyNumberingList) {
		boolean result = false;

		for (int alreadyNumbering : alreadyNumberingList) {
			if (numberForCheck == alreadyNumbering) {
				result = true;
				break;
			}
		}

		return result;
	}

}
