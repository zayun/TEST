package com.innopolis.smoldyrev;

import com.innopolis.smoldyrev.collector.WordCollector;
import com.innopolis.smoldyrev.resources.ResourceReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) {

        String tmpFilePath = "";
        try {

            for (String filePath:
                    args) {
                tmpFilePath= filePath;
                ResourceReader resource = new ResourceReader(filePath);
                resource.sendTextToCounter();
                resource.closeReader();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл: "+tmpFilePath+" не найден");
        } catch (MalformedURLException e) {
            System.out.println("Ссылка: "+tmpFilePath+" имеет неправильный формат");
        } catch (IOException e) {
            System.out.println("Проблема с получением файла");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //выводим итоговый отчет
        WordCollector.getWords();
    }
}
