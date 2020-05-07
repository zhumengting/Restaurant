package com.food.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.service.LikeService;

@Controller
@RequestMapping
public class LikeController {
	private LikeService likeser=new LikeService();
	
	@SuppressWarnings("resource")
	@RequestMapping("/addLikeBusiness")
	@ResponseBody//��ע�ⲻ��ʡ�� ����ajax�޷����ܷ���ֵ 
	public void addLikeBusiness(HttpServletRequest request){
		  String userid=request.getParameter("userid");
		  String businessid=request.getParameter("businessid");
		  likeser.AddLikeRestaurant(userid, businessid);
	  }
	
	@SuppressWarnings("resource")
	@RequestMapping("/deleteLikeBusiness")
	@ResponseBody//��ע�ⲻ��ʡ�� ����ajax�޷����ܷ���ֵ 
	public void deleteLikeBusiness(HttpServletRequest request){
		  String userid=request.getParameter("userid");
		  String businessid=request.getParameter("businessid");
		  likeser.DeleteLikeRestaurant(userid, businessid);
	  }
}
