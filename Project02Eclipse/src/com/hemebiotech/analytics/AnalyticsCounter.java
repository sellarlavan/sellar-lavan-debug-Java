package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		Map<String, Integer> symptomsMap = new HashMap<String, Integer>();


		while (line != null){
			if(symptomsMap.containsKey(line)){
				symptomsMap.put(line, symptomsMap.get(line) + 1);
			}
			else{
				symptomsMap.put(line, 1);
			}

			line = reader.readLine();
		}

		System.out.println(symptomsMap);

		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
