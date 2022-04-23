package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class OrdersModel {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("success")
    private Boolean success;
    @Expose
    @SerializedName("order_no")
    private String order_no;
    @Expose
    @SerializedName("lpo_no")
    private String lpo_no;
    @Expose
    @SerializedName("customer")
    private String customer;
    @Expose
    @SerializedName("caddress")
    private String caddress;
    @Expose
    @SerializedName("cphone")
    private String cphone;
    @Expose
    @SerializedName("cemail")
    private String cemail;
    @Expose
    @SerializedName("supplier")
    private String supplier;
    @Expose
    @SerializedName("saddress")
    private String saddress;
    @Expose
    @SerializedName("sphone")
    private String sphone;
    @Expose
    @SerializedName("semail")
    private String semail;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("rec_items")
    private ArrayList<Items> rec_items;

    public class Items {

        @Expose
        @SerializedName("item_code")
        private String item_code;
        @Expose
        @SerializedName("item_name")
        private String item_name;
        @Expose
        @SerializedName("qty")
        private String qty;
        @Expose
        @SerializedName("unit")
        private String unit;

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public String getItem_name() {
            return item_name;
        }

        public void setItem_name(String item_name) {
            this.item_name = item_name;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
        
        

    }

    public ArrayList<OrdersModel.Items> getRec_items() {
        return rec_items;
    }

    public void setRec_items(ArrayList<OrdersModel.Items> rec_items) {
        this.rec_items = rec_items;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getLpo_no() {
        return lpo_no;
    }

    public void setLpo_no(String lpo_no) {
        this.lpo_no = lpo_no;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }
    
    

}
