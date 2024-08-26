package emi.ginfo.sa.controller;


import emi.ginfo.sa.dto.ErroEntity;
import emi.ginfo.sa.entity.Client;
import emi.ginfo.sa.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path = "client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientService getClientService() {
        return clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Client client){
        this.clientService.creer(client);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> rechercher(){
        return this.clientService.rechercher();
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id){
        //Methode 1
        /*try{
            Client client = this.clientService.lire(id);
            return ResponseEntity.ok(client);
        }catch (EntityNotFoundException exception) {
            return ResponseEntity.status(BAD_REQUEST).body(new ErroEntity(null,exception.getMessage()));
        }*/

        return this.clientService.lire(id);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Client client){
        this.clientService.modifier(id,client);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErroEntity handleEception(EntityNotFoundException exception){
        return  new ErroEntity(null, exception.getMessage());
    }

}
