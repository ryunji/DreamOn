package kr.co.mayo.dreamon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.entity.Mento;
import kr.co.mayo.dreamon.service.MentoService;

@Controller
@RequestMapping("mento")
public class MentoController {
    
    @Autowired
    private MentoService service;

    @GetMapping("list")
    public String list(Model model){

        List<Mento> list = service.findAll();


        model.addAttribute("mentoList", list);
        return "mento/list";
    }
}
