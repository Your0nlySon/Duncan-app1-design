package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Ethan Duncan
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class mainTabController {

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField nameField;

    private void addTab() throws IOException {
        String tabName = getName(nameField);
        Boolean validateTabName = validateTabName(tabName);
        if (validateTabName == true) {
            Tab tab = new Tab(tabName);
            tabPane.getTabs().addAll(tab);
            tab.setContent((VBox) FXMLLoader.load(this.getClass().getResource("tableTab.fxml")));
        }
        nameField.clear();
    }

    private Boolean validateTabName(String tabName) {
        //if tabName is not greater than 3 length then return false
        //if it is greater or equal to 3 then return true
        return null;
    }

    private String getName(TextField nameField) {
        String name = null;

        name = nameField.getText();
        return name;
    }
}