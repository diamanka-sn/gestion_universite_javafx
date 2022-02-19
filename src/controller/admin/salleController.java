package controller.admin;

import ConnexionBD.ConnexionBase;
import Model.Salle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class salleController implements Initializable {

    @FXML
    private Button btnAjouter;

    @FXML
    private TableView<Salle> tableSalle;

    @FXML
    private TableColumn<Salle, String> colNom;
    @FXML
    private TableColumn<Salle, String> colCapacite;

    @FXML
    private TableColumn<Salle, String> ColSiituation;

    @FXML
    private TextField txtNomSalle;

    @FXML
    private TextField txtNomBatiment;

    @FXML
    private TextField txtCapacite;

    @FXML
    private TextField txtSituation;

    @FXML
    private Label lbResultatSalle;

    public ObservableList<Salle> listeSalle = FXCollections.observableArrayList();
    static ObservableList<Salle> suprimerSalles;
    static ObservableList<Salle> suprimerSalle;

    @FXML
    void Ajouter() {
        String nomSalle = txtNomSalle.getText();
        String nomBatiment = txtNomBatiment.getText();
        String capacite = txtCapacite.getText();
        String etat1 = txtSituation.getText();

        if(nomSalle.equals("") || nomBatiment.equals("") || capacite.equals("") || etat1.equals("")){
            lbResultatSalle.setTextFill(Color.TOMATO);
            lbResultatSalle.setText("Veillez remplir tous les champs svp!!");

        } else {
            String sql = "INSERT INTO salle(idSalle,nomSalle,nomBatiment,capacite,etatSalle) values(?,?,?,?,?)";
            try {
                Connection con =ConnexionBase.conDb();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,0);
                ps.setString(2, nomSalle);
                ps.setString(3, nomBatiment);
                ps.setString(4, capacite);
                ps.setString(5, etat1);

                int status = ps.executeUpdate();
                if (status > 0) {
                    System.out.println("niveau Status");
               /* Salle salle = new Salle(nomSalle,etat);
                ObservableList<Salle> ajoutSalle = FXCollections.observableArrayList(salle);
                tableSalle.getItems().addAll(ajoutSalle);

                txtCapacite.clear();
                txtNomBatiment.clear();
                txtNomSalle.clear();
                txtSituation.clear();*/

                    lbResultatSalle.setTextFill(Color.GREEN);
                    lbResultatSalle.setText("Ajouter avec succes dans la base de donnees");

                } else {
                    lbResultatSalle.setTextFill(Color.TOMATO);
                    lbResultatSalle.setText("Desolé!!Veillez revoir ce que vous avez ecrit!!! ");
                }
            } catch (Exception e) {
                lbResultatSalle.setTextFill(Color.TOMATO);
                lbResultatSalle.setText("Exception ");
            }
        }
    }


    @FXML
    void MiseJour(MouseEvent event) {

    }

    @FXML
    void Supprimer() {
        suprimerSalles = tableSalle.getItems();
        suprimerSalle = tableSalle.getSelectionModel().getSelectedItems();

            Alert confirmeSuppression = new Alert(Alert.AlertType.INFORMATION);
            confirmeSuppression.setTitle("INFORMATION");
            confirmeSuppression.setHeaderText(null);
            confirmeSuppression.setContentText("Desoler avant de supprimer une salle vous devez avoir l'autorisation du recteur");
            confirmeSuppression.showAndWait();
        }

    public salleController(){con = ConnexionBase.conDb();}
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void SalleListe(){
        String sql = "SELECT nomSalle,capacite,etatSalle FROM Salle";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                listeSalle.add(new Salle(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        colNom.setCellValueFactory(new PropertyValueFactory<Salle,String>("nomSalle"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<Salle,String>("capaciteSalle"));
        ColSiituation.setCellValueFactory(new PropertyValueFactory<Salle,String>("estOccupe"));
        tableSalle.setItems(listeSalle);

    }

    public void ajouterSalle(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            SalleListe();
    }
}
