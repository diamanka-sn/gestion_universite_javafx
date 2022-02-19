package Model;

public class Attribuer  {
    private String nom;
    private String batiment;
    private String classe;
    private String professeur;
    private String matiere;
    private String debut;
    private String fin;
    private String duree;

    public Attribuer(String nom, String batiment, String classe, String professeur, String matiere, String debut, String fin, String duree) {
        this.nom = nom;
        this.batiment = batiment;
        this.classe = classe;
        this.professeur = professeur;
        this.matiere = matiere;
        this.debut = debut;
        this.fin = fin;
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
}
