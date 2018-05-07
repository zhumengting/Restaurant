package com.food.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.food.model.Photo;
import com.food.model.User;
import com.food.service.MainPageServices;
import com.food.util.ResponseUtil;
import com.food.view.BItem;

import net.sf.json.JSONArray;

@Controller 
public class MainPageController {
	MainPageServices mser=new MainPageServices();

    @RequestMapping(value="/mainbottom")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String mainbottom(){  
        Map<String, Object> map = new HashMap<String, Object>();  
        List<Photo>photoes=mser.getBottomPic();
        String jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(photoes);

        return jsonStr;
    }
    @RequestMapping(value="/mainhot")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String mainhot(){  
        Map<String, Object> map = new HashMap<String, Object>();  
        List<BItem>photoes=mser.getTop12();
        String jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(photoes);
        return jsonStr;
    }
    @SuppressWarnings("resource")
    @RequestMapping("/tologin")
    public ModelAndView tologin(HttpServletRequest request)
    {
        //调用业务处理LoginCheck
	ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");	
    return new ModelAndView("login");
    }
   
    
    public void login(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String remember=request.getParameter("remember");
		User user=new User(userName,password);
		Connection con=null;
		try {
			//con=dbUtil.getCon();
			User currentUser=null;
			//currentUser=userDao.login(con, user);
			if(currentUser==null){//验证失败
				request.setAttribute("user", user);//记录用户输错的用户名和密码
				request.setAttribute("error", "用户名或密码错误!");
				request.getRequestDispatcher("login.jsp").forward(request, response);//重定向等登陆界面
			}else{
				session.setAttribute("currentUser", currentUser);
				response.sendRedirect("main.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void rememberMe(String userName,String password,HttpServletResponse response) {
		Cookie cookie=new Cookie("user",userName+"-"+password);
		cookie.setMaxAge(1*60*60*24*7);
		response.addCookie(cookie);
	}
    
}
	
