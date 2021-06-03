package com.expleo.hello.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.expleo.hello.jdbc.config.Database;
import com.expleo.hello.jdbc.models.Adresse;

public class AdresseDao implements Idao<Adresse> {

    private Connection dbConnection = Database.getInstance();

    @Override
    public List<Adresse> findAll() {
        List<Adresse> adresses = null;

        try {

            Statement stmt = dbConnection.createStatement();
            String query = "SELECT * FROM adresse";

            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int numRue = resultSet.getInt("numRue");
                String rue = resultSet.getString("rue");
                int codePostal = resultSet.getInt("codePostal");
                String ville = resultSet.getString("ville");
                String pays = resultSet.getString("pays");
                int idEmploye = resultSet.getInt("idEmploye");

                Adresse adresse = new Adresse(id, numRue, rue, codePostal, ville, pays, idEmploye);

                if (adresses == null)
                    adresses = new ArrayList<Adresse>();

                adresses.add(adresse);
            }

            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // try {
            // dbConnection.close();
            // } catch (Exception e) {
            // e.printStackTrace();
            // }
        }

        return adresses;
    }

    @Override
    public Adresse findById(int id) {

        Adresse adresse = null;

        try {

            Statement stmt = dbConnection.createStatement();
            String query = "SELECT * FROM adresse WHERE id = " + id;

            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {

                int numRue = resultSet.getInt("numRue");
                String rue = resultSet.getString("rue");
                int codePostal = resultSet.getInt("codePostal");
                String ville = resultSet.getString("ville");
                String pays = resultSet.getString("pays");
                int idEmploye = resultSet.getInt("idEmploye");

                adresse = new Adresse(id, numRue, rue, codePostal, ville, pays, idEmploye);

            }

            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return adresse;
    }

    @Override
    public boolean removeById(int id) {

        int response = 0;

        try {

            Statement stmt = dbConnection.createStatement();
            String query = "DELETE FROM adresse WHERE id = " + id;

            response = stmt.executeUpdate(query);

            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (response == 0) ? false : true;
    }

    @Override
    public int create(Adresse adresse) {

        int response = 0;

        try {

            String query = "insert into adresse (numRue, rue, codePostal, ville, pays, idEmploye) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);

            preparedStatement.setInt(1, adresse.getNumRue());
            preparedStatement.setString(2, adresse.getRue());
            preparedStatement.setInt(3, adresse.getCodePostal());
            preparedStatement.setString(4, adresse.getVille());
            preparedStatement.setString(5, adresse.getPays());
            preparedStatement.setInt(6, adresse.getIdEmploye());

            response = preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public boolean update(Adresse adresse) {

        int response = 0;

        try {

            String query = "update adresse set numRue = ?, rue = ?, codePostal = ?, ville = ?, pays = ?, idEmploye = ? where id = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);

            preparedStatement.setInt(1, adresse.getNumRue());
            preparedStatement.setString(2, adresse.getRue());
            preparedStatement.setInt(3, adresse.getCodePostal());
            preparedStatement.setString(4, adresse.getVille());
            preparedStatement.setString(5, adresse.getPays());
            preparedStatement.setInt(6, adresse.getIdEmploye());
            preparedStatement.setInt(7, adresse.getId());

            // System.out.println(preparedStatement.toString());

            response = preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (response == 0) ? false : true;

    }

}
