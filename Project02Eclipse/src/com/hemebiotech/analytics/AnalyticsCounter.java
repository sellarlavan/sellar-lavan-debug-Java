package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retourne les symptomes.
	 *
	 * @return une liste des symptomes.
	 */
	public List<String> getSymptoms(){
		return reader.getSymptoms();
	}


	/**
	 * Compte les symptomes.
	 * @param la liste des symptomes.
	 * @return une map des symptomes et leur fréquence d'apparition.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		Map<String, Integer> symptomsMap = new HashMap<>();

        for (String line : symptoms) {
            if (symptomsMap.containsKey(line)) {
                symptomsMap.put(line, symptomsMap.get(line) + 1);
            } else {
                symptomsMap.put(line, 1);
            }
        }

		return symptomsMap;
	}

	/**
	 * Retourne les symptomes triés.
	 *
	 * @param la map des symptomes.
	 * @return la map des symptomes triés.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(symptoms.entrySet());
		sortedList.sort(Map.Entry.comparingByKey());

		Map<String, Integer> sortedSymptomsMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : sortedList) {
			sortedSymptomsMap.put(entry.getKey(), entry.getValue());
		}

		return sortedSymptomsMap;
	}

	/**
	 * Ecriture des symptomes et fréquence dans le fichier result.
	 *
	 * @param symptoms la map à écrire dans le fichier.
	 *
	 */
	public void writeSymptoms(Map<String, Integer> symptoms){
		writer.writeSymptoms(symptoms);
	}

}
