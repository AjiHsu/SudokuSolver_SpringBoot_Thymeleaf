package com.ajihsu.sudoku;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Board {
    private char[][] board;

    @PostConstruct
    public void init() {
        board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }
}
