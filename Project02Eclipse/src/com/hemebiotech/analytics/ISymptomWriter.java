package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Ecriture des symptomes et fréquence dans le fichier result.
     *
     * @param symptoms la map à écrire dans le fichier.
     *
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}
