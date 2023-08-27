package com.boots.controller;

import com.boots.entity.Message;
import com.boots.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    MessageService messageService;

    @GetMapping("/getNewMessages")
    public List<Message> getNewMessages(@RequestParam(required = true)String addressee){
        return messageService.getNewMessages(addressee);
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestParam(required = true)String addressee,
                            @RequestParam(required = true)String sender,
                            @RequestParam(required = true)String message){
        Message saveMessage = new Message();
        saveMessage.setAddressee(addressee);
        saveMessage.setSender(sender);
        saveMessage.setMessage(message);
        messageService.saveMessage(saveMessage);
    }
}
