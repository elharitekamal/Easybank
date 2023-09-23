package dao;

import dto.Client;
import dto.Employe;

import java.util.Optional;

public interface Clientdao {

    Optional<Client> ajouterClient(Client client);
}
