package com.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.dao.BusinessDao;
import com.food.dao.ReviewDao;
import com.food.daoImp.BusinessDaoImp;
import com.food.util.StringUtil;
import com.food.view.BItem;
import com.food.view.ReviewItem;
import com.food.daoImp.ReviewDaoImp;
import com.food.model.User;
import com.food.service.RecommandorService;;

@Controller 
public class changePageController {
	
	@RequestMapping(value="/changePage_review")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changePage_review(HttpServletRequest request){  
    	int pageNum=1,onePageCount=3;
    	String businessId = "";
    	if(request.getParameter("pageNum")!=null)
        	pageNum = Integer.parseInt(request.getParameter("pageNum"));
        	if(request.getParameter("onePageCount")!=null)
        		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
        	if(request.getParameter("businessId")!=null)
        		businessId = request.getParameter("businessId");
        	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
        	  ReviewDao reviewDaoImp = (ReviewDaoImp)factory.getBean("ReviewDaoImp");
        	  List<ReviewItem> reviewList = reviewDaoImp.getSingleBusinessReviewList(businessId,(pageNum-1)*onePageCount,onePageCount);
              String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(reviewList);
            
              return jsonStr;
    }
    @RequestMapping(value="/changePage_city")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String mainbottom(HttpServletRequest request){  
    	int pageNum=1,onePageCount=12;
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
    	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
    	 // request.setAttribute("urldo","changePage.do"); 
    	  List<BItem> businessList_city=businessDaoImp.getBusinessListOfSingleCity(condition,(pageNum-1)*onePageCount,onePageCount);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_city);
        return jsonStr;
    }
    @RequestMapping(value="/changePage_country")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changePageCountry(HttpServletRequest request){  
    	int pageNum=1,onePageCount=12;
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
    	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
    	 // request.setAttribute("urldo","changePage.do"); 
    	  List<BItem> businessList_country=businessDaoImp.getBusinessListOfSingleCountry(condition,(pageNum-1)*onePageCount,onePageCount);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_country);
        return jsonStr;
    }
    @RequestMapping(value="/changePage_type")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changePageType(HttpServletRequest request){  
    	int pageNum=1,onePageCount=12;
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	    ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
        BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
        
    	  List<BItem> businessList_type=businessDaoImp.getChoosenBusinessList(condition,(pageNum-1)*onePageCount,onePageCount);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_type);
        return jsonStr;
    }
    @RequestMapping(value="/changePage_env")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changePageEnv(HttpServletRequest request){  
    	int pageNum=1,onePageCount=12;
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
    	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
    	 // request.setAttribute("urldo","changePage.do"); 
    	  List<BItem> businessList_env=businessDaoImp.getBusinessEnvironment(condition,(pageNum-1)*onePageCount,onePageCount);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_env);
        return jsonStr;
    }
    @RequestMapping(value="/changePage_HighScore")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changepage_highscore(HttpServletRequest request){  
    	int pageNum=1,onePageCount=12;
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
    	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
    	
    	  List<BItem> businessList_score=businessDaoImp.getHighScoreBusinessList((pageNum-1)*onePageCount,onePageCount);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_score);
        return jsonStr;
    }
    
    @RequestMapping(value="/changePage_Hottest")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changepage_hottest(HttpServletRequest request){  
    	int pageNum=1,onePageCount=12;
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	    ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
    	BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");    	
        List<BItem> businessList_hot=businessDaoImp.getHottestBusinessList((pageNum-1)*onePageCount,onePageCount);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_hot);
        ((AbstractApplicationContext) factory).close();
        return jsonStr;
        
    }
    
    @RequestMapping(value="/changePage_search")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changePage_search(HttpServletRequest request){  
    	RecommandorService recserv = new RecommandorService();
    	int pageNum=1,onePageCount=12;
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
    	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");    		
      		// Split search string into words by space (" ").
      		List<String> conditions = StringUtil.GetSearchCondition(condition);
      		List<BItem> itemlist = businessDaoImp.QueryBusiness(conditions,(pageNum-1)*onePageCount,onePageCount);
      	ArrayList<String> myFavorite = new ArrayList<>();
        myFavorite.add(itemlist.get(0).getBusiness_id());   
        List<String> guessing = recserv.GuessingLike(myFavorite, 0,2);    		
        List<BItem> businessList_type=businessDaoImp.getBusinessListbyIdList(guessing);
        int flag1=0,flag2=0;
    	for(int i=0;i<itemlist.size();i++) {
    		if(itemlist.get(i).getBusiness_id()==businessList_type.get(0).getBusiness_id()) {
    			flag1=1;
    			
    		}else if(itemlist.get(i).getBusiness_id()==businessList_type.get(1).getBusiness_id()){
    			flag2=1;
    		}
    	}
    	if(flag1==0) {
    		int random=(int)(Math.random()*itemlist.size());
    		itemlist.set(random, businessList_type.get(0));
    	}
    	if(flag2==0) {
    		int random=(int)(Math.random()*itemlist.size());
    		itemlist.set(random, businessList_type.get(1));
    	}
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(itemlist);
        return jsonStr;
    }
    @RequestMapping(value="/changePage_nomalRecommend")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changePageNomalRecommend(HttpServletRequest request){  
    	int pageNum=1,onePageCount=12;
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	    ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
        BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
    	  List<BItem> businessList_type=businessDaoImp.getRecommendBusiness((pageNum-1)*onePageCount,onePageCount);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_type);
        return jsonStr;
    }
    @RequestMapping(value="/changePage_UserRecommend")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changePageUserRecommend(HttpServletRequest request){  
    	int pageNum=1,onePageCount=12;
    	User loginUser = (User) request.getSession().getAttribute("loginUser");
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	    ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
        BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
        String id=businessDaoImp.getUserFakeId(loginUser.getUser_id());
    	List<BItem> businessList_type=businessDaoImp.getRecommendBusinessBaseOnUser(businessDaoImp.getUserFakeId(loginUser.getUser_id()),(pageNum-1)*onePageCount,onePageCount);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_type);
        return jsonStr;
    }
    @RequestMapping(value="/changePage_BusinessRecommend")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值 
    public String changePageBusinessRecommend(HttpServletRequest request){  
    	RecommandorService recserv = new RecommandorService();
    	int pageNum=1,onePageCount=12;
    	User loginUser = (User) request.getSession().getAttribute("loginUser");
    	String condition="";
    	if(request.getParameter("pageNum")!=null)
    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	if(request.getParameter("onePageCount")!=null)
    		onePageCount =  Integer.parseInt(request.getParameter("onePageCount"));
    	if(request.getParameter("condition")!=null)
    		condition = request.getParameter("condition");
  	    ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
        BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
        ReviewDao reviewDaoImp=(ReviewDaoImp)factory.getBean("ReviewDaoImp");
        ArrayList<String> myFavorite = new ArrayList<>();
        myFavorite=(ArrayList<String>) reviewDaoImp.getSingleUserReviewList(loginUser.getUser_id());
		List<String> guessing = recserv.GuessingLike(myFavorite, (pageNum-1)*onePageCount,onePageCount);
		
    	List<BItem> businessList_type=businessDaoImp.getBusinessListbyIdList(guessing);
        String jsonStr = com.alibaba.fastjson.JSONArray.toJSONString(businessList_type);
        return jsonStr;
    }
}
