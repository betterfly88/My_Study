package com.bingo.boardChecker;

public class BoardMarker {
	public static int[][] boardChecker (int[][] bingoBoard, int[] markingPosition){
		
		if(markingPosition.length==2) {
			bingoBoard[markingPosition[0]][markingPosition[1]] = 1;
			System.out.print("???? ");
			System.out.print(markingPosition[0]+1);
			System.out.print(" ??° ???? ");
			System.out.print(markingPosition[1]+1);
			System.out.println("??° ??? ?????");
		}
		else {
			System.out.println("????? ????? ????");
		}
		//aa
		
		return bingoBoard;
	}
	
	public static int[] bingoBoardMarker(int pickNumber, int[][] bingoBoard) {
		int[] markingPosition = {};
		for(int i=0;i<bingoBoard[0].length;i++) {
			for(int j=0;j<bingoBoard[0].length;j++) {
				if(pickNumber==bingoBoard[i][j]) {
					markingPosition = new int[]{i,j};
				}
			}
		}
		return markingPosition;
	}
}
