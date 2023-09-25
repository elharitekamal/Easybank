package dao;

import dto.Client;
import dto.Employe;

import java.util.Optional;

public interface Clientdao {

    Optional<Client> ajouterClient(Client client);
    int supprimerClient(int code);
    Optional<Client> chercherClient(int code);
}
