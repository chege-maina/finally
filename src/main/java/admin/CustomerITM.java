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
public class CustomerITM implements Initializable {

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
    private Label bal;

    @FXML
    private Label terms;

    @FXML
    private Label limit;

    @FXML
    private Label type;

    @FXML
    private Label category;

    @FXML
    public void click(MouseEvent mouseEvent) {
        listenerz.customerITMListener(itemzz);
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
         String ball = (String) itemzz.get(6);
        String termss = (String) itemzz.get(7);
        String limits = (String) itemzz.get(8);
        String types = (String) itemzz.get(9);
        String categorys = (String) itemzz.get(10);

        code.setText(emaill);
        name.setText(fname);
        pin.setText(lname);
        phone.setText(desig);
        address.setText(statuss);
        email.setText(statuss1);
        bal.setText(ball);
        terms.setText(termss);
        limit.setText(limits);
        type.setText(types);
        category.setText(categorys);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
