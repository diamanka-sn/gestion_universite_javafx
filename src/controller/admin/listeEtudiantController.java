package controller.admin;

import ConnexionBD.ConnexionBase;
import Model.Etudiant;
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

public class listeEtudiantController implements Initializable {
    @FXML
    private TableView<Etudiant> tableEtudiant;

    @FXML
    private TableColumn<Etudiant, String> col_etudiant_nom;

    @FXML
    private TableColumn<Etudiant, String > col_etudiantPrenom;

    @FXML
    private TableColumn<Etudiant, String> col_etudiantEmail;

    @FXML
    private TableColumn<Etudiant, String> col_etudiantNumero;

    public ObservableList<Etudiant> listeEtudiant = FXCollections.observableArrayList();

    public listeEtudiantController(){con = ConnexionBase.conDb();}
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void listedesEtudiant(){

        String sql = "SELECT nomEtudiant,prenomEtudiant,email,numeroTelephone FROM Etudiant";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                listeEtudiant.add(new Etudiant(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        col_etudiant_nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nomEtudiant"));
        col_etudiantPrenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenomEtudiant"));
        col_etudiantEmail.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("email"));
        col_etudiantNumero.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("numeroTelephone"));
        tableEtudiant.setItems(listeEtudiant);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listedesEtudiant();
    }
}
