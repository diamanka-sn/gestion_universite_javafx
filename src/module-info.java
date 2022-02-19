module Javasrt3 {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens controller;
    opens controller.admin;
    opens controller.etudiant;
    opens controller.salle;
    opens controller.formation;
    opens controller.enseignant;

    opens Vue;
    opens Vue.compte;
    opens Vue.etudiant;
    opens Vue.sallle;
    opens Vue.formation;
    opens Vue.enseignant;

    opens Model;
}