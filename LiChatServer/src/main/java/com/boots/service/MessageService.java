package com.boots.service;

import com.boots.entity.Message;
import com.boots.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> getNewMessages(String addressee){
        List<Message> messages = messageRepository.findByAddressee(addressee);
//        messageRepository.removeByAddressee(addressee);
        return messages;
    }

    public void saveMessage(Message message){
        messageRepository.save(message);
    }
}
