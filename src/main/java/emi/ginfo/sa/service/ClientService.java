package emi.ginfo.sa.service;


import emi.ginfo.sa.entity.Client;
import emi.ginfo.sa.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }


    public void creer(Client client) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansLaBDD == null) {
            this.clientRepository.save(client);
        }
    }

    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(()-> new EntityNotFoundException("Aucun client n'existe avec cet id"));
    }

    public Client lireOuCreer(Client clientAcreer) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(clientDansLaBDD == null) {
            this.clientRepository.save(clientAcreer);
        }
        return clientDansLaBDD;
    }

    public void modifier(int id,Client clientAmodifier) {
        Client clientDansLaBDD = this.lire(id);
        if(clientDansLaBDD.getId() == clientAmodifier.getId()) {
            clientDansLaBDD.setEmail(clientAmodifier.getEmail());
            clientDansLaBDD.setTelephone(clientAmodifier.getTelephone());
            this.clientRepository.save(clientDansLaBDD);
        }
    }
}
