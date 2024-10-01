package com.quiz.contollers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //create
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return  quizService.add(quiz);
    }

    //get all
    @GetMapping
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    //get all
    @GetMapping("/{quizId}")
    public Quiz getAQuiz(@PathVariable Long quizId){
        return quizService.getQuiz(quizId);
    }


}
