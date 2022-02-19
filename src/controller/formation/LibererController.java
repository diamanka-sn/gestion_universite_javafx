package controller.formation;

import ConnexionBD.ConnexionBase;
import Model.Attribuer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LibererController implements Initializable {
    @FXML
    private TableView<Attribuer> tableauAttribution;

    @FXML
    private TableColumn<Attribuer, String> col_nom;

    @FXML
    private TableColumn<Attribuer, String> col_batiment;

    @FXML
    private TableColumn<Attribuer, String> col_classe;

    @FXML
    private TableColumn<Attribuer, String> col_professeur;

    @FXML
    private TableColumn<Attribuer, String> col_matiere;

    @FXML
    private TableColumn<Attribuer, String> col_debut;

    @FXML
    private TableColumn<Attribuer, String> col_fin;

    @FXML
    private TableColumn<Attribuer, String> col_duree;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtProfesseur;

    @FXML
    private TextField txtMatiere;

    @FXML
    private TextField txtDebut;

    @FXML
    private TextField txtFin;

    @FXML
    private TextField TxtClasse;

    @FXML
    private Label lbresultat;

    public ObservableList<Attribuer> bord = FXCollections.observableArrayList();

    @FXML
    void Liberer(ActionEvent event) {
        String nom = txtNom.getText();
        String professeur = txtProfesseur.getText();
        String matiere = txtMatiere.getText();
        String debut = txtDebut.getText();
        String fin = txtFin.getText();
        String classe = TxtClasse.getText();

        if(nom.equals("") || professeur.equals("") || matiere.equals("") || debut.equals("") || fin.equals("") || classe.equals("")){

            lbresultat.setTextFill(Color.TOMATO);
            lbresultat.setText("Veileez remlir tout les champs!!");
        } else {
            String sql = "DELETE * FROM salleattribuer WHERE NomSalles=? and NomProfesseur=? and Classe=? and Matiere=? and HeureDebut=? and HeureFin=? LIMIT 1";

            try {
                Connection con = ConnexionBase.conDb();
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, nom);
                ps.setString(2, professeur);
                ps.setString(3, classe);
                ps.setString(4, matiere);
                ps.setString(5, debut);
                ps.setString(6, fin);

                int status = ps.executeUpdate();

                if (status > 0) {
                    lbresultat.setTextFill(Color.GREEN);
                    lbresultat.setText("Element supprimer avec succes!!");
                } else {
                    lbresultat.setTextFill(Color.TOMATO);
                    lbresultat.setText("Impossible de supprimer cette element");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                ;

            }
        }
    }
    public LibererController(){con = ConnexionBase.conDb();}

    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void AttribuerSalle(){
        String sql = "SELECT NomSalles,NomBatiments,Classe,NomProfesseur,Matiere,HeureDebut,HeureFin,duree FROM salleattribuer";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                bord.add(new Attribuer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        col_nom.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("nom"));
        col_batiment.setCellValueFactory((new PropertyValueFactory<Attribuer,String>("batiment")));
        col_classe.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("classe"));
        col_professeur.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("professeur"));
        col_matiere.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("matiere"));
        col_debut.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("debut"));
        col_fin.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("fin"));
        col_duree.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("duree"));
        tableauAttribution.setItems(bord);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { AttribuerSalle(); }
}
