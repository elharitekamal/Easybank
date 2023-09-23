package implimentation;

import dao.Clientdao;
import dto.Client;
import helper.Connectionbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class ClientDaoImpl implements Clientdao {
    @Override
    public Optional<Client> ajouterClient(Client client) {
        Connection con = Connectionbd.getConn();

        try {
            String sql = "INSERT INTO client (code, prenom, nom, dateNaissance, telephone, address) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, client.getCode());
            stmt.setString(2, client.getPrenom());
            stmt.setString(3, client.getNom());
            stmt.setDate(4, java.sql.Date.valueOf(client.getDateNaissance()));
            stmt.setString(5, client.getTelephone());
            stmt.setString(6, client.getAdress());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return Optional.of(client);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.of(client);
        }
    }
}
