package com.food.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.lang.SystemUtils;

public class FileOperation {
	/**
	 * Write an object into a file under the directory "/src/main/webapp/objects/".
	 * 
	 * @param obj Object that ready to write into a file
	 * @param filename Name of the file that stores the object
	 */
	public  static void WriteObjectIntoFile(Object obj, String filename) {
		ObjectOutputStream outputStream = null;

		try {
			String MatrixFileName = SystemUtils.getUserDir() + "\\src\\main\\webapp\\objects\\" + filename;
			outputStream = new ObjectOutputStream(new FileOutputStream(MatrixFileName));
			outputStream.writeObject(obj);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Read an object from file under the directory "/src/main/webapp/objects/".
	 * 
	 * @param filename Name of a file that stores the object
	 * @return Object that store in the file
	 */
	public static Object ReadObjectFromFile(String filename) {
		ObjectInputStream inputStream = null;
		Object reading = null;
		try {
			String MatrixFileName = "E:\\zmt\\eclipse_app\\Restaurant" + "\\src\\main\\webapp\\objects\\" + filename;
			inputStream = new ObjectInputStream(new FileInputStream(MatrixFileName));
			reading = inputStream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return reading;
	}



}
