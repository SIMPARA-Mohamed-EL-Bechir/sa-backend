package emi.ginfo.sa.repository;


import emi.ginfo.sa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByEmail(String email);
}
