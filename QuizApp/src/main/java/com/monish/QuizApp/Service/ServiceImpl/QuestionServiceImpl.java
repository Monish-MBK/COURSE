package com.monish.QuizApp.Service.ServiceImpl;

import com.monish.QuizApp.DTO.QuestionDTO;
import com.monish.QuizApp.Entity.Question;
import com.monish.QuizApp.Repository.QuestionRepo;
import com.monish.QuizApp.Service.QuestionService;
import com.monish.QuizApp.Util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo repo;

    @Override
    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = repo.findAll();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for(Question question:questions){
            QuestionDTO questionDTO= Mapper.mapToQuestionDTO(question);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }

    @Override
    public List<QuestionDTO> getQuestionsByCategory(String category) {
        List<Question> questions = repo.findByCategory(category);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for(Question question:questions){
            QuestionDTO questionDTO= Mapper.mapToQuestionDTO(question);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }

    @Override
    public QuestionDTO addQuestion(QuestionDTO questionDTO) {
        Question question=Mapper.mapToQuestion(questionDTO);
        repo.save(question);
        return Mapper.mapToQuestionDTO(question);
    }

    @Override
    public QuestionDTO updateQuestion(int id, QuestionDTO questionDTO) {
        Question question = repo.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id: " + id));;
        question.setQuestionTitle(questionDTO.getQuestionTitle());
        question.setOption1(questionDTO.getOption1());
        question.setOption2(questionDTO.getOption2());
        question.setOption2(questionDTO.getOption2());
        question.setOption2(questionDTO.getOption2());
        question.setRightAnswer(questionDTO.getRightAnswer());
        question.setCategory(questionDTO.getCategory());
        question.setDifficultyLevel(question.getDifficultyLevel());
        question=repo.save(question);
        return Mapper.mapToQuestionDTO(question);
    }

    @Override
    public String deleteQuestion(int id) {
        repo.deleteById(id);
        return "Deleted";
    }
}
