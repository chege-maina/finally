/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author mohware
 */
public class storeModel {

    @Expose
    @SerializedName("success")
    private Boolean success;

    @Expose
    @SerializedName("storeCategory")
    private String storeCategory;

    @Expose
    @SerializedName("unit")
    private String unit;

    @Expose
    @SerializedName("qty")
    private String qty;

    @Expose
    @SerializedName("sale_item")
    private String sale_item;

    @Expose
    @SerializedName("bal_atm")
    private String bal_atm;

    @Expose
    @SerializedName("bal_bulk")
    private String bal_bulk;

    @Expose
    @SerializedName("itemName")
    private String itemName;

    @Expose
    @SerializedName("sup_unit")
    private String sup_unit;

    @Expose
    @SerializedName("disp_unit")
    private String disp_unit;

    @Expose
    @SerializedName("conversion")
    private String conversion;

    @Expose
    @SerializedName("itemCode")
    private String itemCode;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("openingbal")
    private String openingbal;

    @Expose
    @SerializedName("reorder")
    private String reorder;

    public String getReorder() {
        return reorder;
    }

    public void setReorder(String reorder) {
        this.reorder = reorder;
    }

    public String getOpeningbal() {
        return openingbal;
    }

    public void setOpeningbal(String openingbal) {
        this.openingbal = openingbal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStoreCategory() {
        return storeCategory;
    }

    public void setStoreCategory(String storeCategory) {
        this.storeCategory = storeCategory;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSup_unit() {
        return sup_unit;
    }

    public void setSup_unit(String sup_unit) {
        this.sup_unit = sup_unit;
    }

    public String getDisp_unit() {
        return disp_unit;
    }

    public void setDisp_unit(String disp_unit) {
        this.disp_unit = disp_unit;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBal_atm() {
        return bal_atm;
    }

    public void setBal_atm(String bal_atm) {
        this.bal_atm = bal_atm;
    }

    public String getBal_bulk() {
        return bal_bulk;
    }

    public void setBal_bulk(String bal_bulk) {
        this.bal_bulk = bal_bulk;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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



}
