package com.androsor.text;

import java.util.ArrayList;

public class Sentence {
    
    private ArrayList<Word> sentence;

    public Sentence(ArrayList<Word> sentence) {
        this.sentence = sentence;
    }

    public ArrayList<Word> getSentence() {
        return sentence;
    }

    public void setSentence(ArrayList<Word> sentence) {
        this.sentence = sentence;
    }

    public void addWord(Word word) {
        sentence.add(word);
    }

    public void addPunctuation(String string) {
        sentence.add(new Word(string));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Word words : sentence) {
            stringBuilder.append(words.toString()).append(" ");

        }
        return stringBuilder.toString();
    }
}
