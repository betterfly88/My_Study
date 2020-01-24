package player;

import java.util.ArrayList;

public class Player {
	String name;
	int [][] bingoBoard;
	int [][] bingoBoardForCheck;
	ArrayList<MadedBingoInformation> madedBingoList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[][] getBingoBoard() {
		return bingoBoard;
	}
	public void setBingoBoard(int[][] bingoBoard) {
		this.bingoBoard = bingoBoard;
	}
	public int[][] getBingoBoardForCheck() {
		return bingoBoardForCheck;
	}
	public void setBingoBoardForCheck(int[][] bingoBoardForCheck) {
		this.bingoBoardForCheck = bingoBoardForCheck;
	}
	public ArrayList<MadedBingoInformation> getMadedBingoList() {
		return madedBingoList;
	}
	public void setMadedBingoList(ArrayList<MadedBingoInformation> madedBingoList) {
		this.madedBingoList = madedBingoList;
	}
	
}
