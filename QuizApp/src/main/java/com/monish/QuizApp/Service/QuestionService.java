package com.monish.QuizApp.Service;

import com.monish.QuizApp.DTO.QuestionDTO;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getAllQuestions();

    List<QuestionDTO> getQuestionsByCategory(String category);

    QuestionDTO addQuestion(QuestionDTO questionDTO);

    QuestionDTO updateQuestion(int id, QuestionDTO questionDTO);

    String deleteQuestion(int id);
}
