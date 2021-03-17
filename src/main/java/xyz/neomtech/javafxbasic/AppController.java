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
import org.jsoup.Jsoup;
import xyz.neomtech.javafxbasic.model.DataGrid;

import org.jsoup.helper.Validate;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
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

    int count = 0;

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
    private void submitButtonAction() throws IOException {
        System.out.println("Alhudulilah Submit Button is Working!");
        if (searchText.getText().isEmpty()) {
            showAlert();
        } else {
            startJsoupSearch();
        }
    }

    private void startJsoupSearch() throws IOException {
        System.out.println("jSOUP Saerch Working!");
        String baseUrl = "https://app.memrise.com/course/421128/essential-words-for-the-ielts-3/";
        print("Fetching %s...", baseUrl);
        for (int i = 1; i <= 30; i++) {
            String url = "https://app.memrise.com/course/421128/essential-words-for-the-ielts-3/" + i + "/";
            System.out.println(i + "---------------------------------");
            for (int x = 0; x < 19; x++) {
//                System.out.println(x);
            }
            getWords(url);
        }
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("Please Enter Text!");
        alert.showAndWait();
    }

    private void getWords(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
//        no need the words heards, if words header requied then have to active this line.
//        Elements header = doc.select("div.infos");
//        System.out.println(header.text());

        Elements words = doc.select("div.thing");
        List<String> list = words.eachText();
        words.eachText().forEach(s -> {
            String[] ss = s.split(" ");
//            1st print the word,
            System.out.print(ss[0] + ", ");
            DataGrid dataGrid = new DataGrid();
            dataGrid.setIndex(count++);
            dataGrid.setBusinessName(ss[0]);
//            2nd meaning of the word.
            String x = "";
            for (int i = 1; i < ss.length; i++) {
//                System.out.print(ss[i] + " ");
                x += ss[i] + " ";
            }
            dataGrid.setBusinessAddress(x);
            dataLists.add(dataGrid);
            System.out.println();
        });
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}
