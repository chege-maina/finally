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
public class DaBillITM implements Initializable {

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
    private Label pretax;

    @FXML
    private Label tax;

    @FXML
    private Label total;

    @FXML
    private Label status;

    @FXML
    public void click(MouseEvent mouseEvent) {
        listenerz.DaBillITMListener(itemzz);
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
        String pretaxx = (String) itemzz.get(5);
        String taxx = (String) itemzz.get(6);
        String totalx = (String) itemzz.get(7);
        String stat = (String) itemzz.get(8);

        invoiceno.setText(invoive_no);
        orderno.setText(order_no);
        lpo.setText(lpo_no);
        customer.setText(cust);
        date.setText(datex);
        pretax.setText(pretaxx);
        tax.setText(taxx);
        total.setText(totalx);
        status.setText(stat);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
