package Antef.k.messaging.controller;

import Antef.k.messaging.entity.Message;
import Antef.k.messaging.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/messages")

public class MessageController {


    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return repository.save(message);
    }

    @GetMapping("/{user}")
    public List<Message> getMessages(@PathVariable String user) {
        return repository.findBySenderOrReceiver(user, user);
    }

}
