package com.monish.Quiz_Service.Service.ServiceImpl;

import com.monish.Quiz_Service.DTO.QuizDTO;
import com.monish.Quiz_Service.Entity.QuestionWrapper;
import com.monish.Quiz_Service.Entity.Quiz;
import com.monish.Quiz_Service.Entity.Response;
import com.monish.Quiz_Service.Feign.QuizFeign;
import com.monish.Quiz_Service.Repository.QuizRepo;
import com.monish.Quiz_Service.Service.QuizService;
import com.monish.Quiz_Service.Util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuizFeign quizFeign;


    @Override
    public QuizDTO createQuiz(String category, int numQ, String title) {
        List<Integer> questions=quizFeign.getQuestionForQuiz(category,numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizRepo.save(quiz);
        return Mapper.mapToQuizDTO(quiz);
    }

    @Override
    public List<QuestionWrapper> getQuestions(int id) {
        Quiz quiz= quizRepo.findById(id).get();
        List<Integer> questionIds=quiz.getQuestionIds();
        List<QuestionWrapper> wrappers=quizFeign.getQuestionsFromId(questionIds).getBody();
        return wrappers;
    }



    @Override
    public ResponseEntity<Integer> CalcScore(int id, List<Response> responses) {
        ResponseEntity<Integer> count=quizFeign.getScore(responses);
//        Quiz quiz=quizRepo.findById(id).get();
//        List<Question> questions=quiz.getQuestions();
//        int i=0;
//        int correctCount=0;
//        for(Response response:responses){
//            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
//                correctCount++;
//            }
//            i++;
//        }
        return count;
    }
}
