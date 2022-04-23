/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sale;

import admin.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mohware
 */
public class BillITM implements Initializable {

    @FXML
    private Label invoiceno;

    @FXML
    private Label orderno;

    @FXML
    private Label lpo;

    @FXML
    private Label customer;

    @FXML
    private Label date;

    @FXML
    private Label supplier;

    @FXML
    public void click(MouseEvent mouseEvent) {
        listenerz.BillITMListener(itemzz);
    }

    private myInterface listenerz;
    ArrayList itemzz;

    public void userITMSList(ArrayList itemzz, myInterface listenerz) {
        this.listenerz = listenerz;
        this.itemzz = itemzz;

        String invoive_no = (String) itemzz.get(0);
        String order_no = (String) itemzz.get(1);
        String lpo_no = (String) itemzz.get(2);
        String cust = (String) itemzz.get(3);
        String datex = (String) itemzz.get(4);
        String supplierx = (String) itemzz.get(10);

        invoiceno.setText(invoive_no);
        orderno.setText(order_no);
        lpo.setText(lpo_no);
        customer.setText(cust);
        date.setText(datex);
        supplier.setText(supplierx);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
