package com.food.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.food.model.User;

public class LoginInterceptor implements HandlerInterceptor {  
      
    /**  
     * preHandle�����ǽ��д����������õģ��÷�������Controller����֮ǰ���е��ã�SpringMVC�е�Interceptor����������ʽ�ģ�����ͬʱ����  
     * ���Interceptor��Ȼ��SpringMVC�����������ǰ��˳��һ����һ����ִ�У��������е�Interceptor�е�preHandle����������  
     * Controller��������֮ǰ���á�SpringMVC������Interceptor��ʽ�ṹҲ�ǿ��Խ����жϵģ������жϷ�ʽ����preHandle�ķ�  
     * ��ֵΪfalse����preHandle�ķ���ֵΪfalse��ʱ����������ͽ����ˡ�  
     */    
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
        User loginUser = (User) request.getSession().getAttribute("loginUser");  
          
        if(loginUser == null){  
        	String loginCookieUserName=null;
    		String loginCookieId=null;
    		String loginCookiePassword=null;
    		String isTimeout=null;
    		Cookie[] cookies=request.getCookies();
    		if(null!=cookies){    
                for(Cookie cookie : cookies){     
                        if("loginUserName".equals(cookie.getName())){  
                            loginCookieUserName = cookie.getValue();  
                        }else if("loginId".equals(cookie.getName())){  
                            loginCookieId = cookie.getValue();  
                        }else if("loginPassword".equals(cookie.getName())){  
                            loginCookiePassword = cookie.getValue();  
                        }else if("isTimeout".equals(cookie.getName())){  
                        	isTimeout = cookie.getValue();  
                        }       
                }
                if(isTimeout!=null){
                loginUser=new User(loginCookieId,loginCookiePassword);
                loginUser.setName(loginCookieUserName);
                request.getSession().setAttribute("loginUser", loginUser);
                }
    		}
        }
        return true;  
    }  
  
    /**  
     * �������ֻ���ڵ�ǰ���Interceptor��preHandle��������ֵΪtrue��ʱ��Ż�ִ�С�postHandle�ǽ��д����������õģ�����ִ��ʱ�����ڴ��������д���֮  
     * ��Ҳ������Controller�ķ�������֮��ִ�У�����������DispatcherServlet������ͼ����Ⱦ֮ǰִ�У�Ҳ����˵���������������Զ�ModelAndView���в�  
     * ���������������ʽ�ṹ���������ʵķ������෴�ģ�Ҳ����˵��������Interceptor�������÷������������ã����Struts2�������������ִ�й����е���  
     * ֻ��Struts2�����intercept������Ҫ�ֶ��ĵ���ActionInvocation��invoke������Struts2�е���ActionInvocation��invoke�������ǵ�����һ��Interceptor  
     * �����ǵ���action��Ȼ��Ҫ��Interceptor֮ǰ���õ����ݶ�д�ڵ���invoke֮ǰ��Ҫ��Interceptor֮����õ����ݶ�д�ڵ���invoke����֮��  
     */  
    @Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {  
        // TODO Auto-generated method stub  
          
    }  
  
    /**  
     * �÷���Ҳ����Ҫ��ǰ��Ӧ��Interceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С��÷������������������֮��Ҳ����DispatcherServlet��Ⱦ����ͼִ�У�  
     * �����������Ҫ����������������Դ�ģ���Ȼ�������Ҳֻ���ڵ�ǰ���Interceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С�  
     */   
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
        // TODO Auto-generated method stub  
          
    }  
      
}  
