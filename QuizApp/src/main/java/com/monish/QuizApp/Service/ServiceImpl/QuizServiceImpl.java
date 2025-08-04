package com.monish.QuizApp.Service.ServiceImpl;

import com.monish.QuizApp.DTO.QuizDTO;
import com.monish.QuizApp.Entity.Question;
import com.monish.QuizApp.Entity.QuestionWrapper;
import com.monish.QuizApp.Entity.Quiz;
import com.monish.QuizApp.Entity.Response;
import com.monish.QuizApp.Repository.QuestionRepo;
import com.monish.QuizApp.Repository.QuizRepo;
import com.monish.QuizApp.Service.QuizService;
import com.monish.QuizApp.Util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionRepo questionRepo;


    @Override
    public QuizDTO createQuiz(String category, int numQ, String title) {
        List<Question> question= questionRepo.findRandomQuestionByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizRepo.save(quiz);
        return Mapper.mapToQuizDTO(quiz);
    }

    @Override
    public List<QuestionWrapper> getQuestions(int id) {
        Quiz quiz= quizRepo.findById(id).get();
        List<Question> questionFromDB=quiz.getQuestions();
        List<QuestionWrapper> questionForClient=new ArrayList<>();
        for(Question q : questionFromDB){
            QuestionWrapper questionWrapper=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForClient.add(questionWrapper);
        }
        return questionForClient;
    }

    @Override
    public Integer CalcScore(int id, List<Response> responses) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int i=0;
        int correctCount=0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                correctCount++;
            }
            i++;
        }
        return correctCount;
    }
}
