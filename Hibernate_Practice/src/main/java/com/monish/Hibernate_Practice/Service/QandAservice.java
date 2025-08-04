package com.monish.Hibernate_Practice.Service;

import com.monish.Hibernate_Practice.Entity.Answer;
import com.monish.Hibernate_Practice.Entity.Question;
import com.monish.Hibernate_Practice.Repository.AnswerRepo;
import com.monish.Hibernate_Practice.Repository.Questionrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QandAservice {
    @Autowired
    private Questionrepo questionrepo;
    @Autowired
    private AnswerRepo answerRepo;


    public Question addQ(Question question) {
        Answer answer=question.getAnswer();
        answerRepo.save(answer);
        return questionrepo.save(question);
    }
}
