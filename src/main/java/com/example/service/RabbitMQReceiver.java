package com.example.service;

import com.example.model.Vote;
import com.example.repository.VoteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

/*@EnableRabbit
@Component
@RabbitListener(queues = "votes1_queue_fanout", id = "listener")*/
@Service
public class RabbitMQReceiver {
    @Autowired
    VoteRepository repository;

    @Autowired
    VoteService service;
    private static Logger logger = LogManager.getLogger(RabbitMQReceiver.class.toString());
    /*@RabbitHandler
    public void receiver(Vote vote) {
        repository.save(vote);
        logger.info("MenuOrder listener invoked - Consuming Message with MenuOrder Identifier : " + vote.toString());
    }*/
    @RabbitListener(queues= "#{autoDeleteQueue.name}")
    public void consumeJsonMessage(String str) throws IOException {
        logger.info("MenuOrder listener invoked - Consuming Message with MenuOrder Identifier : " + str);

        ObjectMapper objectMapper = new ObjectMapper();
        Vote obj=objectMapper.readValue(str, Vote.class);


        //jwtService.createJWT(obj);

        //repository.save(obj);

        service.createVote(obj);
    }
}
