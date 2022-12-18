package com.laba.laba.controller;

import com.laba.laba.Entity.Appliance;
import com.laba.laba.Utils.Iterator;
import com.laba.laba.service.ApplianceService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TableColumn NameColumn;
    @FXML
    private TableColumn PriceColumn;
    @FXML
    private TableView<Appliance> Table;

    public void drawTable(){
        Table.getItems().clear();
        Iterator<Appliance> applianceIterator= new Iterator<Appliance>(ApplianceService.getAppliances());
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        /**
         * реализация паттерна "Итератор"
         * */
        while (applianceIterator.hasNext()){
            Table.getItems().add((Appliance) applianceIterator.next());
        }
    }

    public void addAppliance(){
        ApplianceService.addAppliance(new Appliance(nameField.getText(),Double.parseDouble(priceField.getText())));
        drawTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        drawTable();
    }

}
