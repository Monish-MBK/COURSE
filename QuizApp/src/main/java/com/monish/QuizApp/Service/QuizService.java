package com.monish.QuizApp.Service;

import com.monish.QuizApp.DTO.QuizDTO;
import com.monish.QuizApp.Entity.QuestionWrapper;
import com.monish.QuizApp.Entity.Response;

import java.util.List;

public interface QuizService {
    QuizDTO createQuiz(String category, int numQ, String title);

    List<QuestionWrapper> getQuestions(int id);

    Integer CalcScore(int id, List<Response> responses);
}
