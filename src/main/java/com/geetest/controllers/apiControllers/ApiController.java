package com.geetest.controllers.apiControllers;

import com.geetest.entities.Message;
import com.geetest.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/disciplines")
    public ResponseEntity<Object> getAllDisciplines() {
        Iterable<Message> allMessages = messageRepository.findAll();
        List<String> response = new ArrayList<>();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/disciplines/{disciplineAlias}")
    public ResponseEntity<Object> getAllTestByDisciplines(@PathVariable String disciplineAlias) {
        List<String> response = new ArrayList<>();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/greetings")
    public String greeting(
            @RequestParam(name="name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greetings";
    }

    @GetMapping
    public ModelAndView main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        model.put("title", "<<Users>>");
        return new ModelAndView("main", model);
    }

    @GetMapping("/mustache")
    public ModelAndView mustache(Map<String, Object> model) {
        List<Message> messages = List.of(
                new Message("Textus1", "Tagus1"),
                new Message("Textus2", "Tagus2"),
                new Message("Textus3", "Tagus3"),
                new Message("Textus4", "Tagus4"),
                new Message("Textus5", "Tagus5")
        );
        model.put("messages", messages);
        model.put("title", "<<Messages>>");
        return new ModelAndView("main", model);
    }

    @PostMapping
    public ModelAndView add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepository.save(message);
        Iterable<Message> allMessages = messageRepository.findAll();
        model.put("messages", allMessages);
        model.put("title", "<<Messages>>");
        return new ModelAndView("main", model);
    }

    @PostMapping("/filter")
    public ModelAndView filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages = null;
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }
        model.put("messages", messages);
        model.put("title", "<<Messages>>");
        return new ModelAndView("main", model);
    }
}
