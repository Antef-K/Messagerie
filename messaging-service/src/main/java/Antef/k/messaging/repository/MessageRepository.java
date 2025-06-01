package Antef.k.messaging.repository;

import Antef.k.messaging.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderOrReceiver(String sender, String receiver);
}