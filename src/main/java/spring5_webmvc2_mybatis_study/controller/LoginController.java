package spring5_webmvc2_mybatis_study.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_webmvc2_mybatis_study.dto.AuthInfo;
import spring5_webmvc2_mybatis_study.dto.LoginCommand;
import spring5_webmvc2_mybatis_study.exception.WrongIdPasswordException;
import spring5_webmvc2_mybatis_study.service.AuthService;

@Configuration
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authService;
	
	@GetMapping
	public String form(LoginCommand loginCommand) {
		return "/login/loginForm";
	}
	
	@PostMapping
	public String submit(@Valid LoginCommand loginCommand, Errors errors, HttpSession session) {
		if(errors.hasErrors()) {
			return "/login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo);
			return "login/loginSuccess";
		}catch (WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}
}