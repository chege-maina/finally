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
public class billITMrec implements Initializable {

    @FXML
    private Label name, code, unit;
    @FXML
    private TextField qty;
    @FXML
    private Button action;

    @FXML
    public void click(MouseEvent mouseEvent) {
        listenerz.removeBillITM(itemzz);
    }
    private myInterface listenerz;
    ArrayList itemzz;

    public void receiptItems(ArrayList itemzz, myInterface listenerz) {
        this.listenerz = listenerz;
        this.itemzz = itemzz;

        String codex = (String) itemzz.get(0);
        String namex = (String) itemzz.get(1);
        String qtyx = (String) itemzz.get(2);
        String unitx = (String) itemzz.get(3);

        name.setText(namex);
        code.setText(codex);
        qty.setText(qtyx);
        unit.setText(unitx);

        qty.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    qty.setText(oldValue);
                } else {
                    if (qty.getText().equals("")) {

                    } else {
                        Double stockchk = Double.parseDouble(qtyx);
                        Double qtychk = Double.parseDouble(newValue);
                        if (qtychk >= stockchk) {
                            qty.setText(oldValue);
                        } else {
                            Double gg = stockchk-qtychk;
                            listenerz.BillEditQty(itemzz, newValue, gg);
                        }

                    }
                }
            }
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
