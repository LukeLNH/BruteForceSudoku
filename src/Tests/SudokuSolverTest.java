package Tests;

import com.company.SudokuSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {
    private SudokuSolver solver;

    @BeforeEach
    public void runBefore() {
        solver = new SudokuSolver();
    }

    @Test
    public void testConstructor() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(0, solver.getBoard()[i][j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(0, solver.getSolvedBoard()[i][j]);
            }
        }
    }

    @Test
    public void testEmptyBoard() {
        int[][] unsolvableSoln = solver.emptyBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(9, unsolvableSoln[i][j]);
            }
        }
    }

    @Test
    public void testInsert() {
        solver.insert(5,6,2);
        assertEquals(2, solver.getBoard()[5][6]);
    }

    @Test
    public void testSolveBoard() {
        int[][] initialBoard = new int[9][9];
        int[][] solution = new int[9][9];

        String boardString = "004300209005009001070060043006002087190007400050083000600000105003508690042910300";
        int strPos = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                initialBoard[i][j] = Integer.parseInt(boardString.substring(strPos, strPos + 1));
                strPos++;
            }
        }

        boardString = "864371259325849761971265843436192587198657432257483916689734125713528694542916378";
        strPos = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solution[i][j] = Integer.parseInt(boardString.substring(strPos, strPos + 1));
                strPos++;
            }
        }

        int[][] solvedBoard = solver.solveBoard(initialBoard);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(solution[i][j], solvedBoard[i][j]);
            }
        }

    }


}