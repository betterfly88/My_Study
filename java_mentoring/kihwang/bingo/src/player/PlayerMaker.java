package player;

import java.util.ArrayList;

import boardMaker.BoardMaker;

public class PlayerMaker {
	public static Player playerMaker(int maximumNumberRange,int boardSize, String userName) {
		Player player = new Player();
		player.setName(userName);
		player.setBingoBoard(BoardMaker.bingoBoardMaker(maximumNumberRange, boardSize));
		player.setBingoBoardForCheck(new int[boardSize][boardSize]);
		player.setMadedBingoList(new ArrayList<MadedBingoInformation>());
		return player;
	}
}
