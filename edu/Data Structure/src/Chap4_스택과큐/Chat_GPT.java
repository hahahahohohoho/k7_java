package Chap4_스택과큐;

import java.util.ArrayList;
import java.util.List;

public class Chat_GPT {

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        List<int[][]> solutions = new ArrayList<>();
        solveEightQueens(board, 0, solutions);
        System.out.println("Number of solutions: " + solutions.size());
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            printBoard(solutions.get(i));
        }
    }

    public static void solveEightQueens(int[][] board, int col, List<int[][]> solutions) {
        if (col == 8) {
            solutions.add(copyBoard(board));
            return;
        }

        for (int row = 0; row < 8; row++) {
            int nextCol = nextMove(board, row, col);
            if (nextCol != -1) {
                solveEightQueens(board, col + 1, solutions);
                board[row][col] = 0; // Backtrack
            }
        }
    }

    // 배열 d에서 현재 위치(row, col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
    public static int nextMove(int[][] d, int row, int col) {
        if (checkMove(d, row, col)) {
            d[row][col] = 1;
            return col;
        }
        return -1;
    }

    // 현재 위치 (row, col) 에 퀸을 놓을 수 있는지 확인하는 메서드
    public static boolean checkMove(int[][] board, int row, int col) {
        // 같은 행에 다른 퀸이 있는지 확인
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // 왼쪽 위 대각선에 다른 퀸이 있는지 확인
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // 왼쪽 아래 대각선에 다른 퀸이 있는지 확인
        for (int i = row, j = col; i < 8 && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static int[][] copyBoard(int[][] original) {
        int[][] copy = new int[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, 8);
        }
        return copy;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
