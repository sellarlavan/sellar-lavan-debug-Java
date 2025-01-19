package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Ecriture des symptomes et fréquence dans le fichier result.
     *
     * @param symptoms la map à écrire dans le fichier.
     *
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
