package com.expleo.hello.jdbc;

import com.expleo.hello.jdbc.dao.EmployeDao;
import com.expleo.hello.jdbc.models.Employe;
import com.expleo.hello.jdbc.config.Database;
import com.expleo.hello.jdbc.dao.AdresseDao;
import com.expleo.hello.jdbc.models.Adresse;

public class MainJDBC {
    public static void main(String[] args) {

        EmployeDao employeDao = new EmployeDao();

        System.out.println("\n*********** Liste des employés *************");

        for (Employe employe : employeDao.findAll()) {
            System.out.println(employe);
        }

        AdresseDao adresseDao = new AdresseDao();

        System.out.println("\n*********** Liste des adresses *************");

        for (Adresse adresse : adresseDao.findAll()) {
            System.out.println(adresse);
        }

        System.out.println("\n******** Find employé by id **************");
        System.out.println(employeDao.findById(4));

        System.out.println("\n******** Find adresse by id **************");
        System.out.println(adresseDao.findById(3));

        // System.out.println("\n******** Delete employé by id **************");
        // System.out.println(employeDao.removeById(6));

        // System.out.println("\n******** Delete adresse by id **************");
        // System.out.println(adresseDao.removeById(5));

        // Employe newEmploye = new Employe(111, "Karoui", "Ahmed", 20);
        // System.out.println(employeDao.create(newEmploye));

        // Adresse newAdresse = new Adresse(111, 5, "rue de la joie", 99999, "Ma ville",
        // "Mon pays", 1);
        // System.out.println(adresseDao.create(newAdresse));

        // Employe modifiedEmploye = employeDao.findById(1);
        // modifiedEmploye.setNom(modifiedEmploye.getNom().toUpperCase());
        // modifiedEmploye.setPrenom(modifiedEmploye.getPrenom().toUpperCase());
        // System.out.println(employeDao.update(modifiedEmploye));

        // Adresse modifiedAdresse = adresseDao.findById(1);
        // modifiedAdresse.setRue("rue de l\'Allemagne");
        // System.out.println(adresseDao.update(modifiedAdresse));

        int newID = 0;
        Employe newEmploye1 = new Employe(111, "Obama", "Barack", 55);
        newID = employeDao.create(newEmploye1);

        Adresse newAdresse1 = new Adresse(111, 12, "rue de Washington", 12345, "Washington DC", "USA", newID);
        adresseDao.create(newAdresse1);

        try {
            Database.getInstance().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
