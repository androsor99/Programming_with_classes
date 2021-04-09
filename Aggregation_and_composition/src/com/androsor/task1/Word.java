package com.androsor.task1;

public class Word extends TextElement<String> {

    public Word (String word) {
        super(word);
    }

    @Override
    public String toString() {
        return textElement;
    }
}
