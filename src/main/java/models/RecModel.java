package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class RecModel {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("success")
    private Boolean success;
    @Expose
    @SerializedName("rec_no")
    private String rec_no;
    @Expose
    @SerializedName("rec_date")
    private String rec_date;
    @Expose
    @SerializedName("rec_time")
    private String rec_time;
    @Expose
    @SerializedName("rec_Atotal")
    private String rec_Atotal;
    @Expose
    @SerializedName("rec_subtotal")
    private String rec_subtotal;
    @Expose
    @SerializedName("rec_taxamt")
    private String rec_taxamt;
    @Expose
    @SerializedName("rec_user")
    private String rec_user;
    @Expose
    @SerializedName("rec_cater")
    private String rec_cater;
    @Expose
    @SerializedName("reminder")
    private String reminder;
    @Expose
    @SerializedName("balance")
    private String balance;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("rec_items")
    private ArrayList<Items> rec_items;

    public class Items {

        @Expose
        @SerializedName("rec_item")
        private String rec_item;
        @Expose
        @SerializedName("rec_qty")
        private String rec_qty;
        @Expose
        @SerializedName("rec_price")
        private String rec_price;
        @Expose
        @SerializedName("rec_total")
        private String rec_total;
        @Expose
        @SerializedName("type")
        private String type;
        @Expose
        @SerializedName("itmtax")
        private String itmtax;
@Expose
        @SerializedName("itm_time")
        private String itm_time;
        @Expose
        @SerializedName("itmcater")
        private String itmcater;

        public String getItm_time() {
            return itm_time;
        }

        public void setItm_time(String itm_time) {
            this.itm_time = itm_time;
        }


        public String getItmtax() {
            return itmtax;
        }

        public void setItmtax(String itmtax) {
            this.itmtax = itmtax;
        }

        public String getItmcater() {
            return itmcater;
        }

        public void setItmcater(String itmcater) {
            this.itmcater = itmcater;
        }

        public String getRec_item() {
            return rec_item;
        }

        public void setRec_item(String rec_item) {
            this.rec_item = rec_item;
        }

        public String getRec_qty() {
            return rec_qty;
        }

        public void setRec_qty(String rec_qty) {
            this.rec_qty = rec_qty;
        }

        public String getRec_price() {
            return rec_price;
        }

        public void setRec_price(String rec_price) {
            this.rec_price = rec_price;
        }

        public String getRec_total() {
            return rec_total;
        }

        public void setRec_total(String rec_total) {
            this.rec_total = rec_total;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRec_no() {
        return rec_no;
    }

    public void setRec_no(String rec_no) {
        this.rec_no = rec_no;
    }

    public String getRec_date() {
        return rec_date;
    }

    public void setRec_date(String rec_date) {
        this.rec_date = rec_date;
    }

    public String getRec_time() {
        return rec_time;
    }

    public void setRec_time(String rec_time) {
        this.rec_time = rec_time;
    }

    public String getRec_Atotal() {
        return rec_Atotal;
    }

    public void setRec_Atotal(String rec_Atotal) {
        this.rec_Atotal = rec_Atotal;
    }

    public String getRec_subtotal() {
        return rec_subtotal;
    }

    public void setRec_subtotal(String rec_subtotal) {
        this.rec_subtotal = rec_subtotal;
    }

    public String getRec_taxamt() {
        return rec_taxamt;
    }

    public void setRec_taxamt(String rec_taxamt) {
        this.rec_taxamt = rec_taxamt;
    }

    public String getRec_user() {
        return rec_user;
    }

    public void setRec_user(String rec_user) {
        this.rec_user = rec_user;
    }

    public String getRec_cater() {
        return rec_cater;
    }

    public void setRec_customer(String rec_cater) {
        this.rec_cater = rec_cater;
    }

    public ArrayList<RecModel.Items> getRec_items() {
        return rec_items;
    }

    public void setRec_items(ArrayList<RecModel.Items> rec_items) {
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


}
