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
public class SearchController {
	@RequestMapping("/ToMap")
    public ModelAndView ToMap(ModelAndView modelAndView,HttpServletRequest request)
    {
		modelAndView.setViewName("jsp/newmap");
		Float longitude = Float.valueOf(request.getParameter("longitude"));
		Float latitude = Float.valueOf(request.getParameter("latitude"));
		String name = request.getParameter("name");
		String img = request.getParameter("img");
		modelAndView.addObject("longitude",longitude);
		modelAndView.addObject("latitude",latitude);
		modelAndView.addObject("name",name);
		modelAndView.addObject("img",img);
        return modelAndView;
    }
    @SuppressWarnings("resource")
    @RequestMapping("/FirstHighScore")
    public ModelAndView ReadFirstHighScore(ModelAndView modelAndView){
  	  modelAndView.setViewName("jsp/product-category");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
  	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
  	 int itemsCount = businessDaoImp.getAllNumber();
  	  //1:在跳转前传递TAG值，在product-category界面接收并放到链接上传递给单界面跳转的controller
  	  modelAndView.addObject("TAG", "HighScore");
  	  modelAndView.addObject("businessCount",itemsCount);
  	  modelAndView.addObject("urldo","changePage_HighScore.do"); 
  	  modelAndView.addObject("condition", "HighScore");
  	  return modelAndView;
    }
    @SuppressWarnings("resource")
  	@RequestMapping("/ReadHottest")
    public ModelAndView ReadHottest(ModelAndView modelAndView)
    {
        //调用业务处理LoginCheck
    	modelAndView.setViewName("jsp/product-category");
  		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
  		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
  		int itemsCount = businessDaoImp.getAllNumber();
    	  //1:在跳转前传递TAG值，在product-category界面接收并放到链接上传递给单界面跳转的controller
    	  modelAndView.addObject("TAG", "Hottest");
    	  modelAndView.addObject("businessCount",itemsCount);
    	  modelAndView.addObject("urldo","changePage_Hottest.do"); 
    	  modelAndView.addObject("condition", "Hottest");
    	  return modelAndView;
    }    
    @SuppressWarnings("resource")
	@RequestMapping("/SingleBusiness")
    public ModelAndView SingleBusiness(HttpServletRequest request)
    {
        //调用业务处理LoginCheck
    	String businessId = request.getParameter("businessId");  
    	//2：接收TAG值
    	String TAG = request.getParameter("TAG");
    	ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		BItem bItem=businessDaoImp.getBusinessById(businessId);
	
		//判断用户是否登陆
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		//登陆则对用户行为进行log记录

		if(loginUser!=null) LogUtil.infoPrint(loginUser.getUser_id(),bItem.getBusiness_id(),TAG);
		
        return new ModelAndView("jsp/single-product","BusinessItem",bItem);
    }
    
    @SuppressWarnings("resource")
    @RequestMapping("/City")
    public ModelAndView ReadBusinessOfSingleCity(@RequestParam(value="m_city",required=true)String cityName,ModelAndView modelAndView){
  	  modelAndView.setViewName("jsp/product-category");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
  	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
  	 int itemsCount = businessDaoImp.cityBusinessCount(cityName);
  	  //1:在跳转前传递TAG值，在product-category界面接收并放到链接上传递给单界面跳转的controller
  	  modelAndView.addObject("TAG", cityName);
  	  modelAndView.addObject("businessCount",itemsCount);
  	  modelAndView.addObject("urldo","changePage_city.do"); 
  	  modelAndView.addObject("condition", cityName);
  	  return modelAndView;
    }
    @SuppressWarnings("resource")
    @RequestMapping("/Country")
    public ModelAndView ReadBusinessOfSingleCountry(@RequestParam(value="m_country",required=true)String countryName,ModelAndView modelAndView){
  	  modelAndView.setViewName("jsp/product-category");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
  	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
  	int itemsCount = businessDaoImp.categoriesBusinessCount(countryName);
	  //1:在跳转前传递TAG值，在product-category界面接收并放到链接上传递给单界面跳转的controller
	  modelAndView.addObject("TAG", countryName);
	  modelAndView.addObject("businessCount",itemsCount);
	  modelAndView.addObject("urldo","changePage_country.do"); 
	  modelAndView.addObject("condition", countryName);
  	  return modelAndView;
    }
  @SuppressWarnings("resource")
  @RequestMapping("/SingleBusinessDetail")
 
  public ModelAndView ReadSingleBusinessDetail(@RequestParam(value="m_businessId",required=true)String businessId,@RequestParam(value="TAG",required=true)String TAG,ModelAndView modelAndView,HttpServletRequest request){
	  modelAndView.setViewName("jsp/single-product");
	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
	  BItem singleBusiness = businessDaoImp.getSingleBusinessById(businessId);
	  
	  Map atri =parseJSON.parseJSONStringToMap(singleBusiness.getAttributes());
	  modelAndView.addObject("attributes",atri);
	  modelAndView.addObject("singleBusiness",singleBusiness);
	  modelAndView.addObject("businessId",businessId);
	  Map<String,Map<String,String>> openHourMap = businessDaoImp.getOpenTimeOfSingleBusiness(singleBusiness.getHours());
	  modelAndView.addObject("openHourMap",openHourMap);
	  ReviewDao reviewDaoImp = (ReviewDaoImp)factory.getBean("ReviewDaoImp");
	  int reviewCount=reviewDaoImp.singleBusinessReviewCount(businessId);
	  modelAndView.addObject("reviewCount",reviewCount);
	  
	  ReviewOverview reviewOverview = reviewDaoImp.getSingleBusinessReviewOverview(businessId);
	  modelAndView.addObject("reviewOverview",reviewOverview);
	  //判断用户是否登陆
	  User loginUser = (User) request.getSession().getAttribute("loginUser");
	  //登陆则对用户行为进行log记录
	  if(loginUser!=null) LogUtil.infoPrint(loginUser.getUser_id(),singleBusiness.getBusiness_id(),TAG);
	  return modelAndView;
  }

  
  @SuppressWarnings("resource")
	@RequestMapping("/ChooseCategory")
  public ModelAndView ChooseCategory(@RequestParam(value="chooseCategory" ,required =true ) String cCategory,ModelAndView modelAndView,String page)
  {

	  modelAndView.setViewName("jsp/product-category");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
  	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
  	  int itemsCount = businessDaoImp.categoriesBusinessCount(cCategory);
	  //1:在跳转前传递TAG值，在product-category界面接收并放到链接上传递给单界面跳转的controller
	  modelAndView.addObject("TAG", cCategory);
	  modelAndView.addObject("businessCount",itemsCount);
	  modelAndView.addObject("urldo","changePage_type.do"); 
	  modelAndView.addObject("condition", cCategory);
  	  return modelAndView;
  	
  }

  
  @SuppressWarnings("resource")
	@RequestMapping("/ChooseEnvironment")
  public ModelAndView ChooseEnvironment(@RequestParam(value="chooseCategory" ,required =true ) String cCategory,ModelAndView modelAndView,String page)
  {
	  modelAndView.setViewName("jsp/product-category");
  	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
  	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
  	  int itemsCount = businessDaoImp.EnvBusinessCount(cCategory);
	  //1:在跳转前传递TAG值，在product-category界面接收并放到链接上传递给单界面跳转的controller
	  modelAndView.addObject("TAG", cCategory);
	  modelAndView.addObject("businessCount",itemsCount);
	  modelAndView.addObject("urldo","changePage_env.do"); 
	  modelAndView.addObject("condition", cCategory);
  	  return modelAndView;
  }


  @SuppressWarnings("resource")
  @RequestMapping("/search")
  public ModelAndView search(@RequestParam(value="search",required=false)String search,ModelAndView modelAndView){
	  modelAndView.setViewName("jsp/product-category");
	 
	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
	  List<String> condition = StringUtil.GetSearchCondition(search);
	  int itemsCount = businessDaoImp.searchBusinessCount(search);
	  modelAndView.addObject("businessCount",itemsCount);
	  modelAndView.addObject("urldo","changePage_search.do"); 
	  modelAndView.addObject("condition", search);
	  return modelAndView;
  }
}
