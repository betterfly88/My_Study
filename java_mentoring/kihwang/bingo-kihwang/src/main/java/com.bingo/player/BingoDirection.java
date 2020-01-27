package com.bingo.player;

import java.util.ArrayList;
import java.util.List;

public enum BingoDirection {
	Diagonal{
		@Override
		List<MadedBingoInformation> check(int[][] bingoBoardForCheck) {
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
	},

	Vertical{
		@Override
		List<MadedBingoInformation> check(int[][] bingoBoardForCheck) {
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
	},

	Horizontal {
		@Override
		List<MadedBingoInformation> check(int[][] bingoBoardForCheck) {
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
	};

	abstract List<MadedBingoInformation> check(int [][] bingoBoardForCheck);
}
