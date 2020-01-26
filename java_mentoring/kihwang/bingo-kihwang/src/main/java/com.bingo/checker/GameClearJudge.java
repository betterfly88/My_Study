package com.bingo.checker;

import java.util.ArrayList;

import com.bingo.player.MadedBingoInformation;
import com.bingo.player.Player;

public class GameClearJudge {
	public static boolean gameCleareJudge(ArrayList<Player> playerList, int clearGoal) {
		boolean isCleared = false;
		for(Player player : playerList) {
			if(player.getMadedBingoList().size()==clearGoal){
				System.out.println(player.getName()+"���� ��ǥ ���� Ƚ�� " +clearGoal+"�� �޼��߽��ϴ�." );
				System.out.println("�ϼ���Ų ���� ��� : ");
				for(MadedBingoInformation bingoInformation : player.getMadedBingoList()) {
					System.out.println(bingoInformation);
				}
				isCleared = true;
			}
		}
		return isCleared;
	}
}
