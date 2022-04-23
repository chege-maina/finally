package sale;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mohware
 */
public class orderlstITM implements Initializable {

    @FXML
    private Label code;

    @FXML
    private Label name;

    @FXML
    private Label qty;

    @FXML
    private Label unit;

    ArrayList itemzz;

    public void receiptItems(ArrayList itemzz) {
       
        this.itemzz = itemzz;

        String codex = (String) itemzz.get(0);
        String namex = (String) itemzz.get(1);
        String qtyx = (String) itemzz.get(2);
        String unitx = (String) itemzz.get(3);

        name.setText(namex);
        code.setText(codex);
        qty.setText(qtyx);
        unit.setText(unitx);

       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
