package controller.salle;

import ConnexionBD.ConnexionBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AjouterSalleController {

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtBatiment;

    @FXML
    private TextField txtCapacite;

    @FXML
    private TextField txtEtat;

    @FXML
    private Label lbAjouter;

    @FXML
    void AjouterSalle(ActionEvent event) {
        String nomSalle = txtNom.getText();
        String nomBatiment = txtBatiment.getText();
        String capacite = txtCapacite.getText();
        String etat = txtEtat.getText();

        if(nomSalle.equals("") || nomBatiment.equals("") || capacite.equals("") || etat.equals("")){
            lbAjouter.setTextFill(Color.TOMATO);
            lbAjouter.setText("Veillez remplir tous les champs svp!!");

        } else {
            String sql = "INSERT INTO salle(idSalle,nomSalle,nomBatiment,capacite,etatSalle) values(?,?,?,?,?)";
            try {
                Connection con = ConnexionBase.conDb();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,0);
                ps.setString(2, nomSalle);
                ps.setString(3,nomBatiment);
                ps.setString(4,capacite);
                ps.setString(5,etat);

                int status = ps.executeUpdate();
                if (status > 0) {

                    txtCapacite.clear();
                    txtNom.clear();
                    txtBatiment.clear();
                    txtEtat.clear();

                    lbAjouter.setTextFill(Color.GREEN);
                    lbAjouter.setText("Ajouter avec succes dans la base de donnees");

                } else {
                    lbAjouter.setTextFill(Color.TOMATO);
                    lbAjouter.setText("Desolé!!Veillez revoir ce que vous avez ecrit!!! ");

                }
            } catch (Exception e) {
                lbAjouter.setTextFill(Color.TOMATO);
                lbAjouter.setText("Exception ");
            }
        }
    }

}
