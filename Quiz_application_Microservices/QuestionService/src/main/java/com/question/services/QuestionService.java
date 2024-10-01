package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestion(Long id);
    List<Question> getQuestionsOfQuizId(Long quizId);
}
