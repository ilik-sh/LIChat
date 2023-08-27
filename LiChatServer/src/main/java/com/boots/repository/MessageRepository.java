package com.boots.repository;

import com.boots.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByAddressee(String Addressee);
    Long removeByAddressee(String Addressee);
}

