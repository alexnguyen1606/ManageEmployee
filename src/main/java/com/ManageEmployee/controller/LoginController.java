package com.ManageEmployee.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ManageEmployee.service.impl.UserServiceImpl;
import com.ManageEmployee.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
	@Autowired
	private CookieUtils cookieUtils;
	@Autowired
	private UserServiceImpl userService;
	@GetMapping("/login")
	public String loginPage(HttpServletRequest request,HttpServletResponse response) {
		cookieUtils.removeCookieByUser(request,response);
		return "login";
		}
	@PostMapping("/login")
	public RedirectView login(@RequestParam("username") String userName,@RequestParam("password") String passWord,HttpServletResponse response) {
		RedirectView rv = new RedirectView();
		if (userName.equals("")||passWord.equals("")) {
			rv.setUrl("/login");
			rv.addStaticAttribute("message", "Username or Passoword Null");
			rv.addStaticAttribute("alert", "danger");
			return rv;
		}
		if(userService.isAuthenticate(userName,passWord)) {
			cookieUtils.createCookieByUser(userService.findByUsernameAndPassword(userName,passWord),response);
			rv.setUrl("/");
			return rv;
		}
		else
		{rv.setUrl("/login");
		rv.addStaticAttribute("message", "Username or Passoword Wrong");
		rv.addStaticAttribute("alert", "danger");
		return rv;
		}
	}
	@GetMapping("/logout")
	public RedirectView logout(HttpServletRequest request,HttpServletResponse response){
		cookieUtils.removeCookieByUser(request,response);
		return new RedirectView("/login");
	}
}
