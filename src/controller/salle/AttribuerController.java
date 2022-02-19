package controller.salle;

import ConnexionBD.ConnexionBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AttribuerController {
    @FXML
    private TextField txtClasse;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtBatiment;

    @FXML
    private TextField txtMatiere;

    @FXML
    private TextField txtProfesseur;

    @FXML
    private TextField txtDuree;

    @FXML
    private TextField txtDebut;

    @FXML
    private TextField txtFin;

    @FXML
    private Label lbAttribuer;

    @FXML
    void AttribuerSalle(ActionEvent event) {
        String nom = txtNom.getText();
        String classe = txtClasse.getText();
        String batiment = txtBatiment.getText();
        String matiere = txtMatiere.getText();
        String professeur = txtProfesseur.getText();
        String duree = txtDuree.getText();
        String debut = txtDebut.getText();
        String fin = txtFin.getText();

        if(nom.equals("") || classe.equals("") || batiment.equals("") || matiere.equals("") || professeur.equals("") || duree.equals("") || debut.equals("") || fin.equals("")){
            lbAttribuer.setTextFill(Color.TOMATO);
            lbAttribuer.setText("Veillez renseigner tout les champs!!");
        } else{
            String sql = "INSERT INTO salleattribuer(idAttribution,NomSalles,NomBatiments,NomProfesseur,Classe,Matiere,HeureDebut,HeureFin,duree) values(?,?,?,?,?,?,?,?,?)";
            try {
                Connection con = ConnexionBase.conDb();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,0);
                ps.setString(2,nom);
                ps.setString(3,batiment);
                ps.setString(4,professeur);
                ps.setString(5,classe);
                ps.setString(6,matiere);
                ps.setString(7,debut);
                ps.setString(8,fin);
                ps.setString(9,duree);

                int status = ps.executeUpdate();
                if (status > 0) {

                    txtBatiment.clear();
                    txtNom.clear();
                    txtClasse.clear();
                    txtDebut.clear();
                    txtFin.clear();
                    txtMatiere.clear();
                    txtProfesseur.clear();
                    txtDuree.clear();

                    lbAttribuer.setTextFill(Color.GREEN);
                    lbAttribuer.setText("Ajouter avec succes dans la base de donnees");

                } else {
                    lbAttribuer.setTextFill(Color.TOMATO);
                    lbAttribuer.setText("Desolé!!Veillez revoir ce que vous avez ecrit!!! ");
                }
            } catch (Exception e) {
                lbAttribuer.setTextFill(Color.TOMATO);
                lbAttribuer.setText("Exception ");
            }
        }
        }
    }
