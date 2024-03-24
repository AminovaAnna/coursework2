package pro.sky.course2anna.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2anna.model.Question;
import pro.sky.course2anna.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamController {
private final ExaminerService service;
    public ExamController(ExaminerService service) {
        this.service = service;
    }
    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount){
return service.getQuestions(amount);
    }

}
