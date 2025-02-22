package com.ajihsu.sudoku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SudokuController {

    private final Board board;

    @Autowired
    SudokuController(Board board) {
        this.board = board;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("board", board);
        board.init();
        return "index";
    }

    @PutMapping("/home")
    public String put(@RequestParam int row,
                      @RequestParam int col,
                      @RequestParam char val) {
        board.getBoard()[row][col] = val;
        return "index";
    }

    @PostMapping("/solution")
    public String solution(Model model) {
        Solution solution = new Solution();

        if (!solution.check(board.getBoard())) {
            return "error";
        }

        solution.solveSudoku(board.getBoard());
        model.addAttribute("board", board);
        return "solution";
    }
}
