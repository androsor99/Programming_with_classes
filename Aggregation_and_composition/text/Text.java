package com.androsor.text;

import java.util.ArrayList;

public class Text {

    private String heading;
    private ArrayList<Sentence> content;



    public Text(String heading) {
        this.heading = heading;
        this.content = new ArrayList<>();
    }

    public Text(String heading, ArrayList<Sentence> content){
        this.heading = heading;
        this.content = content;
    }

    public Text(String heading, Sentence sentence){
        this.heading = heading;
        this.content.add(sentence);
        this.content = new ArrayList<>();
    }

    public void addOneSentenceToText (Sentence sentence) {
        this.content.add(sentence);
    }

    public void addSentenceToText (ArrayList<Sentence> sentences) {
        this.content.addAll(sentences);

    }
    public String printText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sentence sentences : this.content) {
            stringBuilder.append(sentences.toString()).append(" ");
        }
        return stringBuilder.toString();
    }

//    public String printHeading() {
//        System.out.println(heading);
//        return heading.toString();
//    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getHeading() {
        return this.heading;
    }
}
