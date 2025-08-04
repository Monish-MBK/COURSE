package com.monish.Quiz_Service.Util;


import com.monish.Quiz_Service.DTO.QuizDTO;
import com.monish.Quiz_Service.Entity.Quiz;
import com.monish.Quiz_Service.QuizServiceApplication;

public class Mapper {
    public static Quiz maptoQuiz(QuizDTO quizDTO){
        return QuizServiceApplication.modelMapper().map(quizDTO, Quiz.class);
    }
    public static QuizDTO mapToQuizDTO(Quiz quiz){
        return QuizServiceApplication.modelMapper().map(quiz, QuizDTO.class);
    }
}
