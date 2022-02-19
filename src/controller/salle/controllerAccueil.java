package controller.salle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class controllerAccueil {

    private Parent fxml;
    @FXML
    private AnchorPane root;

    @FXML
    void Ajouter(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/sallle/AjouterSalle.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Attribuer(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/sallle/AttribuerSalle.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Tableau(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/sallle/TableauBord.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Deconnecter(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/vue/Accueil.fxml")));

        stage.setScene(scene);
        stage.show();

    }

}
