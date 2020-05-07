package com.food.controller;

import javax.servlet.http.*;

import org.springframework.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import com.food.dao.*;
import com.food.daoImp.*;
import com.food.model.*;
import com.food.util.*;
import com.food.view.BItem;

@Controller
@RequestMapping
public class AccountController {
	
	@SuppressWarnings("resource")
	@RequestMapping("/myAccount")
    public ModelAndView toMyAccount(HttpServletRequest request)
    {
		//判断用户是否登陆
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		//登陆则对用户可进入个人中心
		if(loginUser!=null){
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		//修改部分，添加review列表
		ReviewDao reviewDaoImp=(ReviewDaoImp)factory.getBean("ReviewDaoImp");
		List<Review> reviewList=reviewDaoImp.getReviewListByUserId(loginUser.getUser_id());
		String img=userDaoImp.selectImg(loginUser.getUser_id());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/jsp/myAccount");
		modelAndView.addObject("img",img);
		modelAndView.addObject("reviewList",reviewList);
        return modelAndView;
        }
	    else return new ModelAndView("login");
    }
	
	@SuppressWarnings("resource")
	@RequestMapping("/EditPass")
    public ModelAndView EditPass(HttpServletRequest request)
    {
		String pass = request.getParameter("newPass"); 
		User user=(User)request.getSession().getAttribute("loginUser");
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		userDaoImp.editPassword(user.getUser_id(), pass);
		user.setPassword(pass);
		request.getSession().setAttribute("loginUser", user);
		ReviewDao reviewDaoImp=(ReviewDaoImp)factory.getBean("ReviewDaoImp");
		List<Review> reviewList=reviewDaoImp.getReviewListByUserId(user.getUser_id());
		String img=userDaoImp.selectImg(user.getUser_id());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/jsp/myAccount");
		modelAndView.addObject("img",img);
		modelAndView.addObject("reviewList",reviewList);
        return modelAndView;
    }
	
	@SuppressWarnings("resource")
	@RequestMapping("/editPhone")
    public ModelAndView editPhone(HttpServletRequest request)
    {
		User user=(User)request.getSession().getAttribute("loginUser");
		String phoneNum = request.getParameter("phone");  
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		ReviewDao reviewDaoImp=(ReviewDaoImp)factory.getBean("ReviewDaoImp");
		List<Review> reviewList=reviewDaoImp.getReviewListByUserId(user.getUser_id());
		String img=userDaoImp.selectImg(user.getUser_id());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/jsp/myAccount");
		modelAndView.addObject("img",img);
		modelAndView.addObject("reviewList",reviewList);
		if(userDaoImp.IsExist(phoneNum)){
			//System.out.println("用户存在");
			modelAndView.addObject("info","fail");
			return modelAndView;
		}
		else {
			System.out.println(phoneNum+""+user.getUser_id());
			userDaoImp.updateUser("id",phoneNum,user.getUser_id());
			user.setUser_id(phoneNum);
			request.getSession().setAttribute("loginUser", user);
			modelAndView.addObject("info","success");
			return modelAndView;
			}
    }
	
	@SuppressWarnings("resource")
	@RequestMapping("/editName")
    public ModelAndView editName(HttpServletRequest request)
    {
		User user=(User)request.getSession().getAttribute("loginUser");
		String userName = request.getParameter("userName");  
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		userDaoImp.updateUser("name",userName,user.getUser_id());
		user.setName(userName);
		request.getSession().setAttribute("loginUser", user);
		ReviewDao reviewDaoImp=(ReviewDaoImp)factory.getBean("ReviewDaoImp");
		List<Review> reviewList=reviewDaoImp.getReviewListByUserId(user.getUser_id());
		String img=userDaoImp.selectImg(user.getUser_id());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/jsp/myAccount");
		modelAndView.addObject("img",img);
		modelAndView.addObject("reviewList",reviewList);
		modelAndView.addObject("info","success");
		return modelAndView;
    }
	

	//跳转到img需修改界面
	@RequestMapping("/TomyImg")
	public ModelAndView TomyImg(HttpServletRequest request)
	{
		return new ModelAndView("/jsp/NewFile","index","");
	}
		
		
	//修改完毕存入数据库并返回原界面
	@SuppressWarnings("resource")
    @RequestMapping("/alterImg")
	@ResponseBody
    public ModelAndView alterImg(HttpServletRequest request)
	{
    	User user=(User)request.getSession().getAttribute("loginUser");
	    String img = request.getParameter("imgSrc");  
		System.out.println(img);
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		userDaoImp.updateUser("img",img,user.getUser_id());
	    return new ModelAndView("/jsp/NewFile","index","");
	}
}
