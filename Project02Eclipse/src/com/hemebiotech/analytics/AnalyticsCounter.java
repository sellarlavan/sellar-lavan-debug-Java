package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class AnalyticsCounter {

	ISymptomReader reader;
	ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms){
		Map<String, Integer> symptomsMap = new HashMap<String, Integer>();

		for(int i = 0; i < symptoms.size(); i++ ){
			String line = symptoms.get(i);
			if(symptomsMap.containsKey(line)){
				symptomsMap.put(line, symptomsMap.get(line) + 1);
			}
			else{
				symptomsMap.put(line, 1);
			}
		}

		return symptomsMap;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(symptoms.entrySet());


		sortedList.sort(Map.Entry.comparingByKey());


		Map<String, Integer> sortedSymptomsMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : sortedList) {
			sortedSymptomsMap.put(entry.getKey(), entry.getValue());
		}

		return sortedSymptomsMap;
	}

	public void writeSymptoms(Map<String, Integer> symptoms){
		writer.writeSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {

	ISymptomReader reader1 = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
	ISymptomWriter writer1 = new WriteSymptomsDataToFile();
	AnalyticsCounter counter = new AnalyticsCounter(reader1, writer1);

	List<String> list = counter.getSymptoms();
	Map<String,Integer> listCount = counter.countSymptoms(list);
	listCount = counter.sortSymptoms(listCount);
	counter.writeSymptoms(listCount);

	Map<String, Integer> test = new HashMap<>();
	test.put("rose", 2);
	test.put("argent", 3);
	test.put("bleu", 1);
	test.put("vert", 8);

	List<Map.Entry<String,Integer>> sortList = new ArrayList<>(test.entrySet());
	sortList.sort(Map.Entry.comparingByValue());
	System.out.println(sortList);


	}
}
