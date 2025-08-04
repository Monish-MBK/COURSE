package com.monish.SpringBootWeb;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "index";
    }
    @RequestMapping("add")
//    public String add(HttpServletRequest request, HttpSession session){
//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
//        int result = num1 + num2;
//        session.setAttribute("result",result);
//        return "result.jsp";
//    }
//    public String add(@RequestParam("num1")int num, @RequestParam("num2")int num2, Model model){
//        int result=num+num2;
//        model.addAttribute("result",result);
//        return "result";
//    }
    public ModelAndView add(@RequestParam("num1")int num, @RequestParam("num2")int num2, ModelAndView modelAndView){
        int result=num+num2;
        modelAndView.addObject("result",result);
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
