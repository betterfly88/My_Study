package com.bingo.checker;

import com.bingo.player.MadedBingoInformation;

import java.util.ArrayList;

public interface CheckInterface {
    ArrayList<MadedBingoInformation> check(int[][] bingoBoardForCheck);
}
