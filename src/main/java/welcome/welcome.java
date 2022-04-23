package welcome;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.loginModel;
import models.usersModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mohware
 */
public class welcome implements Initializable, welcomeView {

    @FXML
    private AnchorPane login_ac;

    @FXML
    private JFXTextField email_Login;

    @FXML
    private Label Loginemail_LBL;

    @FXML
    private JFXPasswordField password_Login;

    @FXML
    private Label Login_passwordLBL;

    @FXML
    private Label forgotLbl;

    @FXML
    private Button Login_BTN;

    @FXML
    private ImageView login_back;

    @FXML
    private AnchorPane changePsw_ac;

    @FXML
    private Label changeEmail;

    @FXML
    private JFXPasswordField changePsw;

    @FXML
    private Label changePswLBL;

    @FXML
    private JFXPasswordField changeConfirm;

    @FXML
    private Label changeConfirmLBL;

    @FXML
    private Button changeBTN;

    @FXML
    private ImageView change_back;

    @FXML
    private AnchorPane forgot_ac;

    @FXML
    private JFXTextField resetEmail;

    @FXML
    private Label resetEmailLBL;

    @FXML
    private Button resetEmailBTN;

    @FXML
    private ImageView forgot_back;

    @FXML
    private AnchorPane failed_ac;

    @FXML
    private Label failed_LBL;

    @FXML
    private Button failed_okayBTN;

    @FXML
    private AnchorPane success_ac;

    @FXML
    private Label success_LBL;

    @FXML
    private Button success_okayBTN;

    @FXML
    private AnchorPane confirm_ac;

    @FXML
    private Label confirm_LBL;

    @FXML
    private Button okay_confirm_btn;

    @FXML
    private Button cancel_confirm_btn;

    public static String USER = "Chege Maina";
    public static String EMAIL = "Chege";
    public static String COUNTER = "Chege Maina";
    public static String USERNAME = "Chege Maina";

    String designation = "";
    String pass = "";
    String pangwa = "";

    int counter_check = 8;
    int confirm;
    ArrayList<ArrayList<String>> users_list;
    welcomePresenter presenter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        presenter = new welcomePresenter(this);
        users_list = new ArrayList<>();
        hideItems();
        initialView();
        navigation();
        action_Buttons();
        presenter.getUsers("login", "none");
    }

    private void initialView() {
        login_ac.setVisible(true);
    }

    private void hideItems() {
        //Main Windows AnchorPanes
        failed_ac.setVisible(false);
        success_ac.setVisible(false);
        confirm_ac.setVisible(false);
        login_ac.setVisible(false);
        forgot_ac.setVisible(false);
        changePsw_ac.setVisible(false);
    }

    private void clearAll() {
        Loginemail_LBL.setText("");
        Login_passwordLBL.setText("");
        email_Login.setText("");
        password_Login.setText("");
        resetEmail.setText("");
        resetEmailLBL.setText("");

    }

    private void navigation() {

        login_back.setOnMouseClicked(mouseEvent -> {
            System.exit(0);

        });
        forgot_back.setOnMouseClicked(mouseEvent -> {
            hideItems();
            login_ac.setVisible(true);

        });
        change_back.setOnMouseClicked(mouseEvent -> {
            hideItems();
            login_ac.setVisible(true);
            clearAll();
        });
        forgotLbl.setOnMouseClicked(mouseEvent -> {
            hideItems();
            forgot_ac.setVisible(true);
            clearAll();

        });
    }

    private void action_Buttons() {
        resetEmailBTN.setOnMouseClicked(mouseEvent -> {
            if (resetEmail.getText().equals("")) {
                resetEmailLBL.setText("Email Cannot be Left Empty!!");
            } else {
                int check_run = 0;
                ArrayList<String> user_details = new ArrayList<>();
                resetEmailLBL.setText("");
                int totsize = users_list.size();
                for (int i = 0; i < totsize; i++) {
                    String emailchk = users_list.get(i).get(0);
                    if (emailchk.equals(resetEmail.getText())) {
                        check_run = 8;
                    }
                }
                if (check_run == 8) {
                    //Get Password
                    int len = 8;
                    String chars = "013456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
                    Random rnd = new Random();
                    StringBuilder sb = new StringBuilder(len);
                    for (int i = 0; i < len; i++) {
                        sb.append(chars.charAt(rnd.nextInt(chars.length())));
                    }
                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("email", resetEmail.getText());
                    jsonObject.put("pass", sb.toString());
                    jsonArray.put(jsonObject);
                    presenter.updateUser("reset", String.valueOf(jsonArray));
                } else {
                    call_info_dialog(0, "User Does Not Exists!!");
                }
            }
        });

        success_okayBTN.setOnMouseClicked(mouseEvent -> {
            success_ac.setVisible(false);
        });
        failed_okayBTN.setOnMouseClicked(mouseEvent -> {
            failed_ac.setVisible(false);
        });
        okay_confirm_btn.setOnMouseClicked(mouseEvent -> {
            if (designation.equals("ADMIN")) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("/fxml/admin/admin.fxml"));
                    Stage stage = new Stage();
                    //stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(new Scene(root, 960, 600));
                    stage.setMaximized(true);
                    stage.show();
                    ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (designation.equals("SALE MANAGER")) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("/fxml/sale/sale.fxml"));
                    Stage stage = new Stage();
                    //stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(new Scene(root, 960, 600));
                    stage.setMaximized(true);
                    stage.show();
                    ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        cancel_confirm_btn.setOnMouseClicked(mouseEvent -> {
            confirm_ac.setVisible(false);
        });
        changeBTN.setOnMouseClicked(mouseEvent -> {
            changePswLBL.setText("");
            changeConfirmLBL.setText("");
            if (changePsw.getText().equals("")) {
                changePswLBL.setText("New Password Cannot be Left Empty!!");
                changePsw.requestFocus();
            } else if (changeConfirm.getText().equals("")) {
                changeConfirmLBL.setText("Confirm Password Cannot be Left Empty!!");
                changeConfirm.requestFocus();
            } else if (changePsw.getText().length() < 8) {
                changePswLBL.setText("Password Should have 8 Characters or More!!");
                changePsw.requestFocus();
            } else if (!changePsw.getText().equals(changeConfirm.getText())) {
                changeConfirmLBL.setText("Password Entered Do Not Match!!");
                changeConfirm.requestFocus();
            } else if (changePsw.getText().equals(pass)) {
                changePswLBL.setText("Password Entered Same as Old Password!!");
                changePsw.requestFocus();
            } else {
                pangwa = "change";
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("email", changeEmail.getText());
                jsonObject.put("pass", changeConfirm.getText());
                jsonArray.put(jsonObject);
                presenter.updateUser("change", String.valueOf(jsonArray));
            }
        });
        Login_BTN.setOnMouseClicked(mouseEvent -> {
            if (email_Login.getText().equals("")) {
                Loginemail_LBL.setText("Email Cannot be Left Empty!!");
                Login_passwordLBL.setText("");
            } else if (password_Login.getText().equals("")) {
                Login_passwordLBL.setText("Password Cannot be Left Empty!!");
                Loginemail_LBL.setText("");
            } else {
                int check_run = 0;
                ArrayList<String> user_details = new ArrayList<>();
                Loginemail_LBL.setText("");
                Login_passwordLBL.setText("");
                int totsize = users_list.size();
                for (int i = 0; i < totsize; i++) {
                    String emailchk = users_list.get(i).get(0);
                    if (emailchk.equals(email_Login.getText())) {
                        check_run = 8;
                        user_details.add(users_list.get(i).get(0));
                        user_details.add(users_list.get(i).get(1));
                        user_details.add(users_list.get(i).get(2));
                        user_details.add(users_list.get(i).get(3));
                        user_details.add(users_list.get(i).get(4));
                        user_details.add(users_list.get(i).get(5));
                        user_details.add(users_list.get(i).get(6));
                        user_details.add(users_list.get(i).get(7));
                    }
                }
                if (check_run == 8) {
                    String passchk = user_details.get(1);
                    if (passchk.equals(password_Login.getText())) {
                        designation = user_details.get(2);
                        USER = user_details.get(3) + " " + user_details.get(4);
                        EMAIL = user_details.get(0);
                        USERNAME = user_details.get(7);
                        String status = user_details.get(6);
                        if (status.equals("ACTIVE")) {
                            String pass_status = user_details.get(5);
                            pass = user_details.get(1);
                            if (pass_status.equals("NEW")) {
                                changeEmail.setText(user_details.get(0));
                                hideItems();
                                changePsw_ac.setVisible(true);
                                clearAll();
                            } else {
                                if (designation.equals("ADMIN")) {
                                    call_confirm_dialog("Are You Sure You want to Log In as Admin??");
                                } else if (designation.equals("SALE MANAGER")) {
                                    call_confirm_dialog("Are You Sure You want to Log In as Sale Manager??");
                                } else if (designation.equals("COUNTER MANAGER")) {
                                    call_confirm_dialog("Are You Sure You want to Log In as Counter Manager??");
                                }
                            }

                        } else {
                            call_info_dialog(0, "Wrong Designation Login!!");
                        }

                    } else {
                        call_info_dialog(0, "Wrong Password Entered!!");
                    }

                } else {
                    call_info_dialog(0, "User Does Not Exists!!");
                }
            }

        });
    }

    private void call_info_dialog(int check, String text) {
        if (check == 8) {
            success_LBL.setText(text);
            success_ac.setVisible(true);
        } else {
            failed_LBL.setText(text);
            failed_ac.setVisible(true);
        }
    }

    private void call_confirm_dialog(String Text) {
        confirm_LBL.setText(Text);
        confirm_ac.setVisible(true);
    }

    @Override
    public void onErrorLoading(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                call_info_dialog(0, message);
            }
        });
    }

    @Override
    public void GetUsers(List<usersModel> user) {
        int x = user.size();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < x; i++) {
                    ArrayList<String> listelm = new ArrayList<>();

                    listelm.add(user.get(i).getEmail());
                    listelm.add(user.get(i).getPass());
                    listelm.add(user.get(i).getDesignation());
                    listelm.add(user.get(i).getF_name());
                    listelm.add(user.get(i).getL_name());
                    listelm.add(user.get(i).getSecurity());
                    listelm.add(user.get(i).getStatus());
                    listelm.add(user.get(i).getU_name());
                    users_list.add(listelm);

                }

            }
        });
    }

    @Override
    public void onAddError(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                call_info_dialog(0, message);
            }
        });
    }

    @Override
    public void onUpdateSuccess(String message) {
        Platform.runLater(() -> {
            presenter.getUsers("login", "none");
            if (pangwa.equals("change")) {
                call_info_dialog(8, message);
                if (designation.equals("ADMIN")) {
                    call_confirm_dialog("Are You Sure You want to Log In as Admin??");
                } else if (designation.equals("SALE MANAGER")) {
                    call_confirm_dialog("Are You Sure You want to Log In as Sale Manager??");
                } else if (designation.equals("COUNTER MANAGER")) {
                    call_confirm_dialog("Are You Sure You want to Log In as Counter Manager??");
                }
            } else {
                hideItems();
                login_ac.setVisible(true);
                clearAll();
                call_info_dialog(8, message);
            }
        });
    }
}
