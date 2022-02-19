package controller.etudiant;

import ConnexionBD.ConnexionBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EtudiantController {


    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtPasse;

    @FXML
    private Label lbResultat;

    public EtudiantController(){}


    @FXML
    void Seconnecter(ActionEvent event) {
        String codePermanant = txtCode.getText();
        String passe = txtPasse.getText();


        String sql = "SELECT codePermanant,passe FROM compteEtudiant Where codePermanant = ? and passe = ?";

        try {
            Connection con = ConnexionBase.conDb();
            PreparedStatement  ps = con.prepareStatement(sql);
            ps.setString(1, codePermanant);
            ps.setString(2, passe);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                lbResultat.setTextFill(Color.TOMATO);
                lbResultat.setText("veillez revoir vos identifiants SVP!!!");
            } else {
                try {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();

                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Vue/etudiant/PageEtudiant.fxml")));

                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;

        }

    }
}
