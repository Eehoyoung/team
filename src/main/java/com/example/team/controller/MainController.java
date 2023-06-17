package com.example.team.controller;

import com.example.team.dto.MenteeInfoDto;
import com.example.team.dto.MentorInfoDto;
import com.example.team.service.MenteeServiceImpl;
import com.example.team.service.MentorServiceImpl;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final MentorServiceImpl mentorService;
    private final MenteeServiceImpl menteeService;

    @Autowired
    public MainController(MentorServiceImpl mentorService, MenteeServiceImpl menteeService) {
        this.mentorService = mentorService;
        this.menteeService = menteeService;
    }

    @GetMapping("/main/index")
    public String main(){
        return "main/index";
    }

    @GetMapping("/main/login")
    public String loginPage(HttpServletRequest request, @RequestParam(value = "error", required = false) String error, Model model) {

        String referer = request.getHeader("Referer");

        if (referer != null) {
            request.getSession().setAttribute("prevPage", referer);
        } else {
            referer = "http://localhost:8080/main/index";
            request.getSession().setAttribute("prevPage", referer);
        }
        model.addAttribute("error", error);
        return "main/login";
    }

    @GetMapping("main/register/mentor")
    public String getRegisterMentorPage() {
        return "main/register_mentor";
    }

    @PostMapping("main/register/mentor")
    public String doRegisterMentorPage(MentorInfoDto mentorInfoDto) {
        Long memberId = mentorService.joinMentor(mentorInfoDto);
        return "redirect:/main/login";
    }

    @GetMapping("main/register/mentee")
    public String getRegisterMenteePage() {
        return "main/register_mentee";
    }

    @PostMapping("main/register/mentee")
    public String doRegisterMenteePage(MenteeInfoDto menteeInfoDto) {
        Long memberId = menteeService.joinMentee(menteeInfoDto);
        return "redirect:/main/login";
    }

    @ResponseBody
    @PostMapping("/main/register/mentor/doublecheck")
    public String inDoubleCheckMentor(@RequestParam(value = "registerId") String registerId) {
        if (mentorService.doubleCheckMentorId(registerId)) {
            return "사용 가능한 아이디 입니다.";
        } else {
            return "이미 사용중인 아이디 입니다.";
        }
    }

    @ResponseBody
    @PostMapping("/main/register/mentee/doublecheck")
    public String inDoubleCheckMentee(@RequestParam(value = "registerId") String registerId) {
        if (menteeService.doubleCheckMenteeId(registerId)) {
            return "사용 가능한 아이디 입니다.";
        } else {
            return "이미 사용중인 아이디 입니다.";
        }
    }

}
