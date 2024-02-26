package kr.co.mayo.dreamon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChattController {
    //@RequestMapping("mychatt")
    @GetMapping("mychatt")	public ModelAndView chatt() {
		System.out.println("chatt controller");
        ModelAndView mv = new ModelAndView();
		mv.setViewName("chatting");
		return mv;
	}
}
