package kr.co.mayo.dreamon.controller.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpSession;
import kr.co.mayo.dreamon.service.GoogleLoginService;

//@RestController
@Controller
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class GoogleOauthController {

    @Autowired
    GoogleLoginService  loginService;

    @GetMapping("/code/{registrationId}")
    public void googleLogin(@RequestParam String code, @PathVariable String registrationId, HttpSession session) {
        
        loginService.socialLogin(code, registrationId);

        //this.gotoMain(session);
       // return "redirect:/";
    }

    public RedirectView gotoMain(HttpSession session) {
		System.out.println("kakao callback 컨트롤러 접근");
		
		
		RedirectView redirectView = new RedirectView();
		
		
		

		
		
		
		
		
		
		
		redirectView.setUrl("http://localhost:8082");
			
		return redirectView;
	}
}