package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {

    private Parent fxml;

    @FXML
    private AnchorPane root;


    @FXML
    void Admin(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/admin/LoginAdmin.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void Enseignant(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/enseignant/LoginEnseignant.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Etudiant(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/etudiant/AccueilEtudiant.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Formation(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/formation/LoginFormateur.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void LoginButton(MouseEvent event) {

    }

    @FXML
    void Salle(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/sallle/LoginGerrant.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
