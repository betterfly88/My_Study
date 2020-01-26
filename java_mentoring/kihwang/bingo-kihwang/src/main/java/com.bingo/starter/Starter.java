package com.bingo.starter;

import java.util.ArrayList;

import com.bingo.boardChecker.BoardMarker;
import com.bingo.checker.BingoChecker;
import com.bingo.checker.GameClearJudge;
import com.bingo.numberPicker.NumberPicker;
import com.bingo.player.Player;
import com.bingo.player.PlayerListMaker;

public class Starter {
	static int bingoBoardSize = 5;
	static int maxIntRange = 100;
	static int bingoLinesForClear = 2;
	static int howManyPlayers = 4;
	
	public static void main(String[] args) {
		ArrayList<Integer> numberIndexing = NumberPicker.numberSequenceMaker(maxIntRange, maxIntRange);
		ArrayList<Player> playerList = PlayerListMaker.playerListMaker(maxIntRange, bingoBoardSize, howManyPlayers);
		
		while(!GameClearJudge.gameCleareJudge(playerList, bingoLinesForClear)) {
			int pickNumberNow = numberIndexing.get(0);
			System.out.println("�̹��� ���� ���ڴ�  "+pickNumberNow);
			numberIndexing.remove(0);
			playerList = mainProcessForCheckBingo(pickNumberNow, playerList);
		}
		
	}
	
	public static ArrayList<Player> mainProcessForCheckBingo(int pickNumber, ArrayList<Player> players) {
		for(Player player : players) {
			int[] markingPostion = BoardMarker.bingoBoardMarker(pickNumber, player.getBingoBoard());
			int[][] bingoBoardForCheck = BoardMarker.boardChecker(player.getBingoBoardForCheck(), markingPostion);
			player.setBingoBoardForCheck(bingoBoardForCheck);
			player.setMadedBingoList(BingoChecker.bingoChecker(player.getBingoBoardForCheck()));
		}
		return players;
	}


}
