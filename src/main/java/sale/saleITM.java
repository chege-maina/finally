package sale;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author mohware
 */
public class saleITM implements Initializable {

    @FXML
    private ImageView itmImage;

    @FXML
    private Label itmCode;

    @FXML
    private Label itmName;

    @FXML
    public void clicked(MouseEvent mouseEvent) {
        listenerz.saleItemListener(itemzz);

    }
    private myInterface listenerz;
    ArrayList itemzz;

    public void saleITMcrap(ArrayList itemzz, myInterface listenerz) {
        this.listenerz = listenerz;
        this.itemzz = itemzz;

        String code = (String) itemzz.get(0);
        String name = (String) itemzz.get(1);
        String path = (String) itemzz.get(7);

        Tooltip tooltip1 = new Tooltip(name);
        File logox = new File("images/" + path);
        Image logo_image = new Image(logox.toURI().toString());
        itmImage.setImage(logo_image);

        itmName.setText(name);
        itmName.setTooltip(tooltip1);
        itmCode.setText(code);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
