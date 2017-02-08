package com.innopolis.smoldyrev.collector;

import java.util.HashMap;

/**
 * Собирает слова
 */
public class WordCollector {

    private static HashMap<String, Integer> words = new HashMap<>();

    /**
     * <p>Добавляет слово в поле words</p>
     * если слово отсутсвует в списке - добавляет ключ в words
     * если слово уже есть, то прибавляет 1 к значению найденного ключа
     * по завершению выводит текущее количество повторов, введенного слова
     * @param word добавляемое слово
     */
    public static void put (String word) {

        Integer count = words.get(word);

        if (count == null) {
            count = 0;
        }

        words.put(word, ++count);
        System.out.println("Слово: " + word + "(" + count + ")");
    }

    /**
     * Итоговый отчет
     * выводит список words
     */
    public static void getWords() {
        for (String str:words.keySet()) {
            System.out.println(str+" " + words.get(str));
        }
    }

}
