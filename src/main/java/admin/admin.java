package admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.BarsaleModel;
import models.customersModel;
import models.percentModel;
import models.saleModel;
import models.storeModel;
import models.suppliersModel;
import models.usersModel;
import org.json.JSONArray;
import org.json.JSONObject;
import welcome.welcome;

public class admin implements Initializable, adminView {

    @FXML
    private StackPane rootpanes;

    @FXML
    private AnchorPane main_ac;

    @FXML
    private Label userLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private ImageView logoutImage;

    @FXML
    private Label logoutLabel;

    @FXML
    private JFXButton menu_dash_btn;

    @FXML
    private JFXButton menu_staff_btn;

    @FXML
    private JFXButton menu_exp11;

    @FXML
    private JFXButton menu_customer;

    @FXML
    private JFXButton menu_exp;

    @FXML
    private JFXButton menu_store_btn;

    @FXML
    private JFXButton menu_sales_btn;

    @FXML
    private AnchorPane dash_ac, brsales_item_ac1;

    @FXML
    private AnchorPane users_ac;

    @FXML
    private JFXButton new_usermenu;

    @FXML
    private JFXButton list_usermenu;

    @FXML
    private JFXButton sec_detailsmenu;

    @FXML
    private AnchorPane addUser_ac;

    @FXML
    private JFXTextField add_email;

    @FXML
    private Label add_emailLBL;

    @FXML
    private JFXComboBox<String> add_designation;

    @FXML
    private Label add_designationLBL;

    @FXML
    private JFXTextField add_Fname;

    @FXML
    private Label add_FnameLBL;

    @FXML
    private JFXTextField add_Lname;

    @FXML
    private Label add_LnameLBL;

    @FXML
    private JFXTextField add_username;

    @FXML
    private Label add_usernameLBL;

    @FXML
    private Button add_UserSaveBTN;

    @FXML
    private Button add_UserCancelBTN;

    @FXML
    private AnchorPane editUser_ac;

    @FXML
    private JFXTextField edit_email;

    @FXML
    private Label edit_emailLBL;

    @FXML
    private JFXComboBox<String> editDesiganation;

    @FXML
    private Label editDesiganationLBL;

    @FXML
    private JFXTextField editFname, customer_limitTXT1;

    @FXML
    private Label editFnameLBL;

    @FXML
    private JFXTextField editLname;

    @FXML
    private Label editLnameLBL;

    @FXML
    private JFXTextField editUname;

    @FXML
    private Label editUnameLBL;

    @FXML
    private Button edit_userSaveBTN;

    @FXML
    private Button activateUser;

    @FXML
    private Button DeactivateUser;

    @FXML
    private Label email_LBL;

    @FXML
    private Label status_LBL;

    @FXML
    private AnchorPane listUser_ac;

    @FXML
    private TextField search_users;

    @FXML
    private JFXComboBox<String> filterUsers_COMBO;

    @FXML
    private Label filterUsers_COMBOLBL;

    @FXML
    private Button filter_users;

    @FXML
    private Button rsest_usersList;

    @FXML
    private VBox users_listsVBox;

    @FXML
    private AnchorPane userSecurity_ac;

    @FXML
    private VBox passSecurityVbox;

    @FXML
    private VBox pinSecurityVbox;

    @FXML
    private AnchorPane suppliers_ac;

    @FXML
    private MenuItem New_supplier_subMenu;

    @FXML
    private MenuItem supplier_mgnt_subMenu;

    @FXML
    private MenuItem setperc_submenu;

    @FXML
    private MenuItem listperc_submenu;

    @FXML
    private AnchorPane editSupplier_ac;

    @FXML
    private Label supplierCodeLabel;

    @FXML
    private Label supplierStatusLabel;

    @FXML
    private JFXTextField supplier_nameTXT1;

    @FXML
    private Label supplier_nameLBL1;

    @FXML
    private JFXTextField supplier_PINTXT1;

    @FXML
    private Label supplier_PINLBL1;

    @FXML
    private JFXTextField supplier_phoneTXT1, supplier_phoneTXT;

    @FXML
    private Label supplier_phoneLBL1;

    @FXML
    private JFXTextField supplier_addressTXT1;

    @FXML
    private Label supplier_addressLBL1;

    @FXML
    private JFXTextField supplier_emailTXT1, supplier_openingbalTXT1;

    @FXML
    private Label supplier_emailLBL1, supplier_openingbalLBL1;

    @FXML
    private Button supplier_saveBTN1;

    @FXML
    private Button supplier_cancelBTN1;

    @FXML
    private AnchorPane listSupplier_ac;

    @FXML
    private TextField supplier_SearchListTXT;

    @FXML
    private Button supplierListResetBTN;

    @FXML
    private Button supplierListPrint;

    @FXML
    private VBox supplierListVBOX;

    @FXML
    private AnchorPane addPercentage_ac;

    @FXML
    private JFXComboBox<String> percSupplierCombo;

    @FXML
    private Label percSupplierComboLBL;

    @FXML
    private JFXComboBox<String> percCustCatCombo;

    @FXML
    private Label percCustCatComboLBL;

    @FXML
    private JFXComboBox<String> percCustTypeCombo;

    @FXML
    private Label percCustTypeComboLBL;

    @FXML
    private JFXTextField percPriceTXT;

    @FXML
    private Label percPriceLBL;

    @FXML
    private Button percSaveBTN;

    @FXML
    private Button percCancelBTN;

    @FXML
    private AnchorPane listPercentage_ac;

    @FXML
    private TextField supplier_SearchListTXT1;

    @FXML
    private Button supplierListResetBTN1;

    @FXML
    private Button supplierListPrint1;

    @FXML
    private VBox supplierListVBOX1;

    @FXML
    private AnchorPane addSupplier_ac;

    @FXML
    private JFXTextField supplier_nameTXT;

    @FXML
    private Label supplier_nameLBL;

    @FXML
    private JFXTextField supplier_PINTXT;

    @FXML
    private Label supplier_PINLBL;

    @FXML
    private Label supplier_phoneLBL;

    @FXML
    private JFXTextField supplier_addressTXT;

    @FXML
    private Label supplier_addressLBL;

    @FXML
    private JFXTextField supplier_emailTXT;

    @FXML
    private Label supplier_emailLBL;

    @FXML
    private JFXTextField supplier_openingbalTXT;

    @FXML
    private Label supplier_openingbalLBL;

    @FXML
    private Button supplier_saveBTN;

    @FXML
    private Button supplier_cancelBTN;

    @FXML
    private AnchorPane customers_ac;

    @FXML
    private MenuItem New_customer_subMenu;

    @FXML
    private MenuItem customer_mgnt_subMenu;

    @FXML
    private AnchorPane addCustomer_ac;

    @FXML
    private JFXTextField customer_nameTXT;

    @FXML
    private Label customer_nameLBL;

    @FXML
    private JFXTextField customer_PINTXT;

    @FXML
    private Label customer_PINLBL;

    @FXML
    private JFXTextField customer_phoneTXT;

    @FXML
    private Label customer_phoneLBL;

    @FXML
    private JFXTextField customer_addressTXT;

    @FXML
    private Label customer_addressLBL;

    @FXML
    private JFXTextField customer_emailTXT;

    @FXML
    private Label customer_emailLBL;

    @FXML
    private JFXTextField customer_openingbalTXT;

    @FXML
    private Label customer_openingbalLBL;

    @FXML
    private JFXTextField customer_termsTXT, customer_limitTXT;

    @FXML
    private Label customer_termsLBL, customer_limitLBL;

    @FXML
    private JFXComboBox<String> CustTypeCombo;

    @FXML
    private Label CustTypeComboLBL;

    @FXML
    private JFXComboBox<String> CustCatCombo;

    @FXML
    private Label CustCatComboLBL;

    @FXML
    private Button customer_saveBTN;

    @FXML
    private Button customer_cancelBTN;

    @FXML
    private AnchorPane editCustomer_ac;

    @FXML
    private Label customerCodeLabel;

    @FXML
    private Label customerStatusLabel;

    @FXML
    private JFXTextField customer_nameTXT1;

    @FXML
    private Label customer_nameLBL1;

    @FXML
    private JFXTextField customer_PINTXT1;

    @FXML
    private Label customer_PINLBL1;

    @FXML
    private JFXTextField customer_phoneTXT1;

    @FXML
    private Label customer_phoneLBL1;

    @FXML
    private JFXTextField customer_addressTXT1;

    @FXML
    private Label customer_addressLBL1;

    @FXML
    private JFXTextField customer_emailTXT1;

    @FXML
    private Label customer_emailLBL1;

    @FXML
    private JFXTextField customer_openingbalTXT1;

    @FXML
    private Label customer_openingbalLBL1;

    @FXML
    private JFXTextField customer_termsTXT1;

    @FXML
    private Label customer_termsLBL1;

    @FXML
    private JFXComboBox<String> CustTypeCombo1;

    @FXML
    private Label CustTypeComboLBL1, itemedtCode, itemedtStatus;

    @FXML
    private JFXComboBox<String> CustCatCombo1;

    @FXML
    private Label CustCatComboLBL1;

    @FXML
    private Button supplier_saveBTN11;

    @FXML
    private Button supplier_cancelBTN11;

    @FXML
    private AnchorPane listCustomer_ac;

    @FXML
    private TextField customers_SearchListTXT;

    @FXML
    private Button customerListResetBTN;

    @FXML
    private Button customerListPrint;

    @FXML
    private VBox customerListVBOX;

    @FXML
    private AnchorPane brsales_ac;

    @FXML
    private MenuItem bradd_sale_itm_submenu;

    @FXML
    private MenuItem brsale_itm_mngt_submenu;

    @FXML
    private AnchorPane brmngt_sale_itm_ac;

    @FXML
    private TextField brsearch_Saleitems;

    @FXML
    private JFXComboBox<String> brfilter_SaleitemsCOMBO;

    @FXML
    private Label brsaleItemFillterComboLBL;

    @FXML
    private Button brfilter_saleListBTN;

    @FXML
    private Button brreset_SaleLISTBTN;

    @FXML
    private VBox brsale_listVbox;

    @FXML
    private AnchorPane brsales_item_ac;

    @FXML
    private JFXTextField brsale_itmName_new, brsale_itmName_new12, brsale_itmName_new11, brsale_sellingprice_TXT11;

    @FXML
    private Label brsale_itmName_new_LBL;

    @FXML
    private JFXTextField brsale_itmName_new1;

    @FXML
    private Label brsale_itmName_new_LBL2;

    @FXML
    private JFXComboBox<String> brSalecategoryCombo;

    @FXML
    private Label brSalecategoryCombo_LBL;

    @FXML
    private Button bropen_add_categorysale;

    @FXML
    private JFXComboBox<String> brStoreDispUnitCombo;

    @FXML
    private Label brStoreDispUnitCombo_LBL;

    @FXML
    private Button bropen_add_unit;

    @FXML
    private JFXComboBox<String> originCombo, salerepCombo;

    @FXML
    private Label originComboLBL, salerepComboLBL;

    @FXML
    private Button bropen_add_unit1, bropen_add_rep;

    @FXML
    private JFXComboBox<String> itemSupplierCombo;

    @FXML
    private Label itemSupplierComboLBL;

    @FXML
    private JFXTextField brsale_sellingprice_TXT;

    @FXML
    private Label brsale_sellingprice_LBL;

    @FXML
    private Button brbtnImgSelectrest;

    @FXML
    private Label brimage_labelrest;

    @FXML
    private Button brbtnImageViewrest;

    @FXML
    private Button bradd_sale_saveBTN;

    @FXML
    private Button bradd_sale_cancelBTN;

    @FXML
    private AnchorPane infodialog_ac1;

    @FXML
    private Label infodialog_heading1;

    @FXML
    private Label infodialog_text1;

    @FXML
    private Button infodialog_okay_btn1;

    @FXML
    private ImageView infodialog_image1;

    @FXML
    private AnchorPane confirmdialog_ac;

    @FXML
    private Button okay_confirm_btn;

    @FXML
    private Button cancel_infodialog_btn;

    @FXML
    private AnchorPane imageshow_ac;

    @FXML
    private ImageView preview_image;

    @FXML
    private ImageView close_preview;

    @FXML
    private AnchorPane infodialog_ac;

    @FXML
    private Label infodialog_heading;

    @FXML
    private Label infodialog_text;

    @FXML
    private Button infodialog_okay_btn;

    @FXML
    private ImageView infodialog_image;

    @FXML
    private AnchorPane addCategory_ac;

    @FXML
    private ImageView close_add_cat;

    @FXML
    private Label infodialog_heading21;

    @FXML
    private JFXTextField add_store_cat_txt;

    @FXML
    private Label store_cat_label;

    @FXML
    private Button save_cat_btn;

    @FXML
    private AnchorPane addUnit_ac;

    @FXML
    private ImageView close_add_cat1;

    @FXML
    private Label infodialog_heading211;

    @FXML
    private JFXTextField add_store_cat_txt1;

    @FXML
    private Label store_cat_label1;

    @FXML
    private Button save_cat_btn1;

    @FXML
    private AnchorPane addOrigin_ac, addRep_ac;

    @FXML
    private ImageView close_add_origin, close_add_rep;

    @FXML
    private Label infodialog_heading2111;

    @FXML
    private JFXTextField add_store_cat_txt11, add_store_rep_txt;

    @FXML
    private Label store_cat_label11, saleRepLBL;

    @FXML
    private Button save_cat_btn11, save_btn_rep;
    //Declaration of Variables
    ArrayList<String> category_List, unit_List, category_Listsale, brcategory_Listsale, brunit_List, supplier_list, originList, repList;
    ArrayList itmName;
    ArrayList itmName2;
    ArrayList<ArrayList<String>> store_itemLst;
    ArrayList<ArrayList<String>> store_itemLst2;
    ArrayList<ArrayList<String>> store_itemLst3;
    ArrayList<ArrayList<String>> store_ingredient1;
    ArrayList<ArrayList<String>> store_ingredient2;
    ArrayList<ArrayList<String>> sale_ingredient1;
    ArrayList<ArrayList<String>> sale_ingredient2;
    ArrayList<String> counters_list;
    private myInterface listenerz;
    private String encoded_image;
    adminPresenter presenter;
    String add_checker = "";
    String submenu_checker;
    String category = "";
    String type = "";
    String TYPE = "";
    String jina = "";
    int type_run;
    String itemnameSTRING;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        presenter = new adminPresenter(this);
        store_itemLst = new ArrayList<>();
        store_ingredient1 = new ArrayList<>();
        sale_ingredient1 = new ArrayList<>();
        unit_List = new ArrayList<>();
        counters_list = new ArrayList<>();
        brunit_List = new ArrayList<>();
        originList = new ArrayList<>();
        repList = new ArrayList<>();
        category_List = new ArrayList<>();
        category_Listsale = new ArrayList();
        supplier_list = new ArrayList();
        brcategory_Listsale = new ArrayList();
        addDate();
        addTime();
        userLabel.setText(welcome.USER);
        hideItems();
        initialView();
        imageButton();
        dbase_loading();
        add_dialog_box();
        mainMenu_Buttons();
        subMenu_Buttons();
        info_dialog_Buttons();
        mainAction_buttons();
        init_close_anchors();
        textField_events();
        comboboxValue_events();

        listenerz = new myInterface() {

            @Override
            public void userITMListener(ArrayList list) {
                Platform.runLater(() -> {
                    hideItems();
                    main_ac.setVisible(true);
                    users_ac.setVisible(true);
                    editUser_ac.setVisible(true);
                    String code = list.get(0).toString();
                    String status = list.get(8).toString();
                    email_LBL.setText(code);
                    status_LBL.setText(status);
                    submenu_checker = "edit";
                    presenter.getUsers("edit", code);
                });
            }

            @Override
            public void supplierITMListener(ArrayList list) {
                Platform.runLater(() -> {
                    hideItems();
                    main_ac.setVisible(true);
                    suppliers_ac.setVisible(true);
                    editSupplier_ac.setVisible(true);
                    String code = list.get(0).toString();
                    String status = list.get(6).toString();
                    supplierCodeLabel.setText(code);
                    supplierStatusLabel.setText(status);
                    submenu_checker = "EditSupplier";
                    presenter.getSuppliers("edit", code);
                });
            }

            @Override
            public void customerITMListener(ArrayList list) {
                Platform.runLater(() -> {
                    hideItems();
                    main_ac.setVisible(true);
                    customers_ac.setVisible(true);
                    editCustomer_ac.setVisible(true);
                    String code = list.get(0).toString();
                    String status = list.get(11).toString();
                    customerCodeLabel.setText(code);
                    customerStatusLabel.setText(status);
                    submenu_checker = "EditCustomer";
                    presenter.getCustomers("edit", code);

                });
            }

            @Override
            public void brsaleITMListListener(ArrayList itemzz) {
                Platform.runLater(() -> {
                    hideItems();
                    main_ac.setVisible(true);
                    brsales_ac.setVisible(true);
                    brsales_item_ac1.setVisible(true);
                    String code = itemzz.get(0).toString();
                    String status = itemzz.get(8).toString();
                    itemedtCode.setText(code);
                    itemedtStatus.setText(status);
                    submenu_checker = "EditSaleItem";
                    presenter.brgetStoreItemList("edit", code);

                });
            }

        };
    }

    private void combobox_events(String letCheck) {
        if (letCheck.equals("gen")) {

            //User Designation
            add_designation.getItems().clear();
            editDesiganation.getItems().clear();
            filterUsers_COMBO.getItems().clear();
            ArrayList<String> listelm2 = new ArrayList<>();
            listelm2.add("ADMIN");
            listelm2.add("SALE MANAGER");
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    listelm2);
            add_designation.setItems(categoryList);
            editDesiganation.setItems(categoryList);
            filterUsers_COMBO.setItems(categoryList);

            brStoreDispUnitCombo.getItems().clear();
            categoryList = FXCollections.observableArrayList(
                    brunit_List);
            brStoreDispUnitCombo.setItems(categoryList);

            brfilter_SaleitemsCOMBO.getItems().clear();
            brSalecategoryCombo.getItems().clear();
            categoryList = FXCollections.observableArrayList(
                    brcategory_Listsale);
            brSalecategoryCombo.setItems(categoryList);
            brfilter_SaleitemsCOMBO.setItems(categoryList);
            originCombo.getItems().clear();
            categoryList = FXCollections.observableArrayList(
                    originList);
            originCombo.setItems(categoryList);
            salerepCombo.getItems().clear();
            categoryList = FXCollections.observableArrayList(
                    repList);
            salerepCombo.setItems(categoryList);
            percSupplierCombo.getItems().clear();
            itemSupplierCombo.getItems().clear();
            categoryList = FXCollections.observableArrayList(
                    supplier_list);
            percSupplierCombo.setItems(categoryList);
            itemSupplierCombo.setItems(categoryList);
            percCustCatCombo.getItems().clear();
            CustCatCombo.getItems().clear();
            CustCatCombo1.getItems().clear();
            listelm2 = new ArrayList<>();
            listelm2.add("BAR");
            listelm2.add("STOCKIST");
            listelm2.add("RETAIL");
            categoryList = FXCollections.observableArrayList(
                    listelm2);
            percCustCatCombo.setItems(categoryList);
            CustCatCombo.setItems(categoryList);
            CustCatCombo1.setItems(categoryList);
            percCustTypeCombo.getItems().clear();
            CustTypeCombo.getItems().clear();
            CustTypeCombo1.getItems().clear();
            listelm2 = new ArrayList<>();
            listelm2.add("TYPE 1");
            listelm2.add("TYPE 2");
            categoryList = FXCollections.observableArrayList(
                    listelm2);
            CustTypeCombo.setItems(categoryList);
            CustTypeCombo1.setItems(categoryList);
            percCustTypeCombo.setItems(categoryList);
        } else if (letCheck.equals("brsale_cat")) {
            brfilter_SaleitemsCOMBO.getItems().clear();
            brSalecategoryCombo.getItems().clear();
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    brcategory_Listsale);
            brSalecategoryCombo.setItems(categoryList);
            brfilter_SaleitemsCOMBO.setItems(categoryList);
        } else if (letCheck.equals("bar_origin")) {
            originCombo.getItems().clear();
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    originList);
            originCombo.setItems(categoryList);
        } else if (letCheck.equals("bar_rep")) {
            salerepCombo.getItems().clear();
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    repList);
            salerepCombo.setItems(categoryList);
        } else if (letCheck.equals("bar_unit")) {
            brStoreDispUnitCombo.getItems().clear();
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    brunit_List);
            brStoreDispUnitCombo.setItems(categoryList);
        } else if (letCheck.equals("percent")) {
            percSupplierCombo.getItems().clear();
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    supplier_list);
            percSupplierCombo.setItems(categoryList);
            percCustCatCombo.getItems().clear();
            ArrayList<String> listelm2 = new ArrayList<>();
            listelm2.add("BAR");
            listelm2.add("STOCKIST");
            listelm2.add("RETAIL");
            categoryList = FXCollections.observableArrayList(
                    listelm2);
            percCustCatCombo.setItems(categoryList);
            percCustTypeCombo.getItems().clear();
            listelm2 = new ArrayList<>();
            listelm2.add("TYPE 1");
            listelm2.add("TYPE 2");
            categoryList = FXCollections.observableArrayList(
                    listelm2);
            percCustTypeCombo.setItems(categoryList);
        } else if (letCheck.equals("braddsale")) {
            itemSupplierCombo.getItems().clear();
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    supplier_list);
            itemSupplierCombo.setItems(categoryList);

        } else if (letCheck.equals("addCustomer")) {
            CustCatCombo.getItems().clear();
            ArrayList<String> listelm2 = new ArrayList<>();
            listelm2.add("BAR");
            listelm2.add("STOCKIST");
            listelm2.add("RETAIL");
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    listelm2);
            CustCatCombo.setItems(categoryList);
            CustTypeCombo.getItems().clear();
            listelm2 = new ArrayList<>();
            listelm2.add("TYPE 1");
            listelm2.add("TYPE 2");
            categoryList = FXCollections.observableArrayList(
                    listelm2);
            CustTypeCombo.setItems(categoryList);
        }

    }

    private void comboboxValue_events() {

    }

    private void listSaleItems2() {
        int totsize = store_itemLst.size();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/admin/brsale_item_list.fxml"));

                HBox hBox = fxmlloader.load();
                brsaleITMList itemscontroller = fxmlloader.getController();
                itemscontroller.saleITMSList(store_itemLst.get(i), listenerz);
                brsale_listVbox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listUsers() {
        int totsize = store_itemLst.size();
        users_listsVBox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/admin/user_item_list.fxml"));

                HBox hBox = fxmlloader.load();
                UserITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i), listenerz);
                users_listsVBox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listSuppliers() {
        int totsize = store_itemLst.size();
        supplierListVBOX.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/admin/supplierlst_ITM.fxml"));

                HBox hBox = fxmlloader.load();
                SupplierITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i), listenerz);
                supplierListVBOX.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listCustomers() {
        int totsize = store_itemLst.size();
        customerListVBOX.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/admin/customerlst_ITM.fxml"));

                HBox hBox = fxmlloader.load();
                CustomerITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i), listenerz);
                customerListVBOX.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listPercent() {
        int totsize = store_itemLst.size();
        supplierListVBOX1.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/admin/percentlst_ITM.fxml"));

                HBox hBox = fxmlloader.load();
                percentITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i));
                supplierListVBOX1.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listUsersPass() {
        int totsize = store_itemLst.size();
        passSecurityVbox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/admin/sec_list.fxml"));

                HBox hBox = fxmlloader.load();
                SecUserITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i), "pass");
                passSecurityVbox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        presenter.getUsers("pin", "none");
        submenu_checker = "sec_users2";
    }

    private void listUsersPin() {
        int totsize = store_itemLst.size();
        pinSecurityVbox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/admin/sec_list.fxml"));

                HBox hBox = fxmlloader.load();
                SecUserITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i), "pin");
                pinSecurityVbox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearMe() {
        add_email.setText("");
        add_emailLBL.setText("");
        add_designationLBL.setText("");
        add_Fname.setText("");
        add_FnameLBL.setText("");
        add_username.setText("");
        add_usernameLBL.setText("");
        add_Lname.setText("");
        add_LnameLBL.setText("");
        edit_emailLBL.setText("");
        editDesiganationLBL.setText("");
        brimage_labelrest.setText("Image Local Path");
        brsale_itmName_new.setText("");
        brsale_itmName_new_LBL.setText("");
        brsale_itmName_new1.setText("");
        brsale_itmName_new_LBL2.setText("");
        brSalecategoryCombo_LBL.setText("");
        originComboLBL.setText("");
        salerepComboLBL.setText("");
        itemSupplierComboLBL.setText("");
        brStoreDispUnitCombo_LBL.setText("");
        supplier_nameTXT.setText("");
        supplier_nameLBL.setText("");
        customer_nameTXT.setText("");
        customer_nameLBL.setText("");
        supplier_PINTXT.setText("");
        supplier_PINLBL.setText("");
        customer_PINTXT.setText("");
        customer_PINLBL.setText("");
        supplier_phoneTXT.setText("");
        supplier_phoneLBL.setText("");
        customer_phoneTXT.setText("");
        customer_phoneLBL.setText("");
        supplier_openingbalTXT.setText("");
        supplier_openingbalLBL.setText("");
        customer_openingbalTXT.setText("");
        customer_openingbalLBL.setText("");
        supplier_addressTXT.setText("");
        supplier_addressLBL.setText("");
        customer_addressTXT.setText("");
        customer_addressLBL.setText("");
        supplier_emailTXT.setText("");
        supplier_emailLBL.setText("");
        customer_emailTXT.setText("");
        customer_emailLBL.setText("");
        customer_termsTXT.setText("");
        customer_termsLBL.setText("");
        customer_limitTXT.setText("");
        customer_limitLBL.setText("");
        CustTypeComboLBL.setText("");
        CustCatComboLBL.setText("");
        brsale_sellingprice_TXT.setText("");
        brsale_sellingprice_LBL.setText("");
        editFnameLBL.setText("");
        editLnameLBL.setText("");
        editUnameLBL.setText("");
        percSupplierComboLBL.setText("");
        percCustCatComboLBL.setText("");
        percCustTypeComboLBL.setText("");
        percPriceTXT.setText("");
        percPriceLBL.setText("");

        encoded_image = "";

        editDesiganation.getItems().clear();
        add_designation.getItems().clear();

    }

    private void textField_events() {
        supplier_phoneTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,4})?")) {
                    supplier_phoneTXT.setText(oldValue);
                }
            }
        });
        customer_phoneTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,4})?")) {
                    customer_phoneTXT.setText(oldValue);
                }
            }
        });
        supplier_openingbalTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,4})?")) {
                    supplier_openingbalTXT.setText(oldValue);
                }
            }
        });
        customer_openingbalTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,4})?")) {
                    customer_openingbalTXT.setText(oldValue);
                }
            }
        });
        customer_termsTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
                    customer_termsTXT.setText(oldValue);
                }
            }
        });
        customer_limitTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}([\\.]\\d{0,3})?")) {
                    customer_limitTXT.setText(oldValue);
                }
            }
        });
        percPriceTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,2}([\\.]\\d{0,4})?")) {
                    percPriceTXT.setText(oldValue);
                }
            }
        });
        search_users.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                presenter.getUsers("search", newValue);
                submenu_checker = "list_users";

            }
        });
        supplier_SearchListTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                presenter.getSuppliers("search", newValue);
                submenu_checker = "listSupplier";

            }
        });
        customers_SearchListTXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                presenter.getCustomers("search", newValue);
                submenu_checker = "listCustomer";

            }
        });
        brsearch_Saleitems.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                presenter.brgetStoreItemList("search", newValue);
                submenu_checker = "brmanagesale";

            }
        });

        supplier_SearchListTXT1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                presenter.getPercent("search", newValue);
                submenu_checker = "listpercent";

            }
        });

        brsale_sellingprice_TXT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    brsale_sellingprice_TXT.setText(oldValue);
                }
            }
        });

    }

    private boolean textField_validation(String message, JFXTextField txtfield, Label label) {
        String val = txtfield.getText();
        if (val.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Email cannot be left empty!!", "WARNING", 0);

            label.setText(message);
            return false;
        } else {
            label.setText("");
            return true;
        }
    }

    private boolean textField_validation(String message, TextField txtfield, Label label) {
        String val = txtfield.getText().toString();
        if (val.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Email cannot be left empty!!", "WARNING", 0);

            label.setText(message);
            return false;
        } else {
            label.setText("");
            return true;
        }
    }

    private void hideItems() {
        //Main Windows AnchorPanes
        main_ac.setVisible(false);
        infodialog_ac.setVisible(false);
        infodialog_ac1.setVisible(false);
        confirmdialog_ac.setVisible(false);
        imageshow_ac.setVisible(false);
        addUnit_ac.setVisible(false);
        addOrigin_ac.setVisible(false);
        addRep_ac.setVisible(false);
        addCategory_ac.setVisible(false);

        //Main-Menu AnchorPanes
        dash_ac.setVisible(false);
        users_ac.setVisible(false);
        brsales_ac.setVisible(false);
        suppliers_ac.setVisible(false);
        customers_ac.setVisible(false);
        //users
        addUser_ac.setVisible(false);
        editUser_ac.setVisible(false);
        listUser_ac.setVisible(false);
        userSecurity_ac.setVisible(false);
        //Sale items
        brsales_item_ac.setVisible(false);
        brmngt_sale_itm_ac.setVisible(false);
        brsales_item_ac1.setVisible(false);
        //Suppliers
        addSupplier_ac.setVisible(false);
        listSupplier_ac.setVisible(false);
        editSupplier_ac.setVisible(false);
        addPercentage_ac.setVisible(false);
        listPercentage_ac.setVisible(false);
        //Customers
        addCustomer_ac.setVisible(false);
        listCustomer_ac.setVisible(false);
        editCustomer_ac.setVisible(false);

    }

    private void initialView() {
        main_ac.setVisible(true);
        dash_ac.setVisible(true);

    }

    private void addDate() {
        String txtdate = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date());
        dateLabel.setText(txtdate);
    }

    private void addTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String saa = sdf.format(new Date());
        timeLabel.setText(saa);
    }

    private void loadTXTlists(String checker, ArrayList<ArrayList<String>> array) {

    }

    private void mainMenu_Buttons() {

        // GENERAL MAIN MENU BUTTONS
        menu_dash_btn.setOnMouseClicked(mouseEvent -> {
            hideItems();
            clearMe();
            combobox_events("gen");
            main_ac.setVisible(true);
            dash_ac.setVisible(true);

        });
        menu_staff_btn.setOnMouseClicked(mouseEvent -> {
            hideItems();
            clearMe();
            combobox_events("gen");
            main_ac.setVisible(true);
            users_ac.setVisible(true);
            addUser_ac.setVisible(true);
        });

        // RESTAURANT MAIN MENU BUTTONS
        menu_store_btn.setOnMouseClicked(mouseEvent -> {
            hideItems();
            clearMe();
            combobox_events("gen");
            main_ac.setVisible(true);

        });

        menu_sales_btn.setOnMouseClicked(mouseEvent -> {
            submenu_checker = "addsale";
            hideItems();
            main_ac.setVisible(true);
        });
        menu_exp.setOnMouseClicked(mouseEvent -> {
            submenu_checker = "braddsale";
            clearMe();
            hideItems();
            combobox_events("gen");
            main_ac.setVisible(true);
            brsales_ac.setVisible(true);
            brsales_item_ac.setVisible(true);
        });
        menu_exp11.setOnMouseClicked(mouseEvent -> {
            submenu_checker = "addSupplier";
            clearMe();
            hideItems();
            combobox_events("gen");
            main_ac.setVisible(true);
            suppliers_ac.setVisible(true);
            addSupplier_ac.setVisible(true);
        });
        menu_customer.setOnMouseClicked(mouseEvent -> {
            submenu_checker = "addCustomer";
            clearMe();
            hideItems();
            combobox_events("gen");
            main_ac.setVisible(true);
            customers_ac.setVisible(true);
            addCustomer_ac.setVisible(true);
        });

    }

    private void subMenu_Buttons() {

        //GENERAL SUB-MENU BUTTONS
        new_usermenu.setOnMouseClicked(mouseEvent -> {
            hideItems();
            clearMe();
            combobox_events("gen");
            main_ac.setVisible(true);
            users_ac.setVisible(true);
            addUser_ac.setVisible(true);

        });
        list_usermenu.setOnMouseClicked(mouseEvent -> {
            submenu_checker = "list_users";
            presenter.getUsers("all", "none");
            search_users.setText("");
            hideItems();
            clearMe();
            combobox_events("gen");
            main_ac.setVisible(true);
            users_ac.setVisible(true);
            listUser_ac.setVisible(true);

        });
        sec_detailsmenu.setOnMouseClicked(mouseEvent -> {
            submenu_checker = "sec_users";
            presenter.getUsers("pass", "none");
            hideItems();
            clearMe();
            combobox_events("gen");
            main_ac.setVisible(true);
            users_ac.setVisible(true);
            userSecurity_ac.setVisible(true);

        });
        bradd_sale_itm_submenu.setOnAction(mouseEvent -> {
            submenu_checker = "braddsale";
            hideItems();
            presenter.getSuppliers("all", "none");
            combobox_events("gen");
            main_ac.setVisible(true);
            brsales_ac.setVisible(true);
            brsales_item_ac.setVisible(true);
        });
        brsale_itm_mngt_submenu.setOnAction(mouseEvent -> {
            submenu_checker = "brmanagesale";
            brsearch_Saleitems.setText("");
            presenter.brgetStoreItemList("all", "none");
            hideItems();
            combobox_events("gen");
            main_ac.setVisible(true);
            brsales_ac.setVisible(true);
            brmngt_sale_itm_ac.setVisible(true);
        });
        New_supplier_subMenu.setOnAction(mouseEvent -> {
            submenu_checker = "addSupplier";
            hideItems();
            combobox_events("gen");
            main_ac.setVisible(true);
            suppliers_ac.setVisible(true);
            addSupplier_ac.setVisible(true);
        });
        New_customer_subMenu.setOnAction(mouseEvent -> {
            submenu_checker = "addCustomer";
            hideItems();
            combobox_events("gen");
            main_ac.setVisible(true);
            customers_ac.setVisible(true);
            addCustomer_ac.setVisible(true);
        });
        supplier_mgnt_subMenu.setOnAction(mouseEvent -> {
            submenu_checker = "listSupplier";
            presenter.getSuppliers("all", "none");
            supplier_SearchListTXT.setText("");
            hideItems();
            combobox_events("gen");
            main_ac.setVisible(true);
            suppliers_ac.setVisible(true);
            listSupplier_ac.setVisible(true);
        });
        customer_mgnt_subMenu.setOnAction(mouseEvent -> {
            submenu_checker = "listCustomer";
            presenter.getCustomers("all", "none");
            customers_SearchListTXT.setText("");
            hideItems();
            combobox_events("gen");
            main_ac.setVisible(true);
            customers_ac.setVisible(true);
            listCustomer_ac.setVisible(true);
        });
        setperc_submenu.setOnAction(mouseEvent -> {
            submenu_checker = "percent";
            presenter.getSuppliers("all", "none");
            hideItems();
            main_ac.setVisible(true);
            suppliers_ac.setVisible(true);
            addPercentage_ac.setVisible(true);
        });
        listperc_submenu.setOnAction(mouseEvent -> {
            submenu_checker = "listpercent";
            presenter.getPercent("all", "none");
            hideItems();
            combobox_events("gen");
            supplier_SearchListTXT1.setText("");
            main_ac.setVisible(true);
            suppliers_ac.setVisible(true);
            listPercentage_ac.setVisible(true);
        });

    }

    private void info_dialog_Buttons() {
        infodialog_okay_btn.setOnMouseClicked(mouseEvent -> {
            infodialog_ac.setVisible(false);

        });
        infodialog_okay_btn1.setOnMouseClicked(mouseEvent -> {
            infodialog_ac1.setVisible(false);

        });
    }

    private void init_close_anchors() {
        close_preview.setOnMouseClicked(mouseEvent -> {
            imageshow_ac.setVisible(false);
        });
        close_add_cat.setOnMouseClicked(mouseEvent -> {
            addCategory_ac.setVisible(false);
        });
        close_add_cat1.setOnMouseClicked(mouseEvent -> {
            addUnit_ac.setVisible(false);
        });
        close_add_origin.setOnMouseClicked(mouseEvent -> {
            addOrigin_ac.setVisible(false);
        });
        close_add_rep.setOnMouseClicked(mouseEvent -> {
            addRep_ac.setVisible(false);
        });
        logoutImage.setOnMouseClicked(mouseEvent -> {
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/welcome/welcome.fxml"));
                Stage stage = new Stage();
                //stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root, 960, 600));
                stage.setMaximized(true);
                stage.show();
                ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        logoutLabel.setOnMouseClicked(mouseEvent -> {
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/welcome/welcome.fxml"));
                Stage stage = new Stage();
                //stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root, 960, 600));
                stage.setMaximized(true);
                stage.show();
                ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void call_info_dialog(int check, String text) {
        if (check == 8) {
            infodialog_heading.setText("SUCCESS!!!");
            infodialog_text.setText(text);
            infodialog_ac.setVisible(true);
        } else {
            infodialog_heading1.setText("FAILED!!!");
            infodialog_text1.setText(text);
            infodialog_ac1.setVisible(true);
        }
    }

    private void dbase_loading() {
        submenu_checker = "percent";
        presenter.getSuppliers("all", "none");
        presenter.brgetSaleCategory();
        presenter.BarUnit();
        presenter.Origin();
        presenter.SalesRep();
    }

    private void add_dialog_box() {
        bropen_add_categorysale.setOnMouseClicked(mouseEvent -> {
            add_checker = "brsale_cat";
            addCategory_ac.setVisible(true);
            add_store_cat_txt.requestFocus();

        });
        bropen_add_unit.setOnMouseClicked(mouseEvent -> {
            add_checker = "bar_unit";
            addUnit_ac.setVisible(true);
            add_store_cat_txt1.requestFocus();

        });
        bropen_add_unit1.setOnMouseClicked(mouseEvent -> {
            add_checker = "bar_origin";
            addOrigin_ac.setVisible(true);
            add_store_cat_txt11.requestFocus();

        });
        bropen_add_rep.setOnMouseClicked(mouseEvent -> {
            add_checker = "bar_rep";
            addRep_ac.setVisible(true);
            add_store_rep_txt.requestFocus();

        });
        save_cat_btn.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Category Name Cannot be Empty!!", add_store_cat_txt, store_cat_label)) {
                return;
            }
            if (add_checker.equals("sale_cat")) {
                category = add_store_cat_txt.getText().toUpperCase();
                presenter.addCategory(category, add_checker);
            } else if (add_checker.equals("brsale_cat")) {
                category = add_store_cat_txt.getText().toUpperCase();
                presenter.addCategory(category, add_checker);
            }
        });

        save_cat_btn1.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Unit Name Cannot be Empty!!", add_store_cat_txt1, store_cat_label1)) {
                return;
            }
            if (add_checker.equals("store_unit")) {
                category = add_store_cat_txt1.getText().toUpperCase();
                presenter.addCategory(category, add_checker);
            } else if (add_checker.equals("bar_unit")) {
                category = add_store_cat_txt1.getText().toUpperCase();
                presenter.addCategory(category, add_checker);
            }
        });
        save_cat_btn11.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Origin Name Cannot be Empty!!", add_store_cat_txt11, store_cat_label11)) {
                return;
            }
            if (add_checker.equals("bar_origin")) {
                category = add_store_cat_txt11.getText().toUpperCase();
                presenter.addCategory(category, add_checker);
            }
        });
        save_btn_rep.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Sale Rep Cannot be Empty!!", add_store_rep_txt, saleRepLBL)) {
                return;
            }
            if (add_checker.equals("bar_rep")) {
                category = add_store_rep_txt.getText().toUpperCase();
                presenter.addCategory(category, add_checker);
            }
        });
    }

    private boolean comboBox_validation(String message, Label theLabel, JFXComboBox<String> theTxt) {
        boolean isMyComboBoxEmpty = theTxt.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty) {
            theLabel.setText(message);
            theTxt.getStyleClass().add("textInputError");
            return false;
        } else {
            theLabel.setText("");
            theTxt.getStyleClass().add("textInput");
            return true;
        }
    }

    private void mainAction_buttons() {

        edit_userSaveBTN.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Email Cannot be left Empty!!", edit_email, edit_emailLBL)
                    | !textField_validation("First Name Cannot be left Empty!!", editFname, editFnameLBL)
                    | !textField_validation("Last Name Cannot be left Empty!!", editLname, editLnameLBL)
                    | !textField_validation("UserName Cannot be left Empty!!", editUname, editUnameLBL)
                    | !comboBox_validation("Please Select the User Designation!!", editDesiganationLBL, editDesiganation)) {
                return;
            }
            // Check Email Validity
            String dEmail = edit_email.getText();
            String regex = "^(.+)@(.+)$";
            Pattern partre = Pattern.compile(regex);
            Matcher matcher = partre.matcher(dEmail);
            if (!matcher.matches()) {
                call_info_dialog(0, "Email Address Entered is Invalid!!");
            } else {
                //Get Duty
                String duty = "NONE";
                String desgn = editDesiganation.getValue();
                if (desgn.equals("WAITER") || desgn.equals("CASHIER") || desgn.equals("COUNTER MANAGER")) {
                    duty = "WAITER";
                }
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("email", edit_email.getText());
                jsonObject.put("emailx", email_LBL.getText());
                jsonObject.put("designation", editDesiganation.getValue());
                jsonObject.put("f_name", editFname.getText().toUpperCase());
                jsonObject.put("l_name", editLname.getText().toUpperCase());
                jsonObject.put("u_name", editUname.getText().toUpperCase());
                jsonObject.put("duty", duty);
                jsonArray.put(jsonObject);
                presenter.editUser("update", String.valueOf(jsonArray));
            }
        });
        add_UserSaveBTN.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Email Cannot be left Empty!!", add_email, add_emailLBL)
                    | !textField_validation("First Name Cannot be left Empty!!", add_Fname, add_FnameLBL)
                    | !textField_validation("Last Name Cannot be left Empty!!", add_Lname, add_LnameLBL)
                    | !textField_validation("Username Cannot be left Empty!!", add_username, add_usernameLBL)
                    | !comboBox_validation("Please Select the User Designation!!", add_designationLBL, add_designation)) {
                return;
            }
            // Check Email Validity
            String dEmail = add_email.getText();
            String regex = "^(.+)@(.+)$";
            Pattern partre = Pattern.compile(regex);
            Matcher matcher = partre.matcher(dEmail);
            if (!matcher.matches()) {
                call_info_dialog(0, "Email Address Entered is Invalid!!");
            } else {
                //Get Password
                int len = 8;
                String chars = "013456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
                Random rnd = new Random();
                StringBuilder sb = new StringBuilder(len);
                for (int i = 0; i < len; i++) {
                    sb.append(chars.charAt(rnd.nextInt(chars.length())));
                }
                //Get Duty
                String duty = "NONE";
                String desgn = add_designation.getValue();
                if (desgn.equals("WAITER") || desgn.equals("CASHIER") || desgn.equals("COUNTER MANAGER")) {
                    duty = "WAITER";
                }
                //Get PIN
                String pin = "";
                Random rand = new Random();
                int pinn = rand.nextInt(100000);
                if (pinn < 10) {
                    pin = "00000" + pinn;
                } else if (pinn < 100) {
                    pin = "0000" + pinn;
                } else if (pinn < 1000) {
                    pin = "000" + pinn;
                } else if (pinn < 10000) {
                    pin = "00" + pinn;
                } else if (pinn < 100000) {
                    pin = "0" + pinn;
                }
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("email", add_email.getText());
                jsonObject.put("designation", add_designation.getValue());
                jsonObject.put("f_name", add_Fname.getText().toUpperCase());
                jsonObject.put("l_name", add_Lname.getText().toUpperCase());
                jsonObject.put("u_name", add_username.getText().toUpperCase());
                jsonObject.put("duty", duty);
                jsonObject.put("pass", sb.toString());
                jsonObject.put("pin", pin);
                jsonArray.put(jsonObject);
                presenter.addUser(String.valueOf(jsonArray));
            }

        });
        add_UserCancelBTN.setOnMouseClicked(mouseEvent -> {
            clearMe();
            combobox_events("gen");

        });
        bradd_sale_cancelBTN.setOnMouseClicked(mouseEvent -> {
            clearMe();
            combobox_events("gen");

        });
        supplier_cancelBTN.setOnMouseClicked(mouseEvent -> {
            clearMe();
            combobox_events("gen");

        });
        customer_cancelBTN.setOnMouseClicked(mouseEvent -> {
            clearMe();
            combobox_events("gen");

        });
        percCancelBTN.setOnMouseClicked(mouseEvent -> {
            clearMe();
            combobox_events("gen");

        });
        filter_users.setOnMouseClicked(mouseEvent -> {
            if (!comboBox_validation("Please Select the Designation!!", filterUsers_COMBOLBL, filterUsers_COMBO)) {
                return;
            }
            search_users.setText("");
            String catFilter = filterUsers_COMBO.getValue();
            presenter.getUsers("filter", catFilter);
            submenu_checker = "list_users";

        });
        brfilter_saleListBTN.setOnMouseClicked(mouseEvent -> {
            if (!comboBox_validation("Please Select the Category!!", brsaleItemFillterComboLBL, brfilter_SaleitemsCOMBO)) {
                return;
            }
            brsearch_Saleitems.setText("");
            String catFilter = brfilter_SaleitemsCOMBO.getValue();
            presenter.brgetStoreItemList("filter", catFilter);
            submenu_checker = "brmanagesale";

        });
        rsest_usersList.setOnMouseClicked(mouseEvent -> {
            search_users.setText("");
            submenu_checker = "list_users";
            presenter.getUsers("all", "none");

        });
        brreset_SaleLISTBTN.setOnMouseClicked(mouseEvent -> {
            brsearch_Saleitems.setText("");
            submenu_checker = "brmanagesale";
            presenter.brgetStoreItemList("all", "none");

        });
        supplierListResetBTN1.setOnMouseClicked(mouseEvent -> {
            supplier_SearchListTXT1.setText("");
            submenu_checker = "listpercent";
            presenter.getPercent("all", "none");

        });
        supplierListResetBTN.setOnMouseClicked(mouseEvent -> {
            supplier_SearchListTXT.setText("");
            submenu_checker = "listSupplier";
            presenter.getSuppliers("all", "none");

        });
        customerListResetBTN.setOnMouseClicked(mouseEvent -> {
            customers_SearchListTXT.setText("");
            submenu_checker = "listCustomer";
            presenter.getCustomers("all", "none");

        });
        activateUser.setOnMouseClicked(mouseEvent -> {
            presenter.editUser("ACTIVE", email_LBL.getText());

        });
        DeactivateUser.setOnMouseClicked(mouseEvent -> {
            presenter.editUser("INACTIVE", email_LBL.getText());

        });
        bradd_sale_saveBTN.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Item Code Cannot be left Empty!!", brsale_itmName_new, brsale_itmName_new_LBL)
                    | !textField_validation("Item Name Cannot be left Empty!!", brsale_itmName_new1, brsale_itmName_new_LBL2)
                    | !textField_validation("Buying Price Cannot be left Empty!!", brsale_sellingprice_TXT, brsale_sellingprice_LBL)
                    | !comboBox_validation("Please Select the Category!!", brSalecategoryCombo_LBL, brSalecategoryCombo)
                    | !comboBox_validation("Please Select Unit!!", brStoreDispUnitCombo_LBL, brStoreDispUnitCombo)
                    | !comboBox_validation("Please Select Origin Country!!", originComboLBL, originCombo)
                    | !comboBox_validation("Please Select the Supplier!!", itemSupplierComboLBL, itemSupplierCombo)) {
                return;
            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray2 = new JSONArray();
            DecimalFormat formatter = new DecimalFormat("#,###.00");

            if (brimage_labelrest.getText().equals("Image Local Path")) {
                call_info_dialog(0, "No Image Selected for Item");
            } else {
                jsonObject.put("code", brsale_itmName_new.getText().toUpperCase());
                jsonObject.put("name", brsale_itmName_new1.getText().toUpperCase());
                jsonObject.put("category", brSalecategoryCombo.getValue());
                jsonObject.put("cost", brsale_sellingprice_TXT.getText().toUpperCase());
                jsonObject.put("sel_unit", brStoreDispUnitCombo.getValue());
                jsonObject.put("origin", originCombo.getValue());
                jsonObject.put("supplier", itemSupplierCombo.getValue());
                jsonObject.put("image", encoded_image);
                jsonObject.put("user", userLabel.getText());
                jsonArray.put(jsonObject);

                presenter.addSaleItem_bar(String.valueOf(jsonArray));

            }

        });
        supplier_saveBTN.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Supplier Name Cannot be left Empty!!", supplier_nameTXT, supplier_nameLBL)
                    | !textField_validation("KRA Pin Cannot be left Empty!!", supplier_PINTXT, supplier_PINLBL)
                    | !textField_validation("Supplier Phone No. is Empty!!", supplier_phoneTXT, supplier_phoneLBL)
                    | !textField_validation("Supplier Address is Empty!!", supplier_addressTXT, supplier_addressLBL)
                    | !textField_validation("Supplier Email Cannot be left Empty!!", supplier_emailTXT, supplier_emailLBL)
                    | !textField_validation("Supplier Balance Cannot be left Empty!!", supplier_openingbalTXT, supplier_openingbalLBL)) {
                return;
            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("name", supplier_nameTXT.getText().toUpperCase());
            jsonObject.put("pin", supplier_PINTXT.getText().toUpperCase());
            jsonObject.put("phone", supplier_phoneTXT.getText().toUpperCase());
            jsonObject.put("address", supplier_addressTXT.getText().toUpperCase());
            jsonObject.put("email", supplier_emailTXT.getText());
            jsonObject.put("bal", supplier_openingbalTXT.getText());
            jsonObject.put("user", userLabel.getText());
            jsonArray.put(jsonObject);

            presenter.addSupplier(String.valueOf(jsonArray));

        });
        customer_saveBTN.setOnMouseClicked(mouseEvent -> {
            if (!textField_validation("Customer Name Cannot be left Empty!!", customer_nameTXT, customer_nameLBL)
                    | !textField_validation("KRA Pin Cannot be left Empty!!", customer_PINTXT, customer_PINLBL)
                    | !textField_validation("Customer Phone No. is Empty!!", customer_phoneTXT, customer_phoneLBL)
                    | !textField_validation("Customer Address is Empty!!", customer_addressTXT, customer_addressLBL)
                    | !textField_validation("Customer Email Cannot be left Empty!!", customer_emailTXT, customer_emailLBL)
                    | !textField_validation("Customer Balance Cannot be left Empty!!", customer_openingbalTXT, customer_openingbalLBL)
                    | !textField_validation("Credit Terms Cannot be left Empty!!", customer_termsTXT, customer_termsLBL)
                    | !textField_validation("Credit Limit Cannot be left Empty!!", customer_limitTXT, customer_limitLBL)
                    | !comboBox_validation("Please Select Customer Category!!", CustCatComboLBL, CustCatCombo)
                    | !comboBox_validation("Please Select Sales Rep!!", salerepComboLBL, salerepCombo)
                    | !comboBox_validation("Please Select Customer Type!!", CustTypeComboLBL, CustTypeCombo)) {
                return;
            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("name", customer_nameTXT.getText().toUpperCase());
            jsonObject.put("pin", customer_PINTXT.getText().toUpperCase());
            jsonObject.put("phone", customer_phoneTXT.getText().toUpperCase());
            jsonObject.put("address", customer_addressTXT.getText().toUpperCase());
            jsonObject.put("email", customer_emailTXT.getText());
            jsonObject.put("bal", customer_openingbalTXT.getText());
            jsonObject.put("terms", customer_termsTXT.getText());
            jsonObject.put("limit", customer_limitTXT.getText());
            jsonObject.put("rep", salerepCombo.getValue());
            jsonObject.put("category", CustCatCombo.getValue());
            jsonObject.put("type", CustTypeCombo.getValue());
            jsonObject.put("user", userLabel.getText());
            jsonArray.put(jsonObject);

            presenter.addCustomer(String.valueOf(jsonArray));

          System.out.println();
          System.out.println(String.valueOf(jsonArray));

        });
        percSaveBTN.setOnMouseClicked(mouseEvent -> {
            if (!comboBox_validation("Please Select Supplier!!", percSupplierComboLBL, percSupplierCombo)
                    | !comboBox_validation("Please Select Customer Category!!", percCustCatComboLBL, percCustCatCombo)
                    | !comboBox_validation("Please Select Customer Type!!", percCustTypeComboLBL, percCustTypeCombo)
                    | !textField_validation("Pricing Percentage is Empty!!", percPriceTXT, percPriceLBL)) {
                return;
            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("supplier", percSupplierCombo.getValue());
            jsonObject.put("category", percCustCatCombo.getValue());
            jsonObject.put("type", percCustTypeCombo.getValue());
            jsonObject.put("percent", percPriceTXT.getText().toUpperCase());
            jsonObject.put("user", userLabel.getText());
            jsonArray.put(jsonObject);

            presenter.addPercent(String.valueOf(jsonArray));

        });

    }

    private void imageButton() {
        brbtnImageViewrest.setOnMouseClicked(mouseEvent -> {

            String picPath = brimage_labelrest.getText();
            if (picPath.equals("Image Local Path")) {
                call_info_dialog(0, "No Image Selected");
            } else {
                File logox = new File(picPath);
                Image logo_image = new Image(logox.toURI().toString());
                preview_image.setImage(logo_image);
                imageshow_ac.setVisible(true);
            }

        });

        brbtnImgSelectrest.setOnMouseClicked(mouseEvent -> {
            try {
                FileChooser filechooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpeg", "*.jpg", "*.png");
                filechooser.getExtensionFilters().add(extFilter);
                filechooser.setTitle("Select Product Image");
                Stage stage = (Stage) rootpanes.getScene().getWindow();

                File file = filechooser.showOpenDialog(stage);
                if (file.exists()) {
                    brimage_labelrest.setText(file.getPath());

                    File filex = new File(brimage_labelrest.getText());
                    byte[] bytes = new byte[(int) filex.length()];
                    FileInputStream fis = new FileInputStream(filex);
                    fis.read(bytes);
                    fis.close();
                    encoded_image = Base64.getEncoder().encodeToString(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
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
    public void GetBarUnit(List<storeModel> body) {
        int x = body.size();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < x; i++) {
                    brunit_List.add(body.get(i).getStoreCategory());

                }
                combobox_events("bar_unit");
            }
        });
    }

    @Override
    public void brGetSaleCategory(List<saleModel> category) {
        int x = category.size();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < x; i++) {
                    brcategory_Listsale.add(category.get(i).getSaleCategory());

                }
                combobox_events("brsale_cat");
                combobox_events("gen");
            }
        });
    }

    @Override
    public void GetOrigin(List<storeModel> category) {
        int x = category.size();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < x; i++) {
                    originList.add(category.get(i).getStoreCategory());

                }
                combobox_events("bar_origin");
                combobox_events("gen");
            }
        });
    }

    @Override
    public void GetRep(List<storeModel> category) {
        int x = category.size();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < x; i++) {
                    repList.add(category.get(i).getStoreCategory());

                }
                combobox_events("bar_rep");
                combobox_events("gen");
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
    public void onAddUserSuccess(String message) {
        Platform.runLater(() -> {
            clearMe();
            combobox_events("gen");
            call_info_dialog(8, message);

        });
    }

    @Override
    public void GetUsers(List<usersModel> body) {
        Platform.runLater(() -> {
            store_itemLst.clear();
            int totsize = body.size();
            for (int i = 0; i < totsize; i++) {
                ArrayList<String> listelm = new ArrayList<>();
                listelm.add(body.get(i).getEmail());
                listelm.add(body.get(i).getF_name());
                listelm.add(body.get(i).getL_name());
                listelm.add(body.get(i).getU_name());
                listelm.add(body.get(i).getPass());
                listelm.add(body.get(i).getPin());
                listelm.add(body.get(i).getDesignation());
                listelm.add(body.get(i).getDuty());
                listelm.add(body.get(i).getStatus());
                listelm.add(body.get(i).getSecurity());
                listelm.add(body.get(i).getPresent());
                listelm.add(body.get(i).getSecurityPIN());
                store_itemLst.add(listelm);
            }
            if (submenu_checker.equals("edit")) {
                edit_email.setText(body.get(0).getEmail());
                editFname.setText(body.get(0).getF_name());
                editLname.setText(body.get(0).getL_name());
                editUname.setText(body.get(0).getU_name());
            } else if (submenu_checker.equals("list_users")) {
                listUsers();
            } else if (submenu_checker.equals("sec_users")) {
                listUsersPass();
            } else if (submenu_checker.equals("sec_users2")) {
                listUsersPin();
            }

            clearMe();
            combobox_events("gen");
        }
        );
    }

    @Override
    public void onUserUpdateSuccess(String message) {
        Platform.runLater(() -> {
            submenu_checker = "list_users";
            presenter.getUsers("all", "none");
            search_users.setText("");
            hideItems();
            clearMe();
            combobox_events("gen");
            main_ac.setVisible(true);
            users_ac.setVisible(true);
            listUser_ac.setVisible(true);
            call_info_dialog(8, message);
        });
    }

    @Override
    public void onAddCatSuccess(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (add_checker.equals("brsale_cat")) {
                    brcategory_Listsale.add(category);
                    addCategory_ac.setVisible(false);
                } else if (add_checker.equals("bar_unit")) {
                    brunit_List.add(category);
                    addUnit_ac.setVisible(false);
                } else if (add_checker.equals("bar_origin")) {
                    originList.add(category);
                    addOrigin_ac.setVisible(false);
                } else if (add_checker.equals("bar_rep")) {
                    repList.add(category);
                    addRep_ac.setVisible(false);
                }
                combobox_events(add_checker);
                add_store_cat_txt.setText("");
                add_store_cat_txt1.setText("");
                call_info_dialog(8, message);
            }
        });
    }

    @Override
    public void GetbrSaleItems(List<BarsaleModel> body) {
        Platform.runLater(() -> {
            int totsize = body.size();
            sale_ingredient1.clear();
            store_itemLst.clear();
            store_itemLst2 = new ArrayList();
            brsale_listVbox.getChildren().clear();
            for (int i = 0; i < totsize; i++) {
                ArrayList<String> listelm = new ArrayList<>();
                listelm.add(body.get(i).getCode());
                listelm.add(body.get(i).getName());
                listelm.add(body.get(i).getB_price());
                listelm.add(body.get(i).getCategory());
                listelm.add(body.get(i).getOrigin());
                listelm.add(body.get(i).getSupplier());
                listelm.add(body.get(i).getUnit());
                listelm.add(body.get(i).getPath());
                listelm.add(body.get(i).getStatus());

                sale_ingredient1.add(listelm);
                store_itemLst.add(listelm);

            }
            if (submenu_checker.equals("brmanagesale")) {
                listSaleItems2();
                clearMe();
                combobox_events("gen");
            } else if (submenu_checker.equals("EditSaleItem")) {
                brsale_itmName_new12.setText(body.get(0).getCode());
                brsale_itmName_new11.setText(body.get(0).getName());
                brsale_sellingprice_TXT11.setText(body.get(0).getB_price());
            }

        });
    }

    @Override
    public void onAddBarSaleItemSuccess(String message) {
        Platform.runLater(() -> {
            call_info_dialog(8, message);
            submenu_checker = "braddsale";
            clearMe();
            combobox_events("gen");
        });
    }

    @Override
    public void onAddSupplier(String message) {
        Platform.runLater(() -> {
            call_info_dialog(8, message);
            submenu_checker = "addSupplier";
            clearMe();
            combobox_events("gen");
        });
    }

    @Override
    public void onAddCustomer(String message) {
        Platform.runLater(() -> {
            call_info_dialog(8, message);
            submenu_checker = "addCustomer";
            clearMe();
            combobox_events("gen");
        });
    }

    @Override
    public void GetSuppliers(List<suppliersModel> body) {
        Platform.runLater(() -> {
            store_itemLst.clear();
            supplier_list.clear();
            int totsize = body.size();
            for (int i = 0; i < totsize; i++) {
                ArrayList<String> listelm = new ArrayList<>();
                listelm.add(body.get(i).getCode());
                listelm.add(body.get(i).getName());
                listelm.add(body.get(i).getPin());
                listelm.add(body.get(i).getPhone());
                listelm.add(body.get(i).getAddress());
                listelm.add(body.get(i).getEmail());
                listelm.add(body.get(i).getStatus());
                listelm.add(body.get(i).getBal());
                store_itemLst.add(listelm);
            }
            if (submenu_checker.equals("EditSupplier")) {
                supplier_nameTXT1.setText(body.get(0).getName());
                supplier_PINTXT1.setText(body.get(0).getPin());
                supplier_phoneTXT1.setText(body.get(0).getPhone());
                supplier_addressTXT1.setText(body.get(0).getAddress());
                supplier_emailTXT1.setText(body.get(0).getEmail());
                supplier_openingbalTXT1.setText(body.get(0).getBal());
            } else if (submenu_checker.equals("listSupplier")) {
                listSuppliers();
            }
            if (submenu_checker.equals("percent")) {
                for (int i = 0; i < totsize; i++) {
                    supplier_list.add(body.get(i).getName());

                }
                combobox_events("percent");
            } else if (submenu_checker.equals("braddsale")) {
                for (int i = 0; i < totsize; i++) {
                    supplier_list.add(body.get(i).getName());

                }
                combobox_events("braddsale");
            }

            clearMe();
            combobox_events("gen");
        }
        );
    }

    @Override
    public void GetCustomers(List<customersModel> body) {
        Platform.runLater(() -> {
            store_itemLst.clear();
            supplier_list.clear();
            int totsize = body.size();
            for (int i = 0; i < totsize; i++) {
                ArrayList<String> listelm = new ArrayList<>();
                listelm.add(body.get(i).getCode());
                listelm.add(body.get(i).getName());
                listelm.add(body.get(i).getPin());
                listelm.add(body.get(i).getPhone());
                listelm.add(body.get(i).getAddress());
                listelm.add(body.get(i).getEmail());
                listelm.add(body.get(i).getBal());
                listelm.add(body.get(i).getTerms());
                listelm.add(body.get(i).getLimits());
                listelm.add(body.get(i).getType());
                listelm.add(body.get(i).getCategory());
                listelm.add(body.get(i).getStatus());
                store_itemLst.add(listelm);
            }
            if (submenu_checker.equals("EditCustomer")) {
                customer_nameTXT1.setText(body.get(0).getName());
                customer_PINTXT1.setText(body.get(0).getPin());
                customer_phoneTXT1.setText(body.get(0).getPhone());
                customer_addressTXT1.setText(body.get(0).getAddress());
                customer_emailTXT1.setText(body.get(0).getEmail());
                customer_openingbalTXT1.setText(body.get(0).getBal());
                customer_termsTXT1.setText(body.get(0).getTerms());
                customer_limitTXT1.setText(body.get(0).getLimits());

            } else if (submenu_checker.equals("listCustomer")) {
                listCustomers();
            }

            clearMe();
            combobox_events("gen");
        }
        );
    }

    @Override
    public void onAddPercent(String message) {
        Platform.runLater(() -> {
            call_info_dialog(8, message);
            submenu_checker = "percent";
            clearMe();
            combobox_events("gen");
        });
    }

    @Override
    public void GetPercent(List<percentModel> body) {
        Platform.runLater(() -> {
            store_itemLst.clear();
            supplier_list.clear();
            int totsize = body.size();
            for (int i = 0; i < totsize; i++) {
                ArrayList<String> listelm = new ArrayList<>();
                listelm.add(body.get(i).getName());
                listelm.add(body.get(i).getCategory());
                listelm.add(body.get(i).getType());
                listelm.add(body.get(i).getPercent());
                store_itemLst.add(listelm);
            }
            if (submenu_checker.equals("listpercent")) {
                listPercent();
            }

            clearMe();
            combobox_events("gen");
        }
        );
    }
}
