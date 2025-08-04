package com.monish.QuizApp.DTO;

import com.monish.QuizApp.Entity.Question;

import java.util.List;

public class QuizDTO {
    private int id;
    private String title;
    List<Question> questionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public QuizDTO(int id, String title, List<Question> questionList) {
        this.id = id;
        this.title = title;
        this.questionList = questionList;
    }

    public QuizDTO() {
    }

    @Override
    public String toString() {
        return "QuizDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
