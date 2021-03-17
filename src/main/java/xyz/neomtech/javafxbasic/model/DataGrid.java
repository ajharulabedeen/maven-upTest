package xyz.neomtech.javafxbasic.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataGrid {
    private final SimpleIntegerProperty index;
    private final SimpleStringProperty businessName;
    private final SimpleStringProperty businessAddress;
    private final SimpleStringProperty city;
    private final SimpleStringProperty state;
    private final SimpleStringProperty zip;


    public DataGrid(int index, String businessName, String businessAddress, String city, String state, String zip) {
        this.index = new SimpleIntegerProperty(index);
        this.businessName = new SimpleStringProperty(businessName);
        this.businessAddress = new SimpleStringProperty(businessAddress);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.zip = new SimpleStringProperty(zip);
    }


    public DataGrid() {
        this.index = new SimpleIntegerProperty();
        this.businessName = new SimpleStringProperty();
        this.businessAddress = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.state = new SimpleStringProperty();
        this.zip = new SimpleStringProperty();

    }


    public int getIndex() {
        return index.get();
    }

    public SimpleIntegerProperty indexProperty() {
        return index;
    }

    public void setIndex(int index) {
        this.index.set(index);
    }

    public String getBusinessName() {
        return businessName.get();
    }

    public SimpleStringProperty businessNameProperty() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName.set(businessName);
    }

    public String getBusinessAddress() {
        return businessAddress.get();
    }

    public SimpleStringProperty businessAddressProperty() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress.set(businessAddress);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getZip() {
        return zip.get();
    }

    public SimpleStringProperty zipProperty() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip.set(zip);
    }
}
