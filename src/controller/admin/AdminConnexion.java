package controller.admin;

import ConnexionBD.ConnexionBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class AdminConnexion implements Initializable {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPasse;
    @FXML
    private Button btnconnexion;

    @FXML
    private Label lbConnexionAdmin;

    @FXML
    void ConnexionAdmin(MouseEvent event) {
        if(event.getSource() == btnconnexion){
            if (SeConnecter().equals("succes")){
                try {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();

                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/vue/admin/AccueilAdmin.fxml")));

                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            } else if(SeConnecter().equals("erreur")){
                lbConnexionAdmin.setTextFill(Color.TOMATO);
                lbConnexionAdmin.setText("Etes-vous vraiment l'administrateur");
            }
        }


    }
    public  AdminConnexion(){con = ConnexionBase.conDb();}

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private String SeConnecter() {
        String Login = txtLogin.getText();
        String Passe = txtPasse.getText();

        String sql = "SELECT * FROM administrateur Where login = ? and passe = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Login);
            ps.setString(2, Passe);

            rs = ps.executeQuery();

            if (!rs.next()) {

                return "erreur";
            } else {

                return "succes";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "exception";

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
