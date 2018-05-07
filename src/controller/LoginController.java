package com.food.controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.food.dao.*;
import com.food.daoImp.*;

import com.food.model.*;

import com.food.util.*;
import com.food.view.*;



@Controller
@RequestMapping
public class LoginController {
	@RequestMapping("/ToLogin")
    public ModelAndView ToLogin(HttpServletRequest request)
    {
        return new ModelAndView("jsp/login");
    }
    
	@SuppressWarnings("resource")
	@RequestMapping("/login")
    public ModelAndView Login(HttpServletRequest request,HttpServletResponse response)
    {
		String phoneNum = request.getParameter("phoneNum");  
		String password = request.getParameter("password"); 
		String checked=request.getParameter("rememberme");
		System.out.println(password);
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		User user=userDaoImp.login(phoneNum, password);
		if(user==null){
			return new ModelAndView("jsp/login","error1","wrong");
		}else {
			user.setPassword(password);
			if(checked!=null){
			 //×Ô¶¯µÇÂ¼cookie  
		    Cookie userNameCookie = new Cookie("loginUserName", user.getName());  
		    Cookie IdCookie = new Cookie("loginId", user.getUser_id());
		    Cookie passwordCookie = new Cookie("loginPassword", password);
		    Cookie isTimeout = new Cookie("isTimeout", "NO");
		    userNameCookie.setMaxAge(30 * 600);  
		    userNameCookie.setPath("/");  
		    passwordCookie.setMaxAge(30 * 600);  
		    passwordCookie.setPath("/"); 
		    IdCookie.setMaxAge(30 * 600);  
		    IdCookie.setPath("/"); 
		    isTimeout.setMaxAge(30 * 60);  
		    isTimeout.setPath("/"); 
		    response.addCookie(userNameCookie);  
		    response.addCookie(passwordCookie);
		    response.addCookie(IdCookie);
		    response.addCookie(isTimeout);
			}
		    //µÇÂ½
		    request.getSession().setAttribute("loginUser", user);
			return new ModelAndView("main");
			}
    }
	
	@SuppressWarnings("resource")
	@RequestMapping("/register")
    public ModelAndView Register(HttpServletRequest request)
    {
		String phoneNum = request.getParameter("phoneNumIn");  
		String pass = request.getParameter("passIn"); 
		String username = request.getParameter("usernameIn");
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		if(userDaoImp.IsExist(phoneNum)){
			return new ModelAndView("login","error2","wrong");
		}
		else {
			userDaoImp.register(phoneNum, pass, username);
			return new ModelAndView("jsp/login");
			}
    }
}
