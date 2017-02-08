package com.innopolis.smoldyrev;

import com.innopolis.smoldyrev.collector.WordCollector;
import com.innopolis.smoldyrev.resources.ResourceReader;

public class Main {

    public static void main(String[] args) {
        String filePath = args[0];
        ResourceReader reader = new ResourceReader(filePath);

        try {
            reader.sendTextToCounter();
            reader.closeReader();
        } catch (Exception e) {
            e.getMessage();
        }

        //выводим итоговый отчет
        WordCollector.getWords();
    }
}
