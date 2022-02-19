package Model;

public class Salle {
    private int idSalle;
    private String nomSalle;
    private String nomBatiment;
    private String capaciteSalle;
    private String estOccupe;

    public Salle(int idSalle, String nomSalle, String nomBatiment, String capaciteSalle, String estOccupe) {
        this.idSalle = idSalle;
        this.nomSalle = nomSalle;
        this.nomBatiment = nomBatiment;
        this.capaciteSalle = capaciteSalle;
        this.estOccupe = estOccupe;
    }

    public Salle(String nomSalle, String capaciteSalle, String estOccupe) {
        this.nomSalle = nomSalle;
        this.capaciteSalle = capaciteSalle;
        this.estOccupe = estOccupe;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getNomBatiment() {
        return nomBatiment;
    }

    public void setNomBatiment(String nomBatiment) {
        this.nomBatiment = nomBatiment;
    }

    public String getCapaciteSalle() {
        return capaciteSalle;
    }

    public void setCapaciteSalle(String capaciteSalle) {
        this.capaciteSalle = capaciteSalle;
    }

    public String getEstOccupe() {
        return estOccupe;
    }

    public void setEstOccupe(String estOccupe) {
        this.estOccupe = estOccupe;
    }
}
