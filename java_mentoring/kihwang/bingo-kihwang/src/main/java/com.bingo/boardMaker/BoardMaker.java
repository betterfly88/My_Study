package com.bingo.boardMaker;

import java.util.ArrayList;

import com.bingo.numberPicker.NumberPicker;

public class BoardMaker {
	
	public static void main(String[] args) {
		int[][] tester =  bingoBoardMaker(100,5);
	}
	
	public static int[][] bingoBoardMaker(int maximumNumberRange, int boardSize){
		int[][] bingoBoard = new int[boardSize][boardSize];
		ArrayList<Integer> numbersForBoard = NumberPicker.numberSequenceMaker(maximumNumberRange, boardSize*boardSize);
		int indexMarker = 0;
		for(int i=0;i<bingoBoard[0].length;i++) {
			for(int j=0;j<bingoBoard[0].length;j++) {
				bingoBoard[i][j]=numbersForBoard.get(indexMarker);
				System.out.print(numbersForBoard.get(indexMarker)+",");
				indexMarker++;
			}
			System.out.println();
		}
		System.out.println();

		return bingoBoard;
	}
}
