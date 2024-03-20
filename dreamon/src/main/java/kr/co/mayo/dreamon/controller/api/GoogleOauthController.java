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

//RestController는 데이터를 전달하는 함수로 페이지를 리턴할 수 없다.
//@RestController
@Controller
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class GoogleOauthController {

    @Autowired
    GoogleLoginService  loginService;

    // 예제에서 생성자를 사용 그래서 배운 어노테이션으로 처리
    @GetMapping("/code/{registrationId}")
    public String googleLogin(@RequestParam String code, @PathVariable String registrationId, HttpSession session) {
        
        loginService.socialLogin(code, registrationId);

        //여기서 다른 함수 호출하면 다시 여기로 돌아와서 종료.
        return "redirect:/";
    }
}
