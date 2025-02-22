package com.ajihsu.sudoku;
import java.util.*;

class Solution {
    private final int n = 9;

    private boolean backtracking(char[][] board, int r, int c) {
        if (r == n) return true;
        int nr = r, nc = c;
        nc++;
        if (nc == n) {
            nr++;
            nc = 0;
        }

        if (board[r][c] != ' ') {
            return backtracking(board, nr, nc);
        } else {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (board[i][c] != ' ') set.add(board[i][c] - '0');
            }
            for (int i = 0; i < n; i++) {
                if (board[r][i] != ' ') set.add(board[r][i] - '0');
            }
            int r3x3 = r - r % 3, c3x3 = c - c % 3;
            for (int i = r3x3; i < r3x3 + 3; i++) {
                for (int j = c3x3; j < c3x3 + 3; j++) {
                    if (board[i][j] != ' ') set.add(board[i][j] - '0');
                }
            }

            for (int i = 1; i <= n; i++) {
                if (set.contains(i)) continue;
                board[r][c] = (char) ('0' + i);
                if (backtracking(board, nr, nc)) return true;
                board[r][c] = ' ';
            }
            return false;
        }
    }

    public void solveSudoku(char[][] board) {
        backtracking(board, 0, 0);
    }

    public boolean check(char[][] board) {
        // col
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != ' ') {
                    if (!set.add(board[i][j])) return false;
                }

            }
        }

        // row
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[j][i] != ' ') {
                    if (!set.add(board[j][i])) return false;
                }
            }
        }

        // 3x3
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                HashSet<Character> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] != ' ') {
                            if (!set.add(board[i + k][j + l])) return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
