package checker;

import java.util.ArrayList;

import player.MadedBingoInformation;
import player.Player;

public class GameClearJudge {
	public static boolean gameCleareJudge(ArrayList<Player> playerList, int clearGoal) {
		boolean isCleared = false;
		for(Player player : playerList) {
			if(player.getMadedBingoList().size()==clearGoal){
				System.out.println(player.getName()+"님이 목표 빙고 횟수 " +clearGoal+"를 달성했습니다." );
				System.out.println("완성시킨 빙고 목록 : ");
				for(MadedBingoInformation bingoInformation : player.getMadedBingoList()) {
					System.out.println(bingoInformation);
				}
				isCleared = true;
			}
		}
		return isCleared;
	}
}
