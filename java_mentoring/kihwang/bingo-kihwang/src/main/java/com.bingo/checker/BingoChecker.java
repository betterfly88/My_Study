package com.bingo.checker;

import java.util.ArrayList;

import com.bingo.player.BingoDirection;
import com.bingo.player.MadedBingoInformation;

public class BingoChecker {
	
	public static ArrayList<MadedBingoInformation> bingoChecker(int[][] bingoBoardForCheck) {
		ArrayList<MadedBingoInformation> madedBingoList = new ArrayList<MadedBingoInformation>();
		madedBingoList.addAll(checkDiagonal(bingoBoardForCheck));
		madedBingoList.addAll(checkHorizontal(bingoBoardForCheck));
		madedBingoList.addAll(checkVertical(bingoBoardForCheck));
		
		return madedBingoList;
		
	}
	
	public static ArrayList<MadedBingoInformation> checkDiagonal(int[][] bingoBoardForCheck) {
		ArrayList<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();
	
		int leftDiagonal = 0;
		int rightDiagonal = 0;

		for (int i = 0; i < bingoBoardForCheck.length; i++) {
			if (bingoBoardForCheck[i][i] == 1) {
				leftDiagonal++;
			}
			if (bingoBoardForCheck[bingoBoardForCheck.length - 1 - i][1] == 1) {
				rightDiagonal++;
			}
		}

		if (leftDiagonal == bingoBoardForCheck.length) {
			madedBingoInfomationList.add(new MadedBingoInformation(BingoDirection.Diagonal,1));
		}
		if (rightDiagonal == bingoBoardForCheck.length) {
			madedBingoInfomationList.add(new MadedBingoInformation(BingoDirection.Diagonal,2));
		}

		return madedBingoInfomationList;
	}
	
	public static ArrayList<MadedBingoInformation> checkHorizontal(int[][] bingoBoardForCheck) {
		
		ArrayList<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();

		for (int i = 0; i < bingoBoardForCheck[0].length; i++) {
			int isChecked = 0;

			for (int j = 0; j < bingoBoardForCheck[0].length; j++) {
				if (bingoBoardForCheck[i][j] == 1) {
					isChecked++;
				}
			}

			if (isChecked == bingoBoardForCheck.length) {
				madedBingoInfomationList.add(new MadedBingoInformation(BingoDirection.Horizontal,i+1));
			}
		}

		return madedBingoInfomationList;
	}

	public static ArrayList<MadedBingoInformation> checkVertical(int[][] bingoBoardForCheck) {
		
		ArrayList<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();

		for (int i = 0; i < bingoBoardForCheck[0].length; i++) {
			int isChecked = 0;

			for (int j = 0; j < bingoBoardForCheck[0].length; j++) {
				if (bingoBoardForCheck[j][i] == 1) {
					isChecked++;
				}
			}

			if (isChecked == bingoBoardForCheck.length) {
				madedBingoInfomationList.add(new MadedBingoInformation(BingoDirection.Vertical,i+1));
			}
		}

		return madedBingoInfomationList;
	}


}
