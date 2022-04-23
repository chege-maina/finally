/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class UserITM implements Initializable {

    @FXML
    private Label email, f_name, l_name, design, status;

    @FXML
    private Button action;

    @FXML
    public void click(MouseEvent mouseEvent) {
        listenerz.userITMListener(itemzz);
    }

    private myInterface listenerz;
    ArrayList itemzz;

    public void userITMSList(ArrayList itemzz, myInterface listenerz) {
        this.listenerz = listenerz;
        this.itemzz = itemzz;

        String emaill = (String) itemzz.get(0);
        String fname = (String) itemzz.get(1);
        String lname = (String) itemzz.get(2);
        String desig = (String) itemzz.get(6);
        String statuss = (String) itemzz.get(8);

        email.setText(emaill);
        f_name.setText(fname);
        l_name.setText(lname);
        design.setText(desig);
        status.setText(statuss);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
