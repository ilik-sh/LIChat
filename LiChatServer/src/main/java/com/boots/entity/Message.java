package com.boots.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String addressee;
    @Getter
    @Setter
    private String sender;
    @Getter
    @Setter
    private String message;

    public Message(long id, String addressee, String sender, String message) {
        this.id = id;
        this.addressee = addressee;
        this.sender = sender;
        this.message = message;
    }
    public Message(){}
}
