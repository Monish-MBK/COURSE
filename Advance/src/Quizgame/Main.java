package Quizgame;

public class Main {
    public static void main(String[] args) {
        //creating an object of question service and calling its methods
        QuestionService questionService=new QuestionService();
        questionService.playQuiz();
        questionService.yourScore();
    }
}
