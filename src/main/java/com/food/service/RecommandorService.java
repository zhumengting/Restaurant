package com.food.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.food.daoImp.RecommandDaoImp;
import com.food.model.Business;
import com.food.model.User;
import com.food.util.FileOperation;
import com.food.util.JDBC;
import com.food.util.MapUtil;
import com.food.view.BItem;

public class RecommandorService {
RecommandDaoImp rdao=new RecommandDaoImp();


	/**
	 * Dither a stable result (a stable business item list).
	 * 
	 * The idea behind dithering is to re-order the recommendations list by adding
	 * random noise to the original relevance-based ordering. This results in
	 * surfacing some of the items that are further down the list to the first
	 * page.In doing so, it¡¯s possible to create the illusion of freshness in the
	 * list of recommendations as they appear to change regularly between visits
	 * although they may actually have been generated from a single run of a
	 * recommender model. What¡¯s more, there are also benefits to recommending more
	 * items to users as it increases the variety of interactions from which our
	 * system can learn.
	 * 
	 * @param recommandation
	 *            Stable business item list
	 * @param epsilon
	 *            Effect intension factor. Randomness goes up as the factor growing
	 *            larger.
	 * @return Reordered business list
	 */
	public List<BItem> Dithering(List<BItem> recommandation, float epsilon) {
		List<BItem> newRecmmdList = new ArrayList<BItem>();
		SortedMap<Float, BItem> newRecmmdsMap = new TreeMap<Float, BItem>();
		NormalDistribution normalD = new NormalDistribution(0, Math.log(epsilon));

		for (int i = 0; i < recommandation.size(); ++i) {
			newRecmmdsMap.put(new Float(Math.log(i + 1) + normalD.sample()), recommandation.get(i));
		}
		Iterator iterator = newRecmmdsMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			newRecmmdList.add((BItem) entry.getValue());
		}

		return newRecmmdList;
	}

	

	
	/**
	 * Turn the double-dimensional-array-formed similarity matrix into map form
	 * which <K, V> is <String_businessID, Map<String_businessID, Double_similarity>>.
	 * That is the key indicates a business id and the value indicates a list of businesses' ids 
	 * that are related to the certain business. The relevance between the business in the list and 
	 * the certain business is in descending order which means business with higher similarity gets
	 * more first position in the list.
	 * 
	 * @return Similarity_Map <String, Map<String, Double>>
	 */
	private Map<String, Map> GetItemBasedSimilarityMap() {
		double[][] reading = (double[][]) FileOperation.ReadObjectFromFile("SimilarityMatrix-ItemBased.txt");
		Map<String, Map> similarityMap = new HashMap<String, Map>();
		Map<Integer, String> businessIDsMap = rdao.GetAllBusinessIDsMap();
		
		for (int bIndex = 0; bIndex < reading.length; ++bIndex) {
			TreeMap<String, Double> unSortedOneBusiSimiMap = new TreeMap<String, Double>();
			for (int i = 0; i < reading[bIndex].length; ++i) {
				if (reading[bIndex][i] != 0.0 && bIndex != i) {
					unSortedOneBusiSimiMap.put(businessIDsMap.get(i+1), reading[bIndex][i]);
				}
			}
			Map sortedOneBusiSimiMap = MapUtil.sortByValues(unSortedOneBusiSimiMap);
			
			similarityMap.put(businessIDsMap.get(bIndex+1), sortedOneBusiSimiMap);
		}
		
		return similarityMap;
	}

	

	
	
	/**
	 * Get the similarity map which <K, V> is <String_businessID, Map<String_businessID, Double_similarity>>.
	 * 
	 * @return Similarity_Map <String, Map<String_businessID, Double_similarity>>
	 */
	public Map<String, Map> GetSimilarityMap() {
		Map<String, Map> similarityMap = GetItemBasedSimilarityMap();
//				(Map<String, Map>) ReadObjectFromFile("SimilarityMap-Business");
		
		return similarityMap;
	}
	
	
	public List<String> GuessingLike(ArrayList<String> businesses, int begin,int end) {
		int business_amount = businesses.size();
		Map<String, Map> similarityMap = GetSimilarityMap();
		Map<String, Double> guessingMap = new HashMap<>();
		
		for (int i = 0; i < business_amount; ++i) {
			Map<String, Double> similarBusiness = similarityMap.get(businesses.get(i));
			Iterator iterator = similarBusiness.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry entry = (Entry) iterator.next();
				guessingMap.put((String)entry.getKey(), (Double)entry.getValue());
			}
		}
		
		guessingMap = MapUtil.sortByValues(guessingMap);
		
		List<String> guessingList = new ArrayList<String>(guessingMap.keySet());
		return guessingList.subList(begin, end);
				
	}

	public static void main(String[] args) {
		RecommandorService recserv = new RecommandorService();
		ArrayList<String> myFavorite = new ArrayList<>();
		myFavorite.add("TrbhJJUIX7ed4I8ITSOq3A");
		myFavorite.add("qUUs7IIytYWyWlWXH7Rz-w");
		List<String> guessing = recserv.GuessingLike(myFavorite, 0,100);
		for (int i = 0; i < guessing.size(); ++i) {
			System.out.println(guessing.get(i));
		}
		System.out.println("Size: " + guessing.size());
	}
}
