package it.sevenbits.courses.springbootexample.web.controller.answers;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.books.Book;
import it.sevenbits.courses.springbootexample.core.service.answers.AnswersService;
import it.sevenbits.courses.springbootexample.core.service.answers.IAnswersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/answers")
public class AnswersController {
    private final IAnswersService answersService;

    public AnswersController(IAnswersService answersService) {
        this.answersService = answersService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Answer>> getAllAnswers() {
        try {
            List<Answer> ans = answersService.getAll();
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") final String id) {
        try {
            Answer ans = answersService.findById(UUID.fromString(id));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Answer> save(@RequestBody final Answer newAnswer) {
        Answer created = answersService.save(newAnswer);
        System.out.println(created);
        URI location = UriComponentsBuilder
                .fromPath("/answers/")
                .path(String.valueOf(created.getId()))
                .build()
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}
