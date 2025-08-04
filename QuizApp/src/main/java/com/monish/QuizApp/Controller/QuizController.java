package com.monish.QuizApp.Controller;

import com.monish.QuizApp.DTO.QuizDTO;
import com.monish.QuizApp.Entity.QuestionWrapper;
import com.monish.QuizApp.Entity.Quiz;
import com.monish.QuizApp.Entity.Response;
import com.monish.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<QuizDTO> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return new ResponseEntity<>(quizService.createQuiz(category,numQ,title), HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable int id){
        return new ResponseEntity<>(quizService.getQuestions(id),HttpStatus.OK);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses){
        return new ResponseEntity<>(quizService.CalcScore(id,responses),HttpStatus.OK);
    }
}
