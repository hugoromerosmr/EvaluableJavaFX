package org.example.evaluablejavafx;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private BorderPane borderpane;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vbox1;
    @FXML
    private TableColumn tablecolum2;
    @FXML
    private HBox hbox;
    @FXML
    private TableColumn tablecolum3;
    @FXML
    private TableColumn tablecolum1;
    @FXML
    private TableView <User> table;
    @FXML
    private Button add;
    @FXML
    private CheckBox checkadmin;
    @FXML
    private TextField fieldcorreo;
    @FXML
    private ComboBox <String> fieldplatform;

    private ObservableList<User> list;
    @FXML
    private Button clear;
    @FXML
    private Spinner spinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fieldplatform.getItems().addAll("Windows", "Linux","macOS");
        list= FXCollections.observableArrayList();
        this.tablecolum1.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
        this.tablecolum2.setCellValueFactory(new PropertyValueFactory<User, String>("platform"));
        this.tablecolum3.setCellValueFactory(new PropertyValueFactory<User, String>("admin"));


        table.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends User> observable, User old, User nuevo) -> {
                    if (nuevo!=null) {
                        var alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Informacion del Usuario");
                        alert.setContentText("Correo: " + nuevo.getEmail() + "\n" +
                                "Plataforma: " + nuevo.getPlatform() + "\n" +
                                "Admin: " + (nuevo.getAdmin() + "\n"));
                        alert.showAndWait();
                    }
                }
        );
    }


    @FXML
    public void adduser(ActionEvent actionEvent) {
        String correo = fieldcorreo.getText();
        String platform = fieldplatform.getValue();
        Boolean admin = checkadmin.isSelected();
        User user = new User(correo, platform, admin);
        if (fieldcorreo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Rellena todos los campos");
            alert.showAndWait();
        }else {
            table.getItems().add(user);
        }
    }

    @FXML
    public void limpia(ActionEvent actionEvent) {
        table.getItems().clear();
    }

}