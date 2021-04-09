package com.androsor.task1;

/**
 * Create an object of the Text class using the Sentence, Word classes.
 * Methods: add text, display text to console, text title.
 */
public class Test {

    public static void main(String[] args) {
        Sentence heading = new Sentence();
        heading.addWord(new Word("Жалесный"));
        heading.addWord(new Word("стих"));
        heading.addPunctuation("!!!!!");

        Sentence firstSentence = new Sentence();
        firstSentence.addWord(new Word("Хай"));
        firstSentence.addWord(new Word("здохне"));
        firstSentence.addWord(new Word("той"));
        firstSentence.addWord(new Word("хто"));
        firstSentence.addWord(new Word("нас"));
        firstSentence.addWord(new Word("не"));
        firstSentence.addWord(new Word("любiць"));
        firstSentence.addPunctuation("!!!");

        Sentence secondSentence = new Sentence();
        secondSentence.addWord(new Word("Хто"));
        secondSentence.addWord(new Word("ў"));
        secondSentence.addWord(new Word("спякотны"));
        secondSentence.addWord(new Word("дзень"));
        secondSentence.addWord(new Word("траячки"));
        secondSentence.addWord(new Word("да"));
        secondSentence.addWord(new Word("бутэлькi"));
        secondSentence.addWord(new Word("не"));
        secondSentence.addWord(new Word("дадаў"));
        secondSentence.addPunctuation("!!!");

        Sentence thirdSentence = new Sentence();
        thirdSentence.addWord(new Word("Ганi"));
        thirdSentence.addWord(new Word("яго"));
        thirdSentence.addPunctuation("!!!");
        thirdSentence.addWord(new Word("Кiдай"));
        thirdSentence.addWord(new Word("ў"));
        thirdSentence.addWord(new Word("яго"));
        thirdSentence.addWord(new Word("каменне"));
        thirdSentence.addPunctuation("!!!");

        Text text = new Text(heading);
        text.addOneSentenceToText(firstSentence);
        text.addOneSentenceToText(secondSentence);
        text.addOneSentenceToText(thirdSentence);

        System.out.println(text.getHeading().toString());
        System.out.println();
        System.out.println(text.printText());
    }
}
