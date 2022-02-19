package controller.salle;

import ConnexionBD.ConnexionBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class salleLogin {
    @FXML
    private TextField txtMatricule;

    @FXML
    private PasswordField txtPasse;

    @FXML
    private Label lbResultat;

    @FXML
    void Seconnecter(ActionEvent event) {
        String matricule = txtMatricule.getText();
        String passe = txtPasse.getText();


        String sql = "SELECT matricule,passe FROM compteresponsablesalle Where matricule = ? and passe = ?";

        try {
            Connection con = ConnexionBase.conDb();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, matricule);
            ps.setString(2, passe);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                lbResultat.setTextFill(Color.TOMATO);
                lbResultat.setText("veillez revoir vos identifiants SVP!!!");
            } else {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();

                Scene scene = null;
                try {
                    scene = new Scene(FXMLLoader.load((getClass().getResource("/vue/sallle/AccueilGerant.fxml"))));
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;

        }

    }
 }
