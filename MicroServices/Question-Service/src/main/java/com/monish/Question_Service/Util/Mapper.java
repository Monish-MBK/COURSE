package com.monish.Question_Service.Util;

import com.monish.Question_Service.DTO.QuestionDTO;
import com.monish.Question_Service.Entity.Question;
import com.monish.Question_Service.QuestionServiceApplication;

public class Mapper {
    public static QuestionDTO mapToQuestionDTO(Question question){
        return QuestionServiceApplication.modelMapper().map(question, QuestionDTO.class);
    }

    public static Question mapToQuestion(QuestionDTO questionDTO){
        return QuestionServiceApplication.modelMapper().map(questionDTO,Question.class);
    }
}
