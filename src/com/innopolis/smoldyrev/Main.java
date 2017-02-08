package com.innopolis.smoldyrev;

import com.innopolis.smoldyrev.collector.WordCollector;
import com.innopolis.smoldyrev.resources.ResourceReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        ArrayList<ResourceReader> resources = new ArrayList<>();
//        for (String filePath:
//             args) {
//            resources.add(new ResourceReader(filePath));
//        }
        String filePath = args[0];
        ResourceReader reader;

        try {

            reader = new ResourceReader(filePath);
            reader.sendTextToCounter();
            reader.closeReader();

        } catch (FileNotFoundException e) {
            System.out.println("Файл: "+filePath+" не найден");
        } catch (MalformedURLException e) {
            System.out.println("Ссылка: "+filePath+" имеет неправльный формат");
        } catch (IOException e) {
            System.out.println("Проблема с получением файла");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //выводим итоговый отчет
        WordCollector.getWords();
    }
}
