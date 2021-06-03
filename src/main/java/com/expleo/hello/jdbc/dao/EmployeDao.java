package com.expleo.hello.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.expleo.hello.jdbc.config.Database;
import com.expleo.hello.jdbc.models.Employe;

public class EmployeDao implements Idao<Employe> {

    private Connection dbConnection = Database.getInstance();

    @Override
    public List<Employe> findAll() {
        List<Employe> employes = null;

        try {

            Statement stmt = dbConnection.createStatement();
            String query = "SELECT * FROM employe";

            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                int age = resultSet.getInt("age");

                Employe employe = new Employe(id, nom, prenom, age);

                if (employes == null)
                    employes = new ArrayList<Employe>();

                employes.add(employe);
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

        return employes;
    }

    @Override
    public Employe findById(int id) {

        Employe employe = null;

        try {

            Statement stmt = dbConnection.createStatement();
            String query = "SELECT * FROM employe WHERE id = " + id;

            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {

                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                int age = resultSet.getInt("age");

                employe = new Employe(id, nom, prenom, age);

            }

            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employe;
    }

    @Override
    public boolean removeById(int id) {

        int response = 0;

        try {

            Statement stmt = dbConnection.createStatement();
            String query = "DELETE FROM employe WHERE id = " + id;

            response = stmt.executeUpdate(query);

            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (response == 0) ? false : true;
    }

    @Override
    public int create(Employe employe) {

        int idEmploye = 0;

        try {

            String query = "insert into employe (nom, prenom, age) values (?, ?, ?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, employe.getNom());
            preparedStatement.setString(2, employe.getPrenom());
            preparedStatement.setInt(3, employe.getAge());

            preparedStatement.executeUpdate();

            ResultSet genKey = preparedStatement.getGeneratedKeys();

            if (genKey.next())
                idEmploye = (int) genKey.getLong(1);

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idEmploye;
    }

    @Override
    public boolean update(Employe employe) {

        int response = 0;

        try {

            String query = "update employe set nom = ?, prenom = ?, age = ? where id = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);

            preparedStatement.setString(1, employe.getNom());
            preparedStatement.setString(2, employe.getPrenom());
            preparedStatement.setInt(3, employe.getAge());
            preparedStatement.setInt(4, employe.getId());

            // System.out.println(preparedStatement.toString());

            response = preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (response == 0) ? false : true;

    }

}
