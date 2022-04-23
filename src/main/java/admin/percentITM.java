package admin;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mohware
 */
public class percentITM implements Initializable {

    @FXML
    private Label name;

    @FXML
    private Label category;

    @FXML
    private Label type;

    @FXML
    private Label percent;

    public void userITMSList(ArrayList itemzz) {

        String naame = (String) itemzz.get(0);
        String cat = (String) itemzz.get(1);
        String typ = (String) itemzz.get(2);
        String per = (String) itemzz.get(3);

        name.setText(naame);
        category.setText(cat);
        type.setText(typ);
        percent.setText(per);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
