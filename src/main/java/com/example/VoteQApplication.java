package com.example;

import com.example.controller.ClientVote;
import com.example.model.Vote;
import com.example.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VoteQApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoteQApplication.class, args);
    }

    @Autowired
    ClientVote clientVote;

    @Bean
    public CommandLineRunner loadData( VoteRepository voteRepository) {
        return (args) -> {


            if(voteRepository.count() == 0){
                List<Vote> lista = clientVote.send();
                if (lista != null){
                    voteRepository.saveAll(lista);
                }
            }
            //repository.save(new Customer("Jack", "Bauer"));
        };

    }

}
