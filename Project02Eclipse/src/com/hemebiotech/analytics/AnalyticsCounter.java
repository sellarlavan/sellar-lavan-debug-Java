package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {

//		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
//		String line = reader.readLine();
//

//
//		while (line != null){
//			if(symptomsMap.containsKey(line)){
//				symptomsMap.put(line, symptomsMap.get(line) + 1);
//			}
//			else{
//				symptomsMap.put(line, 1);
//			}
//
//			line = reader.readLine();
//		}

		ReadSymptomDataFromFile symptomDataFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		List<String> symptoms = symptomDataFromFile.GetSymptoms();

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


		WriteSymptomsDataToFile dataToFile = new WriteSymptomsDataToFile();
		dataToFile.writeSymptoms(symptomsMap);
	}
}
