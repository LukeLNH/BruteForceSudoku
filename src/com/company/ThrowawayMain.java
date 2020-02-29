//package com.company;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class ThrowawayMain {
//
//    public static Scanner userInput = new Scanner(System.in);
//    public static ArrayList<String> inputString = new ArrayList<>();
//    public static SudokuSolver sudokuSolver = new SudokuSolver();
//
//    public static void main(String[] args) {
//
//
//        takeUserInput();
//        insertIntoBoard();
//
//        printBoard(sudokuSolver, false);
//        //solve board
//        sudokuSolver.solvedBoard = sudokuSolver.solveBoard(sudokuSolver.getBoard());
//
//        printBoard(sudokuSolver, true);
//
//    }
//
//    private static void takeUserInput() {
//        int row = 1;
//        while(row <= 9) {
//            System.out.println("enter " + row + "st" + " row:");
//            String input = userInput.nextLine();
//            inputString.add(input);
//            row++;
//        }
//    }
//
//    public static void printBoard(SudokuSolver sudokuSolver, boolean solved) {
//
//
//        printCharacter('_');
//        System.out.println("");
//
//
//        for(int i = 0; i < sudokuSolver.getBOARDWIDTH(); i++) {
//
//            // separates every 3 rows
//            if (i != 0 && i % 3 == 0 ) {
//                printCharacter('~');
//                System.out.println("");
//            }
//
//            for(int j = 0; j < sudokuSolver.getBOARDHEIGHT(); j++) {
//
//                if(j % 3 == 0) {
//                    if(!solved) {
//                        System.out.print(" #| " + sudokuSolver.getBoard()[i][j] + " ");
//                    }else {
//                        System.out.print(" #| " + sudokuSolver.getSolvedBoard()[i][j] + " ");
//                    }
//
//                }else{
//                    if(!solved) {
//                        System.out.print("| " + sudokuSolver.getBoard()[i][j] + " ");
//                    }else {
//                        System.out.print("| " + sudokuSolver.getSolvedBoard()[i][j] + " ");
//                    }
//
//                }
//
//
//            }
//            System.out.println("|");
//        }
//
//        printCharacter('_');
//    }
//
//
//    public static void printCharacter(char c) {
//        for(int k = 0; k < 43; k++) {
//            System.out.print(c);
//        }
//    }
//
//    public static void insertIntoBoard() {
//        for(int row = 0; row < 9; row++) {
//            for(int col = 0; col < 9; col++) {
//
//                sudokuSolver.getBoard()[row][col] = Integer.parseInt(String.valueOf(inputString.get(row).charAt(col)));
//            }
//        }
//    }
//
//}
