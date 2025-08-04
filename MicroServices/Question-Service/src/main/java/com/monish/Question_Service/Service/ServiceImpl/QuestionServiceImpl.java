package com.monish.Question_Service.Service.ServiceImpl;

import com.monish.Question_Service.DTO.QuestionDTO;
import com.monish.Question_Service.Entity.Question;
import com.monish.Question_Service.Entity.QuestionWrapper;
import com.monish.Question_Service.Entity.Response;
import com.monish.Question_Service.Repository.QuestionRepo;
import com.monish.Question_Service.Service.QuestionService;
import com.monish.Question_Service.Util.Mapper;
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

    @Override
    public List<Integer> getQuestionForQuiz(String categoryName, int numQuestions) {
        List<Integer> questionId=repo.findRandomQuestionByCategory(categoryName,numQuestions);
        return questionId;
    }

    @Override
    public List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds) {
        List<Question> questions=new ArrayList<>();
        for(Integer id:questionIds){
            questions.add(repo.findById(id).get());
        }

        List<QuestionWrapper> wrappers=new ArrayList<>();
        for(Question question:questions){
            QuestionWrapper wrapper = new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
            wrappers.add(wrapper);
        }
        return wrappers;
    }

    @Override
    public Integer CalcScore(List<Response> responses) {
        int finalScore=0;
        for(Response response:responses){
            Question question=repo.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer())){
                finalScore++;
            }
        }
        return finalScore;
    }
}
