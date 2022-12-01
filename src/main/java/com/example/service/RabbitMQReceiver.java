package com.example.service;

import com.example.model.Vote;
import com.example.repository.VoteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@EnableRabbit
@Component
@RabbitListener(queues = "votes1_queue_fanout", id = "listener")
public class RabbitMQReceiver {
    @Autowired
    VoteRepository repository;
    private static Logger logger = LogManager.getLogger(RabbitMQReceiver.class.toString());
    @RabbitHandler
    public void receiver(Vote vote) {
        repository.save(vote);
        logger.info("MenuOrder listener invoked - Consuming Message with MenuOrder Identifier : " + vote.toString());
    }
}
