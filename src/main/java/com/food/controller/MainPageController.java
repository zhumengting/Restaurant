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

import com.food.dao.BusinessDao;
import com.food.dao.ReviewDao;
import com.food.daoImp.BusinessDaoImp;
import com.food.daoImp.ReviewDaoImp;
import com.food.model.Photo;
import com.food.model.User;
import com.food.service.MainPageServices;
import com.food.service.RecommandorService;
import com.food.util.ResponseUtil;
import com.food.view.BItem;

import net.sf.json.JSONArray;

@Controller 
public class MainPageController {
	MainPageServices mser=new MainPageServices();
	@RequestMapping(value="/autoComplemSearch")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String autoComplementSearch(HttpServletRequest request){
	   String keyword = request.getParameter("keyword").toString();
 	   ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
 	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
 	 List<String> businessName =  businessDaoImp.autoComplementSearch(keyword);
     String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessName);

	   return jsonStr;
   }
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

    @RequestMapping(value="/mainRecommend")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String mainRecommend(HttpServletRequest request){  
    	User loginUser = (User) request.getSession().getAttribute("loginUser");
    	RecommandorService recserv = new RecommandorService();
    	String jsonStr="";
    	if(loginUser==null) {
    		Map<String, Object> map = new HashMap<String, Object>();  
            List<BItem> items=mser.getRecommend();
            jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(items);
    	}else {
    		 ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
    		ReviewDao reviewDaoImp=(ReviewDaoImp)factory.getBean("ReviewDaoImp");
    		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
            ArrayList<String> myFavorite = new ArrayList<>();
            myFavorite=(ArrayList<String>) reviewDaoImp.getSingleUserReviewList(loginUser.getUser_id());
    		List<String> guessing = recserv.GuessingLike(myFavorite, 0,6);
    		
        	List<BItem> businessList_type=businessDaoImp.getBusinessListbyIdList(guessing);
            jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_type);    		
    	}
		return jsonStr;
    }

	@RequestMapping("/ToMain")
    public ModelAndView ToLogin(HttpServletRequest request)
    {
        return new ModelAndView("main");
    }
}
	
