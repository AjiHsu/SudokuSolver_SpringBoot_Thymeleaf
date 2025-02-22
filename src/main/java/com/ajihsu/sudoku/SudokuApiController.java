package com.ajihsu.sudoku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SudokuApiController {

    private final Board board;

    @Autowired
    SudokuApiController(Board board) {
        this.board = board;
    }

    @PutMapping("/update")
    public String updateCell(@RequestParam int row,
                             @RequestParam int col,
                             @RequestParam char val) {
        board.getBoard()[row][col] = val;
        return "{\"status\": \"success\"}"; // 返回 JSON
    }
}
