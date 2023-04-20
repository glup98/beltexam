package com.augusto.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.augusto.beltexam.models.Board;
import com.augusto.beltexam.models.Waitstaff;
import com.augusto.beltexam.services.BoardService;
import com.augusto.beltexam.services.WaitstaffService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final WaitstaffService waitstaffService;
    private final BoardService boardService;
    
    @GetMapping("")
    public String home(HttpSession session,Model model) {
        Long waitstaffId = (Long)session.getAttribute("waitstaffId");
        if (waitstaffId != null) {
            Waitstaff waitstaff = waitstaffService.findById(waitstaffId);
            List<Board> boards = boardService.findBoardsByWaitstaff(waitstaff);
            model.addAttribute("boards", boards);
            model.addAttribute("waitstaff", waitstaff);
            return "home";            
        } else {
            return "redirect:/";
        }
    }

    // invalidar la sesión
    // redireccionar a la página de inicio de sesión.
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("waitstaffId");
        return "redirect:/";
    }

}
