package com.food.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;  
import org.json.JSONException; 

import com.alibaba.fastjson.JSON;

import com.food.model.*;



public class parseJSON {
	public static List parseJSONStringToList(String jsonString){
		return JSON.parseArray(jsonString);
	}
	public static List<String>parseList(String json){
		List<String>lists=new ArrayList<String>();
		try {  

            JSONArray jArray = new JSONArray(json);  

            int length = jArray.length();  

            for (int i = 0; i < length; i++) {  
                String string = jArray.getString(i);  
               lists.add(string);
            }  
  
        } catch (JSONException e) {  
            // TODO: handle exception  
        }
		return lists;  
	}
	public static String parseJSONListToString(List lists){
		int number=lists.size();
		String result="[";
		if(number>1) {
			result+=lists.get(0);
			for(int i=1;i<number;i++) {
				result+=","+lists.get(i);
			}
			
		}
		else if(number==1){
			result+=lists.get(0);
		}
		result +="]";
		return result;
	}
	public static Map<String,?> parseJSONStringToMap(String jsonString){
		System.out.println(jsonString);
		return JSON.parseObject(jsonString).getInnerMap();
	}
	public static List parseJSONFile(String filename,Class cla){
			
		   File file = new File(filename);
		   if(file.exists()){
			   try {
				BufferedReader reader = new BufferedReader(
						   new InputStreamReader(new FileInputStream(file)));
				String readline ="";//reader.readLine();
				if(cla==Photo.class)
				{
					List<Photo> list = new ArrayList<Photo>();
					while((readline = reader.readLine())!=null){
						Photo ph = JSON.parseObject(readline,Photo.class);
						list.add(ph);
					}
					reader.close();
					return list;
				}
				if(cla==Business.class){
					List<Business> list = new ArrayList<Business>();
					while((readline = reader.readLine())!=null){
						Business business = JSON.parseObject(readline,Business.class);
						list.add(business);
					}
					//List list1 = parseJSONStringToList(list.get(0).getCategories());
					reader.close();
					return list;
				}
				if(cla==Review.class){
					List<Review> list = new ArrayList<Review>();
					while((readline = reader.readLine())!=null){
						Review review = JSON.parseObject(readline,Review.class);
						list.add(review);
					}
					reader.close();
					return list;
				}
				if(cla==User.class){
					List<User> list = new ArrayList<User>();
					while((readline = reader.readLine())!=null){
						User user = JSON.parseObject(readline,User.class);
						list.add(user);
					}
					reader.close();
					return list;
				}
			   }catch(Exception e){
				   
				   }
			   }
		
	return null;
	}
	
	public static void main(String[] args){
		 //参数1:文件路径,参数2:Model.class,返回值:list<Model>
		 List<Business> list = parseJSONFile("FilterdBusiness.json",Business.class);
		
	   }
	   
}
