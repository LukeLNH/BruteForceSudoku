package com.company;

import exceptions.InvalidBoardException;
import model.SudokuManager;

import java.util.ArrayList;


public class SudokuSolver {

    private int[][] board;
    public int[][] solvedBoard;
    public static final int BOARDWIDTH = 9;
    public static final int BOARDHEIGHT = 9;
    private SudokuManager manager;
    private ArrayList<int[][]> todo;



    public SudokuSolver(){
        board = new int[BOARDWIDTH][BOARDHEIGHT];
        solvedBoard = new int[BOARDWIDTH][BOARDHEIGHT];
        todo = new ArrayList<>();
        manager = new SudokuManager();

        // Initialize the board with zeros
        for(int row = 0; row < BOARDWIDTH; row++) {
            for(int col = 0; col < BOARDHEIGHT; col++) {
                board[row][col] = 0;
            }
        }
        //Initialize solved board with zeros
        for(int row = 0; row < BOARDWIDTH; row++) {
            for(int col = 0; col < BOARDHEIGHT; col++) {
                solvedBoard[row][col] = 0;
            }
        }
    }


//    public int[][] solveBoard(int[][] board) {
//        if(manager.isComplete(board)) {
//            return board;
//        }
//
//        todo.addAll(0, manager.generateValidBoards(board));
//        return solveListOfBoards();
//    }

    private int[][] solveListOfBoards() {
        if (todo.size() == 0) {
            return emptyBoard(); //no valid solution
        }
        int[][] temp = todo.get(0);
        todo.remove(0);
        return solveBoard(temp);
    }

    public int[][] emptyBoard() {
        int[][] temp = new int[9][9];
        for(int row = 0; row < BOARDWIDTH; row++) {
            for(int col = 0; col < BOARDHEIGHT; col++) {
                temp[row][col] = 9;
            }
        }
        return temp;
    }

    //////////////////////////////////////////// New Version /////////////////////////////////
    public int[][] solveBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solvedBoard[i][j] = board[i][j]; //creating a copy of the initial board
            }
        }

        solvedBoard = manager.solveBoard(solvedBoard);
        return solvedBoard;
    }


    public void insert(int row, int col, int val) {
        board[row][col] = val;
    }

    public static int getBOARDWIDTH() {
        return BOARDWIDTH;
    }

    public static int getBOARDHEIGHT() {
        return BOARDHEIGHT;
    }

    public int[][] getBoard() {
        return board;
    }
    public int[][] getSolvedBoard() {
        return solvedBoard;
    }
}
