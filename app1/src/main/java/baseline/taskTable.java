package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Ethan Duncan
 */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;


public class taskTable {

    private final SimpleStringProperty desc;
    private final SimpleStringProperty date;
    private BooleanProperty completed;

    public taskTable(String description, String dueDate) {
        this.desc = new SimpleStringProperty(description);
        this.date = new SimpleStringProperty(dueDate);
        this.completed = new SimpleBooleanProperty(false);
    }


    public String getDesc() {
        return desc.get();
    }

    public void setDesc(String description) {
        desc.set(description);
    }

    public StringProperty descriptionProperty() {
        return desc;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String dueDate) {
        date.set(dueDate);
    }

    public StringProperty dueDateProperty() {
        return date;
    }

    public Boolean isCompleted() {
        return completed.get();
    }

    public void setCompleted(Boolean completed) {
        this.completed.set(completed);
    }

    public BooleanProperty completedProperty() {
        return completed;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ((this.desc.get().equals(((taskTable) obj).desc.get())) && (this.date.get().equals(((taskTable) obj).date.get())));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.desc.get());
        return hash;
    }

}