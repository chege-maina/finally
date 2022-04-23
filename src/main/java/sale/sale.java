package sale;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ProgressIndicator;
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
import models.InvoicesModel;
import models.OrdersModel;
import models.OrdersModel.Items;
import models.customersModel;
import models.percentModel;
import models.saleModel;
import models.storeModel;
import models.suppliersModel;
import models.usersModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.json.JSONArray;
import org.json.JSONObject;
import welcome.welcome;

public class sale implements Initializable, saleView {

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
    private JFXButton menu_orders;

    @FXML
    private JFXButton csutomerINV_menu;

    @FXML
    private JFXButton supplierINVmenu;

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
    private AnchorPane addOrigin_ac;

    @FXML
    private ImageView close_add_origin;

    @FXML
    private Label infodialog_heading2111;

    @FXML
    private JFXTextField add_store_cat_txt11;

    @FXML
    private Label store_cat_label11;

    @FXML
    private Button save_cat_btn11;

    @FXML
    private JFXButton new_orderMenu, ordersmngtMenu, invoicesmngtMenu, create_billsMenu;
    @FXML
    private AnchorPane orders_ac, listOrders_ac, viewOrder_ac, neworder_ac, loader_ac, invoices_ac, listInvoices_ac, viewInvoice_ac, bills_ac, viewbills_ac, listBills_ac;
    @FXML
    private TextField search_items, nwOrderLPO, orders_search, invoices_search, bills_search, nwBillNo;
    @FXML
    private JFXComboBox<String> suppliersnwOrderCombo, customersnwOrderCombo, order_statusCombo, invoice_statusCombo;
    @FXML
    private Button src_items, makeOrderBTN, viewBillPostBTN, viewOrderPrintBTN, viewOrdersaveOrderBTN, billListReset, viewInvoicePrintBTN, cancelOrderBTN, orderFilterComboBTN, ordersListReset, viewOrderInvoiceBTN, invoiceFilterComboBTN, invoiceListReset;
    @FXML
    private Label suppliersnwOrderComboLBL, customersnwOrderComboLBL, order_statusComboLBL;
    @FXML
    private Label viewOrderDateLBL, viewOrderNumberLBL, viewOrderLPOLBL, viewOrderStatusLBL, viewOrderSupplierLBL, viewOrderSupplierAddreLBL, viewOrderSupplierPhnLBL, viewOrderSupplierEmailLBL;
    @FXML
    private Label viewOrderCustomerLBL, viewOrderCustomerAddrLBL, viewOrderCustomerPhnLBL, viewOrderCustomerEmailLBL, invoice_statusComboLBL;
    @FXML
    private Label viewInvoiceDateLBL, viewInvoiceNumberLBL, viewInvoiceOrdernoLBL, viewInvoiceLPOLBL, viewInvoiceStatusLBL, viewInvoiceDueLBL;
    @FXML
    private Label viewInvoiceCustomerLBL, viewInvoiceCustomerAddrLBL, viewInvoiceCustomerPhnLBL, viewInvoiceCustomerEmailLBL;
    @FXML
    private Label Invoicepretax, InvoiceTax, InvoiceTotal;
    @FXML
    private VBox itemsVbox, nworderitemVbox, ordersListVbox, viewOrdersItemsVBox, invoicesListVbox, viewInvoicesItemsVBox, billsListVbox, viewBillItemsVBox;
    @FXML
    private JFXDatePicker nworderdate, nwBilldate;
    @FXML
    private Label viewBillDateLBL, viewBillNumberLBL, viewBillOrdernoLBL, viewBillLPOLBL, viewBillStatusLBL, viewBillSupplierLBL, viewBillSupplierAddrLBL, viewBillSupplierPhnLBL, viewBillSupplierEmailLBL;
    @FXML
    private ProgressIndicator p_Indicator;

    //Declaration of Variables
    ArrayList<Items> orderItems;
    ArrayList<InvoicesModel.Items> invoiceItems;
    ArrayList<String> category_List, unit_List, category_Listsale, brcategory_Listsale, brunit_List, supplier_list, originList, customer_list;
    ArrayList itmName;
    ArrayList itmName2;
    ArrayList<ArrayList<String>> store_itemLst;
    ArrayList<ArrayList<String>> store_itemLst2;
    ArrayList<ArrayList<String>> store_itemLst3;
    ArrayList<ArrayList<String>> receiptlist;
    ArrayList<ArrayList<String>> creditNote;
    ArrayList<ArrayList<String>> store_ingredient1;
    ArrayList<ArrayList<String>> store_ingredient2;
    ArrayList<ArrayList<String>> sale_ingredient1;
    ArrayList<ArrayList<String>> sale_ingredient2;
    ArrayList<String> counters_list;
    private myInterface listenerz;
    private String encoded_image;
    salePresenter presenter;
    String add_checker = "";
    String submenu_checker;
    String category = "";
    String type = "";
    String TYPE = "";
    String jina = "";
    String daCreditNote = "";
    int type_run;
    String itemnameSTRING;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        presenter = new salePresenter(this);
        p_Indicator.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
        store_itemLst = new ArrayList<>();
        store_ingredient1 = new ArrayList<>();
        sale_ingredient1 = new ArrayList<>();
        unit_List = new ArrayList<>();
        receiptlist = new ArrayList<>();
        counters_list = new ArrayList<>();
        brunit_List = new ArrayList<>();
        originList = new ArrayList<>();
        category_List = new ArrayList<>();
        category_Listsale = new ArrayList();
        supplier_list = new ArrayList();
        customer_list = new ArrayList();
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
            public void saleItemListener(ArrayList itemzz) {
                Platform.runLater(() -> {
                    getRecItems(itemzz);
                });
            }

            @Override
            public void removeRecITM(ArrayList itemzz) {
                String code = itemzz.get(0).toString();
                int totsize = receiptlist.size();
                for (int i = 0; i < totsize; i++) {
                    String namechk = receiptlist.get(i).get(0);
                    if (namechk.equals(code)) {
                        receiptlist.remove(i);
                        i = totsize;
                        //Reload the VBox with new receiptlist
                        int totsize2 = receiptlist.size();
                        nworderitemVbox.getChildren().clear();
                        for (int k = 0; k < totsize2; k++) {
                            FXMLLoader fxmlloader = new FXMLLoader();
                            fxmlloader.setLocation(getClass().getResource("/fxml/sale/receipt_list.fxml"));

                            try {

                                HBox hBox = fxmlloader.load();
                                receiptITM itemscontroller = fxmlloader.getController();
                                itemscontroller.receiptItems(receiptlist.get(k), listenerz);
                                nworderitemVbox.getChildren().add(hBox);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }

            @Override
            public void removeBillITM(ArrayList itemzz) {

                String code = itemzz.get(0).toString();
                int totsize = store_itemLst.size();
                for (int i = 0; i < totsize; i++) {
                    String namechk = store_itemLst.get(i).get(0);
                    if (namechk.equals(code)) {
                        ArrayList<String> listelm = new ArrayList<>();
                        listelm.add(store_itemLst.get(i).get(0));
                        listelm.add(store_itemLst.get(i).get(1));
                        listelm.add(store_itemLst.get(i).get(2));
                        listelm.add(store_itemLst.get(i).get(3));
                        creditNote.add(listelm);
                        store_itemLst.remove(i);
                        daCreditNote = "8";
                        i = totsize;
                        //Reload the VBox with new receiptlist
                        int totsize2 = store_itemLst.size();
                        viewBillItemsVBox.getChildren().clear();
                        for (int k = 0; k < totsize2; k++) {
                            FXMLLoader fxmlloader = new FXMLLoader();
                            fxmlloader.setLocation(getClass().getResource("/fxml/sale/bill_itemslst.fxml"));
                            try {
                                HBox hBox = fxmlloader.load();
                                billITMrec itemscontroller = fxmlloader.getController();
                                itemscontroller.receiptItems(store_itemLst.get(k), listenerz);
                                viewBillItemsVBox.getChildren().add(hBox);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

            }

            @Override
            public void saleEditQty(ArrayList itemzz, String newValue) {
                Platform.runLater(() -> {
                    String code = itemzz.get(0).toString();
                    int totsize = receiptlist.size();
                    for (int i = 0; i < totsize; i++) {
                        if (code.equals(receiptlist.get(i).get(0))) {
                            Double QTY = Double.parseDouble(newValue);
                            //Set the new values to the receiptlist
                            receiptlist.get(i).set(2, "" + QTY);

                        }
                    }
                });

            }

            @Override
            public void BillEditQty(ArrayList itemzz, String newValue, Double gg) {
                Platform.runLater(() -> {
                    String code = itemzz.get(0).toString();
                    int totsize = store_itemLst.size();
                    for (int i = 0; i < totsize; i++) {
                        if (code.equals(store_itemLst.get(i).get(0))) {
                            Double QTY = Double.parseDouble(newValue);
                            //Set the new values to the receiptlist
                            store_itemLst.get(i).set(2, "" + QTY);
                            //Credit Note 

                            int totsize1 = creditNote.size();
                            if (totsize1 == 0) {
                                ArrayList<String> listelm = new ArrayList<>();
                                listelm.add(store_itemLst.get(i).get(0));
                                listelm.add(store_itemLst.get(i).get(1));
                                listelm.add("" + gg);
                                listelm.add(store_itemLst.get(i).get(3));
                                creditNote.add(listelm);
                            }
                            for (int j = 0; j < totsize1; j++) {
                                if (code.equals(creditNote.get(j).get(0))) {

                                    creditNote.get(j).set(2, "" + gg);
                                } else {
                                    ArrayList<String> listelm = new ArrayList<>();
                                    listelm.add(store_itemLst.get(i).get(0));
                                    listelm.add(store_itemLst.get(i).get(1));
                                    listelm.add("" + gg);
                                    listelm.add(store_itemLst.get(i).get(3));
                                    creditNote.add(listelm);
                                }
                            }
                            daCreditNote = "8";
                        }
                    }
                });

            }

            @Override
            public void orderITMListener(ArrayList itemzz) {
                Platform.runLater(() -> {
                    hideItems();
                    main_ac.setVisible(true);
                    orders_ac.setVisible(true);
                    viewOrder_ac.setVisible(true);
                    submenu_checker = "view_order";
                    String code = itemzz.get(0).toString();
                    String status = itemzz.get(5).toString();
                    if (status.equals("PENDING")) {
                        viewOrderInvoiceBTN.setDisable(false);
                    } else {
                        viewOrderInvoiceBTN.setDisable(true);
                    }
                    presenter.getOrders("view", code);
                    loader_ac.setVisible(true);

                });
            }

            @Override
            public void invoiceITMListener(ArrayList itemzz) {
                Platform.runLater(() -> {
                    hideItems();
                    main_ac.setVisible(true);
                    invoices_ac.setVisible(true);
                    viewInvoice_ac.setVisible(true);
                    submenu_checker = "view_invoice";
                    String code = itemzz.get(0).toString();
                    presenter.getInvoices("view", code);
                    loader_ac.setVisible(true);

                });
            }

            @Override
            public void BillITMListener(ArrayList itemzz) {
                Platform.runLater(() -> {
                    hideItems();
                    main_ac.setVisible(true);
                    bills_ac.setVisible(true);
                    viewbills_ac.setVisible(true);
                    submenu_checker = "view_bills";
                    String code = itemzz.get(0).toString();
                    String status = itemzz.get(8).toString();
                    if (status.equals("PENDING")) {
                        viewBillPostBTN.setDisable(false);
                    } else {
                        viewBillPostBTN.setDisable(true);
                    }
                    presenter.getInvoices("view", code);
                    loader_ac.setVisible(true);
                });
            }
        };
    }

    private void getRecItems(ArrayList recitem) {
        int on = 0;
        Double qty_entered = 1.0;

        nworderitemVbox.getChildren().clear();
        int totsize = receiptlist.size();
        String code = (String) recitem.get(0);
        String name = (String) recitem.get(1);
        String path = (String) recitem.get(7);
        String unit = (String) recitem.get(6);
        if (totsize > 0) {
            for (int i = 0; i < totsize; i++) {
                String namechk = receiptlist.get(i).get(1);
                if (namechk.equals(name)) {
                    String getQTY = receiptlist.get(i).get(2);
                    Double QTY = qty_entered + Double.parseDouble(getQTY);
                    on = 1;
                    receiptlist.get(i).set(2, "" + QTY);

                }

            }
            if (on == 0) {
                Double QTY = qty_entered;

                ArrayList<String> listelm = new ArrayList<>();
                listelm.add(code);
                listelm.add(name);
                listelm.add("" + qty_entered);
                listelm.add(unit);
                receiptlist.add(listelm);

            }
        } else {
            Double QTY = qty_entered;
            ArrayList<String> listelm = new ArrayList<>();
            listelm.add(code);
            listelm.add(name);
            listelm.add("" + qty_entered);
            listelm.add(unit);
            receiptlist.add(listelm);

        }
        int totsize1 = receiptlist.size();
        for (int i = 0; i < totsize1; i++) {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("/fxml/sale/receipt_list.fxml"));

            try {

                HBox hBox = fxmlloader.load();
                receiptITM itemscontroller = fxmlloader.getController();
                itemscontroller.receiptItems(receiptlist.get(i), listenerz);
                nworderitemVbox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void combobox_events(String letCheck) {
        if (letCheck.equals("add_order")) {
            suppliersnwOrderCombo.getItems().clear();
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    supplier_list);
            suppliersnwOrderCombo.setItems(categoryList);
            customersnwOrderCombo.getItems().clear();
            categoryList = FXCollections.observableArrayList(
                    customer_list);
            customersnwOrderCombo.setItems(categoryList);
        } else if (letCheck.equals("list_order")) {
            order_statusCombo.getItems().clear();
            ArrayList<String> listelm2 = new ArrayList<>();
            listelm2.add("PENDING");
            listelm2.add("DONE");
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    listelm2);
            order_statusCombo.setItems(categoryList);
        } else if (letCheck.equals("list_invoice")) {
            invoice_statusCombo.getItems().clear();
            ArrayList<String> listelm2 = new ArrayList<>();
            listelm2.add("PENDING");
            listelm2.add("PAID");
            listelm2.add("DONE");
            ObservableList<String> categoryList = FXCollections.observableArrayList(
                    listelm2);
            invoice_statusCombo.setItems(categoryList);
        }
    }

    private void comboboxValue_events() {
        suppliersnwOrderCombo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> composant, String oldValue, String newValue) {
                if (newValue == null) {
                    search_items.setEditable(false);
                    search_items.setText("");
                } else {

                }
            }
        });
    }

    private void clearMe() {

    }

    private void textField_events() {
        search_items.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("")) {
                } else {
                    presenter.getSaleItems("supsearch", newValue, suppliersnwOrderCombo.getValue());
                }
            }
        });
        invoices_search.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("")) {
                } else {
                    presenter.getInvoices("search", newValue);

                }
            }
        });
        bills_search.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("")) {
                } else {
                    presenter.getInvoices("searchbill", newValue);

                }
            }
        });
        orders_search.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("")) {
                } else {
                    presenter.getOrders("search", newValue);

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
        addCategory_ac.setVisible(false);
        loader_ac.setVisible(false);

        //Orders AnchorPanes
        orders_ac.setVisible(false);
        neworder_ac.setVisible(false);
        listOrders_ac.setVisible(false);
        viewOrder_ac.setVisible(false);

        //Invoices AnchorPanes
        invoices_ac.setVisible(false);
        viewInvoice_ac.setVisible(false);
        listInvoices_ac.setVisible(false);

        //Invoices AnchorPanes
        bills_ac.setVisible(false);
        listBills_ac.setVisible(false);
        viewbills_ac.setVisible(false);
    }

    private void initialView() {
        main_ac.setVisible(true);
        orders_ac.setVisible(true);
        neworder_ac.setVisible(true);

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
        menu_orders.setOnMouseClicked(mouseEvent -> {
            store_itemLst.clear();
            itemsVbox.getChildren().clear();
            receiptlist.clear();
            nworderitemVbox.getChildren().clear();
            customersnwOrderCombo.getItems().clear();
            suppliersnwOrderCombo.getItems().clear();
            nwOrderLPO.setText("");
            nworderdate.setValue(null);
            submenu_checker = "add_order";
            presenter.getSuppliers("all", "none");
            presenter.getCustomers("all", "none");
            hideItems();
            clearMe();
            search_items.setEditable(false);
            search_items.setText("");
            main_ac.setVisible(true);
            orders_ac.setVisible(true);
            neworder_ac.setVisible(true);

        });
        csutomerINV_menu.setOnMouseClicked(mouseEvent -> {
            presenter.getInvoices("all", "none");
            invoices_search.setText("");
            combobox_events("list_invoice");
            submenu_checker = "list_invoice";
            hideItems();
            clearMe();
            main_ac.setVisible(true);
            invoices_ac.setVisible(true);
            listInvoices_ac.setVisible(true);
            loader_ac.setVisible(true);

        });
        supplierINVmenu.setOnMouseClicked(mouseEvent -> {
            presenter.getInvoices("bill", "none");
            bills_search.setText("");
            submenu_checker = "post_bill";
            hideItems();
            clearMe();
            main_ac.setVisible(true);
            bills_ac.setVisible(true);
            listBills_ac.setVisible(true);
            loader_ac.setVisible(true);

        });

    }

    private void subMenu_Buttons() {
        new_orderMenu.setOnMouseClicked(mouseEvent -> {
            store_itemLst.clear();
            itemsVbox.getChildren().clear();
            receiptlist.clear();
            nworderitemVbox.getChildren().clear();
            customersnwOrderCombo.getItems().clear();
            suppliersnwOrderCombo.getItems().clear();
            nwOrderLPO.setText("");
            nworderdate.setValue(null);
            submenu_checker = "add_order";
            presenter.getSuppliers("all", "none");
            presenter.getCustomers("all", "none");
            hideItems();
            clearMe();
            search_items.setEditable(false);
            search_items.setText("");
            main_ac.setVisible(true);
            orders_ac.setVisible(true);
            neworder_ac.setVisible(true);

        });
        ordersmngtMenu.setOnMouseClicked(mouseEvent -> {
            presenter.getOrders("all", "none");
            orders_search.setText("");
            combobox_events("list_order");
            submenu_checker = "list_order";
            hideItems();
            clearMe();
            main_ac.setVisible(true);
            orders_ac.setVisible(true);
            listOrders_ac.setVisible(true);
            loader_ac.setVisible(true);

        });
        invoicesmngtMenu.setOnMouseClicked(mouseEvent -> {
            presenter.getInvoices("all", "none");
            invoices_search.setText("");
            combobox_events("list_invoice");
            submenu_checker = "list_invoice";
            hideItems();
            clearMe();
            main_ac.setVisible(true);
            invoices_ac.setVisible(true);
            listInvoices_ac.setVisible(true);
            loader_ac.setVisible(true);
        });
        create_billsMenu.setOnMouseClicked(mouseEvent -> {
            presenter.getInvoices("bill", "none");
            bills_search.setText("");
            submenu_checker = "post_bill";
            hideItems();
            clearMe();
            main_ac.setVisible(true);
            bills_ac.setVisible(true);
            listBills_ac.setVisible(true);
            loader_ac.setVisible(true);
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
        submenu_checker = "add_order";
        presenter.getSuppliers("all", "none");
        presenter.getCustomers("all", "none");

    }

    private void add_dialog_box() {

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
        src_items.setOnMouseClicked(mouseEvent -> {
            if (!comboBox_validation("Please Select Supplier!!", suppliersnwOrderComboLBL, suppliersnwOrderCombo)) {
                return;
            }
            search_items.setEditable(true);
            String catFilter = suppliersnwOrderCombo.getValue();
            loader_ac.setVisible(true);
            presenter.getSaleItems("supall", "none", catFilter);

        });
        viewOrdersaveOrderBTN.setOnMouseClicked(mouseEvent -> {
            String source = System.getProperty("user.dir") + "/order-rep.jrxml";
            if (new File(source).exists() == false) {
                call_info_dialog(0, "SPECIFY THE REPORT ROOT!!");
                return;
            }
            try {
                JRDataSource dataSource = new JRBeanCollectionDataSource(orderItems);
                JasperReport jasperReport = JasperCompileManager.compileReport(source);
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("sup_email", viewOrderSupplierEmailLBL.getText());
                param.put("sup_name", viewOrderSupplierLBL.getText());
                param.put("sup_phone", viewOrderSupplierPhnLBL.getText());
                param.put("sup_address", viewOrderSupplierAddreLBL.getText());

                param.put("cust_email", viewOrderCustomerEmailLBL.getText());
                param.put("cust_name", viewOrderCustomerLBL.getText());
                param.put("cust_phone", viewOrderCustomerPhnLBL.getText());
                param.put("cust_address", viewOrderCustomerAddrLBL.getText());

                param.put("date", viewOrderDateLBL.getText());
                param.put("lpo", viewOrderLPOLBL.getText());
                param.put("orderno", viewOrderNumberLBL.getText());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
                //JasperPrintManager.printReport(jasperPrint, false);
                JasperViewer.viewReport(jasperPrint, false);
                //PrintReportToPrinter(jasperPrint);
                loader_ac.setVisible(false);

            } catch (JRException ex) {
                Logger.getLogger(sale.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        viewOrderPrintBTN.setOnMouseClicked(mouseEvent -> {
            String source = System.getProperty("user.dir") + "/order-rep.jrxml";
            if (new File(source).exists() == false) {
                call_info_dialog(0, "SPECIFY THE REPORT ROOT!!");
                return;
            }
            try {
                JRDataSource dataSource = new JRBeanCollectionDataSource(orderItems);
                JasperReport jasperReport = JasperCompileManager.compileReport(source);
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("sup_email", viewOrderSupplierEmailLBL.getText());
                param.put("sup_name", viewOrderSupplierLBL.getText());
                param.put("sup_phone", viewOrderSupplierPhnLBL.getText());
                param.put("sup_address", viewOrderSupplierAddreLBL.getText());

                param.put("cust_email", viewOrderCustomerEmailLBL.getText());
                param.put("cust_name", viewOrderCustomerLBL.getText());
                param.put("cust_phone", viewOrderCustomerPhnLBL.getText());
                param.put("cust_address", viewOrderCustomerAddrLBL.getText());

                param.put("date", viewOrderDateLBL.getText());
                param.put("lpo", viewOrderLPOLBL.getText());
                param.put("orderno", viewOrderNumberLBL.getText());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
                JasperPrintManager.printReport(jasperPrint, false);
                //PrintReportToPrinter(jasperPrint);
                loader_ac.setVisible(false);

            } catch (JRException ex) {
                Logger.getLogger(sale.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        viewInvoicePrintBTN.setOnMouseClicked(mouseEvent -> {
            String source = System.getProperty("user.dir") + "/invoice-rep.jrxml";
            if (new File(source).exists() == false) {
                call_info_dialog(0, "SPECIFY THE REPORT ROOT!!");
                return;
            }
            try {
                JRDataSource dataSource = new JRBeanCollectionDataSource(invoiceItems);
                JasperReport jasperReport = JasperCompileManager.compileReport(source);
                Map<String, Object> param = new HashMap<String, Object>();

                param.put("cust_email", viewInvoiceCustomerEmailLBL.getText());
                param.put("cust_name", viewInvoiceCustomerLBL.getText());
                param.put("cust_phone", viewInvoiceCustomerPhnLBL.getText());
                param.put("cust_address", viewInvoiceCustomerAddrLBL.getText());

                param.put("date", viewInvoiceDateLBL.getText());
                param.put("lpo", viewInvoiceLPOLBL.getText());
                param.put("invoiceno", viewInvoiceNumberLBL.getText());
                param.put("orderno", viewInvoiceOrdernoLBL.getText());

                param.put("user", userLabel.getText());
                param.put("amount", InvoiceTotal.getText());
                param.put("tax", InvoiceTax.getText());
                param.put("pretax", Invoicepretax.getText());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
                JasperPrintManager.printReport(jasperPrint, false);
                //PrintReportToPrinter(jasperPrint);
                loader_ac.setVisible(false);

            } catch (JRException ex) {
                Logger.getLogger(sale.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        makeOrderBTN.setOnMouseClicked(mouseEvent -> {
            if (!comboBox_validation("Please Select Supplier!!", suppliersnwOrderComboLBL, suppliersnwOrderCombo)
                    | !comboBox_validation("Please Select Customer!!", customersnwOrderComboLBL, customersnwOrderCombo)) {
                return;
            }
            String datex = (nworderdate.getValue() != null ? nworderdate.getValue().toString() : "");
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray1 = new JSONArray();
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            int totsize = receiptlist.size();
            if (datex.equals("")) {
                call_info_dialog(0, "Please Select the Order Date");
            } else if (nwOrderLPO.getText().equals("")) {
                call_info_dialog(0, "Please Enter Customer LPO... Enter N/A if not Available");
            } else if (totsize < 1) {
                call_info_dialog(0, "No Items on the Order!!");
            } else {
                jsonObject.put("user", userLabel.getText());
                jsonObject.put("lpo", nwOrderLPO.getText().toUpperCase());
                jsonObject.put("date", datex);
                jsonObject.put("supplier", suppliersnwOrderCombo.getValue());
                jsonObject.put("customer", customersnwOrderCombo.getValue());
                jsonArray.put(jsonObject);

                totsize = receiptlist.size();
                for (int i = 0; i < totsize; i++) {
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("code", receiptlist.get(i).get(0));
                    jsonObject1.put("name", receiptlist.get(i).get(1));
                    jsonObject1.put("qty", receiptlist.get(i).get(2));
                    jsonObject1.put("unit", receiptlist.get(i).get(3));
                    jsonObject1.put("date", datex);
                    jsonArray1.put(jsonObject1);
                }
                presenter.createOrder(String.valueOf(jsonArray), String.valueOf(jsonArray1));
                loader_ac.setVisible(true);
            }

        });
        cancelOrderBTN.setOnMouseClicked(mouseEvent -> {
            store_itemLst.clear();
            itemsVbox.getChildren().clear();
            receiptlist.clear();
            nworderitemVbox.getChildren().clear();
            customersnwOrderCombo.getItems().clear();
            suppliersnwOrderCombo.getItems().clear();
            nwOrderLPO.setText("");
            nworderdate.setValue(null);
            submenu_checker = "add_order";
            presenter.getSuppliers("all", "none");
            presenter.getCustomers("all", "none");
            search_items.setEditable(false);
            search_items.setText("");

        });
        orderFilterComboBTN.setOnMouseClicked(mouseEvent -> {
            if (!comboBox_validation("Please Select Order Status!!", order_statusComboLBL, order_statusCombo)) {
                return;
            }
            String catFilter = order_statusCombo.getValue();
            presenter.getOrders("nownow", catFilter);
            loader_ac.setVisible(true);

        });
        invoiceFilterComboBTN.setOnMouseClicked(mouseEvent -> {
            if (!comboBox_validation("Please Select Order Status!!", invoice_statusComboLBL, invoice_statusCombo)) {
                return;
            }
            String catFilter = invoice_statusCombo.getValue();
            presenter.getInvoices("nownow", catFilter);
            loader_ac.setVisible(true);

        });
        ordersListReset.setOnMouseClicked(mouseEvent -> {
            presenter.getOrders("all", "none");
            orders_search.setText("");
            combobox_events("list_order");
            submenu_checker = "list_order";
            loader_ac.setVisible(true);

        });
        invoiceListReset.setOnMouseClicked(mouseEvent -> {
            presenter.getInvoices("all", "none");
            invoices_search.setText("");
            combobox_events("list_invoice");
            submenu_checker = "list_invoice";
            loader_ac.setVisible(true);

        });
        billListReset.setOnMouseClicked(mouseEvent -> {
            presenter.getInvoices("bill", "none");
            bills_search.setText("");
            submenu_checker = "post_bill";
            loader_ac.setVisible(true);

        });
        viewOrderInvoiceBTN.setOnMouseClicked(mouseEvent -> {

            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray1 = new JSONArray();
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            int totsize = store_itemLst.size();

            jsonObject.put("user", userLabel.getText());
            jsonObject.put("lpo", viewOrderLPOLBL.getText());
            jsonObject.put("date", viewOrderDateLBL.getText());
            jsonObject.put("supplier", viewOrderSupplierLBL.getText());
            jsonObject.put("customer", viewOrderCustomerLBL.getText());
            jsonObject.put("order_no", viewOrderNumberLBL.getText());
            jsonArray.put(jsonObject);

            for (int i = 0; i < totsize; i++) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("code", store_itemLst.get(i).get(0));
                jsonObject1.put("name", store_itemLst.get(i).get(1));
                jsonObject1.put("qty", store_itemLst.get(i).get(2));
                jsonObject1.put("unit", store_itemLst.get(i).get(3));
                jsonObject1.put("date", viewOrderDateLBL.getText());
                jsonArray1.put(jsonObject1);
            }
            presenter.createInvoice(String.valueOf(jsonArray), String.valueOf(jsonArray1));
            loader_ac.setVisible(true);

        });
        viewBillPostBTN.setOnMouseClicked(mouseEvent -> {
            String datex = (nwBilldate.getValue() != null ? nwBilldate.getValue().toString() : "");
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray1 = new JSONArray();
            JSONArray jsonArray2 = new JSONArray();
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            int totsize = store_itemLst.size();
            int totsize1 = creditNote.size();
            if (datex.equals("")) {
                call_info_dialog(0, "Please Select the Invoice Date");
            } else if (nwBillNo.getText().equals("")) {
                call_info_dialog(0, "Please Enter Supplier Invoice Number!!");
            } else if (totsize < 1) {
                call_info_dialog(0, "No Items on the Invoice!!");
            } else {

                jsonObject.put("user", userLabel.getText());
                jsonObject.put("date", nwBilldate.getValue().toString());
                jsonObject.put("bill_no", nwBillNo.getText().toUpperCase());
                jsonObject.put("cred_chek", daCreditNote);
                jsonObject.put("invoice_no", viewBillNumberLBL.getText());
                jsonArray.put(jsonObject);

                for (int i = 0; i < totsize; i++) {
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("code", store_itemLst.get(i).get(0));
                    jsonObject1.put("name", store_itemLst.get(i).get(1));
                    jsonObject1.put("qty", store_itemLst.get(i).get(2));
                    jsonObject1.put("unit", store_itemLst.get(i).get(3));
                    jsonObject1.put("date", nwBilldate.getValue().toString());
                    jsonArray1.put(jsonObject1);
                }
                for (int i = 0; i < totsize1; i++) {
                    JSONObject jsonObject2 = new JSONObject();
                    jsonObject2.put("code", creditNote.get(i).get(0));
                    jsonObject2.put("name", creditNote.get(i).get(1));
                    jsonObject2.put("qty", creditNote.get(i).get(2));
                    jsonObject2.put("unit", creditNote.get(i).get(3));
                    jsonObject2.put("date", nwBilldate.getValue().toString());
                    jsonArray2.put(jsonObject2);
                }
                presenter.postBill(String.valueOf(jsonArray), String.valueOf(jsonArray1), String.valueOf(jsonArray2));
                loader_ac.setVisible(true);

            }
        }
        );

    }

    private void imageButton() {
    }

    public void saveUrl(final String filename, String urlString)
            throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            if (urlString.contains(" ")) {
                urlString = urlString.replace(" ", "%20");
            }
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(filename);

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }

    private void placeSaleItems() {
        int totsize = store_itemLst.size();
        for (int i = 0; i < totsize; i++) {
            try {
                //Download Image
                String dpath = store_itemLst.get(i).get(7);
                File f = new File("images/" + dpath);
                if (!f.exists()) {
                    String logox = "images/" + dpath;
                    //String getuurl = "http://192.168.0.251:80/kelmo/" + dpath;
                    //String getuurl = "http://www.severinombae.net/kelmo/" + dpath;
                    //String getuurl = "http://localhost:80/apps/hospitality/" + dpath;
                    String getuurl = "http://www.twistyscocktails.com/apps/finally/" + dpath;
                    saveUrl(logox, getuurl);
                }
                //Load Item on grid
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/sale/sale_item.fxml"));
                HBox ac = fxmlloader.load();
                saleITM itemscontroller = fxmlloader.getController();
                itemscontroller.saleITMcrap(store_itemLst.get(i), listenerz);
                itemsVbox.getChildren().add(ac);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            loader_ac.setVisible(false);
        });
    }

    private void listOrders() {
        int totsize = store_itemLst.size();
        ordersListVbox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/sale/lst_order_item.fxml"));

                HBox hBox = fxmlloader.load();
                OrderITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i), listenerz);
                ordersListVbox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            loader_ac.setVisible(false);
        });
    }

    private void listOrdersItem() {
        int totsize = store_itemLst.size();
        viewOrdersItemsVBox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/sale/order_itemslst.fxml"));

                HBox hBox = fxmlloader.load();
                orderlstITM itemscontroller = fxmlloader.getController();
                itemscontroller.receiptItems(store_itemLst.get(i));
                viewOrdersItemsVBox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            loader_ac.setVisible(false);
        });
    }

    private void listInvoices() {
        int totsize = store_itemLst.size();
        invoicesListVbox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/sale/lst_invoice_item.fxml"));

                HBox hBox = fxmlloader.load();
                InvoiceITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i), listenerz);
                invoicesListVbox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            loader_ac.setVisible(false);
        });
    }

    private void listBillPost() {
        int totsize = store_itemLst.size();
        billsListVbox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/sale/lst_bill_item.fxml"));

                HBox hBox = fxmlloader.load();
                BillITM itemscontroller = fxmlloader.getController();
                itemscontroller.userITMSList(store_itemLst.get(i), listenerz);
                billsListVbox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            loader_ac.setVisible(false);
        });
    }

    private void listInvoicesItem() {
        int totsize = store_itemLst.size();
        viewInvoicesItemsVBox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/sale/invoice_itemslst.fxml"));

                HBox hBox = fxmlloader.load();
                invoicelstITM itemscontroller = fxmlloader.getController();
                itemscontroller.receiptItems(store_itemLst.get(i));
                viewInvoicesItemsVBox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            loader_ac.setVisible(false);
        });
    }

    private void listBillsItem() {
        int totsize = store_itemLst.size();
        viewBillItemsVBox.getChildren().clear();
        for (int i = 0; i < totsize; i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/fxml/sale/bill_itemslst.fxml"));

                HBox hBox = fxmlloader.load();
                billITMrec itemscontroller = fxmlloader.getController();
                itemscontroller.receiptItems(store_itemLst.get(i), listenerz);
                viewBillItemsVBox.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            loader_ac.setVisible(false);
        });
    }

    @Override
    public void GetSuppliers(List<suppliersModel> body) {
        Platform.runLater(() -> {
            supplier_list.clear();
            int totsize = body.size();
            if (submenu_checker.equals("add_order")) {
                for (int i = 0; i < totsize; i++) {
                    supplier_list.add(body.get(i).getName());
                }
                combobox_events("add_order");
            }

        }
        );
    }

    @Override
    public void GetCustomers(List<customersModel> body) {
        Platform.runLater(() -> {
            customer_list.clear();
            int totsize = body.size();
            if (submenu_checker.equals("add_order")) {
                for (int i = 0; i < totsize; i++) {
                    customer_list.add(body.get(i).getName());
                }
                combobox_events("add_order");
            }

        }
        );
    }

    @Override
    public void onErrorLoading(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                loader_ac.setVisible(false);
                call_info_dialog(0, message);
            }

        }
        );
    }

    @Override
    public void GetbrSaleItems(List<BarsaleModel> body) {
        Platform.runLater(() -> {
            int totsize = body.size();
            store_itemLst.clear();
            itemsVbox.getChildren().clear();
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

                store_itemLst.add(listelm);

            }
            if (submenu_checker.equals("add_order")) {
                placeSaleItems();
            }

        });
    }

    @Override
    public void onCreateOrder(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                store_itemLst.clear();
                itemsVbox.getChildren().clear();
                receiptlist.clear();
                nworderitemVbox.getChildren().clear();
                customersnwOrderCombo.getItems().clear();
                suppliersnwOrderCombo.getItems().clear();
                nwOrderLPO.setText("");
                nworderdate.setValue(null);
                submenu_checker = "add_order";
                presenter.getSuppliers("all", "none");
                presenter.getCustomers("all", "none");
                search_items.setEditable(false);
                search_items.setText("");
                loader_ac.setVisible(false);
                call_info_dialog(8, message);
            }
        });
    }

    @Override
    public void onCreateInvoice(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                presenter.getOrders("all", "none");
                orders_search.setText("");
                combobox_events("list_order");
                submenu_checker = "list_order";
                hideItems();
                clearMe();
                main_ac.setVisible(true);
                orders_ac.setVisible(true);
                listOrders_ac.setVisible(true);
                loader_ac.setVisible(false);
                call_info_dialog(8, message);
            }
        });
    }

    @Override
    public void onPostBill(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                presenter.getInvoices("bill", "none");
                bills_search.setText("");
                submenu_checker = "post_bill";
                hideItems();
                clearMe();
                main_ac.setVisible(true);
                bills_ac.setVisible(true);
                listBills_ac.setVisible(true);
                loader_ac.setVisible(false);
                call_info_dialog(8, message);
            }
        });
    }

    @Override
    public void onAddError(String error) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                call_info_dialog(0, error);
                loader_ac.setVisible(false);
            }
        });
    }

    @Override
    public void GetOrders(List<OrdersModel> body) {
        Platform.runLater(() -> {
            store_itemLst.clear();
            int totsize = body.size();
            for (int i = 0; i < totsize; i++) {
                ArrayList<String> listelm = new ArrayList<>();
                listelm.add(body.get(i).getOrder_no());
                listelm.add(body.get(i).getLpo_no());
                listelm.add(body.get(i).getSupplier());
                listelm.add(body.get(i).getCustomer());
                listelm.add(body.get(i).getDate());
                listelm.add(body.get(i).getStatus());
                store_itemLst.add(listelm);
            }
            if (submenu_checker.equals("list_order")) {
                listOrders();
            } else if (submenu_checker.equals("view_order")) {
                viewOrderDateLBL.setText(body.get(0).getDate());
                viewOrderNumberLBL.setText(body.get(0).getOrder_no());
                viewOrderLPOLBL.setText(body.get(0).getLpo_no());
                viewOrderStatusLBL.setText(body.get(0).getStatus());

                viewOrderSupplierLBL.setText(body.get(0).getSupplier());
                viewOrderSupplierAddreLBL.setText(body.get(0).getSaddress());
                viewOrderSupplierPhnLBL.setText(body.get(0).getSphone());
                viewOrderSupplierEmailLBL.setText(body.get(0).getSemail());

                viewOrderCustomerLBL.setText(body.get(0).getCustomer());
                viewOrderCustomerAddrLBL.setText(body.get(0).getCaddress());
                viewOrderCustomerPhnLBL.setText(body.get(0).getCphone());
                viewOrderCustomerEmailLBL.setText(body.get(0).getCemail());

                ArrayList<Items> recitems = body.get(0).getRec_items();
                orderItems = new ArrayList<>();
                orderItems = body.get(0).getRec_items();
                store_itemLst.clear();
                int totsize1 = recitems.size();
                for (int i = 0; i < totsize1; i++) {
                    ArrayList<String> listelm = new ArrayList<>();
                    listelm.add(recitems.get(i).getItem_code());
                    listelm.add(recitems.get(i).getItem_name());
                    listelm.add(recitems.get(i).getQty());
                    listelm.add(recitems.get(i).getUnit());
                    store_itemLst.add(listelm);
                }

                listOrdersItem();
            }

            clearMe();
            combobox_events("list_order");
        }
        );
    }

    @Override
    public void GetInvoices(List<InvoicesModel> body) {
        Platform.runLater(() -> {
            store_itemLst.clear();
            int totsize = body.size();
            for (int i = 0; i < totsize; i++) {
                ArrayList<String> listelm = new ArrayList<>();
                listelm.add(body.get(i).getInvoice_no());
                listelm.add(body.get(i).getOrder_no());
                listelm.add(body.get(i).getLpo_no());
                listelm.add(body.get(i).getCustomer());
                listelm.add(body.get(i).getDate());
                listelm.add(body.get(i).getPretax());
                listelm.add(body.get(i).getTax());
                listelm.add(body.get(i).getTotal());
                listelm.add(body.get(i).getStatus());
                listelm.add(body.get(i).getDue());
                listelm.add(body.get(i).getSupplier());
                store_itemLst.add(listelm);
            }
            if (submenu_checker.equals("list_invoice")) {
                listInvoices();
            } else if (submenu_checker.equals("post_bill")) {
                listBillPost();
            } else if (submenu_checker.equals("view_invoice")) {

                viewInvoiceDateLBL.setText(body.get(0).getDate());
                viewInvoiceNumberLBL.setText(body.get(0).getInvoice_no());
                viewInvoiceOrdernoLBL.setText(body.get(0).getOrder_no());
                viewInvoiceLPOLBL.setText(body.get(0).getLpo_no());
                viewInvoiceStatusLBL.setText(body.get(0).getStatus());
                viewInvoiceDueLBL.setText(body.get(0).getDue());

                viewInvoiceCustomerLBL.setText(body.get(0).getCustomer());
                viewInvoiceCustomerAddrLBL.setText(body.get(0).getCaddress());
                viewInvoiceCustomerPhnLBL.setText(body.get(0).getCphone());
                viewInvoiceCustomerEmailLBL.setText(body.get(0).getCemail());

                Invoicepretax.setText(body.get(0).getPretax());
                InvoiceTax.setText(body.get(0).getTax());
                InvoiceTotal.setText(body.get(0).getTotal());

                ArrayList<InvoicesModel.Items> recitems = body.get(0).getRec_items();
                invoiceItems = new ArrayList<>();
                invoiceItems = body.get(0).getRec_items();
                store_itemLst.clear();
                int totsize1 = recitems.size();
                for (int i = 0; i < totsize1; i++) {
                    ArrayList<String> listelm = new ArrayList<>();
                    listelm.add(recitems.get(i).getItem_code());
                    listelm.add(recitems.get(i).getItem_name());
                    listelm.add(recitems.get(i).getQty());
                    listelm.add(recitems.get(i).getUnit());
                    listelm.add(recitems.get(i).getPrice());
                    listelm.add(recitems.get(i).getPretax());
                    listelm.add(recitems.get(i).getTax());
                    listelm.add(recitems.get(i).getTotal());
                    store_itemLst.add(listelm);
                }

                listInvoicesItem();

            } else if (submenu_checker.equals("view_bills")) {

                viewBillDateLBL.setText(body.get(0).getDate());
                viewBillNumberLBL.setText(body.get(0).getInvoice_no());
                viewBillOrdernoLBL.setText(body.get(0).getOrder_no());
                viewBillLPOLBL.setText(body.get(0).getLpo_no());
                viewBillStatusLBL.setText(body.get(0).getStatus());

                viewBillSupplierLBL.setText(body.get(0).getSupplier());
                viewBillSupplierAddrLBL.setText(body.get(0).getSaddress());
                viewBillSupplierPhnLBL.setText(body.get(0).getSphone());
                viewBillSupplierEmailLBL.setText(body.get(0).getSemail());

                ArrayList<InvoicesModel.Items> recitems = body.get(0).getRec_items();
                invoiceItems = new ArrayList<>();
                creditNote = new ArrayList<>();
                daCreditNote = "0";
                invoiceItems = body.get(0).getRec_items();
                store_itemLst.clear();
                int totsize1 = recitems.size();
                for (int i = 0; i < totsize1; i++) {
                    ArrayList<String> listelm = new ArrayList<>();
                    listelm.add(recitems.get(i).getItem_code());
                    listelm.add(recitems.get(i).getItem_name());
                    listelm.add(recitems.get(i).getQty());
                    listelm.add(recitems.get(i).getUnit());
                    store_itemLst.add(listelm);
                }

                listBillsItem();

            }

            clearMe();
            combobox_events("list_invoice");
        }
        );
    }
}
