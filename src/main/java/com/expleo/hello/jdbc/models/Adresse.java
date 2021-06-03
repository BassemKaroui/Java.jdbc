package com.expleo.hello.jdbc.models;

public class Adresse {

    private int id;
    private int numRue;
    private String rue;
    private int codePostal;
    private String ville;
    private String pays;
    private int idEmploye;

    public Adresse(int id, int numRue, String rue, int codePostal, String ville, String pays, int idEmploye) {
        this.id = id;
        this.numRue = numRue;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.idEmploye = idEmploye;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Override
    public String toString() {
        return "Adresse [codePostal=" + codePostal + ", id=" + id + ", idEmploye=" + idEmploye + ", numRue=" + numRue
                + ", pays=" + pays + ", rue=" + rue + ", ville=" + ville + "]";
    }

}
