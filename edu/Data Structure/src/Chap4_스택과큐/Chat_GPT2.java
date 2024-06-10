package Chap4_스택과큐;

import java.util.Stack;

import java.util.ArrayList;
import java.util.List;

public class Chat_GPT2 {

    public static void EightQueen(int[][] board, int col, List<int[][]> solutions) {
        if (col == 8) {
            solutions.add(copyBoard(board));
            return;
        }

        for (int row = 0; row < 8; row++) {
            if (checkMove(board, row, col)) {
                board[row][col] = 1;
                EightQueen(board, col + 1, solutions);
                board[row][col] = 0; // Backtrack
            }
        }
    }

    public static boolean checkRow(int[][] d, int crow) { // 배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
        for (int i = 0; i < d.length; i++)
            if (d[crow][i] == 1) return false;
        return true;
    }

    public static boolean checkCol(int[][] d, int ccol) { // 배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
        for (int i = 0; i < d.length; i++)
            if (d[i][ccol] == 1) return false;
        return true;
    }

    public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0 <= x,y <= 7
        for (int i = cx, j = cy; i < 8 && j >= 0; i++, j--) {
            if (d[i][j] == 1) {
                return false;
            }
        }
        for (int i = cx, j = cy; i >= 0 && j < 8; i--, j++) {
            if (d[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiagSE(int[][] d, int cx, int cy) { // x++, y++ or x--, y--
        for (int i = cx, j = cy; i >= 0 && j >= 0; i--, j--) {
            if (d[i][j] == 1) {
                return false;
            }
        }
        for (int i = cx, j = cy; i < 8 && j < 8; i++, j++) {
            if (d[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkMove(int[][] d, int x, int y) { // (x,y)로 이동 가능한지를 check
        return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
    }

    public static int[][] copyBoard(int[][] original) {
        int[][] copy = new int[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, 8);
        }
        return copy;
    }

    public static void showQueens(int[][] data) { // 배열 출력
        for (int[] row : data) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        List<int[][]> solutions = new ArrayList<>();
        EightQueen(board, 0, solutions);
        System.out.println("Number of solutions: " + solutions.size());
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            showQueens(solutions.get(i));
        }
    }
}
