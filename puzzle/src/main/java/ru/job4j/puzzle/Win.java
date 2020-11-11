package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = true;
        for(int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (checkRow(board, i) || checkColumn(board, i)) {
                    return rsl;
                }
            }
            rsl = false;
        }
        return rsl;
    }
    public static boolean checkRow(int[][] board, int line) {
        for(int i = 0; i < board.length; i++) {
            if (board[line][i] == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkColumn(int[][] board, int key) {
        for(int i = 0; i < board.length; i++) {
            if (board[i][key] == 1) {
                return true;
            }
        }
        return false;
    }
}
