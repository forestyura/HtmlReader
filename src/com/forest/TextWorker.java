package com.forest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yuriy Vlasiuk on 28.02.2017.
 */
public class TextWorker {
    private String text;
    private String[] words;
    private List<String> formatWordsList;

    public TextWorker(String text) {
        this.text = text;
        words = getWords();
        formatWordsList = formatWords();
    }

    /**
     * @return Number of words in text
     */
    public long getNumberOfWords() {
        return formatWords().stream().count();
    }

    /**
     * Writing words from the list and count the number of occurrences
     * @return List of words and the number of occurrences of
     */
    public String getListOfWords() {
        String listOfWords = "";
        List<String> sortedList = sortWordsList();

        for(String word : sortedList){
            listOfWords += word + " - ";
            listOfWords += formatWordsList.stream().filter((f) -> f.equals(word)).count();
            listOfWords += "\n";
        }

        return listOfWords;
    }

    /**
     * Sorting and deleting similar words in a list
     * @return Sorting list
     */
    private List<String> sortWordsList() {
        return formatWordsList.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * @return a list of words separated by characters: a space, dot, comma, semicolon, dash, and the transfer carriage
     */
    private String[] getWords() {
        return text.split("(\\s|\\.|,|;|-|\n )");
    }


    /**
     *  Formatting an array of words in the list does not include the word containing numbers and punctuation symbols
     * @return Formatted list
     */
    private List<String> formatWords() {
        ArrayList<String> wordsList = new ArrayList<String>();
        List<String> formatWordsList;

        Collections.addAll(wordsList, words);
        formatWordsList =  wordsList.stream()
                .filter((f) -> !(f.matches(".*(\\d|\\.|,|;).*")))
                .filter((f) -> !(f.equals("")))
                .collect(Collectors.toList());

        return formatWordsList;
    }
}
