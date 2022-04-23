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
public class invoicelstITM implements Initializable {

    @FXML
    private Label code;

    @FXML
    private Label name;

    @FXML
    private Label qty;

    @FXML
    private Label unit;

    @FXML
    private Label price;

    @FXML
    private Label pretax;

    @FXML
    private Label tax;

    @FXML
    private Label total;

    ArrayList itemzz;

    public void receiptItems(ArrayList itemzz) {

        this.itemzz = itemzz;

        String codex = (String) itemzz.get(0);
        String namex = (String) itemzz.get(1);
        String qtyx = (String) itemzz.get(2);
        String unitx = (String) itemzz.get(3);
        String pricex = (String) itemzz.get(4);
        String pretaxx = (String) itemzz.get(5);
        String taxx = (String) itemzz.get(6);
        String totalx = (String) itemzz.get(7);

        name.setText(namex);
        code.setText(codex);
        qty.setText(qtyx);
        unit.setText(unitx);
        price.setText(pricex);
        pretax.setText(pretaxx);
        tax.setText(taxx);
        total.setText(totalx);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
