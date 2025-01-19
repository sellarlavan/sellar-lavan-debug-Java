package com.hemebiotech.analytics;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomsDataToFile("Project02Eclipse/result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        Map<String,Integer> symptomsCount = counter.countSymptoms(counter.getSymptoms());
        symptomsCount = counter.sortSymptoms(symptomsCount);
        counter.writeSymptoms(symptomsCount);
    }
}
