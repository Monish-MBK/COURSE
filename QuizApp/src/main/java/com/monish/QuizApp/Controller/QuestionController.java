package com.monish.QuizApp.Controller;

import com.monish.QuizApp.DTO.QuestionDTO;
import com.monish.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/allquestions")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<QuestionDTO>> getQuestionByCategory(@PathVariable String category){
        return new ResponseEntity<>(questionService.getQuestionsByCategory(category),HttpStatus.OK);
    }
    @PostMapping("/addquestion")
    public ResponseEntity<QuestionDTO> allQuestion(@RequestBody QuestionDTO questionDTO){
        return new ResponseEntity<>(questionService.addQuestion(questionDTO), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<QuestionDTO> updateQuestion(@PathVariable int id,@RequestBody QuestionDTO questionDTO){
        return new ResponseEntity<>(questionService.updateQuestion(id,questionDTO),HttpStatus.CREATED);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return new ResponseEntity<>(questionService.deleteQuestion(id),HttpStatus.OK);
    }
}
