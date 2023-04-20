package com.augusto.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.augusto.beltexam.models.Board;
import com.augusto.beltexam.models.Waitstaff;
import com.augusto.beltexam.services.BoardService;
import com.augusto.beltexam.services.WaitstaffService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardsController {
    
    private final BoardService boardService;
    private final WaitstaffService waitstaffService;

    @GetMapping("/new")
    public String newBoard(@ModelAttribute ("board") Board board, HttpSession session) {
        Long waitstaffId = (Long)session.getAttribute("waitstaffId");
        if(waitstaffId != null){
            return "newBoard";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/new")
    public String createBoard(@Valid @ModelAttribute ("board") Board board, BindingResult result,HttpSession session) {
        if (result.hasErrors()) {
            return "newBoard";
        } else {
            Long waitstaffId = (Long)session.getAttribute("waitstaffId");
            Waitstaff waitstaff = waitstaffService.findById(waitstaffId);
            board.setWaitstaff(waitstaff);
            boardService.save(board);
        }
        return "redirect:/home";
    }

    @DeleteMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:/home";
    }

    @GetMapping("/edit/{boardId}")
    public String editBoard(@PathVariable("boardId") Long boardId, Model model) {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "editBoard";
    }

    @PutMapping("/edit/{boardId}")
    public String updateBoard(@Valid @ModelAttribute ("board") Board board, BindingResult result, @PathVariable("boardId") Long boardId) {
        if (result.hasErrors()) {
            return "editBoard";
        } else {
            boardService.updateBoard(boardId,board.getGuestName(),board.getNumberOfGuests(),board.getNote());
            return "redirect:/home";
        }
    }

    @GetMapping ("/allboards")
    public String showAllBoards(Model model) {
        List<Board> allBoards = boardService.findAll();
        model.addAttribute("allBoards", allBoards);
        return "allBoards";
    }


    @GetMapping("/open/{boardId}")
    public String openBoards(Model model, @PathVariable ("boardId") Long boardId) {
        List <Board> openBoards = boardService.findBoardsWithoutWaitstaff();
        model.addAttribute("openBoards", openBoards);
        Board board = boardService.findById(boardId);
        board.setWaitstaff (null);
        boardService.save(board);
        return "openBoards";
    }

    @GetMapping("/pickup/{boardId}")
    public String pickUpBoard(@PathVariable("boardId") Long boardId, HttpSession session) {
        Long waitstaffId = (Long)session.getAttribute("waitstaffId");
        Waitstaff waitstaff = waitstaffService.findById(waitstaffId);
        Board board = boardService.findById(boardId);
        board.setWaitstaff (waitstaff);
        boardService.save(board);
        return "redirect:/home";
    }

}
