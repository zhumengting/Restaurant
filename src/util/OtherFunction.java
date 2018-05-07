package com.food.util;

public class OtherFunction {
public void generateRondomNumber(int[] a,int bound) {
	int number=0;
	int[] check=new int[bound+1];
	for(int i=0;i<=bound;i++) {
		check[i]=0;
	}
	while(number<10) {
		int x=(int)(Math.random()*bound);
		if(check[x]==0) {
			check[x]=1;
			a[number]=x;
			number++;
		}
	}	
}
}
