package com.rxjava.observable;

import com.metoring.BingoBoard;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class BingoGameTest {
    int [][] bingoArr;
    private BingoBoard bingoBoard;
    List<String> userNames;
    @Before
    public void init(){
        bingoArr = new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 1, 1}
                };


        int bingoLength = 5;
        int endGameCondition = 3;
        int attendanceNumber = 2;

        userNames = new ArrayList<>();
        userNames.add("최상현");
        userNames.add("아무개");


        bingoBoard = new BingoBoard(bingoLength, endGameCondition, attendanceNumber, userNames);
    }

    @Test
    public void 가로_빙고(){
        boolean bingoFlag = false;
        for(int width=0; width < bingoArr.length; width++){
            for(int height=0; height<bingoArr.length; height++){
                if(bingoArr[width][height] != 0){
                    bingoFlag = true;
                }
            }
        }
        //when
        assertTrue(bingoArr[0][2] == 0);
    }

    @Test
    public void validate(){
        bingoBoard.validateUserNames(userNames);
    }
}
