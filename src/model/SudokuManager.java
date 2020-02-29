package model;


import exceptions.InvalidBoardException;

import java.util.ArrayList;
import java.util.Iterator;

public class SudokuManager {


    // PRE: None
    // EFFECTS: returns true if the board is valid, false otherwise
    private boolean validateBoard(int[][] board) {
        try {
            checkRows(board);
            checkCols(board);
            checkSquares(board);
        } catch (InvalidBoardException e) {
            return false;
        }
        return true;
    }

    // PRE: None
    // EFFECTS: Checks that no rows of the board contain duplicates, throws an exception if duplication exists
    private void checkRows(int[][] board) throws InvalidBoardException {
        for (int i = 0; i < 9; i ++){
            checkCombination(board[i]);
        }
    }

    //PRE: None
    //EFFECTS: Checks that the consumed combination is valid, throws an excpetion if duplication exists
    private void checkCombination(int[] board) throws InvalidBoardException {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 0) {
                for (int j = i+1; j < 9; j++) {
                    if (board[i] == board[j]) {
                        throw new InvalidBoardException();
                    }
                }
            }
        }
    }

    //PRE: None
    //EFFECTS: Throws an exception if any columns contains duplicates
    private void checkCols(int[][] board) throws InvalidBoardException {
        for (int j = 0; j < 9; j++) {
            int[] temp = new int[9];

            for (int i = 0; i < 9; i++) {
                temp[i] = board[i][j];
            }

            checkCombination(temp);
        }
    }

    //PRE: None
    //EFFECTS: throws an exception if any squares contain duplicates
    private void checkSquares(int[][] board) throws InvalidBoardException {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j+= 3) {
                int rowIndex = i;
                int colIndex = j;
                int colMax = colIndex + 3;
                int[] temp = new int[9];
                int length = 0;
                while (length < 9) {
                    temp[length] = board[rowIndex][colIndex];
                    length++;
                    colIndex++;
                    if (colIndex >= colMax) {
                        colIndex = j;
                        rowIndex++;
                    }
                }
                checkCombination(temp);
            }
        }
    }


    // PRE: The board is valid
    // EFFECTS: returns true is the board has no zeros, false otherwise
    public boolean isComplete(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // PRE: the board is not solved; pos = "row" or "col" ONLY
    // EFFECTS: returns the index position of the next 0, -1 if none found.
    private int getNext0(int[][] board, String pos) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    if (pos.equals("row")) {
                        return i;
                    } else if (pos.equals("col")) {
                        return j;
                    }
                }
            }
        }
        return -1; //add an exception here
    }

    // PRE: none
    // EFFECTS: Produces an arraylist of only valid boards
    public ArrayList<int[][]> generateValidBoards(int[][] board) {
        ArrayList<int[][]> temp = generateAllBoards(board);
        onlyValidBoards(temp);
        return temp;
    }

    // PRE: none
    // EFFECTS: Produces an arraylist of all possible board combinations
    private ArrayList<int[][]> generateAllBoards(int[][] board) {
        int rowIndex = getNext0(board, "row");
        int colIndex = getNext0(board, "col");

        ArrayList<int[][]> listOfBoards = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            int[][] temp = createCopy(board);
            temp[rowIndex][colIndex] = i;
            listOfBoards.add(temp);
        }

        return listOfBoards;
    }

    //EFFECTS: creates a new copy of the consumed board
    private int[][] createCopy(int[][] board) {
        int[][] temp = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                temp[i][j] = board[i][j];
            }
        }
        return temp;
    }

    // PRE: None
    // EFFECTS: removes all invalid boards from the arraylist
    private void onlyValidBoards(ArrayList<int[][]> boards) {
        Iterator<int[][]> lob = boards.iterator();
        while (lob.hasNext()) {
            if (!validateBoard(lob.next())) {
                lob.remove();
            }
        }
    }
}
