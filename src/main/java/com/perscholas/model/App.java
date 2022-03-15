package com.perscholas.model;

public class App {
    public static void main(String[] args) {
        AddressController addressController = new AddressController();
        addressController.createTables();
        addressController.InsertInfo();
        addressController.getpersoninfo();
        addressController.updateinsert();
    }

}
