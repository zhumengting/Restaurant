package com.food.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.food.dao.BusinessDao;
import com.food.dao.ReviewDao;
import com.food.daoImp.BusinessDaoImp;
import com.food.daoImp.ReviewDaoImp;
import com.food.model.User;
import com.food.service.RecommandorService;
import com.food.util.StringUtil;
import com.food.view.BItem;

@Controller
@RequestMapping
public class AddReviewController {
	
	  @RequestMapping("/gotoLogin")
	  public ModelAndView gotoLogin(ModelAndView modelAndView){
		  modelAndView.setViewName("jsp/login");
		  return modelAndView;
	  }
	  
	 @RequestMapping(value="/insertNewReview")
	 @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
	 public void insertNewReview(HttpServletRequest request){  
	    	String businessId = "";
	    	String userid="";
	    	int iScore=0;
	    	String comment_content="";
	    	if(request.getParameter("businessId")!=null)
	    		businessId = request.getParameter("businessId");
	        if(request.getParameter("userid")!=null)
	        	userid =  request.getParameter("userid");
	        if(request.getParameter("comment_content")!=null)
	        	comment_content = request.getParameter("comment_content");
	        if(request.getParameter("iScore")!=null)
	        	iScore = Integer.parseInt(request.getParameter("iScore"));
	        ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
	        ReviewDao reviewDaoImp = (ReviewDaoImp)factory.getBean("ReviewDaoImp");
	        reviewDaoImp.addNewReview(businessId, userid, comment_content, iScore);
	        //return "aaaaaaa";
	 }
	 @RequestMapping(value="/myreview")
	 @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
	 public String myreview(HttpServletRequest request){  	    	
	    	RecommandorService recserv = new RecommandorService();
	    	String jsonStr="";
	    	User loginUser = (User) request.getSession().getAttribute("loginUser");
	        ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
	        ReviewDao reviewDaoImp=(ReviewDaoImp)factory.getBean("ReviewDaoImp");
	    	BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
	    	List<String>businessids= reviewDaoImp.getSingleUserReviewList(loginUser.getUser_id());	  
	    	
	        List<BItem> businessList_type=businessDaoImp.getBusinessListbyIdList(businessids);
	        
	        if(businessList_type.size()>6) {
	        	businessList_type.subList(0, 6);
	        }
	        jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_type);    		    	
			return jsonStr;
	    }
}
