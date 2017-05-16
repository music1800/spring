package com.lg.sort;

public  class InsertSort {
	
	public static void sort(int[] array) {
		for(int i = 2; i < array.length;i++){
			int val = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > val){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = val;
		}
	}
}
