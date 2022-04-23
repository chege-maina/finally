package admin;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author mohware
 */
public class SecUserITM implements Initializable {

    @FXML
    private Label email, name, pass;
    ArrayList itemzz;

    public void userITMSList(ArrayList itemzz, String Check) {
        this.itemzz = itemzz;
        String password;
        String emaill = (String) itemzz.get(0);
        String names = (String) itemzz.get(1) + " " + (String) itemzz.get(2);
        if (Check.equals("pass")) {
            password = (String) itemzz.get(4);
        } else {
            password = (String) itemzz.get(5);
        }

        email.setText(emaill);
        name.setText(names);
        pass.setText(password);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
