package com.bingo.player;

import java.util.ArrayList;

public class PlayerListMaker {
	public static ArrayList<Player> playerListMaker(int maxIntRange,int boardSize,int howManyPlayers){
		ArrayList<Player> playerList = new ArrayList<Player>();
		for(int i=0;i<howManyPlayers;i++) {
			playerList.add(PlayerMaker.playerMaker(maxIntRange, boardSize, (i+1)+"�� ����"));
		}
		return playerList;
	}
}
