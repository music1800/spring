package com.ect.utils;

import java.lang.reflect.Field;

public class DomainToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(getClassStr(BankFlow.class));
		
		
	}
	
	
	
	public static String getClassStr(Class clazz){
		
			String str = "public String toString(){\nreturn " + "\"[\"+";
			
		  Field[] fields = clazz.getDeclaredFields();
		  
		  for(int i =0 ;i < fields.length;i++){
			
			String type = fields[i].getGenericType().toString();
			if (type.equals("class java.lang.String")) {
				String name = fields[i].getName();
				str += "\""+ name + ":\" + " + name;
				 if (i +1 < fields.length) {
					 str += "+\",\"+";
				}
			}
		  }
		  str += "+\"]\" ;\n}";
		  return str;
	}
}

