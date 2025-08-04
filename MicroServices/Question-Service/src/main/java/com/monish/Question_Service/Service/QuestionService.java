package com.monish.Question_Service.Service;


import com.monish.Question_Service.DTO.QuestionDTO;
import com.monish.Question_Service.Entity.QuestionWrapper;
import com.monish.Question_Service.Entity.Response;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getAllQuestions();

    List<QuestionDTO> getQuestionsByCategory(String category);

    QuestionDTO addQuestion(QuestionDTO questionDTO);

    QuestionDTO updateQuestion(int id, QuestionDTO questionDTO);

    String deleteQuestion(int id);

    List<Integer> getQuestionForQuiz(String categoryName, int numQuestions);

    List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds);

    Integer CalcScore(List<Response> responses);
}
