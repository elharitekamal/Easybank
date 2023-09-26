package implimentation;

import dao.CompteCourantdao;
import dto.CompteCourant;
import helper.Connectionbd;

import java.sql.*;
import java.util.Optional;

public class CompteCourantImp implements CompteCourantdao {
    @Override
    public Optional<CompteCourant> ajouterCompteC(CompteCourant compteCourant) {
        Connection con = Connectionbd.getConn();
        try {
            String compteInsertSQL = "INSERT INTO compte (numero, solde, dateCreation, etat, client, employe) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(compteInsertSQL);

            stmt.setInt(1, compteCourant.getNumero());
            stmt.setDouble(2, compteCourant.getSolde());
            stmt.setDate(3, java.sql.Date.valueOf(compteCourant.getDateCreation()));
            stmt.setObject(4, compteCourant.getEtat().name(), Types.OTHER);
            stmt.setInt(5, compteCourant.getClient().getCode());
            stmt.setInt(6, compteCourant.getEmploye().getMatricule());

            stmt.executeUpdate();

            String compteCourantInsertSQL = "INSERT INTO compteCourant (num_compte, decouvert) " +
                    "VALUES (?, ?)";
            stmt = con.prepareStatement(compteCourantInsertSQL);

            stmt.setInt(1, compteCourant.getNumero());
            stmt.setDouble(2, compteCourant.getDecouvert());

            stmt.executeUpdate();

            return Optional.of(compteCourant);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }


    }
}
