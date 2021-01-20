package com.androsor.text;

import java.util.ArrayList;

/**
 * Create an object of the Text class using the Sentence, Word classes.
 * Methods: add text, display text to console, text title.
 */

public class TextMain {

    public static void main(String[] args) {

        ArrayList<Word> wordsList = new ArrayList<>();
        ArrayList<Sentence> sentencesList = new ArrayList<>();

        // список слов
        wordsList.add(new Word("Хай"));
        wordsList.add(new Word("здохне"));
        wordsList.add(new Word("той"));
        wordsList.add(new Word("хто"));
        wordsList.add(new Word("нас"));
        wordsList.add(new Word("не"));

        //создаём предложение
        sentencesList.add(new Sentence(wordsList));
        sentencesList.get(0).addWord(new Word("любiць")); //добавляем слово методом из Sentence
        sentencesList.get(0).addPunctuation("\b!");

        ArrayList<Word> wordsList1 = new ArrayList<>();

        wordsList1.add(new Word("Хто"));
        wordsList1.add(new Word("ў"));
        wordsList1.add(new Word("спякотны"));
        wordsList1.add(new Word("дзень"));
        wordsList1.add(new Word("траячки"));
        wordsList1.add(new Word("да"));
        wordsList1.add(new Word("бутэлькi"));
        wordsList1.add(new Word("не"));
        wordsList1.add(new Word("дадаў"));

        sentencesList.add(new Sentence(wordsList1));
        sentencesList.get(1).addPunctuation("\b!!!");

        Text text = new Text("Жалесный стих!", sentencesList);

        System.out.printf("\nЗаголовок: %s", text.getHeading());
        System.out.printf("\nТекст: %s", text.printText());

        ArrayList<Word> wordsList2 = new ArrayList<>();

        wordsList2.add(new Word("Ганi"));
        wordsList2.add(new Word("яго!"));
        wordsList2.add(new Word("Кiдай"));
        wordsList2.add(new Word("ў"));
        wordsList2.add(new Word("яго"));
        wordsList2.add(new Word("каменне"));
        Sentence sentence = new Sentence(wordsList2);
        sentence.addPunctuation("\b!!!");
        text.addOneSentenceToText(sentence);
        System.out.printf("\nПосле добавления в текст: %s", text.printText());

        ArrayList<Sentence> sentencesList1 = new ArrayList<>(sentencesList);

        text.addSentenceToText(sentencesList1);
        System.out.printf("\nПосле добавления самого текста: %s", text.printText());
    }
}
