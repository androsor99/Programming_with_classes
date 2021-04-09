package com.androsor.task1;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends TextElement<List<Word>> {

    public Sentence() {
        super(new ArrayList<>());
    }

    public Sentence(List<Word> sentence) {
       super(sentence);
    }

    public void addWord(Word word) {
        textElement.add(word);
    }

    public void addPunctuation(String string) {
        textElement.add(new Word("\b" + string));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.textElement.forEach(word -> stringBuilder.append(word.toString()).append(" "));
        return stringBuilder.toString();
    }
}
