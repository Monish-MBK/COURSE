package com.monish.Quiz_Service.Service;


import com.monish.Quiz_Service.DTO.QuizDTO;
import com.monish.Quiz_Service.Entity.QuestionWrapper;
import com.monish.Quiz_Service.Entity.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    QuizDTO createQuiz(String category, int numQ, String title);

    List<QuestionWrapper> getQuestions(int id);

    ResponseEntity<Integer> CalcScore(int id, List<Response> responses);
}
