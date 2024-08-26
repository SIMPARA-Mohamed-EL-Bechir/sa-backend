package emi.ginfo.sa.controller;


import emi.ginfo.sa.entity.Sentiment;
import emi.ginfo.sa.enums.TypeSentiment;
import emi.ginfo.sa.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment")
public class SentimentController {

    private final SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment){
        this.sentimentService.creer(sentiment);
    }

    /*@GetMapping
    public @ResponseBody List<Sentiment> rechercher(){
        return this.sentimentService.rechercher();
    }*/

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.sentimentService.supprimer(id);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> recherchertype(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentService.recherchertype(type);
    }



}
