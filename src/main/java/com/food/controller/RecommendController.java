package com.food.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.food.dao.UserDao;
import com.food.daoImp.BusinessDaoImp;
import com.food.daoImp.ReviewDaoImp;
import com.food.daoImp.UserDaoImp;
import com.food.model.User;
import com.food.service.MainPageServices;
import com.food.service.RecommandorService;
import com.food.view.BItem;

@Controller
@RequestMapping
public class RecommendController {

	    @SuppressWarnings("resource")
		@RequestMapping("/RecommendBaseOnUser")
	  public ModelAndView RecommendBaseOnUser(ModelAndView modelAndView,String page,HttpServletRequest request)
	  {
	    	modelAndView.setViewName("jsp/product-category");
	    	User loginUser = (User) request.getSession().getAttribute("loginUser");
			ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
			int itemsCount=30;
			ReviewDao reviewdao=(ReviewDaoImp)factory.getBean("ReviewDaoImp");  
			BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
			//若用户没有登陆则使用加权推荐
			if(loginUser==null){							
			    modelAndView.addObject("TAG", "Recommend");
				modelAndView.addObject("businessCount",itemsCount);
				modelAndView.addObject("urldo","changePage_nomalRecommend.do"); 					
		        }
		    else {
		    	int reviewnumber=reviewdao.singleUserReviewCount(loginUser.getUser_id());
		    	
		    	if(reviewnumber==0) {
		    		modelAndView.addObject("TAG", "Recommend");
					modelAndView.addObject("businessCount",itemsCount);
					modelAndView.addObject("urldo","changePage_nomalRecommend.do"); 	
		    	}else {
		    		modelAndView.addObject("TAG", "Recommend");
					modelAndView.addObject("businessCount",itemsCount);
					modelAndView.addObject("urldo","changePage_UserRecommend.do"); 
		    	}
		    	
		    }
			return modelAndView;
	
	  	
	  }

    @SuppressWarnings("resource")
	@RequestMapping("/RecommendBaseOnUBussiness")
  public ModelAndView RecommendBaseOnUBussiness(ModelAndView modelAndView,String page,HttpServletRequest request)
  {
    	modelAndView.setViewName("jsp/product-category");
    	User loginUser = (User) request.getSession().getAttribute("loginUser");
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		int itemsCount=30;
		ReviewDao reviewdao=(ReviewDaoImp)factory.getBean("ReviewDaoImp");  
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		//若用户没有登陆则使用加权推荐
		if(loginUser==null){							
		    modelAndView.addObject("TAG", "Recommend");
			modelAndView.addObject("businessCount",itemsCount);
			modelAndView.addObject("urldo","changePage_nomalRecommend.do"); 					
	        }
	    else {
	    	int reviewnumber=reviewdao.singleUserReviewCount(loginUser.getUser_id());
	    	
	    	if(reviewnumber==0) {
	    		modelAndView.addObject("TAG", "Recommend");
				modelAndView.addObject("businessCount",itemsCount);
				modelAndView.addObject("urldo","changePage_nomalRecommend.do"); 	
	    	}else {
	    		modelAndView.addObject("TAG", "Recommend");
				modelAndView.addObject("businessCount",itemsCount);
				modelAndView.addObject("urldo","changePage_BusinessRecommend.do"); 
	    	}
	    	
	    }
		return modelAndView;
 	
  }
    @RequestMapping(value="/same")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String same(HttpServletRequest request){  
    	
    	RecommandorService recserv = new RecommandorService();
    	String jsonStr="";
        ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
        ReviewDao reviewDaoImp=(ReviewDaoImp)factory.getBean("ReviewDaoImp");
    	BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
        ArrayList<String> myFavorite = new ArrayList<>();
        myFavorite.add(request.getParameter("businessid"));   
    	List<String> guessing = recserv.GuessingLike(myFavorite, 0,6);    		
        List<BItem> businessList_type=businessDaoImp.getBusinessListbyIdList(guessing);
        jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_type);    		    	
		return jsonStr;
    }
}
