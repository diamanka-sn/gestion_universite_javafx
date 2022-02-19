package controller.formation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilFormateurController {
    private Parent fxml;
    @FXML
    private AnchorPane root;


    @FXML
    void Attribuer(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/formation/AllouerSalle.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Deconnecter(ActionEvent event) {
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
    void liberer(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/formation/Liberer.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
