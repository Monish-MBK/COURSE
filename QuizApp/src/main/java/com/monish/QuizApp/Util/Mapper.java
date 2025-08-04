package com.monish.QuizApp.Util;

import com.monish.QuizApp.DTO.QuestionDTO;
import com.monish.QuizApp.DTO.QuizDTO;
import com.monish.QuizApp.Entity.Question;
import com.monish.QuizApp.Entity.Quiz;
import com.monish.QuizApp.QuizAppApplication;

public class Mapper {
    public static QuestionDTO mapToQuestionDTO(Question question){
        return QuizAppApplication.modelMapper().map(question, QuestionDTO.class);
    }

    public static Question mapToQuestion(QuestionDTO questionDTO){
        return QuizAppApplication.modelMapper().map(questionDTO,Question.class);
    }
    public static Quiz maptoQuiz(QuizDTO quizDTO){
        return QuizAppApplication.modelMapper().map(quizDTO, Quiz.class);
    }
    public static QuizDTO mapToQuizDTO(Quiz quiz){
        return QuizAppApplication.modelMapper().map(quiz, QuizDTO.class);
    }
}
