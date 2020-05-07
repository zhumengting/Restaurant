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
		//�ж��û��Ƿ��½
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		//��½����û��ɽ����������
		if(loginUser!=null){
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		//�޸Ĳ��֣����review�б�
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
			//System.out.println("�û�����");
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
	

	//��ת��img���޸Ľ���
	@RequestMapping("/TomyImg")
	public ModelAndView TomyImg(HttpServletRequest request)
	{
		return new ModelAndView("/jsp/NewFile","index","");
	}
		
		
	//�޸���ϴ������ݿⲢ����ԭ����
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
