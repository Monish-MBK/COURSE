package com.monish.Quiz_Service.Controller;


import com.monish.Quiz_Service.DTO.QuizDTO;
import com.monish.Quiz_Service.Entity.QuestionWrapper;
import com.monish.Quiz_Service.Entity.Response;
import com.monish.Quiz_Service.Service.QuizService;
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
        return quizService.CalcScore(id,responses);
    }
}
