package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomsDataToFile implements  ISymptomWriter{

    /**
     * Ecriture des symptomes et fréquence dans le fichier result.
     *
     * @param symptoms la map à écrire dans le fichier.
     *
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if(symptoms != null){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
                for(Map.Entry<String, Integer> entry : symptoms.entrySet()){
                    writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
