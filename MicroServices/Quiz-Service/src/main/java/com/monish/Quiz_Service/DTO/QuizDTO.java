package com.monish.Quiz_Service.DTO;



import java.util.List;

public class QuizDTO {
    private int id;
    private String title;
    List<Integer> questionIds;

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

    public List<Integer> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Integer> questionIds) {
        this.questionIds = questionIds;
    }

    public QuizDTO(int id, String title, List<Integer> questionIds) {
        this.id = id;
        this.title = title;
        this.questionIds = questionIds;
    }

    @Override
    public String toString() {
        return "QuizDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questionIds=" + questionIds +
                '}';
    }

    public QuizDTO() {
    }

}
