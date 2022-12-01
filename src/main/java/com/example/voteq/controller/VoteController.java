package com.example.voteq.controller;

import com.example.voteq.model.VoteDTO;
import com.example.voteq.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Tag(name = "Votes", description = "Endpoints for managing votes")
@RequestMapping("/votes")
@RestController
public class  VoteController {
    @Autowired
    VoteService service;


    @Operation(summary = "Search for votes in review")
    @GetMapping(value = "/search/{idReview}")
    public List<VoteDTO> searchVotes(@PathVariable("idReview") final int idReview) throws IOException {
        return service.searchVotes(idReview);
    }
}
