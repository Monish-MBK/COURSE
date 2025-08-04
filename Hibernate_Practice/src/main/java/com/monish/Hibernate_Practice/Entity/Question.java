package com.monish.Hibernate_Practice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question_Table")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int q_id;
    private String question;
    @OneToOne
    @JoinColumn(name = "ans_id")      //Modifiying the name of foreign key in question table
    private Answer answer;

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question(int q_id, String question, Answer answer) {
        this.q_id = q_id;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
    }
}
