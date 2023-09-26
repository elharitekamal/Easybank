package implimentation;

import dao.Clientdao;
import dto.Client;
import dto.Employe;
import helper.Connectionbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class ClientDaoImpl implements Clientdao {
    @Override
    public Optional<Client> ajouterClient(Client client) {
        Connection con = Connectionbd.getConn();

        try {
            String sql = "INSERT INTO client (code, prenom, nom, dateNaissance, telephone, adress, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, client.getCode());
            stmt.setString(2, client.getPrenom());
            stmt.setString(3, client.getNom());
            stmt.setDate(4, java.sql.Date.valueOf(client.getDateNaissance()));
            stmt.setString(5, client.getTelephone());
            stmt.setString(6, client.getAdress());
            stmt.setString(7, client.getEmail());

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

    @Override
    public int supprimerClient(int code) {
        Connection con = Connectionbd.getConn();

        try {
            String sql = "DELETE FROM client WHERE code = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, code);

            int rowsDeleted = stmt.executeUpdate();

            return rowsDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Optional<Client> chercherClient(int code) {
        Connection con = Connectionbd.getConn();

        try {
            String sql = "SELECT * FROM client WHERE code = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, code);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int codeRetrieved = resultSet.getInt("code");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                LocalDate dateNaissance = resultSet.getDate("dateNaissance").toLocalDate();
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                String adress = resultSet.getString("adress");

                    Client client = new Client(nom,  prenom,  dateNaissance,  telephone,  adress,  codeRetrieved, email);
                return Optional.of(client);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
