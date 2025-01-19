package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomsDataToFile implements  ISymptomWriter{

    private String filepath;

    public WriteSymptomsDataToFile (String filepath) {this.filepath = filepath;}

    /**
     * Ecriture des symptomes et fréquence dans le fichier result.
     *
     * @param symptoms la map à écrire dans le fichier.
     *
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (symptoms == null || symptoms.isEmpty()){
            System.err.println("La liste des symtomes est vide.");
            throw new IllegalArgumentException("Rien ne sera afficher en sortie car la liste des symptomes est null.");
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for(Map.Entry<String, Integer> entry : symptoms.entrySet()){
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite " + e);
        }
    }
}
