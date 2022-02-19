package controller.admin;

import ConnexionBD.ConnexionBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class responsableSalleController {
    @FXML
    private TextField txtMatricule;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtPasse;

    @FXML
    private Label lbResultat;

    @FXML
    private Label lbAutorisation;

    @FXML
    void Ajouter() {
        String matricule1 = txtMatricule.getText();
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String email = txtemail.getText();

        if (matricule1.equals("") || nom.equals("") || prenom.equals("") || email.equals("")) {
            lbResultat.setTextFill(Color.TOMATO);
            lbResultat.setText("Veillez remplir tous les Champs");
        } else {
            int matricule = Integer.parseInt(matricule1);
            String sql = "INSERT INTO responsableSalle(matricule,nomGerant,prenomGerant,email) values(?,?,?,?)";
            try {
                Connection con = ConnexionBase.conDb();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, matricule);
                ps.setString(2, nom);
                ps.setString(3, prenom);
                ps.setString(4, email);

                int st = ps.executeUpdate();

                if (st > 0) {
                    lbResultat.setTextFill(Color.GREEN);
                    lbResultat.setText("Ajoutes avec  succes");

                    txtNom.clear();
                    txtPrenom.clear();
                    txtemail.clear();

                } else {
                    lbResultat.setTextFill(Color.TOMATO);
                    lbResultat.setText("Erreur !! Veillez ressayer!!");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void Autorisation() {
        String passe = txtPasse.getText();
        String matricule1 = txtMatricule.getText();

        if (passe.equals("")) {
            lbAutorisation.setTextFill(Color.TOMATO);
            lbAutorisation.setText("veiller renseigner le champs Mot de passe!!");
        } else {
            String Sql = "INSERT INTO compteResponsableSalle(idCompteSalle,matricule,passe) values(?,?,?)";

            try {
                Connection con = ConnexionBase.conDb();
                PreparedStatement ps = con.prepareStatement(Sql);
                ps.setInt(1, 0);
                ps.setString(2, matricule1);
                ps.setString(3, passe);

                int st = ps.executeUpdate();
                if(st>0){

                    lbAutorisation.setTextFill(Color.GREEN);
                    lbAutorisation.setText("Autorisation acceptee");

                    txtMatricule.clear();
                    txtPasse.clear();
                } else{
                    lbAutorisation.setTextFill(Color.TOMATO);
                    lbAutorisation.setText("rejeter");
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }

        }
    }

    }


