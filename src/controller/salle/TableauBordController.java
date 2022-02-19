package controller.salle;

import ConnexionBD.ConnexionBase;
import Model.Attribuer;
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

public class TableauBordController implements Initializable {

    @FXML
    private TableView<Attribuer> tableauAttribution;

    @FXML
    private TableColumn<Attribuer, String> col_nom;

    @FXML
    private TableColumn<Attribuer, String> col_batiment;

    @FXML
    private TableColumn<Attribuer, String> col_classe;

    @FXML
    private TableColumn<Attribuer, String> col_professeur;

    @FXML
    private TableColumn<Attribuer, String> col_matiere;

    @FXML
    private TableColumn<Attribuer, String> col_debut;

    @FXML
    private TableColumn<Attribuer, String> col_fin;

    @FXML
    private TableColumn<Attribuer, String> col_duree;


    public ObservableList<Attribuer> bord = FXCollections.observableArrayList();
    public TableauBordController(){con = ConnexionBase.conDb();}

    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void AttribuerSalle(){
        String sql = "SELECT NomSalles,NomBatiments,Classe,NomProfesseur,Matiere,HeureDebut,HeureFin,duree FROM salleattribuer";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                bord.add(new Attribuer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        col_nom.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("nom"));
        col_batiment.setCellValueFactory((new PropertyValueFactory<Attribuer,String>("batiment")));
        col_classe.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("classe"));
        col_professeur.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("professeur"));
        col_matiere.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("matiere"));
        col_debut.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("debut"));
        col_fin.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("fin"));
        col_duree.setCellValueFactory(new PropertyValueFactory<Attribuer,String>("duree"));
        tableauAttribution.setItems(bord);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { AttribuerSalle(); }
}
