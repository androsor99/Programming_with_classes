package com.androsor.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text extends TextElement<List<Sentence>>{

    private Sentence heading;

    public Text(Sentence heading) {
        super(new ArrayList<>());
        this.heading = heading;
    }

    public Text(Sentence heading, List<Sentence> content){
        super(content);
        this.heading = heading;
    }

    public void addOneSentenceToText (Sentence sentence) {
        this.textElement.add(sentence);
    }

    public void addSentencesToText(ArrayList<Sentence> sentences) {
        this.textElement.addAll(sentences);
    }

    public String printText() {
        StringBuilder stringBuilder = new StringBuilder();
        this.textElement.forEach(sentence -> stringBuilder.append(sentence.toString()).append("\n"));
        return stringBuilder.toString();
    }

    public void setHeading(Sentence heading) {
        this.heading = heading;
    }

    public Sentence getHeading() {
        return this.heading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Text text = (Text) o;
        return Objects.equals(heading, text.heading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), heading);
    }
}
