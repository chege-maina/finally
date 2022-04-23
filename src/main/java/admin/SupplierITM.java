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
public class SupplierITM implements Initializable {

    @FXML
    private Label code;

    @FXML
    private Label name;

    @FXML
    private Label pin;

    @FXML
    private Label phone;

    @FXML
    private Label address;

    @FXML
    private Label email;

    @FXML
    public void click(MouseEvent mouseEvent) {
        listenerz.supplierITMListener(itemzz);
    }

    private myInterface listenerz;
    ArrayList itemzz;

    public void userITMSList(ArrayList itemzz, myInterface listenerz) {
        this.listenerz = listenerz;
        this.itemzz = itemzz;

        String emaill = (String) itemzz.get(0);
        String fname = (String) itemzz.get(1);
        String lname = (String) itemzz.get(2);
        String desig = (String) itemzz.get(3);
        String statuss = (String) itemzz.get(4);
        String statuss1 = (String) itemzz.get(5);

        code.setText(emaill);
        name.setText(fname);
        pin.setText(lname);
        phone.setText(desig);
        address.setText(statuss);
        email.setText(statuss1);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
