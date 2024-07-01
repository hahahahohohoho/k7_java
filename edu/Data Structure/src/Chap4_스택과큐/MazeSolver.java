package Chap4_스택과큐;

import java.util.Stack;

import Chap4_스택과큐.objectStack.EmptyGenericStackException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;

class Offsets {
    int a, b;
    public Offsets(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Position {
    int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MazeSolver {
    static Offsets[] moves = new Offsets[8];

    public static void main(String[] args) {
        int[][] maze = new int[14][17];
        int[][] mark = new int[14][17];

        int input[][] = { // 12 x 15
                { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};

        for (int ia = 0; ia < 8; ia++)
            moves[ia] = new Offsets(0, 0); // 배열에 offsets 객체를 치환해야 한다.
        moves[0].a = -1;    moves[0].b = 0;
        moves[1].a = -1;    moves[1].b = 1;
        moves[2].a = 0;     moves[2].b = 1;
        moves[3].a = 1;     moves[3].b = 1;
        moves[4].a = 1;     moves[4].b = 0;
        moves[5].a = 1;     moves[5].b = -1;
        moves[6].a = 0;     moves[6].b = -1;
        moves[7].a = -1;    moves[7].b = -1;

        // input[][]을 maze[][]로 복사
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 17; j++) {
                maze[i][j] = 1;
            }
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 15; j++) {
                maze[i + 1][j + 1] = input[i][j];
            }
        }

        show("maze[12,15]::", maze);
        show("\nmark[12,15]::", mark);

        path(maze, mark, 12, 15);
        System.out.println("\n==path 후 ==\n");
        show("\nmaze[12,15]::", maze);
        show("\nmark[12,15]::", mark);
    }

    private static void show(String msg, int[][] mark) {
        System.out.println(msg);
        for (int[] N : mark) {
            for (int n : N) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static boolean path(int[][] maze, int[][] mark, int m, int p) {
        Queue<Position> queue = new LinkedList<>();
        Position[][] parent = new Position[14][17];
        boolean[][] visited = new boolean[14][17];
        Position temp;
        int row, col, nextRow, nextCol;

        visited[1][1] = true;
        queue.add(new Position(1, 1));
        parent[1][1] = new Position(-1, -1); // Starting position has no parent

        while (!queue.isEmpty()) {
            temp = queue.poll();
            row = temp.x;
            col = temp.y;

            for (int dir = 0; dir < 8; dir++) {
                nextRow = row + moves[dir].a;
                nextCol = col + moves[dir].b;

                if (nextRow == m && nextCol == p) { // Goal reached
                    mark[nextRow][nextCol] = 1;

                    // Backtrack to mark the shortest path
                    while (row != -1 && col != -1) {
                        mark[row][col] = 1;
                        Position pos = parent[row][col];
                        row = pos.x;
                        col = pos.y;
                    }

                    return true;
                }

                if (maze[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Position(nextRow, nextCol));
                    parent[nextRow][nextCol] = new Position(row, col);
                }
            }
        }

        System.out.println("No path found.");
        return false;
    }
}
