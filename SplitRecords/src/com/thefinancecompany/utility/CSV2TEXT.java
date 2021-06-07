package com.thefinancecompany.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class CSV2TEXT implements Serializable {
	private static final long serialVersionUID = 2765929083985289594L;
	static int linecounter = 0;
	static String dkirPath = "C:\\Users\\vkumbam\\Documents\\AIA_Vitality_Related\\Bulk_Points_Allotment\\BulkPoints_Incidents\\HK_Market Incidents\\INC2363230_HK";
	
	
	/////////////////////
	///
	///   TXT TYPE
	///
	////////////////////
	static String readFromFileTXT() throws IOException {
		File file = new File(dkirPath+"\\csvtotextfile.csv");
		FileReader reader = new FileReader(file);  
	    BufferedReader buffer = new BufferedReader(reader);
	    String line ="";
	    List<CSV2TEXTModel> records = new ArrayList<>();
	    while((line = buffer.readLine())!=null) {
	    	CSV2TEXTModel obj = new CSV2TEXTModel();
	    	String[] str =line.split(",");
	    	System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]+" "+str[4]);
	    	obj.setId(str[0]);
	    	obj.setId2(str[1]);
	    	obj.setEvent(str[2]);
	    	obj.setPoints(str[3]);
	    	obj.setDate(str[4]);
	    	records.add(obj);
	    }
	    System.out.println("records size is :"+records.size());
	   Iterator<CSV2TEXTModel> itr = records.iterator();
	   List<CSV2TEXTModel> batch = new ArrayList<>();
	   int count=0;
	   int fileCount=1;
	   while(itr.hasNext()) {
		   batch.add(itr.next());
		   count++;
		   if(count==1000) {
			   writtenIntoFileTXT(batch,fileCount);
			   count=0;
			   fileCount++;
			   batch.clear();
		   }
	   }
	    return "We are created "+(fileCount-(1))+" .txt files in your dkir";
	}
	
	
	
	static String writtenIntoFileTXT(List<CSV2TEXTModel> records, int counter) throws IOException {
		File file = new File(dkirPath+"\\file"+counter+".txt");
		FileWriter writer = new FileWriter(file);  
	    BufferedWriter buffer = new BufferedWriter(writer);
	    for(CSV2TEXTModel str:records) {
	    	buffer.write(str.getId()+"	"+str.getId2()+"	"+str.getEvent()+"	"+str.getPoints()+"	 "+str.getDate());
	    	buffer.newLine();
	    }
	    buffer.close();
		return "done with batch "+counter;
	}
	
	
	/////////////////////
	///
	///   CSV TYPE
	///
	////////////////////
	
	static String readFromFileCSV() throws IOException {
		File file = new File(dkirPath+"\\csvtotextfile.csv");
		FileReader reader = new FileReader(file);  
	    BufferedReader buffer = new BufferedReader(reader);
	    String line ="";
	    List<CSV2TEXTModel> records = new ArrayList<>();
	    while((line = buffer.readLine())!=null) {
	    	CSV2TEXTModel obj = new CSV2TEXTModel();
	    	String[] str =line.split(",");
	    	System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]+" "+str[4]);
	    	obj.setId(str[0]);
	    	obj.setId2(str[1]);
	    	obj.setEvent(str[2]);
	    	obj.setPoints(str[3]);
	    	obj.setDate(str[4]);
	    	records.add(obj);
	    }
	    System.out.println("records size is :"+records.size());
	   Iterator<CSV2TEXTModel> itr = records.iterator();
	   List<CSV2TEXTModel> batch = new ArrayList<>();
	   int count=0;
	   int fileCount=1;
	   while(itr.hasNext()) {
		   batch.add(itr.next());
		   count++;
		   if(count==1000) {
			   writtenIntoFileCSV(batch,fileCount);
			   count=0;
			   fileCount++;
			   batch.clear();
		   }
	   }
	    return "We are created "+(fileCount-(1))+" .csv files in your dkir";
	}
	
	
	
	static String writtenIntoFileCSV(List<CSV2TEXTModel> records, int counter) throws IOException {
		File file = new File(dkirPath+"\\file"+counter+".csv");
		FileWriter writer = new FileWriter(file);  
	    BufferedWriter buffer = new BufferedWriter(writer);
	    for(CSV2TEXTModel str:records) {
	    	buffer.write(str.getId()+","+str.getId2()+","+str.getEvent()+","+str.getPoints()+","+str.getDate());
	    	buffer.newLine();
	    }
	    buffer.close();
		return "done with batch "+counter;
	}
	public static void main(String[] args) throws IOException {
		System.out.println("Select your prefered type out of .txt or .csv ");
		System.out.println("Press 1 for .txt file");
		System.out.println("Press 2 for .csv file");
		Scanner sc = new Scanner(System.in);
		 String userChoice = sc.next();
		 if(userChoice.contains("1")|| userChoice.contains("2")) {
			 if(userChoice.contains("1")) {
				 System.out.println(readFromFileTXT());
			 }
			 else
				 System.out.println(readFromFileCSV()); 
		 }
		 else
			 System.out.println("Please don't be over smart!");
		 sc.close();
		
		
	}
}
 