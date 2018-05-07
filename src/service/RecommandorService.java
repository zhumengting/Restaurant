package com.food.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.math3.distribution.NormalDistribution;
import com.food.view.BItem;

public class RecommandorService {

	/**
	 * Dither a stable result (a stable business item list).
	 * 
	 * The idea behind dithering is to re-order the recommendations list by adding random
	 * noise to the original relevance-based ordering. This results in surfacing some of 
	 * the items that are further down the list to the first page.In doing so, it¡¯s possible
	 * to create the illusion of freshness in the list of recommendations as they appear 
	 * to change regularly between visits although they may actually have been generated 
	 * from a single run of a recommender model.  What¡¯s more, there are also benefits to
	 * recommending more items to users as it increases the variety of interactions from
	 * which our system can learn. 
	 * 
	 * @param recommandation Stable business item list
	 * @param epsilon Effect intension factor. Randomness goes up as the factor growing larger.
	 * @return Reordered business list
	 */
	public List<BItem> Dithering(List<BItem> recommandation, float epsilon) {
		List<BItem> newRecmmdList = new ArrayList<BItem>();
		SortedMap<Float, BItem> newRecmmdsMap = new TreeMap<Float, BItem>();
		NormalDistribution normalD = new NormalDistribution(0, Math.log(epsilon));
		
		for(int i = 0; i < recommandation.size(); ++i) {
			newRecmmdsMap.put(new Float(Math.log(i + 1) + normalD.sample()), recommandation.get(i));
		}
		Iterator iterator = newRecmmdsMap.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			newRecmmdList.add((BItem) entry.getValue());
		}
		
		return newRecmmdList;
	}
	
}
