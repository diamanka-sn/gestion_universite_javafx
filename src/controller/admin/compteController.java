package controller.admin;

import ConnexionBD.ConnexionBase;
import Model.Etudiant;
import Model.Salle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class compteController implements Initializable {
    private Parent fxml;
    @FXML
    private AnchorPane rootComptes;


    @FXML
    void AjoutEnseignant(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/compte/ListeEnseignant.fxml"));
            rootComptes.getChildren().removeAll();
            rootComptes.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void AjoutEtudiant(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/compte/ListeEtudiant.fxml"));
            rootComptes.getChildren().removeAll();
            rootComptes.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void AjoutResponsableFormation(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/compte/AjouterResponsableFormation.fxml"));
            rootComptes.getChildren().removeAll();
            rootComptes.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void AjoutResponsableSalle(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Vue/compte/AjouterResponsableSalle.fxml"));
            rootComptes.getChildren().removeAll();
            rootComptes.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public compteController(){ con = ConnexionBase.conDb();}

    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
