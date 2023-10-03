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

            String sql = "INSERT INTO compteCourant (num_compte, decouvert) " +
                    "VALUES (?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, compteCourant.getNumero());
            stmt.setDouble(2, compteCourant.getDecouvert());

            stmt.executeUpdate();

            return Optional.of(compteCourant);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }


    }

    @Override
    public int supprimerCompte(int numero) {
        Connection con = Connectionbd.getConn();

        try {
            String sql = "DELETE FROM compte WHERE numero = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);

            int rowsDeleted = stmt.executeUpdate();

            return rowsDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public boolean chercherCompteC(int numero) {
        Connection con = Connectionbd.getConn();
        try {
            String sql = "SELECT * FROM comptecourant WHERE num_compte = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;    }
    }
