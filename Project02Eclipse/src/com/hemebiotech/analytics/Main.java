package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomsDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();
        Map<String,Integer> symptomsCount = counter.countSymptoms(symptoms);
        symptomsCount = counter.sortSymptoms(symptomsCount);
        counter.writeSymptoms(symptomsCount);
    }
}
