package com.example.controller;

import com.example.model.Vote;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientVote {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchangeVote;
    public List<Vote> send() {
        int n= 0;
        List<Vote> response = (List<Vote>) rabbitTemplate.convertSendAndReceive(directExchangeVote.getName(),"vote", n);

        System.out.println("Got " + response + "");
        return response;
    }

}
