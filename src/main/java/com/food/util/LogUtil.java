package com.food.util;

import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
public class LogUtil {  
    public static File file;  
    public static String filePath;  
    public LogUtil(){  
          
    }  
    public static void  infoPrint(String UId,String BId,String TAG){  
        filePath="E:\\zmt\\eclipse_app\\Restaurant\\src\\main\\webapp\\log\\"+UId+".txt";  
        file =new File(filePath);  
        if (file==null || !file.exists()){  
            try {  
                file.createNewFile();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH-mm-ss");  
        String dateString=df.format(new Date());  
        try {  
            FileWriter writer = new FileWriter(file, true);  
            String content=TAG+"#"+BId+"#"+dateString+"\r\n";  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
  
}  
