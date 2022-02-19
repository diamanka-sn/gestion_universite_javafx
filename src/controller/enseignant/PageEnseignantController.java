package controller.enseignant;

import Model.Emploi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PageEnseignantController {
    @FXML
    private TableView<Emploi> tableEmploi;

    @FXML
    private TableColumn<Emploi, String> colLundi;

    @FXML
    private TableColumn<Emploi,String> colMardi;

    @FXML
    private TableColumn<Emploi, String> colMercredi;

    @FXML
    private TableColumn<Emploi, String> colJeudi;

    @FXML
    private TableColumn<Emploi, String> colvendredi;

    @FXML
    private TableColumn<Emploi, String> colSamedi;
    @FXML
    void Deconnecter(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/vue/Accueil.fxml")));

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @FXML
    void Emploi(ActionEvent event) {
        colLundi.setCellValueFactory(new PropertyValueFactory<Emploi,String>("lundi"));
        colMardi.setCellValueFactory(new PropertyValueFactory<Emploi,String>("mardi"));
        colMercredi.setCellValueFactory(new PropertyValueFactory<Emploi,String>("mercredi"));
        colJeudi.setCellValueFactory(new PropertyValueFactory<Emploi,String>("jeudi"));
        colvendredi.setCellValueFactory(new PropertyValueFactory<Emploi,String>("vendredi"));
        colSamedi.setCellValueFactory(new PropertyValueFactory<Emploi,String>("samedi"));

        tableEmploi.getItems().add(new Emploi("SRT 1 8H-12H","M1 SI 15H-18H","D2A2 8H-13H","D2A3 8H-12H 15H-18H","SRT3 8H-10H 15H 17","M2 SR 8H-19H"));

    }
}
