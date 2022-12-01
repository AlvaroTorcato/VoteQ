package com.example.controller;

import com.example.service.VoteService;
import com.example.model.VoteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
