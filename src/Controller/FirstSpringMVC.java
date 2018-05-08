package com.food.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.food.dao.BusinessDao;
import com.food.dao.UserDao;
import com.food.daoImp.UserDaoImp;
import com.food.model.User;
import com.food.util.LogUtil;
import com.food.daoImp.BusinessDaoImp;
import com.food.view.BItem;


@Controller
@RequestMapping
public class FirstSpringMVC {
	
    @RequestMapping("/spring")
    public ModelAndView test()
    {
        String str = "this is a SpringMVC instance!";
        return new ModelAndView("single-product","str",str);
    }

	@RequestMapping("/ToLogin")
    public ModelAndView ToLogin(HttpServletRequest request)
    {
        return new ModelAndView("login","index","");
    }
    
	@SuppressWarnings("resource")
	@RequestMapping("/login")
    public ModelAndView Login(HttpServletRequest request,HttpServletResponse response)
    {
		String phoneNum = request.getParameter("phoneNum");  
		String password = request.getParameter("password"); 
		String checked=request.getParameter("rememberme");
		System.out.println(checked);
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		UserDao userDaoImp=(UserDaoImp)factory.getBean("UserDaoImp");
		User user=userDaoImp.login(phoneNum, password);
		if(user==null){
			return new ModelAndView("login","error1","wrong");
		}
		else {
			if(checked!=null){
			 //自动登录cookie  
		    Cookie userNameCookie = new Cookie("loginUserName", user.getName());  
		    Cookie IdCookie = new Cookie("loginId", user.getUser_id());
		    Cookie passwordCookie = new Cookie("loginPassword", user.getPassword());
		    userNameCookie.setMaxAge(30 * 60);  
		    userNameCookie.setPath("/");  
		    passwordCookie.setMaxAge(30 * 60);  
		    passwordCookie.setPath("/");  
		    response.addCookie(userNameCookie);  
		    response.addCookie(passwordCookie);
		    response.addCookie(IdCookie);
			}
		    //登陆
		    request.getSession().setAttribute("loginUser", user);
			return new ModelAndView("login");
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
			return new ModelAndView("login");
			}
    }
    
    @SuppressWarnings("resource")
	@RequestMapping("/FirstHighScore")
    public ModelAndView ReadFirstHighScore(ModelAndView modelAndView,HttpServletRequest request)
    {
    	modelAndView.setViewName("product-category");
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		List<BItem> businessList=businessDaoImp.getHighScoreBusinessList(0);
		//1:在跳转前传递TAG值，在product-category界面接收并放到链接上传递给单界面跳转的controller
		modelAndView.addObject("TAG", "HighScore");
		modelAndView.addObject("businessList", businessList);
        return modelAndView;
    }
    
    @SuppressWarnings("resource")
	@RequestMapping("/SingleBusiness")
    public ModelAndView SingleBusiness(HttpServletRequest request,ModelAndView modelAndView)
    {
    	modelAndView.setViewName("single-product");
    	String businessId = request.getParameter("businessId");
    	//2：接收TAG值
    	String TAG = request.getParameter("TAG");  
    	ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		BItem bItem=businessDaoImp.getBusinessById(businessId);
		modelAndView.addObject("BusinessItem",bItem);
		//判断用户是否登陆
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		//登陆则对用户行为进行log记录
		if(loginUser!=null) LogUtil.infoPrint(loginUser.getUser_id(),bItem.getBusiness_id(),TAG);
        return modelAndView;
    }
    
    @SuppressWarnings("resource")
	@RequestMapping("/HighScore")
    public ModelAndView ReadHighScore(ModelAndView modelAndView,String page)
    {
        //调用业务处理LoginCheck
    	modelAndView.setViewName("product-category");
		ApplicationContext factory=new ClassPathXmlApplicationContext("/applicationContext/application_spring_mvc.xml");
		BusinessDao businessDaoImp=(BusinessDaoImp)factory.getBean("BusinessDaoImp");
		List<BItem> businessList=businessDaoImp.getHighScoreBusinessList(Integer.parseInt(page));
		modelAndView.addObject("businessList", businessList);
		modelAndView.addObject("TAG", "HighScore");
        return modelAndView;
    }

}
