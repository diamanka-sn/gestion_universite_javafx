package controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController  implements Initializable{
    private Parent fxml;

    @FXML
    private AnchorPane root;
    @FXML
    void Deconnecter(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = null;
        try {
            scene = new Scene(FXMLLoader.load((getClass().getResource("/vue/Accueil.fxml"))));
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @FXML
    void accueil(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/admin/accueil.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void comptes(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/admin/Compte.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void salles(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/admin/Salle.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        } catch (IOException e) {

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
