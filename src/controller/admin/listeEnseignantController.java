package controller.admin;

import ConnexionBD.ConnexionBase;
import Model.Enseignant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class listeEnseignantController implements Initializable {

    @FXML
    private TableView<Enseignant> tableEnseignant;

    @FXML
    private TableColumn<Enseignant, String> col_enseignantNom;

    @FXML
    private TableColumn<Enseignant, String> col_enseignantPrenom;

    @FXML
    private TableColumn<Enseignant, String> col_enseignantEmail;

    public ObservableList<Enseignant> listeEnseignant = FXCollections.observableArrayList();

    public listeEnseignantController(){con = ConnexionBase.conDb();}

    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void listedesEnseignant (){
        String Sql = "Select nomEnseignant,prenomEnseignant,email from Enseignant";

        try {
            ps = con.prepareStatement(Sql);
            rs = ps.executeQuery();
            while(rs.next()){
                listeEnseignant.add(new Enseignant(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        col_enseignantNom.setCellValueFactory(new PropertyValueFactory<Enseignant,String>("nomEnseignant"));
        col_enseignantPrenom.setCellValueFactory(new PropertyValueFactory<Enseignant,String>("prenomEnseignant"));
        col_enseignantEmail.setCellValueFactory(new PropertyValueFactory<Enseignant,String>("email"));
        tableEnseignant.setItems(listeEnseignant);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listedesEnseignant();
    }
}
