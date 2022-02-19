package controller;

import ConnexionBD.ConnexionBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class AccueilController {

    @FXML
    private TextField txtNom;

    @FXML
    private PasswordField txtPasse;

    @FXML
    private Button btnValider;

    @FXML
    private Button btnAnnuler;

    @FXML
    private Label lbResultatlogin;

    @FXML
    private TextField txtNiveau;

    @FXML
    void HandleButtonActive(MouseEvent event) {
        if(event.getSource() == btnValider){
            if(SeConnecter().equals("succes")){
                lbResultatlogin.setTextFill(Color.GREEN);
                lbResultatlogin.setText("Connexion Avec Succes.....Redirection");
            } else if (SeConnecter().equals("erreur")){
                lbResultatlogin.setTextFill(Color.TOMATO);
                lbResultatlogin.setText("Echec reverifier s'il vous plait !!!!!");
            } else if (SeConnecter().equals("Exception")){
                lbResultatlogin.setTextFill(Color.TOMATO);
                lbResultatlogin.setText("Retourne une exception!!!");
            }
        } else if(event.getSource() == btnAnnuler){
            Alert confirme = new Alert(Alert.AlertType.CONFIRMATION);


            confirme.setTitle("BoitedeConfirmation");
            confirme.setHeaderText(null);
            confirme.setContentText("Voulez-vous vraiment quitter!!");

            Optional <ButtonType> reponse = confirme.showAndWait();

            if(((Optional<?>) reponse).get() == ButtonType.OK){

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
            }
        }
    }

    public  AccueilController(){
        con = ConnexionBase.conDb();
    }
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private String SeConnecter() {
        String Login = txtNom.getText();
        String Passe = txtPasse.getText();
        String Niveau = txtNiveau.getText();

        String sql = "SELECT * FROM compte Where login = ? and passe = ? and niveau = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Login);
            ps.setString(2, Passe);
            ps.setString(3,Niveau);

            rs = ps.executeQuery();

            if(!rs.next()) {
                   return "erreur";
            }
            else {

                return "succes";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  "exception";

        }
    }
}
