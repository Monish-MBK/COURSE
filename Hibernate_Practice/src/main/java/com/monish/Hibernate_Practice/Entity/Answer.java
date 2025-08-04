package com.monish.Hibernate_Practice.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "answer_Table")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int a_id;
    private String answer;
    @OneToOne(mappedBy = "answer")     //This is optional, telling the compiler to create foreign key only in question table
    private Question question;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer() {
    }

    public Answer(int a_id, String answer,Question question) {
        this.a_id = a_id;
        this.answer = answer;
        this.question = question;
    }
}
