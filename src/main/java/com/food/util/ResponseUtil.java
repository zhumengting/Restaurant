package com.food.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


public class ResponseUtil {

	public static void write(Object jsonObject,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");//��Ϣͷ�����ݰ���ʽ
		PrintWriter out=response.getWriter();//io��
		out.println(jsonObject.toString());//��ҳ����
		out.flush();//ˢ��
		out.close();
	}
}
