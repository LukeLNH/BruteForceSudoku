package Tests;

import model.SudokuManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SudokuManagerTest {

    private int[][] testBoard;
    private int[][] nonZeroBoard;
    private SudokuManager manager;

    @BeforeEach
    public void runBefore() {
        manager = new SudokuManager();

        testBoard = new int[9][9];

        String boardString = "004300209005009001070060043006002087190007400050083000600000105003508690042910300";
        int strPos = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                testBoard[i][j] = Integer.parseInt(boardString.substring(strPos, strPos + 1));
                strPos++;
            }
        }

        nonZeroBoard = new int[9][9]; //algorithm determines that the board has no valid solution
        strPos = 0;
        boardString = "864371259325849761971265843436192587198657432257483916689734125713528694542916378";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                nonZeroBoard[i][j] = Integer.parseInt(boardString.substring(strPos, strPos + 1));;
                strPos++;
            }
        }
    }

    @Test
    void testIsComplete() {
        assertTrue(manager.isComplete(nonZeroBoard));
        assertFalse(manager.isComplete(testBoard));
    }

    @Test
    void testGenerateValidBoards() {
        ArrayList<int[][]> boards = manager.generateValidBoards(testBoard);
        System.out.println(boards.size());
        String validBoardString = "804300209005009001070060043006002087190007400050083000600000105003508690042910300";
        int[][] validBoard = new int[9][9];
        int strPos = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                validBoard[i][j] = Integer.parseInt(validBoardString.substring(strPos, strPos + 1));
                strPos++;
            }
        }
        ArrayList<int[][]> temp = new ArrayList<>();
        temp.add(validBoard);
        for (int i = 0; i < boards.size(); i++) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    assertEquals(temp.get(i)[row][col], boards.get(i)[row][col]);
                }
            }
        }
    }
}