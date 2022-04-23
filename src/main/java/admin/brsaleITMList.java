/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

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
public class brsaleITMList implements Initializable {

    @FXML
    private Label code;

    @FXML
    private Label name;

    @FXML
    private Label cat;

    @FXML
    private Label reorder;

    @FXML
    private Label price;

    @FXML
    private Label selUnit;

    @FXML
    private Label supUnit;

    @FXML
    private Label status;

    @FXML
    public void click(MouseEvent mouseEvent) {
        listenerz.brsaleITMListListener(itemzz);
    }
    private myInterface listenerz;
    ArrayList itemzz;

    public void saleITMSList(ArrayList itemzz, myInterface listenerz) {
        this.listenerz = listenerz;
        this.itemzz = itemzz;

        String codex = (String) itemzz.get(0);
        String namex = (String) itemzz.get(1);
        String catx = (String) itemzz.get(3);
        String reoderx = (String) itemzz.get(2);
        String pricex = (String) itemzz.get(4);
        String sel_unitx = (String) itemzz.get(6);
        String sup_unitx = (String) itemzz.get(5);
        String statusx = (String) itemzz.get(8);
        code.setText(codex);
        name.setText(namex);
        cat.setText(catx);
        reorder.setText(reoderx);
        price.setText(pricex);
        selUnit.setText(sel_unitx);
        supUnit.setText(sup_unitx);
        status.setText(statusx);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
