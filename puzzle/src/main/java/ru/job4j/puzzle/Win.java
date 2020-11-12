package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for(int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (checkRow(board, i) || checkColumn(board, i)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }
    public static boolean checkRow(int[][] board, int line) {
        boolean res = true;
        for(int i = 0; i < board.length; i++) {
            if (board[line][i] != 1) {
                res = false;
            }
        }
        return res;
    }

    public static boolean checkColumn(int[][] board, int key) {
        boolean res = true;
        for(int i = 0; i < board.length; i++) {
            if (board[i][key] != 1) {
                res = false;
            }
        }
        return res;
    }
}
