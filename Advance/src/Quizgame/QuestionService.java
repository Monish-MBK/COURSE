package Quizgame;

import java.util.Scanner;

public class QuestionService {
//Creating an object of class question of type array to store multiple questions inside a same object
    Question questions[] = new Question[5];
    String selection[]=new String[5];
//Creating a constructor to intialize all the values using question constructor
    public QuestionService(){
        questions[0]=new Question(1,"2+2","4","5","6","7","4");
        questions[1]=new Question(2,"2+3","4","5","6","7","5");
        questions[2]=new Question(3,"4+2","4","5","6","7","6");
        questions[3]=new Question(4,"4+3","4","5","6","7","7");
        questions[4]=new Question(5,"5+2","4","5","6","7","7");
    }

    public void playQuiz(){
        int i=0;
        for (Question q : questions){
            System.out.println("Question no : "+q.getId());
            System.out.println("Question : "+q.getQuestion());
            System.out.println("Option1 : "+q.getOpt1());
            System.out.println("Option2 : "+q.getOpt2());
            System.out.println("Option3 : "+q.getOpt3());
            System.out.println("Option4 : "+q.getOpt4());
//Accepting answer from the user and storing it in selection array
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your answer : ");
            selection[i]=sc.nextLine();
            i++;

        }
        for(String s : selection){
            System.out.println(s);
        }
    }

    public void yourScore(){
        int score=0;
        for (int i=0;i<questions.length;i++){
            Question que = questions[i];
            String actualAnswer = que.getAnswer();
            String useraAnswer = selection[i];

            if (actualAnswer.equals(useraAnswer)) {
                score++;
            }
        }
        System.out.println("Your score is "+score);
    }
}
