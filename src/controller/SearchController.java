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
	@SuppressWarnings("resource")
	@RequestMapping("/FirstHighScore")
    public ModelAndView ReadFirstHighScore(HttpServletRequest request)
    {
        //调用业务处理LoginCheck
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		List<BItem> businessList=businessDaoImp.getHighScoreBusinessList(0);
		System.out.println(businessList.size());
        return new ModelAndView("jsp/product-category","businessList",businessList);
    }
    
    @SuppressWarnings("resource")
	@RequestMapping("/SingleBusiness")
    public ModelAndView SingleBusiness(HttpServletRequest request)
    {
        //调用业务处理LoginCheck
    	String businessId = request.getParameter("businessId");  
    	ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		BItem bItem=businessDaoImp.getBusinessById(businessId);
		System.out.println(bItem.getAttributes());
        return new ModelAndView("jsp/single-product","BusinessItem",bItem);
    }
    
    @SuppressWarnings("resource")
	@RequestMapping("/HighScore")
    public ModelAndView ReadHighScore(ModelAndView modelAndView,String page)
    {
        //调用业务处理LoginCheck
    	modelAndView.setViewName("jsp/product-category");
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		List<BItem> businessList=businessDaoImp.getHighScoreBusinessList(Integer.parseInt(page));
		modelAndView.addObject("businessList", businessList);
        return modelAndView;
    }
  @SuppressWarnings("resource")
  @RequestMapping("/City")
  public ModelAndView ReadBusinessOfSingleCity(@RequestParam(value="m_city",required=true)String cityName,ModelAndView modelAndView){
	  modelAndView.setViewName("jsp/product-category");
	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
	  List<BItem> businessList_city=businessDaoImp.getBusinessListOfSingleCity(cityName);
	  modelAndView.addObject("businessList",businessList_city);
	  return modelAndView;
  }
  @SuppressWarnings("resource")
  @RequestMapping("/Country")
  public ModelAndView ReadBusinessOfSingleCountry(@RequestParam(value="m_country",required=true)String countryName,ModelAndView modelAndView){
	  modelAndView.setViewName("jsp/product-category");
	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
	  List<BItem> businessList_country=businessDaoImp.getBusinessListOfSingleCountry(countryName);
	  modelAndView.addObject("businessList",businessList_country);
	  return modelAndView;
  }
  @SuppressWarnings("resource")
  @RequestMapping("/SingleBusinessDetail")
  public ModelAndView ReadSingleBusinessDetail(@RequestParam(value="m_businessId",required=true)String businessId,ModelAndView modelAndView){
	  modelAndView.setViewName("jsp/single-product");
	  ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
	  BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
	  BItem singleBusiness = businessDaoImp.getSingleBusinessById(businessId);
	  Map atri =parseJSON.parseJSONStringToMap(singleBusiness.getAttributes());
	  modelAndView.addObject("attributes",atri);
	  modelAndView.addObject("singleBusiness",singleBusiness);
	 
	  ReviewDao reviewDaoImp = (ReviewDaoImp)factory.getBean("ReviewDaoImp");
	  List<ReviewItem> reviewList = reviewDaoImp.getSingleBusinessReviewList(businessId);
	  ReviewOverview reviewOverview = reviewDaoImp.getSingleBusinessReviewOverview(businessId);
	  modelAndView.addObject("reviewOverview",reviewOverview);
	  modelAndView.addObject("reviewList",reviewList);
	  return modelAndView;
  }
  @SuppressWarnings("resource")
	@RequestMapping("/ReadHottest")
  public ModelAndView ReadHottest(ModelAndView modelAndView,String page)
  {
      //调用业务处理LoginCheck
  	modelAndView.setViewName("jsp/product-category");
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		List<Business> businessList=businessDaoImp.getHottestBusinessList();
		System.out.println(businessList.size());
		modelAndView.addObject("businessList", businessList);
      return modelAndView;
  }
  
  @SuppressWarnings("resource")
	@RequestMapping("/ChooseCategory")
  public ModelAndView ChooseCategory(@RequestParam(value="chooseCategory" ,required =true ) String cCategory,ModelAndView modelAndView,String page)
  {
  	System.out.println(cCategory);
      //调用业务处理LoginCheck
  	modelAndView.setViewName("jsp/product-category");
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		List<BItem> businessList=businessDaoImp.getChoosenBusinessList(cCategory);
		System.out.println(businessList.size());
		modelAndView.addObject("businessList", businessList);
      return modelAndView;
  }

  @SuppressWarnings("resource")
	@RequestMapping("/search")
  public ModelAndView search(HttpServletRequest request)
  {
      //调用业务处理LoginCheck
  	String search = request.getParameter("search");  
  	ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		List<String> condition = StringUtil.GetSearchCondition(search);
		List<BItem> itemlist = businessDaoImp.QueryBusiness(condition);
      return new ModelAndView("jsp/product-category","businessList",itemlist);
  }
}
