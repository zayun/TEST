package com.innopolis.smoldyrev.resources;

import com.innopolis.smoldyrev.collector.WordCollector;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by smoldyrev on 07.02.17.
 */
public class ResourceReader {

     private BufferedReader br;

    /**
     * Конструктор - создание нового объекта
     * @see ResourceReader#ResourceReader(String)
     */
    public ResourceReader(String filePath) throws IOException {


            InputStream stream;

            if (filePath.contains("http://")) {
                URL myURL = new URL(filePath);
                stream = myURL.openStream();
            } else {
                stream = new FileInputStream(filePath);
            }

            br = new BufferedReader(new InputStreamReader(stream));
    }

    /**
     * <p>Разделяет текст на слова и отправляет их в счетчик</p>
     * перед отправкой в счетчик удаляет незначимые символы (знаки препинания(кроме "-") и цифры)
     * и переводит строку в нижний регистр
     * @throws Exception если в файле встречается неразрешенный символ
     */
    public void sendTextToCounter() throws Exception {
        while (br.ready()) {

            for (String str: br.readLine().split("\\s+")) {

                if (isValidValue(str)) {
                    /*приводим слова в правильный вид*/
                    str = str.replaceAll("[^А-Яа-яёЁ-]","").toLowerCase();
                    WordCollector.put(str);
                } else {
                    throw new Exception("Текст содержит не кирилические символы!");
                }
            }
        }
    }

    /**
     * <p>Проверяет, является ли строка допустимой</p>
     * Строка допустима, если в ней содержатся только:
     * символы кириллицы
     * цифры
     * знаки препинания
     * @param str Проверяемая строка
     * @return true, если входная строка допустима, и false, если недопустима
     */
    private boolean isValidValue(String str){

        final String VALID_SYMBOLS = "[А-Яа-яёЁ\\d\\s\\\\/_,.\\-—?!№%\":*();`]*";

        return str.matches(VALID_SYMBOLS);
    }

    public void closeReader() {
        try{
            br.close();
        } catch (IOException e) {
            System.out.println("Ресурс не закрыт!");
        }
    }

}
