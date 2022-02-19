package Model;

import java.sql.Date;

public class Etudiant {
    private int codePermanant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private String sexe;
    private String email;
    private String numeroTelephone;
    private  java.sql.Date dateNaissance;

    public Etudiant(int codePermanant, String nomEtudiant, String prenomEtudiant, String sexe, String email, String numeroTelephone, Date dateNaissance) {
        this.codePermanant = codePermanant;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.sexe = sexe;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.dateNaissance = dateNaissance;
    }

    public Etudiant(String nomEtudiant, String prenomEtudiant, String email, String numeroTelephone) {
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
    }

    public int getCodePermanant() {
        return codePermanant;
    }

    public void setCodePermanant(int codePermanant) {
        this.codePermanant = codePermanant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
