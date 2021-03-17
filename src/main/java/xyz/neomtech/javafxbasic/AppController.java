/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.javafxbasic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import xyz.neomtech.javafxbasic.model.DataGrid;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author Dell
 */
public class AppController implements Initializable {

    @FXML
    private TextField searchText;

    @FXML
    private TableView<DataGrid> dataGrid;
    @FXML
    private TableColumn<DataGrid, Integer> index;
    @FXML
    private TableColumn<DataGrid, String> columnBusinessName;
    @FXML
    private TableColumn<DataGrid, String> columnBusinessAddress;
    @FXML
    private TableColumn<DataGrid, String> columnCity;
    @FXML
    private TableColumn<DataGrid, String> columnState;
    @FXML
    private TableColumn<DataGrid, String> columnZipcode;

    ObservableList<DataGrid> dataLists = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        index.setCellValueFactory(new PropertyValueFactory<DataGrid, Integer>("index")); //1
        columnBusinessName.setCellValueFactory(new PropertyValueFactory<DataGrid, String>("businessName"));//3
        columnBusinessAddress.setCellValueFactory(new PropertyValueFactory<DataGrid, String>("businessAddress"));//4
        columnCity.setCellValueFactory(new PropertyValueFactory<DataGrid, String>("city"));//5
        columnState.setCellValueFactory(new PropertyValueFactory<DataGrid, String>("state"));//5
        columnZipcode.setCellValueFactory(new PropertyValueFactory<DataGrid, String>("zipCode"));//5
        this.dataGrid.setItems(dataLists);
    }

    @FXML
    private void submitButtonAction() {
        System.out.println("Alhudulilah Submit Button is Working!");
        if (searchText.getText().isEmpty()) {
            showAlert();
        } else {
            startJsoupSearch();
        }
    }

    private void startJsoupSearch() {
        System.out.println("jSOUP Saerch Working!");
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("Please Enter Text!");
        alert.showAndWait();
    }


}
