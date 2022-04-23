/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author mohware
 */
public class saleModel {

    @Expose
    @SerializedName("success")
    private Boolean success;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("counter")
    private String counter;

    @Expose
    @SerializedName("opening_bal")
    private String opening_bal;

    @Expose
    @SerializedName("saleCategory")
    private String saleCategory;

    @Expose
    @SerializedName("cost")
    private String cost;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("balance")
    private String balance;

    @Expose
    @SerializedName("code")
    private String code;

    @Expose
    @SerializedName("reorder")
    private String reorder;

    @Expose
    @SerializedName("portion")
    private String portion;

    @Expose
    @SerializedName("price")
    private String price;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("path")
    private String path;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("str_items")
    private ArrayList<StoreItems> str_items;

    public class StoreItems {

        @Expose
        @SerializedName("code")
        private String code;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("qty")
        private String qty;
        @Expose
        @SerializedName("sale_item")
        private String sale_item;
        @Expose
        @SerializedName("conversion")
        private String conversion;
        @Expose
        @SerializedName("unit")
        private String unit;
        @Expose
        @SerializedName("bal_bulk")
        private String bal_bulk;
        @Expose
        @SerializedName("bal_atm")
        private String bal_atm;

        public String getBal_bulk() {
            return bal_bulk;
        }

        public void setBal_bulk(String bal_bulk) {
            this.bal_bulk = bal_bulk;
        }

        public String getBal_atm() {
            return bal_atm;
        }

        public void setBal_atm(String bal_atm) {
            this.bal_atm = bal_atm;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getSale_item() {
            return sale_item;
        }

        public void setSale_item(String sale_item) {
            this.sale_item = sale_item;
        }

        public String getConversion() {
            return conversion;
        }

        public void setConversion(String conversion) {
            this.conversion = conversion;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReorder() {
        return reorder;
    }

    public void setReorder(String reorder) {
        this.reorder = reorder;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSaleCategory() {
        return saleCategory;
    }

    public void setSaleCategory(String saleCategory) {
        this.saleCategory = saleCategory;
    }

    public String getOpening_bal() {
        return opening_bal;
    }

    public void setOpening_bal(String opening_bal) {
        this.opening_bal = opening_bal;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public ArrayList<StoreItems> getStr_items() {
        return str_items;
    }

    public void setStr_items(ArrayList<StoreItems> str_items) {
        this.str_items = str_items;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
