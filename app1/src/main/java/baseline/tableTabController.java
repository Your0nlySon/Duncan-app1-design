package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Ethan Duncan
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

public class tableTabController {
    
    @FXML private RadioButton normalV;
    @FXML private RadioButton completedV;
    @FXML private RadioButton incompletedV;
    @FXML private TableView<taskTable> tableList;
    @FXML private TableColumn <taskTable, String> description;
    @FXML private TableColumn <taskTable, String> date;
    @FXML private TableColumn <taskTable, Boolean> completed;
    @FXML private VBox vBox;
    @FXML private TextField descField;
    @FXML private DatePicker datePicker;

    ObservableList<taskTable> list = FXCollections.observableArrayList();
    ObservableList<taskTable> compList = FXCollections.observableArrayList();
    ObservableList<taskTable> inCompList = FXCollections.observableArrayList();

    public void initialize() {

        description.setCellValueFactory(new PropertyValueFactory<taskTable, String>("description"));
        date.setCellValueFactory(new PropertyValueFactory<taskTable, String>("date"));
        completed.setCellValueFactory(new PropertyValueFactory<taskTable, Boolean>("completed"));
        completed.setCellFactory(CheckBoxTableCell.forTableColumn(completed));

        list.add(new taskTable("Going to School", "2021-05-18"));
        list.add(new taskTable("Lax Practice", "2020-03-04"));

        tableList.setItems(list);
//                group.selectedToggleProperty().addListener(
//                (observable, oldToggle, newToggle) -> {
//                    if (newToggle == allV) {
//                        compList.clear();
//                        inCompList.clear();
//                        tableList.setItems(list);
//                    }
//                    else if (newToggle == completedV) {
//                        compList.clear();
//                        inCompList.clear();
//                        for (Items items : list) {
//                            if (items.isCompleted() == true) {
//                                compList.add(items);
//                            }
//                        }
//                        tableList.setItems(compList);
//                    }
//                    else if (newToggle == inCompletedV) {
//                        compList.clear();
//                        inCompList.clear();
//                        for (Items items : list) {
//                            if (items.isCompleted() == false) {
//                                inCompList.add(items);
//                            }
//                        }
//                        tableList.setItems(inCompList);
//                    }
//                }
//        );
        tableList.setEditable(true);
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        date.setCellFactory(TextFieldTableCell.forTableColumn());

        tableList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    public void removeItem(ActionEvent event) {
        try {
            //allItems = tableList.getItems();
            //selectedRows = tableList.getSelectionModel().getSelectedItems();
            //for (Items item : selectedRows) {allItems.remove(item);}
        } catch (NoSuchElementException e) {
            System.out.println("Exception Thrown");
        }
    }

    public void clearList(ActionEvent event) {
        //tableList.getItems().clear();
    }

    public void openList(ActionEvent event) {
        //FileChooser fileChooser = new FileChooser();
        //fileChooser.setTitle("Open TableView");
        //FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        //fileChooser.getExtensionFilters().add(extFilter);
        //Stage stage = (Stage)vBox.getScene().getWindow();
        //File file = fileChooser.showOpenDialog(stage);
        //if (file != null) {
            //tableList.getItems().clear();
            //openFileToText(file);
        //}
    }

    public void openFileToText(File file) throws  IOException {
        //BufferedReader reader = Files.newBufferedReader(Paths.get(String.valueOf(file)));
        //String line;
        //while ((line = reader.readLine()) != null) {
            //String[] names = line.split(",");

            //list.add(new taskTable(names[0],names[1]));
        //}
    }

    public void saveList(ActionEvent event) throws IOException {
        //FileChooser fileChooser = new FileChooser();
        //fileChooser.setTitle("Save TableView");
        //FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        //fileChooser.getExtensionFilters().add(extFilter);
        //Stage stage = (Stage)vBox.getScene().getWindow();
        //File file = fileChooser.showSaveDialog(stage);
        //if (file != null) {
            //saveTextToFile(file);
        //}
    }

    public void saveTextToFile(File file) throws IOException {
        //FileWriter writer = new FileWriter(file);
        //for (taskTable items : list) {
            //writer.write(items.getDesc() + "," + items.getDate() + "\n");
        //}
        //writer.close();
    }

    public void addItem(ActionEvent event) {
        String descTXT = descField.getText();
        Boolean validateDesc = validateDesc(descTXT);

        String date = pickerToString(datePicker);
        Boolean validateDate = validateDate(date);

        if (validateDesc == true && validateDate == true) {
            addFunc(descTXT, date);
        }
        //clear the fields of input

    }

    public void addFunc(String descTXT, String date) {
        //add items to the list
    }

    public Boolean validateDate(String date) {
        //see if the date is a valid date by checking if the string will fall on a calander that is in the past, present, or future
        return null;
    }

    private String pickerToString(DatePicker datePicker) {
        String dateString = "N/A";
        ////if the date picker is null then set date as "" else String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (datePicker.getValue() == null) {
            return dateString;
        }
        else {
            String dueString = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return  dueString;
        }
    }

    public Boolean validateDesc(String descTXT) {
        int length = descTXT.length();

        if (length < 1) {
            return false;
        }
        return true;
    }

    public void editDesc(TableColumn.CellEditEvent<taskTable, String> taskTableStringCellEditEvent) {
        //create an taskTable object called item and make it equal to tableList.getSelectionModel().getSelectedItem()
        //call validateDesc to make sure that it is edited in a valid format
        //create an if else that allows the edit to happen or doesn't allow it to happen
    }

    public void editDate(TableColumn.CellEditEvent<taskTable, String> taskTableStringCellEditEvent) {
        //create an taskTable object called item and make it equal to tableList.getSelectionModel().getSelectedItem()
        //call validateDate to make sure that it is edited in a valid format
        //create an if else that allows the edit to happen or doesn't allow it to happen
    }
}
